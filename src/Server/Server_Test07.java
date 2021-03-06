package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//目标:多线程加入分发器
public class Server_Test07 {
	private ServerSocket serverSocket;
	private boolean isRunning;

	public static void main(String[] args) {
		Server_Test07 server = new Server_Test07();
		server.start();
	}

	// 启动服务
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			isRunning = true;
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
			stop();
		}
	}

	// 接受连接处理
	public void receive() {

		while (isRunning) {
			try {
				Socket client = serverSocket.accept();
				new Thread(new Dispatcher01(client)).start();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("客户端错误");
			}
		}
	}

	// 停止服务
	public void stop() {
		isRunning = false;
		try {
			this.serverSocket.close();
			System.out.println("服务器已停止");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
