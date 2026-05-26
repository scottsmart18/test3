package com.davidniu.thread;

import org.apache.commons.io
        .FileUtils;

import java.io.File;
import java.net.URL;

public class TestThread1 extends Thread{
        private String url;
        private String name;

        public TestThread1(String url, String name) {
            this.url = url;
            this.name = name;
        }

        public void run() {
            WebDownloader webDownloader = new WebDownloader();
            webDownloader.downloader(url, name);
            System.out.println("下载完成: 文件名 = " + name);
        }

    public static void main(String[] args) {
            new TestThread1("https://images.cnblogs.com/cnblogs_com/blogs/848282/galleries/2466393/o_250714023743_1.jpg", "1.jpg").start();
            new TestThread1("https://images.cnblogs.com/cnblogs_com/blogs/848282/galleries/2466393/o_250714023805_2.jpg", "2.jpg").start();
            //new TestThread1("https://blog.kuangstudy.com/usr/themes/handsome/usr/img/sj/3,jpg", "3.jpg").start();
    }
}


class WebDownloader {

    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("download failed: " + url);
        }
    }
}