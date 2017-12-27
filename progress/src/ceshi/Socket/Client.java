package ceshi.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 17:58 2017/12/26
 * @Modified By:
 */
public class Client {
    public static void main (String[] args) throws IOException {
        System.out.println("客户端启动：");
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
