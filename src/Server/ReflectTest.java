package Server;

//����:��java���еĸ��ֽṹ(���������ԡ�������������)ӳ���һ������java����
//1����ȡClass����
//���ַ�ʽ:Class.forName("����·��")
//2�����Զ�̬�������� clz.getConstructor().newInstance();
public class ReflectTest {
	public static void main(String[] args) throws Exception {

		//�õ�Դ���ַ�ʽ

		// 1������.getClass()
		Iphone iphone = new Iphone();
		Class clz = iphone.getClass();

		// 2����.class()
		clz = Iphone.class;

		// 3��Class.forName("����.����")
		clz = Class.forName("Server.Iphone");

		// ��������
		// Iphone iphone2 = (Iphone) clz.newInstance();// ���Ƽ��Ѿ���ʱ��
		// System.out.println(iphone2);

		Iphone iphone3 = (Iphone) clz.getConstructor().newInstance();//�Ƽ����ַ�ʽ
		System.out.println(iphone3);

	}
}

class Iphone {
	public Iphone() {
	}
}
