package Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//目标:封装请求信息中参数转成Map
public class Server_Test04 {
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server_Test04 server = new Server_Test04();
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

			Response response = new Response(client);
			response.print("<html>");
			response.print("<head>");
			response.print("<title>");

			response.print("服务器响应成功");

			response.print("</title>");
			response.print("</head>");
			response.print("<body>");

			response.print("我滴宝儿我终于回来了" + request.getParameter("uname"));

			response.print("</body>");
			response.print("</html>");
			// 关注了状态码
			response.pushToBrowser(200);
			System.out.println(response.getHeadInfo() + "\n" + response.getContent());

			/*
			 * StringBuilder responseInfo = new StringBuilder(); String blank = " "; String
			 * CRLF = "\r\n"; // 返回 // 1、响应行:HTTP/1.1 200 OK
			 * responseInfo.append("HTTP/1.1").append(blank);
			 * responseInfo.append(200).append(blank);
			 * responseInfo.append("OK").append(CRLF);
			 * 
			 * // 2、响应头:最后一行存在空行 // Data:Mon,31Dec209904:25:57GMT // Server:10086
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
