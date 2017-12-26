package TCPIPUDP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Socket socket=null;
		PrintWriter out=null;
		BufferedReader input=null;//获取控制台输入的数据
		BufferedReader in=null;
		try {
			socket=new Socket("127.0.0.1", 9000);
			while(true){
				//向服务器发送数据
				out=new PrintWriter(socket.getOutputStream(),true) ;
				//控制台输入
				input=new BufferedReader(new InputStreamReader(System.in));
				//获取服务器数据
				in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println("请输入客户端消息:");
				String info=input.readLine();
				out.println("客户端消息:"+info);
				if(info.equals("quit"))break;
				System.out.println("我是客户端"+in.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				out.close();
				socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}

	}

}
