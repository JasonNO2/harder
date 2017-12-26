package TCPIPUDP.DoitYourself;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 17:57 2017/12/26
 * @Modified By:
 */
public class Service implements Runnable{
    private Socket socket;
    public Service(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        //遇到的问题：readLine()方法必须读到换行符才结束,在此之前都是阻塞状态
        //解决方法是使用println()输出,或者使用\r换行符
        //否则一直处于阻塞状态无法接受消息
        if (socket != null) {
            try (BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
                 BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out=new PrintWriter(socket.getOutputStream(),true)
            )
            {
                String receive=null;
                while ((receive=in.readLine())!=null) {
                    System.out.println("接收自客户端" + socket.getInetAddress().getHostName()+socket.getPort()+ "的消息:" + receive);
                    System.out.print("回应:");
                    String words=input.readLine();
                    out.println(words);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("客户端关闭");
            }
        }
    }
}
