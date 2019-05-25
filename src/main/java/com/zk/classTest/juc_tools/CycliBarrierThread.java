package com.zk.classTest.juc_tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: gupaothread
 * @description:
 * @author: zk
 * @create: 2019-05-25 15:20
 **/
public class CycliBarrierThread extends Thread {
    private CyclicBarrier cyclicBarrier;
    private String path;

    public CycliBarrierThread(CyclicBarrier cyclicBarrier, String path) {
        this.cyclicBarrier = cyclicBarrier;
        this.path = path;
    }

    @Override
    public void run() {
        System.out.println("开始导入"+path+"数据！");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
