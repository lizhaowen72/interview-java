package com.lzw.java.concurrent.practice.lession034;

import com.lzw.java.concurrent.practice.lession001.Test;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.*;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/5 09:14
 * @Description: TODO
 */
public class EchoServer {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(500);
        final ServerSocketChannel ssc = ServerSocketChannel.open().bind(new InetSocketAddress(8080));
        // 处理请求
        try{
            while (true){
                // 接收请求
                SocketChannel sc = ssc.accept();
                // 将请求处理任务提交给线程池
                es.execute(()->{
                    try {
                        //读socket
                        ByteBuffer rb = ByteBuffer.allocateDirect(1024);
                        sc.read(rb);
                        // 模拟处理请求
                        Thread.sleep(2000);
                        // 写socket
                        ByteBuffer wb = (ByteBuffer)rb.flip();
                        sc.write(wb);
                        // 关闭socket
                        sc.close();
                    }catch (Exception e){
                        throw new UncheckedIOException((IOException) e);
                    }
                });
            }
        }finally {
            ssc.close();
            es.shutdown();
        }
    }

    public void test(){
        new ThreadPoolExecutor(50,500,60L, TimeUnit.SECONDS,
                // 注意要创建有界队列
                new LinkedBlockingQueue<Runnable>(2000),
                // 建议根据业务需求实现ThreadFactory
                r->{
                    return new Thread(r,"echo-"+r.hashCode());
                },
                // 建议根据业务需求实现拒绝策略
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
