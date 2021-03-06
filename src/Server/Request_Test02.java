package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//封装请求协议:封装请求参数为Map
public class Request_Test02 {

	private String requestInfo;
	private String method;// 请求方式
	private String url;// 请求url
	private String queryStr;// 请求参数
	private final String CRLF = "\r\n";
	private Map<String, List<String>> parameterMap;

	public Request_Test02(Socket client) throws IOException {
		this(client.getInputStream());
	}

	public Request_Test02(InputStream in) {
		parameterMap = new HashMap<String, List<String>>();
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

	// 分解字符串
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
		System.out.println(method + "   " + url + "  " + decode(queryStr, "utf-8"));
		// 转成Map fav=1&fav=2&uname=laogouge&age=18&others=
		convertMap();
	}

	// 处理请求参数为Map
	private void convertMap() {
		// 1、分割字符串&
		String keyValues[] = this.queryStr.split("&");
		for (String querStr : keyValues) {
			// 2、再次分割字符串=
			String kv[] = querStr.split("=");
			kv = Arrays.copyOf(kv, 2);
			// 获取Key和value
			String key = kv[0];
			String value = kv[1] == null ? null : decode(kv[1], "utf-8");
			// 存储到Map中
			if (parameterMap.containsKey(key) != true) {
				parameterMap.put(key, new ArrayList<String>());
			}
			parameterMap.get(key).add(value);
		}

	}

	// 处理中文
	private String decode(String value, String encode) {
		try {
			return java.net.URLDecoder.decode(value, encode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 通过name获取对应的多个值
	public String[] getParameterValues(String key) {
		List<String> values = this.parameterMap.get(key);
		if (values == null || values.size() < 1) {
			return null;
		}
		return values.toArray(new String[0]);
	}

	// 通过name获取对应的一个值
	public String getParameter(String key) {
		String values[] = getParameterValues(key);
		return values == null ? null : values[0];
	}

	public String getMethod() {
		return method;
	}

	public String getUrl() {
		return url;
	}

	public String getQueryStr() {
		return queryStr;
	}

}
