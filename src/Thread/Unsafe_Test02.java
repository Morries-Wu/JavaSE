package Thread;


//ȡǮ�̲߳���ȫ
public class Unsafe_Test02 {
	public static void main(String[] args) {

		// �˻�
		Account account = new Account(100, "������");
		UnSaveDrawing you = new UnSaveDrawing(account, 80, "˧������");
		UnSaveDrawing wifi = new UnSaveDrawing(account, 90, "happy����");
		you.start();
		wifi.start();
	}
}

//ģ��ȡ��
class UnSaveDrawing extends Thread {

	Account account;// ȡǮ�˻�
	int drawingMoney;// ȡ��Ǯ��
	int pocketTotal;// �ڴ�������

	public UnSaveDrawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	public void run() {
		if (account.money - drawingMoney < 0) {
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account.money = account.money - drawingMoney;
		pocketTotal = pocketTotal + drawingMoney;
		System.out.println(this.getName() + "�˻����Ϊ:" + account.money);
		System.out.println(this.getName() + "�ڴ���ǮΪ:" + pocketTotal);
	}
}
