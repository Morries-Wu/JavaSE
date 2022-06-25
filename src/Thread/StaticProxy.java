package Thread;

//静态代理
//1、真是角色
//2、代理角色
public class StaticProxy {
	public static void main(String[] args) {
		new WeddingCompany(new You()).happMarry();
		//new Thread(线程对象).start();
	}
}

interface Marry {
	void happMarry();
}

class You implements Marry {

	@Override
	public void happMarry() {
		System.out.println("You and  嫦娥奔月了...........");
	}

}

//代理角色
class WeddingCompany implements Marry {

	// 真是角色
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
		System.out.println("布置房间.....");
	}

	private void after() {
		System.out.println("闹玉兔");
	}

}
