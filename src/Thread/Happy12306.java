package Thread;



public class Happy12306 {
	public static void main(String[] args) {
		Web12306 we_306 = new Web12306(3, "happy_dog");
		new Passenger(2, we_306, "pig").start();
		new Passenger(2, we_306, "faker").start();
	}
}

//顾客
class Passenger extends Thread {
	int seats;
	public Passenger(int seats, Runnable target, String name) {
		super(target, name);
		this.seats = seats;
	}
}

//影院
class Web12306 implements Runnable {
	int available;// 可用位置
	String name;// 名称

	public Web12306(int available, String name) {
		this.available = available;
		this.name = name;
	}

	public void run() {
		Passenger person = (Passenger) Thread.currentThread();
		boolean flag = this.bookTickets(person.seats);
		if (flag) {
			System.out.println("出票成功  " + Thread.currentThread().getName() + "位置为:" + person.seats);
		} else {
			System.out.println("出票失败  " + Thread.currentThread().getName() + "位置不够");
		}
	}

	// 购票
	public synchronized boolean bookTickets(int seats) {
		System.out.println("可用位置为:" + available);
		if (seats > available) {
			return false;
		}
		available = available - seats;
		return true;
	}
}
