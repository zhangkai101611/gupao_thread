package com.zk.classTest.juc_tools;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program: gupaothread
 * @description:
 * @author: zk
 * @create: 2019-05-25 11:56
 **/
public class ConditionNotify implements Runnable{
    private Lock lock;
    private Condition condition;

    public ConditionNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    public void run() {
        try {
            lock.lock();
            System.out.println("begin - ConditionNotify! ");
            condition.signal();
            System.out.println("end - ConditionNotify! ");
        } finally {
            lock.unlock();
        }
    }
}
