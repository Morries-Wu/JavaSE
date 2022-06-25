package Network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//接收端:使用面向对象封装
public class TalkReceive implements Runnable {
	private DatagramSocket server;
	private String from;

	public TalkReceive(String from, int port) {
		try {
			this.from = from;
			server = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			// 2.准备容器 封装成DatagramPacket 包裹
			byte container[] = new byte[1024];
			DatagramPacket packet = new DatagramPacket(container, 0, container.length);
			// 3.阻塞式接收包裹receive(DatagramPacket)
			try {
				// 4.分析数据
				server.receive(packet);
				byte datas[] = packet.getData();
				int len = datas.length;
				String data = new String(datas, 0, len);
				System.out.println(from + "\n" + data);
				if (data.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 释放资源
		server.close();
	}

}
