package com.davidniu.networks;

import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo02 {
    public static void main(String[] args) throws Exception {
        // 1.创建服务器Socket，指定端口号
         ServerSocket serverSocket = new ServerSocket(9000);
        // 2.等待客户端连接
        System.out.println("TCPServerDemo02 is running... Waiting for client connections...");
        Socket socket =serverSocket.accept();
        // 3.处理客户端请求（这里可以添加更多的处理逻辑）
        socket.getInputStream();
        // 4.关闭资源
        System.out.println("TCPServerDemo02 is running...");
        // 实现代码...
    }
}
