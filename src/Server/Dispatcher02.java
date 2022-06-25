package Server;


import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

//�ַ���:����״̬���ݴ��� 404 505����ҳ
public class Dispatcher02 implements Runnable {
	private Socket client;
	private Request_Test02 request;
	private Response response;

	public Dispatcher02(Socket client) {
		this.client = client;
		try {
			// ��ȡ����Э��
			request = new Request_Test02(client);
			// ��ȡ��ӦЭ��
			response = new Response(client);
		} catch (IOException e) {
			e.printStackTrace();
			this.release();
		}

	}

	@Override
	public void run() {
		try {
			if (request.getUrl().equals("") == true || request.getUrl() == null) {
				InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
				//response.println(new String(is.readAllBytes()));
				response.pushToBrowser(200);
				is.close();
				return;
			}
			Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
			if (servlet != null) {
				servlet.service(request, response);
				response.pushToBrowser(200);
			} else {
				// ����
				InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
				//response.println(new String(is.readAllBytes()));
				response.pushToBrowser(404);
				is.close();
			}
			//System.out.println(response.getHeadInfo() + "\n" + response.getContent());
		} catch (Exception e) {
			response.println("����Ҳ���,�һ����Ϻ�");
			e.printStackTrace();
			try {
				response.pushToBrowser(500);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
		release();
	}

	// �ͷ���Դ
	private void release() {
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
