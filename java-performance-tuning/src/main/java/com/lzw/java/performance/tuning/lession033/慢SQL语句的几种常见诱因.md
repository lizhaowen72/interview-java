### 慢sql语句的几种常见诱因:
## 1.无索引 索引失效导致慢查询
## 2.锁等待
    常用的存储引擎有InnoDB 和 MyISAM,前者支持行锁和表锁,后者只支持表锁.
    如果数据库操作是基于表锁实现的,试想下,如果一张订单表在更新时,需要锁住整张表,那么其他大量数据库操作(包括查询)都将处于等待状态,这将严重影响到系统的并发性能.
    InnoDB存储引擎支持的行锁更适合高并发场景,但在使用InnoDB存储引擎时,要特别注意行锁升级为表锁的可能,在批量更新操作的时候,行锁就很可能会升级为表锁.
    MySQL认为如果对一张表使用大量行锁,会导致事务执行效率下降,从而可能造成其他事务长时间锁等待和更多的锁冲突问题发生,致使性能严重下降,所以MySQL会将行锁升级为表锁.还有,行锁是基于索引加的锁,如果我们在更新操作时,条件索引失效,那么行锁也会升级为表锁.
    因此,基于表锁的数据库操作,会导致SQL阻塞等待,从而影响执行速度,在一些更新操作大于或者等于读操作的情况下,MySQL不建议使用MyISAM存储引擎.
    注意:除了锁升级之外,行锁相对表锁来说,虽然粒度更细,并发能力提升了,但也带来了新的问题,那就是死锁.因此,在使用行锁时,我们要注意避免死锁.
## 3.不恰当的SQL语句
    使用不恰当的SQL语句也是慢SQL最常见的诱因之一.例如,习惯使用<select *> ,<select count(*)>SQL语句,
    在大数据表中使用<limit m,n>分页查询,以及对非索引字段进行排序

