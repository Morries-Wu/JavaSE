package Chat;

import java.io.Closeable;

//工具类
public class Utils {
	//释放资源
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
