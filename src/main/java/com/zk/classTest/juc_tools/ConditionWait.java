package com.zk.classTest.juc_tools;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program: gupaothread
 * @description:
 * @author: zk
 * @create: 2019-05-25 11:56
 **/
public class ConditionWait implements Runnable {
    private Lock lock;
    private Condition condition;

    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    public void run() {
        try {
            lock.lock();
            try {
                Thread.sleep(10000);
                System.out.println("begin - ConditionWait! ");
                condition.await();
                System.out.println("end - ConditionWait! ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }
}
