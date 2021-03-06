package Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

//封装请求协议:获取 method uri以及请求参数
public class Request_Test01 {

	private String requestInfo;
	private String method;// 请求方式
	private String url;// 请求url
	private String queryStr;// 请求参数
	private final String CRLF = "\r\n";

	public Request_Test01(Socket client) throws IOException {
		this(client.getInputStream());
	}

	public Request_Test01(InputStream in) {
		byte datas[] = new byte[1024 * 1024];
		int len;
		try {
			len = in.read(datas);
			this.requestInfo = new String(datas, 0, len);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 分解字符串
		parseRequestInfo();
	}

	private void parseRequestInfo() {
		System.out.println("------分解------");
		System.out.println("---1、获取请求方式:开头第一个/-----");
		this.method = this.requestInfo.substring(0, this.requestInfo.indexOf("/")).toLowerCase().trim();
		System.out.println("---2、获取请求url:第一个/到HTTP/-----");
		System.out.println("可能包含请求参数?前面的为url");
		// 1、获取/的位置
		int startIdx = this.requestInfo.indexOf("/") + 1;
		// 2、获取HTTP/的位置
		int endIdx = this.requestInfo.indexOf("HTTP/");
		// 3、分割字符串
		this.url = this.requestInfo.substring(startIdx, endIdx);
		System.out.println(this.url);
		// 4、获取?的位置
		int queryIdx = this.url.indexOf("?");
		if (queryIdx >= 0) {// 表示存在请求参数
			String urlArray[] = this.url.split("\\?");
			this.url = urlArray[0];
			queryStr = urlArray[1];
		}
		System.out.println(this.url);

		System.out.println("---3、获取请求参数:如果Get已经获取,如果是post可能在请求中---");
		if (method.equals("post") == true) {
			String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
			if (queryStr == null) {
				queryStr = qStr;
			} else {
				queryStr = queryStr + "&" + qStr;
			}	
		}
		System.out.println(method + "   " + url + "  " + queryStr);
	}

}
