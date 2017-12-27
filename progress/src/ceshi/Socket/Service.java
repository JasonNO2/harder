package ceshi.Socket;

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
