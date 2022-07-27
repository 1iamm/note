package com.liam;

/**
 * @author Liam Li
 * @date 2022/2/24
 * @Description
 */



/*
* 进程分为用户进程和守护进程
* 虚拟机需要等用户进程完成后才可以结束
* 而不需要等待守护进程结束后才可以结束程序
* */


//测试守护进程
//上帝守护着你
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);

        thread.start();
        new Thread(you).start();
    }
}


//上帝
class God implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println("上帝守护着你!");
        }
    }
}

//你
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("活得很开心！");
        }
        System.out.println("====死了！");
    }
}


