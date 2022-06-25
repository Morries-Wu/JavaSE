package Server;

import java.awt.geom.FlatteningPathIterator;
import java.io.IOException;
import java.net.Socket;

public class Dispatcher01 implements Runnable {
	private Socket client;
	private Request_Test02 request;
	private Response response;

	public Dispatcher01(Socket client) {
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
			Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
			if (servlet != null) {
				servlet.service(request, response);
				response.pushToBrowser(200);
			} else {
				response.pushToBrowser(404);
			}
			System.out.println(response.getHeadInfo() + "\n" + response.getContent());
		} catch (Exception e) {
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
