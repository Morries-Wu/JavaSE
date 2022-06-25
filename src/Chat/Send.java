package Chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
/*
ʹ�ö��̷߳�װ:���Ͷ�
1.������Ϣ
2.�ӿ���̨��ȡ��Ϣ
3.�ͷ���Դ
4.��дrun
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
			dos = new DataOutputStream(client.getOutputStream());// �����
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

	// ������Ϣ
	private void send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			System.out.println("--3--");
			release();
		}

	}

	// �ͷ���Դ
	private void release() {
		this.isRunning = false;
		Utils.close(client, dos);
	}

	// �ӿ���̨��ȡ��Ϣ
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
