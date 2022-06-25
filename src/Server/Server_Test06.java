package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//目标:加入了Servlet解耦了业务代码
public class Server_Test06 {
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server_Test06 server = new Server_Test06();
		server.start();
	}

	// 启动服务
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
		}
	}

	// 接受连接处理
	public void receive() {
		try {
			Socket client = serverSocket.accept();
			System.out.println("一个客户端建立了连接");
			// 获取请求协议
			Request_Test02 request = new Request_Test02(client);

			// 获取响应协议
			Response response = new Response(client);
			Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
			if (servlet != null) {
				servlet.service(request, response);
				response.pushToBrowser(200);
			} else {
				response.pushToBrowser(404);
			}

			System.out.println(response.getHeadInfo() + "\n" + response.getContent());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
	}

	// 停止服务
	public void stop() {

	}

}
