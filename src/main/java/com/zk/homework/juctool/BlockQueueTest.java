package com.zk.homework.juctool;

/**
 * @program: gupaothread
 * @description:
 * @author: zk
 * @create: 2019-05-25 15:56
 **/
public class BlockQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockQueue blockQueue = new BlockQueue(5);
        for (int i = 0; i < 20; i++) {
            int j=i;
            new Thread(() -> {
                blockQueue.put("thread"+j);
            }, "BlockQueueTest[" + i + "]").start();
        }

        Thread.sleep(5000);

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                   String h= blockQueue.take();
                   System.out.println("take:"+h);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "BlockQueueTest[" + i + "]").start();
        }
    }
}
