package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
在线聊天室:服务器
目标:使用多线程实现多个客户可以正常收发多条信息
问题:1、代码太多不好维护，2、客户端读写没有分开必须先写后读
*/
public class MultiServer03 {
	public static void main(String[] args) throws IOException {
		// 1.指定端口 使用SeverSocket创建服务器
		System.out.println("----------------Sever-----------");
		ServerSocket server = new ServerSocket(8888);
		// 2.阻塞式 等待连接accept
		while (true) {
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接");

			new Thread(() -> {
				DataInputStream dis = null;
				DataOutputStream dos = null;
				boolean isRunning = true;
				try {
					dis = new DataInputStream(client.getInputStream());
					dos = new DataOutputStream(client.getOutputStream());
					while (isRunning) {
						// 3.接收消息
						String msg = dis.readUTF();

						// 4.返回消息
						dos.writeUTF(msg);
						dos.flush();
					}

				} catch (IOException e) {
				 //e.printStackTrace();
					isRunning=false;
				}

				// 4.释放资源
				try {
					if (dos != null) {
						dos.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					if (dis != null) {
						dis.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					if (client != null) {
						client.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}).start();

		}

	}
}
