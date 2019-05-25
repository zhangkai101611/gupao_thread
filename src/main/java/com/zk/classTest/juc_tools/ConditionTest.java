package com.zk.classTest.juc_tools;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: gupaothread
 * @description:
 * @author: zk
 * @create: 2019-05-25 11:57
 **/
public class ConditionTest {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        new Thread(new ConditionWait(lock,condition),"Thread-wait").start();
        new Thread(new ConditionNotify(lock,condition),"Thread-notify").start();
    }

}
