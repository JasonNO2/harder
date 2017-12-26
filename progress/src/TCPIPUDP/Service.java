package TCPIPUDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Service implements Runnable {
	private Socket socket;

	public Service(Socket socket) {
		super();
		this.socket = socket;
	}
	public void run(){
		BufferedReader in=null;//读取
		PrintWriter out=null;//写入（客户端）
		BufferedReader input=null;
		try {
			//获取到客户端发送过来的数据
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new PrintWriter(socket.getOutputStream(),true);//自动清空缓存
			//控制台输入流
			input=new BufferedReader(new InputStreamReader(System.in));
			//读取操作
			String info=null;
			while((info=in.readLine())!=null){
				System.out.println("我是服务器，客户端说:"+info);
				System.out.println("请输入响应的内容：");
				//向客户端响应数据
				out.println("服务器说:"+input.readLine());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				out.close();
				in.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
