package com.zk.classTest.juc_tools;

import java.util.concurrent.CountDownLatch;

/**
 * @program: gupaothread
 * @description:
 * @author: zk
 * @create: 2019-05-25 14:22
 **/
public class CountDownLatchTest extends Thread{
    static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<1000;i++){
            new CountDownLatchTest().start();
        }
        Thread.sleep(4000);
        countDownLatch.countDown();


    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("threadName:"+Thread.currentThread());
    }
    /*  public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(3);
        new Thread(()->{
            System.out.println("Thread1");
            countDownLatch.countDown();
        }).start();
        new Thread(()->{
            System.out.println("Thread2");
            countDownLatch.countDown();
        }).start();
        new Thread(()->{
            System.out.println("Thread3");
        }).start();

        countDownLatch.await();

        System.out.println("hello CountDownLatch!");
    }*/
}
