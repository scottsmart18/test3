package com.davidniu.networks;

import java.net.InetSocketAddress;

public class TestInetSocketAddress {
    public static void main(String[] args) {
        // This class is intended to test socket-related functionalities
        // related to InetAddress, but currently does not contain any code.
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress address1 = new InetSocketAddress("localhost", 8080);
        InetSocketAddress address2 = new InetSocketAddress("localhost", 8080);
        System.out.println("This class is a placeholder for testing socket-related InetAddress functionalities."+address);
        System.out.println("This class is a placeholder for testing socket-related InetAddress functionalities."+address1);
        System.out.println("This class is a placeholder for testing socket-related InetAddress functionalities."+address2.getHostName());
        System.out.println("This class is a placeholder for testing socket-related InetAddress functionalities."+address2.getPort());
        System.out.println("This class is a placeholder for testing socket-related InetAddress functionalities."+address2.getAddress());
    }
}
