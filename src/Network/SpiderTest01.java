package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//��������ԭ��
public class SpiderTest01 {
	public static void main(String[] args) throws IOException {
		// ��ȡURL
		// URL url = new URL("https://www.jd.com");
		URL url = new URL("https://www.dianping.com");
		// ������Դ
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");// �ӷ�������ȡ��Դ|post�ύ����
		con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
		// ����
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String msg = null;
		while ((msg = br.readLine()) != null) {
			System.out.println(msg);
		}
		br.close();
	}
}
