package BOX;

public class TestWrappedClass {
	public static void main(String[] args) {
		// ��������l����ת�ɰ�װ�����
		Integer a = new Integer(3);
		a.intValue();
		Integer b = Integer.valueOf(30);// �൱��new integer(30)
		// �Ѱ�װ�����ת�ɻ�����������
		int c = b.intValue();
		double d = b.doubleValue();

		// ���ַ���ת�ɰ�װ�����
		Integer e = new Integer("999999");
		Integer f = Integer.parseInt("9999");

		// �Ѱ�װ�����ת���ַ���
		String str = f.toString();

	}
}
