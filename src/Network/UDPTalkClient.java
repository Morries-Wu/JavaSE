package Network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/*
��ν���:���Ͷ�
1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
2.׼������ һ��Ҫת���ֽ�����
3.��װ��DatagramPacket����,��Ҫָ��Ŀ�ĵ�
4.���Ͱ���send(DatagramPacket)
5.�ͷ���Դ*/
public class UDPTalkClient {
    public static void main(String[] args) throws Exception {
        System.out.println("���ͷ�������....");
        // 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
        DatagramSocket client = new DatagramSocket(8888);
        // 2.׼������ һ��Ҫת���ֽ�����
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String data = reader.readLine();
            byte datas[] = data.getBytes();
            // 3.��װ��DatagramPacket����,��Ҫָ��Ŀ�ĵ�
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
            // 4.���Ͱ���send(DatagramPacket)
            client.send(packet);
            if (data.equals("bye")) {
                break;
            }
        }
        client.close();
    }
}
