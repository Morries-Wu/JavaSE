package Network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/*
多次交流:发送端
1.使用DatagramSocket 指定端口 创建发送端
2.准备数据 一定要转成字节数组
3.封装成DatagramPacket包裹,需要指定目的地
4.发送包裹send(DatagramPacket)
5.释放资源*/
public class UDPTalkClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中....");
        // 1.使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(8888);
        // 2.准备数据 一定要转成字节数组
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String data = reader.readLine();
            byte datas[] = data.getBytes();
            // 3.封装成DatagramPacket包裹,需要指定目的地
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
            // 4.发送包裹send(DatagramPacket)
            client.send(packet);
            if (data.equals("bye")) {
                break;
            }
        }
        client.close();
    }
}
