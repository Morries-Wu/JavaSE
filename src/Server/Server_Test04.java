package Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//Ŀ��:��װ������Ϣ�в���ת��Map
public class Server_Test04 {
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server_Test04 server = new Server_Test04();
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
			Request_Test02 request = new Request_Test02(client);

			Response response = new Response(client);
			response.print("<html>");
			response.print("<head>");
			response.print("<title>");

			response.print("��������Ӧ�ɹ�");

			response.print("</title>");
			response.print("</head>");
			response.print("<body>");

			response.print("�ҵα��������ڻ�����" + request.getParameter("uname"));

			response.print("</body>");
			response.print("</html>");
			// ��ע��״̬��
			response.pushToBrowser(200);
			System.out.println(response.getHeadInfo() + "\n" + response.getContent());

			/*
			 * StringBuilder responseInfo = new StringBuilder(); String blank = " "; String
			 * CRLF = "\r\n"; // ���� // 1����Ӧ��:HTTP/1.1 200 OK
			 * responseInfo.append("HTTP/1.1").append(blank);
			 * responseInfo.append(200).append(blank);
			 * responseInfo.append("OK").append(CRLF);
			 * 
			 * // 2����Ӧͷ:���һ�д��ڿ��� // Data:Mon,31Dec209904:25:57GMT // Server:10086
			 * Server/0.0.1:charset=GBK // Content-type:text/html // Content-lenght:39725426
			 * responseInfo.append("Date:").append(new Date()).append(CRLF);
			 * responseInfo.append("Server:").append("10086 Server/0.0.1:charset=GBK").
			 * append(CRLF); responseInfo.append("Content-type:text/html").append(CRLF);
			 * responseInfo.append("Content-lenght:").append(size).append(CRLF);
			 * 
			 * BufferedWriter bw = new BufferedWriter(new
			 * OutputStreamWriter(client.getOutputStream(), "utf-8"));
			 * bw.write(responseInfo.toString()); bw.flush();
			 */
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
