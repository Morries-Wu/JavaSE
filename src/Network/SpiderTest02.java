package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

//网络爬虫原理+模拟浏览器
public class SpiderTest02 {
	public static void main(String[] args) throws IOException {
		// 获取URL
		URL url = new URL("https://www.dianping.com");
		// 下载资源
		InputStream is = url.openStream();
		// 分析
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String msg = null;
		while ((msg = br.readLine()) != null) {
			System.out.println(msg);
		}
		br.close();
	}
}
