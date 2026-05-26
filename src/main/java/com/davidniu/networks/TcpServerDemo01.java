package com.davidniu.networks;

import  java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TcpServerDemo01 {

    public static void main(String[] args) {
        ServerSocket serverSocket =null;
        Socket clientSocket =null;
        InputStream is =null;
        ByteArrayOutputStream byteArrayOutputStream =null;
        // 1.创建服务器Socket，指定端口号
        try {
                serverSocket = new ServerSocket(9999) ;
                System.out.println("服务器已启动，等待客户端连接...");
            while (true) {
                // 2.等待客户端连接
                clientSocket = serverSocket.accept();
                // 客户端连接成功后，读取客户端的消息
                is = clientSocket.getInputStream();
                System.out.println("客户端已连接：" + clientSocket.getInetAddress().getHostAddress());

                // 3.处理客户端请求（这里可以添加更多的处理逻辑）
                byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int bytesRead;
                int length = 0;
                while ((bytesRead = is.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, bytesRead);
                }
                System.out.println("读到的是：   " + byteArrayOutputStream.toString());
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭资源
            try {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (is != null) {
                    is.close();
                }
                if (clientSocket != null) {
                    clientSocket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }

    }
}