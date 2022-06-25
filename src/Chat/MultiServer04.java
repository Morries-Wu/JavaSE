package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
在线聊天室:服务器
目标:使用多线程实现多个客户可以正常收发多条信息
目标:封装使用多线程实现多个客户可以正常收发多条信息
*/
public class MultiServer04 {
	public static void main(String[] args) throws IOException {
		// 1.指定端口 使用SeverSocket创建服务器
		System.out.println("----------------Sever-----------");
		ServerSocket server = new ServerSocket(8888);
		// 2.阻塞式 等待连接accept
		while (true) {
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接");
			new Thread(new Channel(client)).start();
		}
	}

	static class Channel implements Runnable {
		private boolean isRunning;
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;

		// 一个客户代表一个多线程
		public Channel(Socket client) {
			this.client = client;
			this.isRunning = true;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				System.out.println("--------------1------------------");
				release();
			}

		}

		// 接收消息
		private String receive() {
			String datas = "";
			try {
				datas = dis.readUTF();
			} catch (IOException e) {
				release();
			}
			return datas;
		}

		// 发送消息
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				System.out.println("--------------3------------------");
				release();
			}

		}

		// 释放资源
		private void release() {
			this.isRunning = false;
			Utils.close(client, dis, dos);
		}

		public void run() {
			while (isRunning) {
				String msg = receive();
				if (msg.equals("") != true) {
					send(msg);
				}
			}

		}

	}

}
