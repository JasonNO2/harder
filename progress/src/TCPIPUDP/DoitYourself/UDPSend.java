package TCPIPUDP.DoitYourself;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 21:33 2017/12/26
 * @Modified By:
 */
public class UDPSend {
    public static void main (String[] args){
        //发送端
        System.out.println("发送端启动");
        try (BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in))){
            //指定发送端使用的端口
            DatagramSocket datagramSocket = new DatagramSocket(8888);
            String message=null;
            while ((message=bufferedReader.readLine()) != null) {
                if (message.equals("quit")) {
                    break;
                }
                //获取字节数组
                byte[] bytes = message.getBytes("utf-8");
                //实例数据报对象,需要参数 byte[]-offset-length-InetAddress-port
                //这个port与接收端一致
                DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length,InetAddress.getByName("localhost"),6666);
                datagramSocket.send(datagramPacket);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
