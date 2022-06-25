package Chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/*
* ʹ�ö��̷߳�װ:���ն�
1.������Ϣ
2.�ͷ���Դ
3.��дrun*/
public class Receive implements Runnable {
	private DataInputStream dis;
	private Socket client;
	private boolean isRunning;

	public Receive(Socket client) {
		this.client = client;
		this.isRunning = true;
		try {
			dis = new DataInputStream(client.getInputStream());// ������
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

	// �ͷ���Դ
	private void release() {
		this.isRunning = false;
		Utils.close(client, dis);
	}

}
