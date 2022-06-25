package Network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
熟悉流程
创建服务器
1.指定端口 使用SeverSocket创建服务器
2.阻塞式 等待连接accept
3.操作:输入输出流操作
4.释放资源
*/
public class Server {
	public static void main(String[] args) throws IOException {
		// 1.指定端口 使用SeverSocket创建服务器
		System.out.println("----------------Sever-----------");
		ServerSocket server = new ServerSocket(8888);
		// 2.阻塞式 等待连接accept
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接");
		// 3.操作:输入输出流操作
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String data = dis.readUTF();
		System.out.println(data);
		// 4.释放资源
		dis.close();
		client.close();//关闭客户端连接
		server.close();//关闭服务器
	}
}
