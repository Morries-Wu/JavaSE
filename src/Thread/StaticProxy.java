package Thread;

//��̬����
//1�����ǽ�ɫ
//2�������ɫ
public class StaticProxy {
	public static void main(String[] args) {
		new WeddingCompany(new You()).happMarry();
		//new Thread(�̶߳���).start();
	}
}

interface Marry {
	void happMarry();
}

class You implements Marry {

	@Override
	public void happMarry() {
		System.out.println("You and  �϶�����...........");
	}

}

//�����ɫ
class WeddingCompany implements Marry {

	// ���ǽ�ɫ
	private Marry target;

	public WeddingCompany(Marry target) {
		this.target = target;
	}

	@Override
	public void happMarry() {
		read();
		this.target.happMarry();
		after();
	}

	private void read() {
		System.out.println("���÷���.....");
	}

	private void after() {
		System.out.println("������");
	}

}
