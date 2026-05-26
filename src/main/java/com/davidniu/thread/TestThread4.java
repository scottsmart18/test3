package com.davidniu.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.concurrent.Callable;

//线程创建方式三：实现callable接口

/**
 * * 使用Callable接口创建线程的好处：
 * * 1. 可以返回结果：Callable接口的call方法可以返回一个值，而Thread类的run方法不能返回值。
 * * 2. 可以抛出异常：Callable接口的call方法可以抛出异常，而Thread类的run方法不能抛出异常。
 */
public class TestThread4 implements Callable <Boolean> {
    private String url;
    private String name;

    public TestThread4(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public Boolean call() {
        WebDownloader1 webDownloader = new WebDownloader1();
        webDownloader.downloader(url, name);
        System.out.println("下载完成: 文件名 = " + name);
        return true;
    }

    public static void main(String[] args) {
        TestThread4 t1 = new TestThread4("https://images.cnblogs.com/cnblogs_com/blogs/848282/galleries/2466393/o_250714023743_1.jpg", "1.jpg");
        TestThread4 t2 = new TestThread4("https://images.cnblogs.com/cnblogs_com/blogs/848282/galleries/2466393/o_250714023805_2.jpg", "2.jpg");
        //new TestThread1("https://blog.kuangstudy.com/usr/themes/handsome/usr/img/sj/3,jpg", "3.jpg").start();
        // 创建线程池
        java.util.concurrent.ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(2);
        // 提交任务
        java.util.concurrent.Future<Boolean> future1 = executorService.submit(t1);
        java.util.concurrent.Future<Boolean> future2 = executorService.submit(t2);
        try {
            // 等待任务完成
            future1.get();
            future2.get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown(); // 关闭线程池
        }
    }

}

class WebDownloader1 {

    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("download failed: " + url);
        }
    }
}