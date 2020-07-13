package com.lzw.java.concurrent.practice.lession036;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.*;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/5 17:41
 * @Description: TODO
 */
public class Logger {
    // 用于终止日志执行的毒丸
    final LogMsg poisonPill = new LogMsg(LEVEL.ERROR, "");
    // 任务队列
    final BlockingQueue<LogMsg> bq = new LinkedBlockingQueue<LogMsg>();
    // flush批量
    static final int batchSize = 500;
    // 只需要一个线程写日志
    ExecutorService es = Executors.newFixedThreadPool(1);

    // 启动写日志线程
    void start() throws IOException {
        File file = File.createTempFile("foo", ".log");
        final FileWriter writer = new FileWriter(file);
        this.es.execute(() -> {
            try {
                // 未刷盘日志数量
                int curIdx = 0;
                long preFT = System.currentTimeMillis();
                while (true) {
                    LogMsg log = bq.poll(5, TimeUnit.SECONDS);
                    // 如果是毒丸,终止执行
                    if (poisonPill.equals(log))
                        // 写日志
                        if (log != null) {
                            writer.write(log.toString());
                            ++curIdx;
                        }
                    // 如果不存在未刷盘数据,则无需刷盘
                    if (curIdx <= 0) {
                        continue;
                    }
                    // 根据刷盘规则刷盘
                    if (log != null && log.level == LEVEL.ERROR || curIdx == batchSize || System.currentTimeMillis() - preFT > 5000) {
                        writer.flush();
                        curIdx = 0;
                        preFT = System.currentTimeMillis();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 写INFO级别日志
    void info(String msg) throws InterruptedException {
        bq.put(new LogMsg(LEVEL.INFO, msg));
    }

    // 写error级别日志
    void error(String msg) throws InterruptedException {
        bq.put(new LogMsg(LEVEL.ERROR, msg));
    }

    // 终止写日志线程
    public void stop() {
        // 将毒丸对象加入阻塞队列
        bq.add(poisonPill);
        es.shutdown();
    }
}
