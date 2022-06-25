package Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//Ŀ��:��װ��Ӧ��Ϣ
//1.���ݿ��Զ�̬���
//2.��ע״̬��,ƴ�Ӻ���Ӧ��Э����Ϣ
public class Server_Test03 {
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server_Test03 server = new Server_Test03();
		server.start();
	}

	// ��������
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("����������ʧ��");
		}
	}

	// �������Ӵ���
	public void receive() {
		try {
			Socket client = serverSocket.accept();
			System.out.println("һ���ͻ��˽���������");
			// ��ȡ����Э��
			InputStream in = client.getInputStream();
			byte datas[] = new byte[1024 * 1024];
			int len = in.read(datas);
			String requestInfo = new String(datas, 0, len);
			System.out.println(requestInfo);

			Response response = new Response(client);
			response.print("<html>");
			response.print("<head>");
			response.print("<title>");

			response.print("��������Ӧ�ɹ�");

			response.print("</title>");
			response.print("</head>");
			response.print("<body>");

			response.print("�ҵα��������ڻ�����");

			response.print("</body>");
			response.print("</html>");
			// ��ע��״̬��
			response.pushToBrowser(200);
			System.out.println(response.getHeadInfo() + "\n" + response.getContent());
			// 3������
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ͻ��˴���");
		}
	}

	// ֹͣ����
	public void stop() {

	}

}
