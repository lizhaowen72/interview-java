package com.lzw.java.concurrent.practice.lession019;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Solver {
    final int N;
    final float[][] data;
    final CyclicBarrier barrier;

    class Worker implements Runnable {
        int myRow;

        Worker(int row) {
            myRow = row;
        }

        @Override
        public void run() {
            while (!done()) {
                processRow(myRow);
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        private void processRow(int myRow) {
        }

        private boolean done() {
            return false;
        }
    }

    public Solver(float[][] matrix) throws InterruptedException {
        data = matrix;
        N = matrix.length;
        Runnable barrierAction = new Runnable() {
            @Override
            public void run() {
                mergeRows();
            }
        };
        barrier = new CyclicBarrier(N, barrierAction);

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Thread thread = new Thread(new Worker(i));
            threads.add(thread);
            thread.start();
        }
        // wait util done
        for (Thread thread : threads) {
            thread.join();
        }
    }

    private void mergeRows() {
    }
}
