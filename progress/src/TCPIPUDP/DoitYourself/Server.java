package TCPIPUDP.DoitYourself;

import TCPIPUDP.DoitYourself.Service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 17:57 2017/12/26
 * @Modified By:
 */
public class Server {
    public static void main (String[] args) throws IOException {
        System.out.println("服务端启动：");
        ServerSocket serverSocket=new ServerSocket(9999);
        Socket socket=null;
        while (true) {
            socket=serverSocket.accept();
            new Thread(new Service(socket)).start();
        }
    }
}
