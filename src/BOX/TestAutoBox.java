package BOX;


import javax.sound.midi.Soundbank;

/*�����Զ�װ��,�Զ�����*/
public class TestAutoBox {
	public static void main(String[] args) {
		Integer a = 234; // �Զ�װ��.Integer a =Integer.valueOf(234);

		int b = a; // �Զ�����.���������޸ĳɣ�int b=a.intValue();

		// Integer c = null;
		// int d = c; // �Զ�����:������:C.intValue()

		// ����[-128,127]֮�������,ʵ�ʾ���ϵͳ��ʼ��ʱ��,������[-128,127]֮��һ����������
		Integer in3 = 1234;
		Integer in4 = 1234;
		System.out.println(in3 == in4);// fales����Ϊ1234���ڻ��淶Χ�ڣ�����in3��in4���ڲ����ɶ�����Ȼ��ֵһ�����Ƕ�������õ�ַ��һ��
		System.out.println(in3.equals(in4));
		System.out.println("##############");
		Integer in5 = 123;
		Integer in6 = 123;
		System.out.println(in5 == in6);// true����Ϊ123�ڻ��淶Χ��
		System.out.println(in5.equals(in6));

	}
}
