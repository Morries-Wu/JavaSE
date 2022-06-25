package Thread;


//取钱线程不安全
public class Unsafe_Test02 {
	public static void main(String[] args) {

		// 账户
		Account account = new Account(100, "结婚礼金");
		UnSaveDrawing you = new UnSaveDrawing(account, 80, "帅气的我");
		UnSaveDrawing wifi = new UnSaveDrawing(account, 90, "happy的她");
		you.start();
		wifi.start();
	}
}

//模拟取款
class UnSaveDrawing extends Thread {

	Account account;// 取钱账户
	int drawingMoney;// 取的钱数
	int pocketTotal;// 口袋的总数

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
		System.out.println(this.getName() + "账户余额为:" + account.money);
		System.out.println(this.getName() + "口袋的钱为:" + pocketTotal);
	}
}
