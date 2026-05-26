package com.davidniu.networks;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

//客户端
public class TcpClientDemo01 {
    public static void main(String[] args) {
        Socket clientSocket =null;
        OutputStream os =null;
        // 1.创建客户端Socket，连接到服务器的IP地址和端口号
        try {
                InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
                int serverPort = 9999;
                clientSocket = new Socket("127.0.0.1", serverPort);
                System.out.println("客户端已连接到服务器：" + serverAddress.getHostName() );

            // 2.发送消息
            os = clientSocket.getOutputStream();
            String message = "Hello, Server! 欢迎您！";
            os.write(message.getBytes());
            // ...

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3.关闭资源
            try {
                if (os != null) {
                    os.close();
                }
                if (clientSocket != null) {
                    clientSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
