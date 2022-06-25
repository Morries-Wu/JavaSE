package Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
ģ���¼ ˫��
����������
1.ָ���˿� ʹ��SeverSocket����������
2.����ʽ �ȴ�����accept
3.����:�������������
4.�ͷ���Դ
*/
public class LoginMultiServer {
    public static void main(String[] args) throws IOException {
        //1.ָ���˿� ʹ��SeverSocket����������
        System.out.println("----------------Sever-----------");
        ServerSocket server = new ServerSocket(8888);
        boolean isRuning = true;
        //2.����ʽ �ȴ�����accept
        while (isRuning) {
            Socket client = server.accept();
            new Thread(new Channel(client)).start();
        }
        //�رշ�����
        server.close();
    }
}

class Channel implements Runnable {
    private Socket client;
    //������
    private DataInputStream dis;
    //�����
    private DataOutputStream dos;
    //һ��Channel����һ���ͻ��˹ܵ�
    public Channel(Socket client) {
        this.client = client;
        try {
            //����
            dis = new DataInputStream(client.getInputStream());
            //���
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            release();
        }
    }

    public void run() {
        System.out.println("һ���ͻ��˽���������");
        //3. ����:
        //�������������
        String uname = "";
        String upwd = "";
        //����
        String dataArray[] = receive().split("&");
        receive(); //���������ȴ��û�����
        for (String info : dataArray) {
            String user[] = info.split("=");
            if (user[0].equals("uname")) {
                System.out.println("����û���Ϊ:" + user[1]);
                uname = user[1];
            } else if (user[0].equals("upwd")) {
                System.out.println("�������Ϊ:" + user[1]);
                upwd = user[1];
            }
        }

        if (uname.equals("10086") && upwd.equals("110")) {
            send("��¼�ɹ�,��ӭ����");
        } else {
            send("�û������������");
        }
        release();
    }

    //���������õ�
    private String receive() {
        String datas = "";
        try {
            datas = dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }

    //���������õ�
    private void send(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //�ͷ���Դ
    private void release() {
        try {
            if (dis != null) {
                dis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (client != null) {
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //�رտͻ�������
        try {
            if (dos != null) {
                dos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
