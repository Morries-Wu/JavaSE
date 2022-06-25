package Thread;

import java.util.ArrayList;
import java.util.List;

//线程安全:在并发时保证数据的正确性、效率尽可能高
//synchronized
//1.同步方法
//2.同步块
public class Syn_Test03 {
	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			new Thread(() -> {
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
			}).start();
		}
		Thread.sleep(1000);
		System.out.println(list.size());
	}
}
