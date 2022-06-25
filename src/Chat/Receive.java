package Chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/*
* 使用多线程封装:接收端
1.接收消息
2.释放资源
3.重写run*/
public class Receive implements Runnable {
	private DataInputStream dis;
	private Socket client;
	private boolean isRunning;

	public Receive(Socket client) {
		this.client = client;
		this.isRunning = true;
		try {
			dis = new DataInputStream(client.getInputStream());// 输入流
		} catch (IOException e) {
			System.out.println("--2--");
			release();
		}
	}

	public void run() {
		while (isRunning) {
			String msg = receive();
			if (msg.equals("") != true) {
				System.out.println(msg);
			}
		}

	}

	private String receive() {
		try {
			return dis.readUTF();
		} catch (Exception e) {
			System.out.println("--4--");
			release();
		}
		return "";
	}

	// 释放资源
	private void release() {
		this.isRunning = false;
		Utils.close(client, dis);
	}

}
