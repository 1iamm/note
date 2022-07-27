package com.liam;

/**
 * @author Liam Li
 * @date 2022/1/29
 * @Description
 */
//模拟龟兔赛跑
public class Race implements Runnable {

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            boolean flag = gameOver(i);
            if (flag) break;
            System.out.println(Thread.currentThread().getName() + "-> 离终点还剩" + (100 - i) + "米");
        }
    }

    private boolean gameOver(int steps) {
        if (winner != null) return true;
        if (steps >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"乌龟").start();
        new Thread(race,"兔子").start();
    }
}
