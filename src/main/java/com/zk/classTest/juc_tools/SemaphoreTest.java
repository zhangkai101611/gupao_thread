package com.zk.classTest.juc_tools;

import java.util.concurrent.Semaphore;

/**
 * @program: gupaothread
 * @description:
 * @author: zk
 * @create: 2019-05-25 14:55
 **/
public class SemaphoreTest {
    static class Car extends Thread{
        private int i;
        private Semaphore semaphore;

        public Car(int i, Semaphore semaphore) {
            this.i = i;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("第"+i+" 辆车抢占一个车位！");
                Thread.sleep(2000);
                System.out.println("第"+i+" 辆车腾出车位！");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(5);
        for(int i=0;i<10;i++){
            new Car(i,semaphore).start();
        }
    }
}
