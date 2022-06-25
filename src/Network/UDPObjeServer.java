package Network;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
/*
实现接收端
Address already in use:Cannot bind 同一个协议下端口不允许冲突
*/
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
引用类型类型:接收端
1.使用DatagramSocket 指定端口 创建接收端
2.准备容器 封装成DatagramPacket 包裹
3.阻塞式接收包裹receive(DatagramPacket)
4.分析数据 将字节数组还原为对应的类型即可
5.释放资源
*/

public class UDPObjeServer {
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
		// 读取
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String msg = in.readUTF();
		int age = in.readInt();
		boolean flag = in.readBoolean();
		Object employee = in.readObject();

		if (msg instanceof String) {
			String str = (String) msg;
			System.out.println(str);
		}

		System.out.println(age);
		System.out.println(flag);

		if (employee instanceof Employee) {
			Employee empobj = (Employee) employee;
			System.out.println(empobj.getName() +"   "+ empobj.getSalary());
		}
		server.close();
		in.close();
	}
}
