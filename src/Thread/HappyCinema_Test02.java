package Thread;

import java.util.ArrayList;
import java.util.List;

public class HappyCinema_Test02 {
    public static void main(String[] args) {

        // ����λ��
        List<Integer> available = new ArrayList<>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(6);
        available.add(7);

        // �˿���Ҫ��λ��
        List<Integer> seats1 = new ArrayList<>();
        seats1.add(1);
        seats1.add(2);

        List<Integer> seats2 = new ArrayList<>();
        seats2.add(4);
        seats2.add(5);
        seats2.add(6);

        SynCinema c = new SynCinema(available, "happy���");
        new Thread(new HappyCustomer(c, seats1), "dog").start();
        new Thread(new HappyCustomer(c, seats2), "love").start();
    }
}

//�˿�
class HappyCustomer implements Runnable {
    SynCinema cinema;
    List<Integer> seats;

    public HappyCustomer(SynCinema cinema, List<Integer> seats) {
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

// ӰԺ
class SynCinema {
    List<Integer> available;// ����λ��
    String name;// ����

    public SynCinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    // ��Ʊ
    public boolean bookTickets(List<Integer> seats) {
        System.out.println("��ӭѡ��" + this.name + "����λ��Ϊ:" + available);
        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(available);
        // ���
        copy.removeAll(seats);
        // �жϴ�С
        if (available.size() - copy.size() != seats.size()) {
            return false;
        }
        // �ɹ�
        available = copy;
        return true;
    }
}
