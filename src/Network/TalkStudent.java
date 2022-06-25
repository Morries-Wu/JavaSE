package Network;

//加入多线程,实现双向交流模拟在线咨询
public class TalkStudent {
	public static void main(String[] args) {
		new Thread(new TalkSend(6666, "localhost", 9999)).start();// 发送
		new Thread(new TalkReceive("老师",8888)).start();// 接收
	}
}
