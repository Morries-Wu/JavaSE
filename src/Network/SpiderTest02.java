package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

//��������ԭ��+ģ�������
public class SpiderTest02 {
	public static void main(String[] args) throws IOException {
		// ��ȡURL
		URL url = new URL("https://www.dianping.com");
		// ������Դ
		InputStream is = url.openStream();
		// ����
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String msg = null;
		while ((msg = br.readLine()) != null) {
			System.out.println(msg);
		}
		br.close();
	}
}