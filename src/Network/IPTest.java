package Network;

import java.net.InetAddress;
import java.net.UnknownHostException;

//getLocalHost：本机
//getByName：根据域名DNS|IP

//IP定位一个结点:计算机、路由、通讯设备

//两个成员方法
//1.getHostAddress:返回地址
//2.getHostName:返回计算机名
public class IPTest {
	public static void main(String[] args) throws UnknownHostException {

		// 使用getLocalHost方法创建InetAddress对象
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());// 返回:192.168.1.110
		System.out.println(addr.getHostName() + "\n");// 输出计算机名

		// 根据域名得到InetAddress对象
		addr = InetAddress.getByName("www.shsxt.com");
		System.out.println(addr.getHostAddress());// 返回163服务器的ip:61.135.253.15
		System.out.println(addr.getHostName());// 输出:www.163.com

		// DNS将某数字的IP地址转成有意义的字符串,或者将字符串映射成对应的IP

		// 根据ip得到InetAddress对象
		addr = InetAddress.getByName("8.136.140.197");
		System.out.println(addr.getHostAddress());// 返回163服务器的ip:123.56.138.176
		System.out.println(addr.getHostName());
		// 输出IP而不是域名,如果这个IP地址不存在或者DNS服务器不允许IP地址和域名映射
	}
}
