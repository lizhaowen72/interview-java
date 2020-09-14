1分布式会话是什么?

    session是啥?浏览器有个cookie,在一段时间内这个cookie都存在,然后每次发请求过来都带上一个特殊的
    jessionid cookie,根据这个东西,在服务端可以维护一个对应的session域,里面可以放点数据.一般只要没
    关掉浏览器,cookie还在,name对应的那个session就在,但是如果cookie没了,但是如果cookie没了,session
    也就没了.常见于登录状态的保存

 2.集群部署时的分布式session如何实现?

    tomcat+redis
    这个其实还挺方便,就是使用session的代码,跟以前一样,还是基于tomcat原生的session支持即可,然后就是用一个叫做
    RedisSessionManager的东西,让所有我们部署的tomcat都将session数据存储到redis中即可
    
    在tomcat的配置文件中配置
    <Valve className="com.orangefunction.tomcat.redissessions.RedisSessionHandlerValve" />
    <Manager className="com.orangefunction.tomcat.redissessions.RedisSessionManager"
         host="localhost" <!-- optional: defaults to "localhost" -->
         port="6379" <!-- optional: defaults to "6379" -->
         database="0" <!-- optional: defaults to "0" -->
         maxInactiveInterval="60" <!-- optional: defaults to "60" (in seconds) -->
         sessionPersistPolicies="PERSIST_POLICY_1,PERSIST_POLICY_2,.." <!-- optional -->
         sentinelMaster="SentinelMasterName" <!-- optional -->
         sentinels="sentinel-host-1:port,sentinel-host-2:port,.." <!-- optional --> />
    然后指定redis的host和port就ok了
    
    
    SpringBoot 以一个非常简洁易用的方式帮我们实现了分布式Session,我们要做的仅仅是1个注解@EnableRedisHttpSession.
    spring session的配置和spring redis的配置.其本质上是利用Tomcat的Filter的实现类SpringSessionRepositoryFilter,
    实现了对每一次请求的拦截,拦截之后将Session放入到Redis中         