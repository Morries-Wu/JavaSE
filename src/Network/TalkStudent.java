package Network;

//������߳�,ʵ��˫����ģ��������ѯ
public class TalkStudent {
	public static void main(String[] args) {
		new Thread(new TalkSend(6666, "localhost", 9999)).start();// ����
		new Thread(new TalkReceive("��ʦ",8888)).start();// ����
	}
}
