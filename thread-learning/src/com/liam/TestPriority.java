package com.liam;

/**
 * @author Liam Li
 * @date 2022/2/23
 * @Description
 */
public class TestPriority {

    public static void main(String[] args) {
        //主线程的优先级
        System.out.println(Thread.currentThread().getName() + " --> " + Thread.currentThread().getPriority());

        MyPriority mp = new MyPriority();
        Thread t1 = new Thread(mp);
        Thread t2 = new Thread(mp);


        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);



        t1.start();
        t2.start();


    }
}

class MyPriority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " --> " + Thread.currentThread().getPriority());
    }
}