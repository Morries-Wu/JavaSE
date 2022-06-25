package Thread;

//����ӰԺ
public class HappyCinema_Test01 {

	public static void main(String[] args) {
		Cinema c = new Cinema(2, "happy���");
		new Thread(new Customer(c, 2), "dog").start();
		new Thread(new Customer(c, 1), "love").start();
	}
}

//�˿�
class Customer implements Runnable {
	Cinema cinema;
	int seats;

	public Customer(Cinema cinema, int seats) {
		this.cinema = cinema;
		this.seats = seats;
	}

	public void run() {
		synchronized (cinema) {
			boolean flag = cinema.bookTickets(seats);
			if (flag) {
				System.out.println("��Ʊ�ɹ�  " + Thread.currentThread().getName() + "λ��Ϊ:" + seats);
			} else {
				System.out.println("��Ʊʧ��  " + Thread.currentThread().getName() + "λ�ò���");
			}
		}
	}
}

//ӰԺ
class Cinema {
	int available;// ����λ��
	String name;// ����

	public Cinema(int avaiable, String name) {
		this.available = avaiable;
		this.name = name;
	}

	// ��Ʊ
	public boolean bookTickets(int seats) {
		System.out.println("����λ��Ϊ:" + available);
		if (seats > available) {
			return false;
		}
		available = available - seats;
		return true;
	}

}
