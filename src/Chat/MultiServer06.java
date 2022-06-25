package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

//在线聊天室:服务器
//目标:私聊
public class MultiServer06 {
	private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();

	public static void main(String[] args) throws IOException {
		// 1.指定端口 使用SeverSocket创建服务器
		System.out.println("----------------Sever-----------");
		ServerSocket server = new ServerSocket(8888);
		// 2.阻塞式 等待连接accept
		while (true) {
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接");
			Channel c = new Channel(client);
			all.add(c);// 管理所有的成员
			new Thread(c).start();
		}
	}

	static class Channel implements Runnable {
		private String name;
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
				// 获取名称
				this.name = receive();
				// 欢迎你的到来
				this.send("欢迎你的到来");
				this.sendOthers(name + "来到了Mirries_Wu聊天室", true);
			} catch (IOException e) {
				System.out.println("--------------1------------------");
				release();
			}

		}

		// 接收消息
		private String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (Exception e) {
				release();
			}
			return msg;
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

		// 群聊:获取自己消息发给别人
		// 私聊:约定数据格式:@xxxxmsg
		private void sendOthers(String msg, boolean isSys) {
			boolean isPrivate = msg.startsWith("@");
			if (isPrivate) {// 私聊
				int idx = msg.indexOf(":");
				// 获取目标的数据
				String targetName = msg.substring(1, idx);
				msg = msg.substring(idx + 1);
				for (Channel other : all) {
					if (other.name.equals(targetName)) {// 目标
						other.send(name + "悄悄地对您说\n" + msg);// 私聊消息
						break;
					}
				}

			} else {
				for (Channel other : all) {
					if (other == this) {// 代表自身
						continue;
					}
					if (isSys != true) {
						other.send(name + "对所有人说\n" + msg);// 群聊消息
					} else {
						other.send(msg);// 系统消息
					}
				}
			}

		}

		// 释放资源
		private void release() {
			this.isRunning = false;
			Utils.close(client, dis, dos);
			all.remove(this);
			this.sendOthers(this.name + "离开了聊天室....", true);

		}

		public void run() {
			while (isRunning) {
				String msg = receive();
				if (msg.equals("") != true) {
					sendOthers(msg, false);
				}
			}
		}

	}

}
