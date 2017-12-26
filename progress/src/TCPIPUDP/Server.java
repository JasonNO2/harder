package TCPIPUDP;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket server=null;
		Socket socket=null;
		try {
			server=new ServerSocket(9000);
			while(true){
				socket=server.accept();//接收客户端连接
				new Thread(new Service(socket)).start();//为客户端开启线程
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
