package Chat;

import java.io.Closeable;

//������
public class Utils {
	//�ͷ���Դ
	public static void close(Closeable... targets) {
		for (Closeable target : targets) {
			try {
				if (target != null) {
					target.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
