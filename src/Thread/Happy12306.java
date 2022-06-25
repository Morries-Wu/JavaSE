package Thread;



public class Happy12306 {
	public static void main(String[] args) {
		Web12306 we_306 = new Web12306(3, "happy_dog");
		new Passenger(2, we_306, "pig").start();
		new Passenger(2, we_306, "faker").start();
	}
}

//�˿�
class Passenger extends Thread {
	int seats;
	public Passenger(int seats, Runnable target, String name) {
		super(target, name);
		this.seats = seats;
	}
}

//ӰԺ
class Web12306 implements Runnable {
	int available;// ����λ��
	String name;// ����

	public Web12306(int available, String name) {
		this.available = available;
		this.name = name;
	}

	public void run() {
		Passenger person = (Passenger) Thread.currentThread();
		boolean flag = this.bookTickets(person.seats);
		if (flag) {
			System.out.println("��Ʊ�ɹ�  " + Thread.currentThread().getName() + "λ��Ϊ:" + person.seats);
		} else {
			System.out.println("��Ʊʧ��  " + Thread.currentThread().getName() + "λ�ò���");
		}
	}

	// ��Ʊ
	public synchronized boolean bookTickets(int seats) {
		System.out.println("����λ��Ϊ:" + available);
		if (seats > available) {
			return false;
		}
		available = available - seats;
		return true;
	}
}
