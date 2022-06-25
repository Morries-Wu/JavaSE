package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//Ŀ��:���������ļ�
public class Server_Test05 {
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server_Test05 server = new Server_Test05();
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

			// ��ȡ��ӦЭ��
			Response response = new Response(client);
			Servlet servlet = null;
			if (request.getUrl().equals("login") == true) {
				servlet = new LoginServlet();
			}else if(request.getUrl().equals("reg") == true) {
				servlet = new RegisterServlet();
			}

			servlet.service(request, response);

			response.pushToBrowser(200);
			System.out.println(response.getHeadInfo() + "\n" + response.getContent());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ͻ��˴���");
		}
	}

	// ֹͣ����
	public void stop() {

	}

}
