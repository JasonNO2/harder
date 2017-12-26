package TCPIPUDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UPDSend {
    public static void main (String[] args) throws IOException {
        System.out.println("发送端启动。。。。");
        /** 1、创建udp传输的发送端
            2、建立UDP的socket的服务
            3、将要发送的数据封装到数据包中
            4、通过udp的socket服务将数据包发送出去
            5、关闭socket服务
         */
        DatagramSocket ds = new DatagramSocket(8888);//监听端口
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = input.readLine())!= null) {
            if ("bye".equals(str)) {
                break;
            }
            byte[] bytes = str.getBytes("utf-8");
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("125.42.232.120"),33815);
            ds.send(dp);
        }
        //ds.close();
    }
}
