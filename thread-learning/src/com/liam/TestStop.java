package com.liam;

/**
 * @author Liam Li
 * @date 2022/2/9
 * @Description
 * 线程停止的方法
 * 一般自己创一个stop函数以及标志位Flag进行停止
 */
public class TestStop implements Runnable {
    //    1.设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag)  System.out.println("running! * " + i++);
    }

    //  2.设置一个停止的方法
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop st = new TestStop();
        new Thread(st).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main * " + i);
            if (i == 900) {
//                调用stop()方法切换标志位
                st.stop();
                System.out.println("thread stop!");
            }
        }
    }
}
