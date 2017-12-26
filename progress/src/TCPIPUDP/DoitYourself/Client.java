package TCPIPUDP.DoitYourself;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 17:58 2017/12/26
 * @Modified By:
 */
public class Client {
    public static void main (String[] args) throws IOException {
        System.out.println("客户端启动：");
        //控制台输入流
        //输出流
        //输入流
        //遇到的问题：readLine()方法必须读到换行符才结束,在此之前都是阻塞状态
        //解决方法是使用println()输出,或者使用\r换行符
        //否则一直处于阻塞状态无法接受消息
        Socket socket = new Socket("127.0.0.1", 9999);
        try (BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out=new PrintWriter(socket.getOutputStream(),true)
        ){
            while (true) {
                System.out.print("you:");
                String words=input.readLine();
                if (words.equals("quit")) {
                    break;
                }
                out.println(words);
                String echo=in.readLine();
                System.out.print("server:");
                System.out.println(echo);
            }
        }finally {
            socket.close();
            System.out.println("关闭连接");
        }
    }
}
