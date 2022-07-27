package com.liam;

/**
 * @author Liam Li
 * @date 2022/1/29
 * @Description
 */
//多个线程同时操作同一个对象
//    买火车票的操作

//    多个线程同时操作同一个对象，数据紊乱！！
public class TestThread4 implements Runnable {

//    票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0)  break;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-> 拿到了第" +  ticketNums-- +"张车票！");
        }
    }

    public static void main(String[] args) {
        TestThread4 t = new TestThread4();
        new Thread(t, "小明").start();
        new Thread(t, "葫芦娃").start();
        new Thread(t, "黄牛").start();
    }
}
