package com.lzw.java.lock.zook;

/**
 * @Auther: lizhaowen
 * @Date: 2020/9/12 11:13
 * @Description: TODO
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class MicroController {

    @Autowired
    private DistributedLockByZookeeper distributedLockByZookeeper;

    private final static String PATH = "test";

    @GetMapping("/lock1")
    public RespMsg<Boolean> getLock1() {
        Boolean flag;
        distributedLockByZookeeper.acquireDistributedLock(PATH);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        }
        flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        return RespMsg.success(flag);
    }

    @GetMapping("/lock2")
    public RespMsg getLock2() {
        Boolean flag;
        distributedLockByZookeeper.acquireDistributedLock(PATH);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        }
        flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        return RespMsg.success(flag);
    }
}
