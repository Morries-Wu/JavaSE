package Exception;

//����StringBuilder��StringBuffer�ǿɱ��ַ����У��������ݿ������޸�
public class TestStringBuilder {
	public static void main(String[] args) {

		// StringBuilder�̲߳���ȫ,Ч�ʸߣ�һ��������,StringBuffer�̰߳�ȫ,Ч�ʵ�
		StringBuilder s1 = new StringBuilder("abcdefg"); // StringBuilder��String��һ���������������ֽضϴ�����Ϊ�ڲ�char vaule[]���޸�;

		System.out.println(Integer.toHexString(s1.hashCode()));

		System.out.println(s1);
		s1.setCharAt(0, '˧');
		System.out.println(Integer.toHexString(s1.hashCode()));
		System.out.println(s1);
	}
}
