package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

//����������:������
//Ŀ��:˽��
public class MultiServer06 {
	private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();

	public static void main(String[] args) throws IOException {
		// 1.ָ���˿� ʹ��SeverSocket����������
		System.out.println("----------------Sever-----------");
		ServerSocket server = new ServerSocket(8888);
		// 2.����ʽ �ȴ�����accept
		while (true) {
			Socket client = server.accept();
			System.out.println("һ���ͻ��˽���������");
			Channel c = new Channel(client);
			all.add(c);// �������еĳ�Ա
			new Thread(c).start();
		}
	}

	static class Channel implements Runnable {
		private String name;
		private boolean isRunning;
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;

		// һ���ͻ�����һ�����߳�
		public Channel(Socket client) {
			this.client = client;
			this.isRunning = true;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				// ��ȡ����
				this.name = receive();
				// ��ӭ��ĵ���
				this.send("��ӭ��ĵ���");
				this.sendOthers(name + "������Mirries_Wu������", true);
			} catch (IOException e) {
				System.out.println("--------------1------------------");
				release();
			}

		}

		// ������Ϣ
		private String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (Exception e) {
				release();
			}
			return msg;
		}

		// ������Ϣ
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				System.out.println("--------------3------------------");
				release();
			}

		}

		// Ⱥ��:��ȡ�Լ���Ϣ��������
		// ˽��:Լ�����ݸ�ʽ:@xxxxmsg
		private void sendOthers(String msg, boolean isSys) {
			boolean isPrivate = msg.startsWith("@");
			if (isPrivate) {// ˽��
				int idx = msg.indexOf(":");
				// ��ȡĿ�������
				String targetName = msg.substring(1, idx);
				msg = msg.substring(idx + 1);
				for (Channel other : all) {
					if (other.name.equals(targetName)) {// Ŀ��
						other.send(name + "���ĵض���˵\n" + msg);// ˽����Ϣ
						break;
					}
				}

			} else {
				for (Channel other : all) {
					if (other == this) {// ��������
						continue;
					}
					if (isSys != true) {
						other.send(name + "��������˵\n" + msg);// Ⱥ����Ϣ
					} else {
						other.send(msg);// ϵͳ��Ϣ
					}
				}
			}

		}

		// �ͷ���Դ
		private void release() {
			this.isRunning = false;
			Utils.close(client, dis, dos);
			all.remove(this);
			this.sendOthers(this.name + "�뿪��������....", true);

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
