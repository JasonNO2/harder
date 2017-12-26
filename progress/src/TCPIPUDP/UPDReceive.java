package TCPIPUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UPDReceive {
    public static void main (String[] args) throws IOException {
        /**
        1、建立UDP的socket的服务,必须明确一个端口号
        2、创建数据包，用于储存接收到的数据，方便用数据包对象的方法解析这些数据
        3、使用DatagramSocket的receive方法将接收到的数据存储到数据包中
        4、通过数据包的方法解析数据包中的数据
        5、关闭socket服务
        */
        System.out.println("接收端启动：");
        DatagramSocket ds = new DatagramSocket(6666);
        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
            ds.receive(dp);
            String str = new String(bytes,0,bytes.length);
            System.out.println("接收自:地址"+dp.getAddress().getHostAddress()+",端口号:"+dp.getPort()+"发送的消息："+str);
        }
    }
}
