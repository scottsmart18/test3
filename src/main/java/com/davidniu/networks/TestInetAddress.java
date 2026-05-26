package com.davidniu.networks;

import java.net.InetAddress;

//测试IP地址相关的类和方法
public class TestInetAddress {

    public static void main(String[] args) {
        try {
            // Get the local host address
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Host Address: " + localHost);
            InetAddress localHost1 = InetAddress.getByName("127.0.0.1");
            System.out.println("Local Host Address1: " + localHost1);
            InetAddress localHost2 = InetAddress.getByName("localhost");
            System.out.println("Local Host Address2: " + localHost2);

            // Get the loopback address
            InetAddress loopback = InetAddress.getLoopbackAddress();
            System.out.println("Loopback Address: " + loopback.getHostAddress());

            // Get all IP addresses associated with a domain name
            String domainName = "www.baidu.com";
            InetAddress[] addresses = InetAddress.getAllByName(domainName);
            System.out.println("IP Addresses for " + domainName);
            System.out.println("百度的IP地址是 " + InetAddress.getByName(domainName ));

            for (InetAddress address : addresses) {
                System.out.println(address.getHostAddress());
            }
            System.out.println("=====================");
            InetAddress baidu = InetAddress.getByName("www.baidu.com");
            System.out.println("Baidu IP Address: " + baidu.getHostAddress());
            System.out.println("Baidu Host Name: " + baidu.getHostName());
            System.out.println("Baidu Canonical Host Name: " + baidu.getCanonicalHostName());
            System.out.println("Baidu getAddress: " + baidu.getAddress());

            System.out.println("Baidu is reachable: " + baidu.isReachable(2000)); // 2 seconds timeout
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
