package com.zk.classTest.juc_tools;


import java.util.concurrent.CyclicBarrier;

/**
 * @program: gupaothread
 * @description:
 * @author: zk
 * @create: 2019-05-25 15:20
 **/
public class CycliBarrierTest extends Thread {

    @Override
    public void run() {
        System.out.println("开始分析数据");
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(3,new CycliBarrierTest());
        new Thread(new CycliBarrierThread(cyclicBarrier,"file1")).start();
        new Thread(new CycliBarrierThread(cyclicBarrier,"file2")).start();
        new Thread(new CycliBarrierThread(cyclicBarrier,"file3")).start();
    }

}
