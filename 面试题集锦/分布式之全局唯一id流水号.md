1.设计一个全局唯一流水号?

    1.设置数据库sequence或者表自增字段步长
        可以通过设置数据库sequence或者表的自增字段步长来进行水平伸缩.比如说,现在有8个服务节点,每个服务节点使用一个sequence功能来产生
    id,每个sequence的起始id不同,并且依次递增,步长都是8.这种设计方式适合的场景:防止id重复,这种方案实现起来比较简单,也能达到
    性能目标.但是服务节点固定,步长也固定,将来如果还要增加服务节点,就不好搞了.
![image_24](../image_24.png)

    2.Redis生成id
    当使用数据库来生成id性能不够要求的时候,我们可以尝试使用Redis来生成id,这主要依赖于Redis是单线程的,所以也可以用来生成全局唯一的id.
    可以用Redis的原子操作INCR和INCRBY来实现.
    可以使用Redis集群来获取更高的吞吐量.假如一个集群中有5台Redis.可以初始化每台Redis的值分别是1,2,3,4,5,然后步长都是5.各个Redis生成
    的id为:
            A：1,6,11,16,21
        
            B：2,7,12,17,22
            
            C：3,8,13,18,23
            
            D：4,9,14,19,24
            
            E：5,10,15,20,25
    优点:不依赖与数据库,灵活方便,且性能优于数据库.数字id天然排序,对分页或者需要排序的结果很有帮助,使用Redis集群可以防止单点故障的问题.
    缺点:如果系统中没有Redis,还需要引入新的组件,增加系统复杂度,需要编码和配置的工作量比较大,多环境运维很麻烦.
    
    3.Flicker的解决方案    
    MySQL中id自增的特性，可以借此来生成全局的序列号，Flicker在解决全局ID生成方案里就采用了MySQL自增长ID的机制（auto_increment + replace into + MyISAM）。一个生成64位ID方案具体就是这样的： 先创建单独的数据库，然后创建一个表：
```mysql
    CREATE TABLE borrow_order (
    id bigint(20) unsigned NOT NULL auto_increment,
    stub char(1) NOT NULL default '',
    PRIMARY KEY (id),
    UNIQUE KEY stub (stub)
    ) ENGINE=MyISAM
```
    当我们插入记录后，执行SELECT * from borrow_order ，查询结果就是这样的：
    +-------------------+------+
    | id | stub |
    +-------------------+------+
    | 1 | 192.168.100.102      |
    +-------------------+------+
    在我们的应用端需要做下面这两个操作，在一个事务会话里提交：
    REPLACE INTO borrow_order (stub) VALUES ('192.168.100.102');
    SELECT LAST_INSERT_ID();
    上述操作，通过 replace into 操作，首先尝试插入数据到表中，如果发现表中已经有此行数据则先删除此行数据，然后插入新的数据。 如果没有此行数据的话，直接插入新数据。注意：插入的行字段需要有主键索引或者唯一索引，否则会出错
    通过上述方式，就可以拿到不重复且自增的ID了。 到上面为止，我们只是在单台数据库上生成ID，从高可用角度考虑，接下来就要解决单点故障问题：Flicker启用了两台数据库服务器来生成ID，通过区分auto_increment的起始值和步长来生成奇偶数的ID。
    DBServer1:
    auto-increment-increment = 2
    auto-increment-offset = 1
     
    DBServer2:
    auto-increment-increment = 2
    auto-increment-offset = 2
    最后，在客户端只需要通过轮询方式取ID就可以了。
    优点：充分借助数据库的自增ID机制，提供高可靠性，生成的ID有序。 缺点：占用两个独立的MySQL实例，有些浪费资源，成本较高 数据库中记录过多，每次生成id都需要请求数据库