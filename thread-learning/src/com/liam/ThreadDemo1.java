package com.liam;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Liam Li
 * @date 2022/1/29
 * @Description
 */

//实现多线程下载图片

public class ThreadDemo1 extends Thread{
    private String url; //网络图片地址
    private String name;//保存的文件名

    public ThreadDemo1(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.downloader(url, name);
        System.out.println("下载了文件名为" + name + "的文件！");
    }

    public static void main(String[] args) {
        ThreadDemo1 t1 = new ThreadDemo1("https://ae01.alicdn.com/kf/U96efca6dc11d4083a2bade280a896d4ap.jpg", "1.jpg");
        ThreadDemo1 t2 = new ThreadDemo1("https://ae01.alicdn.com/kf/Ue477fbaa91264dc891c06d64fdf8ff2eS.jpg", "2.jpg");
        ThreadDemo1 t3 = new ThreadDemo1("https://ae01.alicdn.com/kf/Uc2a1a2128a0c49ebab0770fc68bad7afF.jpg", "3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

class WebDownloader{
    public void downloader (String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题！");
        }
    }
}
