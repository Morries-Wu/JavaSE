package Network;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

//文件上传:发送端
//1.使用DatagramSocket 指定端口 创建发送端
//2.将基本类型 转成字节数组
//3.封装成DatagramPacket包裹,需要指定目的地
//4.发送包裹send(DatagramPacket)
//5.释放资源
public class UDPFileClient {
	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中....");
		// 1.使用DatagramSocket 指定端口 创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		// 2.准备数据 一定要转成字节数组

		byte datas[] = IOUtil.FileToByteArray(
				"F:\\Multifunctionapplication\\Advanced Files\\Java Project\\JAVAPratice\\img\\close.jpg");
		// 3.封装成DatagramPacket包裹,需要指定目的地
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
		// 4.发送包裹send(DatagramPacket)
		client.send(packet);
		client.close();
	}
}
