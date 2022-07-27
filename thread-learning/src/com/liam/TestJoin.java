package com.liam;

/**
 * @author Liam Li
 * @date 2022/2/10
 * @Description
 */
public class TestJoin implements Runnable
{

    @Override
    public void run() {
        for (int i = 0; i < 400; i++) {
            System.out.println("&&&&&&&thread * " + i);
        }
    }

    public static void main(String[] args) {
        TestJoin tj = new TestJoin();
        Thread thread = new Thread(tj);
        thread.start();

        for (int i = 0; i < 500; i++) {
            System.out.println("main * " + i);
            if (i == 200) {
                System.out.println("******************* comming ***********************");
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("***************************** join in *****************");
            }
        }
    }
}
