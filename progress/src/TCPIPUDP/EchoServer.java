package TCPIPUDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 16:34 2017/12/22
 * @Modified By:
 */
public class EchoServer {
    private static final int ECHO_SERVER_PORT=6666;
    public static void main (String[] args){
        try (ServerSocket server = new ServerSocket(ECHO_SERVER_PORT)) {
            System.out.println("服务器已启动.......");
            while (true) {
                Socket client=server.accept();
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public ClientHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter printWriter = new PrintWriter(client.getOutputStream());
                 BufferedReader input = new BufferedReader(new InputStreamReader(System.in))
            ) {
                String msg = bufferedReader.readLine();
                System.out.println("收到" + client.getInetAddress() + "发送的消息:" + msg);
                System.out.println("输入回复：");
                printWriter.write(input.readLine());
                printWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
