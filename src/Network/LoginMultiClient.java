package Network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/*
模拟登录 双向
创建客户端
1.建立连接:使用Socket创建客户端+服务的地址和端口
2.操做:输入输出流操作
3.释放资源
*/
public class LoginMultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----------------Client-----------");
		// 1.建立连接:使用Socket创建客户端+服务的地址和端口
		Socket client = new Socket("localhost", 8888);

		// 2.操作:输入输出流
		new Send(client).send();
		new Receive(client).receive();
		client.close();
	}

	// 发送
	static class Send {
		private DataOutputStream dos;
		private Socket client;
		private BufferedReader console;
		private String msg;

		public Send(Socket client) {
			console = new BufferedReader(new InputStreamReader(System.in));
			this.msg = init();
			this.client = client;
			try {
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void send() {
			try {
				dos.writeUTF(this.msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private String init() {
			System.out.println("请输入用户名");
			try {
				String uname = console.readLine();
				System.out.println("请输入密码");
				String upwd = console.readLine();
				return "uname=" + uname + "&" + "upwd=" + upwd;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "";
		}

	}

	// 接收
	static class Receive {
		DataInputStream dis;
		private Socket client;

		public Receive(Socket client) {
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void receive() {
			String result;
			try {
				result = dis.readUTF();
				System.out.println(result);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
