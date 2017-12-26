package TCPIPUDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 16:44 2017/12/22
 * @Modified By:
 */
public class EchoClient {
    public static void main (String[] args){
        try {
            Socket client = new Socket("localhost", 6666);
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入内容：");
            String msg=sc.nextLine();
            sc.close();
            PrintWriter printWriter = new PrintWriter(client.getOutputStream());
            printWriter.println(msg);
            printWriter.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println(bufferedReader.readLine());
            bufferedReader.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
