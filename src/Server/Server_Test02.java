package Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//Ŀ��:������ӦЭ��
public class Server_Test02 {
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server_Test02 server = new Server_Test02();
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

			StringBuilder content = new StringBuilder();
			content.append("<html>");
			content.append("<head>");
			content.append("<title>");
			content.append("��������Ӧ�ɹ�");
			content.append("</title>");
			content.append("</head>");
			content.append("<body>");
			content.append("�ҵα��������ڻ�����");
			content.append("</body>");
			content.append("</html>");
			int size = content.toString().getBytes().length;
			StringBuilder responseInfo = new StringBuilder();
			String blank = " ";
			String CRLF = "\r\n";
			// ����
			// 1����Ӧ��:HTTP/1.1 200 OK
			responseInfo.append("HTTP/1.1").append(blank);
			responseInfo.append(200).append(blank);
			responseInfo.append("OK").append(CRLF);

			// 2����Ӧͷ:���һ�д��ڿ���
			// Data:Mon,31Dec209904:25:57GMT
			// Server:10086 Server/0.0.1:charset=GBK
			// Content-type:text/html
			// Content-lenght:39725426
			responseInfo.append("Date:").append(new Date()).append(CRLF);
			responseInfo.append("Server:").append("10086 Server/0.0.1;charset=utf-8").append(CRLF);
			responseInfo.append("Content-type:text/html").append(CRLF);
			responseInfo.append("Content-lenght:").append(size).append(CRLF);
			responseInfo.append(CRLF);
			// 3������
			responseInfo.append(content.toString());

			// д�����ͻ���
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(responseInfo.toString());
			bw.flush();
		} catch (IOException e) {	
			e.printStackTrace();
			System.out.println("�ͻ��˴���");

		}
	}

	// ֹͣ����
	public void stop() {

	}

}
