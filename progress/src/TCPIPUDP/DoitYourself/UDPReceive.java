package TCPIPUDP.DoitYourself;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 21:33 2017/12/26
 * @Modified By:
 */
public class UDPReceive {
    public static void main (String[] args){
        //接收某一端口发过来的消息
        System.out.println("接收端启动");
        DatagramSocket datagramSocket=null;
        DatagramPacket datagramPacket=null;
        try {
            //明确端口号
            datagramSocket = new DatagramSocket(6666);
            while (true) {
                byte[] bytes = new byte[102];
                datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
                datagramSocket.receive(datagramPacket);
                //解析数据
                String message = new String(bytes, 0, bytes.length, "utf-8");
                System.out.println("接收自"+datagramPacket.getAddress().getHostAddress()+",端口号:"+datagramPacket.getPort()+"发来的消息:"+message);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
