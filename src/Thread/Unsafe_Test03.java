package Thread;

import java.util.ArrayList;
import java.util.List;

//�̲߳���ȫ:��������
public class Unsafe_Test03 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			new Thread(() -> {
				list.add(Thread.currentThread().getName());
			}).start();

		}
		System.out.println(list.size());
	}
}
