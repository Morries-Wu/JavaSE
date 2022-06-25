package Thread;

import java.util.concurrent.CopyOnWriteArrayList;

//²Ù×÷²¢·¢ÈÝÆ÷

public class Syn_Test06 {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
