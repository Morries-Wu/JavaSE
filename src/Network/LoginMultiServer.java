package Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
模拟登录 双向
创建服务器
1.指定端口 使用SeverSocket创建服务器
2.阻塞式 等待连接accept
3.操作:输入输出流操作
4.释放资源
*/
public class LoginMultiServer {
    public static void main(String[] args) throws IOException {
        //1.指定端口 使用SeverSocket创建服务器
        System.out.println("----------------Sever-----------");
        ServerSocket server = new ServerSocket(8888);
        boolean isRuning = true;
        //2.阻塞式 等待连接accept
        while (isRuning) {
            Socket client = server.accept();
            new Thread(new Channel(client)).start();
        }
        //关闭服务器
        server.close();
    }
}

class Channel implements Runnable {
    private Socket client;
    //输入流
    private DataInputStream dis;
    //输出流
    private DataOutputStream dos;
    //一个Channel代表一个客户端管道
    public Channel(Socket client) {
        this.client = client;
        try {
            //输入
            dis = new DataInputStream(client.getInputStream());
            //输出
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            release();
        }
    }

    public void run() {
        System.out.println("一个客户端建立了连接");
        //3. 操作:
        //输入输出流操作
        String uname = "";
        String upwd = "";
        //分析
        String dataArray[] = receive().split("&");
        receive(); //方法阻塞等待用户连接
        for (String info : dataArray) {
            String user[] = info.split("=");
            if (user[0].equals("uname")) {
                System.out.println("你的用户名为:" + user[1]);
                uname = user[1];
            } else if (user[0].equals("upwd")) {
                System.out.println("你的密码为:" + user[1]);
                upwd = user[1];
            }
        }

        if (uname.equals("10086") && upwd.equals("110")) {
            send("登录成功,欢迎回来");
        } else {
            send("用户名或密码错误");
        }
        release();
    }

    //接收数据用的
    private String receive() {
        String datas = "";
        try {
            datas = dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }

    //发送数据用的
    private void send(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //释放资源
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
        //关闭客户端连接
        try {
            if (dos != null) {
                dos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
