package Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
模拟登录 双向
创建服务器
1.指定端口 使用SeverSocket创建服务器
2.阻塞式 等待连接accept
3.操作:输入输出流操作
4.释放资源
*/
public class LoginTwoWayServer {
	public static void main(String[] args) throws IOException {
		// 1.指定端口 使用SeverSocket创建服务器
		System.out.println("----------------Sever-----------");
		ServerSocket server = new ServerSocket(8888);
		// 2.阻塞式 等待连接accept
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接");
		// 3.操作:输入输出流操作
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String datas = dis.readUTF();
		String uname = "";
		String upwd = "";
		// 分析
		String dataArray[] = datas.split("&");
		for (String info : dataArray) {
			String user[] = info.split("=");
			if (user[0].equals("uname")) {
				System.out.println("你的用户名为:" + user[1]);
				uname = user[1];
			} else if (user[0].equals("upwd")) {
				System.out.println("你的密码为:" + user[1]);
				upwd = user[1];
			}
		}

		// 输出
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		if (uname.equals("10086") && upwd.equals("110")) {
			dos.writeUTF("登录成功,欢迎回来");
		} else {
			dos.writeUTF("用户名或密码错误");
		}

		// 4.释放资源
		dis.close();
		client.close();// 关闭客户端连接
		server.close();// 关闭服务器 }
	}

}
