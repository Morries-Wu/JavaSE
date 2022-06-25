package Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//目标:封装响应信息
//1.内容可以动态添加
//2.关注状态码,拼接好响应的协议信息
public class Server_Test03 {
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server_Test03 server = new Server_Test03();
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
			InputStream in = client.getInputStream();
			byte datas[] = new byte[1024 * 1024];
			int len = in.read(datas);
			String requestInfo = new String(datas, 0, len);
			System.out.println(requestInfo);

			Response response = new Response(client);
			response.print("<html>");
			response.print("<head>");
			response.print("<title>");

			response.print("服务器响应成功");

			response.print("</title>");
			response.print("</head>");
			response.print("<body>");

			response.print("我滴宝儿我终于回来了");

			response.print("</body>");
			response.print("</html>");
			// 关注了状态码
			response.pushToBrowser(200);
			System.out.println(response.getHeadInfo() + "\n" + response.getContent());
			// 3、正文
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
	}

	// 停止服务
	public void stop() {

	}

}
