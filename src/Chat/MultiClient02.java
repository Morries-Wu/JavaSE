package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/*
在线聊天室:客户端
目标:封装使用多线程实现多个客户可以正常收发多条信息
*/
public class MultiClient02 {
	public static void main(String[] args) throws IOException {
		System.out.println("----------------Client-----------");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名");
		// 1.建立连接:使用Socket创建客户端+服务的地址和端口
		Socket client = new Socket("localhost", 8888);
		new Thread(new Send(client, in.readLine())).start();
		new Thread(new Receive(client)).start();
	}
}
