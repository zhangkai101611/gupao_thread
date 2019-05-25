package com.zk.homework.juctool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: gupaothread
 * @description:
 * @author: zk
 * @create: 2019-05-25 15:56
 **/
public class BlockQueue {
    private List queueList;
    private int count;
    private static final int INIT_COUNT =16;
    private Lock lock=new ReentrantLock();
    private Condition putCondition=lock.newCondition();
    private Condition takeCondition=lock.newCondition();

    public BlockQueue(int count){
        this.count=count;
        queueList=new ArrayList(count);
    }

    public BlockQueue(){
        this.count=INIT_COUNT;
        queueList=new ArrayList(count);
    }

    public <T> void put(T t){
        try{
            lock.lock();
            while(queueList.size()==count){
                putCondition.await();
            }
            System.out.println("正在放数据："+t);
            queueList.add(t);
            takeCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public <T> T take(){
        try{
            lock.lock();
            while(queueList.size()==0){
                try {
                    takeCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t1 = (T)queueList.remove(0);
            putCondition.signal();
            return t1;
        } finally {
            lock.unlock();
        }
    }
}
