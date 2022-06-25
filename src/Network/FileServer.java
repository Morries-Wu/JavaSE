package Network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//存储文件
//创建服务器
//1.指定端口 使用SeverSocket创建服务器
//2.阻塞式 等待连接accept
//3.操作:输入输出流操作
//4.释放资源
public class FileServer {
	public static void main(String[] args) throws IOException {
		// 1.指定端口 使用SeverSocket创建服务器
		System.out.println("----------------Sever-----------");
		ServerSocket server = new ServerSocket(8888);
		// 2.阻塞式 等待连接accept
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接");
		// 3.操作:文件拷贝 存储
		InputStream in = new BufferedInputStream(client.getInputStream());
		OutputStream out = new BufferedOutputStream(new FileOutputStream("ppg.png"));

		byte flush[] = new byte[1024];
		int len = -1;
		while ((len = in.read(flush)) != -1) {
			out.write(flush, 0, len);
		}
		// 4.释放资源
		client.close();// 关闭客户端连接
		server.close();// 关闭服务器
	}
}
