package Server;


import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

//分发器:加入状态内容处理 404 505及首页
public class Dispatcher02 implements Runnable {
	private Socket client;
	private Request_Test02 request;
	private Response response;

	public Dispatcher02(Socket client) {
		this.client = client;
		try {
			// 获取请求协议
			request = new Request_Test02(client);
			// 获取响应协议
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
				// 错误
				InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
				//response.println(new String(is.readAllBytes()));
				response.pushToBrowser(404);
				is.close();
			}
			//System.out.println(response.getHeadInfo() + "\n" + response.getContent());
		} catch (Exception e) {
			response.println("你好我不好,我会马上好");
			e.printStackTrace();
			try {
				response.pushToBrowser(500);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
		release();
	}

	// 释放资源
	private void release() {
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
