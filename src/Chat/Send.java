package Chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
/*
使用多线程封装:发送端
1.发送消息
2.从控制台获取消息
3.释放资源
4.重写run
 */
public class Send implements Runnable {
	private BufferedReader console;
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning;
	private String name;

	public Send(Socket client, String name) {
		this.name = name;
		this.isRunning = true;
		this.client = client;
		console = new BufferedReader(new InputStreamReader(System.in));
		try {
			dos = new DataOutputStream(client.getOutputStream());// 输出流
			send(name);
		} catch (IOException e) {
			System.out.println("--1--");
			release();
		}
	}

	public void run() {
		while (isRunning) {
			String msg = getStrFromConsole();
			if (msg.equals("") != true) {
				send(msg);
			}
		}
	}

	// 发送消息
	private void send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			System.out.println("--3--");
			release();
		}

	}

	// 释放资源
	private void release() {
		this.isRunning = false;
		Utils.close(client, dos);
	}

	// 从控制台获取消息
	private String getStrFromConsole() {
		String msg = "";
		try {
			msg = console.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

}
