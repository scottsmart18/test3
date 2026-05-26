package com.davidniu.networks;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TcpClientDemo02 {
    public static void main(String[] args) throws Exception {
        // 1.创建客户端Socket，连接到服务器的IP地址和端口号
        Socket clientSocket = new Socket( InetAddress.getByName("127.0.0.1"),9000 );
        //创建一个输出流
        OutputStream os = clientSocket.getOutputStream();
        // 2.读取文件
        String message = "Hello, Server! 欢迎您！";
        FileInputStream fis = new FileInputStream(new File("1.jpg"));
        // 3.写出文件
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }

        // 4.关闭资源
        fis.close();
        os.close();
        clientSocket.close();
    }
}
