package com.liam;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Liam Li
 * @date 2022/2/10
 * @Description
 */
public class TestSleep {
    public static void main(String[] args) {
        Date time = new Date();
        while (true) {
            System.out.println("time = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = new Date();
        }
    }
}
