package Network;

//加入多线程,实现双向交流模拟在线咨询
public class TalkTeacher {
	public static void main(String[] args) {
		new Thread(new TalkReceive("学生",9999)).start();// 接收
		new Thread(new TalkSend(5555, "localhost", 8888)).start();// 发送
	}
}
