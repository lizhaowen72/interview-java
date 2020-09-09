package com.lzw.java.mq;

import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: lizhaowen
 * @Date: 2020/9/9 10:22
 * @Description: TODO
 */
public class RedisDemo {

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useClusterServers()
                .setScanInterval(2000) // 集群状态扫描间隔时间，单位是毫秒
                .addNodeAddress("redis://127.0.0.1:7000").setPassword("1")
                        .addNodeAddress("redis://127.0.0.1:7001").setPassword("1")
                        .addNodeAddress("redis://127.0.0.1:7002")
                        .setPassword("1");
        return Redisson.create(config);
    }

    public static void main(String[] args) {

        Config config1 = new Config();
        config1.useSingleServer().setAddress("redis://172.29.1.180:5378")
                .setPassword("a123456").setDatabase(0);
        RedissonClient redissonClient1 = Redisson.create(config1);

        Config config2 = new Config();
        config2.useSingleServer().setAddress("redis://172.29.1.180:5379")
                .setPassword("a123456").setDatabase(0);
        RedissonClient redissonClient2 = Redisson.create(config2);

        Config config3 = new Config();
        config3.useSingleServer().setAddress("redis://172.29.1.180:5380")
                .setPassword("a123456").setDatabase(0);
        RedissonClient redissonClient3 = Redisson.create(config3);

        String resourceName = "REDLOCK";
        RLock lock1 = redissonClient1.getLock(resourceName);
        RLock lock2 = redissonClient2.getLock(resourceName);
        RLock lock3 = redissonClient3.getLock(resourceName);

        RedissonRedLock redLock = new RedissonRedLock(lock1, lock2, lock3);
        boolean isLock;
        try {
            isLock = redLock.tryLock(500, 30000, TimeUnit.MILLISECONDS);
            System.out.println("isLock = " + isLock);
            if (isLock) {
                //TODO if get lock success, do something;
                Thread.sleep(30000);
            }
        } catch (Exception e) {
        } finally {
            // 无论如何, 最后都要解锁
            System.out.println("");
            redLock.unlock();
        }
    }

}
