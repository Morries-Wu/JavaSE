package Thread;

import java.util.ArrayList;
import java.util.List;

public class HappyCinema_Test02 {
    public static void main(String[] args) {

        // 可用位置
        List<Integer> available = new ArrayList<>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(6);
        available.add(7);

        // 顾客需要的位置
        List<Integer> seats1 = new ArrayList<>();
        seats1.add(1);
        seats1.add(2);

        List<Integer> seats2 = new ArrayList<>();
        seats2.add(4);
        seats2.add(5);
        seats2.add(6);

        SynCinema c = new SynCinema(available, "happy祥哥");
        new Thread(new HappyCustomer(c, seats1), "dog").start();
        new Thread(new HappyCustomer(c, seats2), "love").start();
    }
}

//顾客
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
                System.out.println("出票成功  " + Thread.currentThread().getName() + "位置为:" + seats);
            } else {
                System.out.println("出票失败  " + Thread.currentThread().getName() + "位置不够");
            }
        }
    }
}

// 影院
class SynCinema {
    List<Integer> available;// 可用位置
    String name;// 名称

    public SynCinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    // 购票
    public boolean bookTickets(List<Integer> seats) {
        System.out.println("欢迎选购" + this.name + "可用位置为:" + available);
        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(available);
        // 相减
        copy.removeAll(seats);
        // 判断大小
        if (available.size() - copy.size() != seats.size()) {
            return false;
        }
        // 成功
        available = copy;
        return true;
    }
}
