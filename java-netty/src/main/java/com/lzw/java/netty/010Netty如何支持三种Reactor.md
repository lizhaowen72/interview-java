>1.什么是Reactor及三种版本
>  生活场景：饭店规模变化
> 一个人包揽所有：迎宾、点菜、做菜、上菜、送客
> 多招几个伙计：大家一起做上面的事情
> 进一步分工：搞一个或者多个人专门做迎宾
> 在这个生活场景中，饭店伙计等于线程，迎宾工作等于介入连接，点菜等于请求
> >1.一个人包揽所有:Reactor单线程;  
> > 2.多招几个伙计:Reactor多线程模式;  
> > 3:进一步分工:主从Reactor多线程模式
> 做菜：业务处理
> 上菜：响应
> 送客：断连


> >2.如何在Netty中使用Reactor模式

>3.解析Netty对Reactor模式支持的常见疑问
> Netty如何支持Reactor模式的？
> 两种SocketChannel（ServerSocketChannel、SocketChannel）绑定到两种Group（BossGroup WorkerGroup）中

>为什么说Netty的main reactor大多并不能用到一个线程组。只能使用线程组里面的一个？
> 对于服务器来说只会绑定一个地址 一个端口，所以说我们只会用到一个
>
>Netty给Channel分配NioEventLoop的规则是什么？  
> 两种GenericEventExecutorChooser  PowerOfTwoEventExecutorChooser
当executors长度为2的次幂时，使用PowerOfTwoEventExecutorChooser，性能更好，更公平，类似hashmap的hash算法
```java
private static final class GenericEventExecutorChooser implements EventExecutorChooser {
        private final AtomicInteger idx = new AtomicInteger();
        private final EventExecutor[] executors;

        GenericEventExecutorChooser(EventExecutor[] executors) {
            this.executors = executors;
        }

        @Override
        public EventExecutor next() {
            return executors[Math.abs(idx.getAndIncrement() % executors.length)];
        }
    }
    
    public interface EventExecutor extends EventExecutorGroup {
    
    }
    
    private static final class PowerOfTwoEventExecutorChooser implements EventExecutorChooser {
        private final AtomicInteger idx = new AtomicInteger();
        private final EventExecutor[] executors;

        PowerOfTwoEventExecutorChooser(EventExecutor[] executors) {
            this.executors = executors;
        }

        @Override
        public EventExecutor next() {
            return executors[idx.getAndIncrement() & executors.length - 1];
        }
    }
```
> 通用模式的NIO实现多路复用器是怎么跨平台的？
> 在new NioEventLoopGroup的时候
```java
    public NioEventLoopGroup(int nThreads, ThreadFactory threadFactory) {
        this(nThreads, threadFactory, SelectorProvider.provider());
    }
     public static SelectorProvider provider() {
        synchronized (lock) {
            if (provider != null)
                return provider;
            return AccessController.doPrivileged(
                new PrivilegedAction<SelectorProvider>() {
                    public SelectorProvider run() {
                            if (loadProviderFromProperty())
                                return provider;
                            if (loadProviderAsService())
                                return provider;
                            provider = sun.nio.ch.DefaultSelectorProvider.create();
                            return provider;
                        }
                    });
        }
    }
    windows平台
    public class DefaultSelectorProvider {
 
    public static SelectorProvider create() {
        return new WindowsSelectorProvider();
    }
    macos平台
    public class DefaultSelectorProvider {
    public static SelectorProvider create() {
        return new sun.nio.ch.KQueueSelectorProvider();
    }
    }
}
```

