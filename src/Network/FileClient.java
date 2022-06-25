package Network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

//上传
//创建客户端
//1.建立连接:使用Socket创建客户端+服务的地址和端口
//2.操做:输入输出流操作
//3.释放资源
public class FileClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----------------Client-----------");
		// 1.建立连接:使用Socket创建客户端+服务的地址和端口
		Socket client = new Socket("localhost", 8888);
		// 2.操作:文件拷贝 上传
		InputStream in = new BufferedInputStream(new FileInputStream(
				"F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\img\\复制.png"));
		OutputStream out = new BufferedOutputStream(client.getOutputStream());
		byte flush[] = new byte[1024];
		int len = -1;
		while ((len = in.read(flush)) != -1) {
			out.write(flush, 0, len);
		}
		out.flush();	
		out.close();
		client.close();
	}
}
