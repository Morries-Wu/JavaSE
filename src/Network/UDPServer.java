package Network;
/*
	实现接收端
	Address already in use:Cannot bind 同一个协议下端口不允许冲突
*/
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
	1.使用DatagramSocket 指定端口 创建接收端
	2.准备容器 封装成DatagramPacket 包裹
	3.阻塞式接收包裹receive(DatagramPacket)
	4.分析数据 byte[] getDate()  get Length()
	5.释放资源
*/

public class UDPServer {
	public static void main(String[] args) throws Exception {
		System.out.println("接收方启动中");
		// 1.使用DatagramSocket 指定端口 创建接收端
		DatagramSocket server = new DatagramSocket(9999);
		// 2.准备容器 封装成DatagramPacket 包裹
		byte container[] = new byte[1024];
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);
		// 3.阻塞式接收包裹receive(DatagramPacket)
		server.receive(packet);
		byte datas[] = packet.getData();
		int len = datas.length;
		System.out.println(len);
		System.out.println(new String(datas, 0, len));
		server.close();
	}
}
