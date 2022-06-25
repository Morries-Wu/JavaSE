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

//��װ����Э��:��װ�������ΪMap
public class Request_Test02 {

	private String requestInfo;
	private String method;// ����ʽ
	private String url;// ����url
	private String queryStr;// �������
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
		// �ֽ��ַ���
		parseRequestInfo();
	}

	// �ֽ��ַ���
	private void parseRequestInfo() {
		System.out.println("------�ֽ�------");
		System.out.println("---1����ȡ����ʽ:��ͷ��һ��/-----");
		this.method = this.requestInfo.substring(0, this.requestInfo.indexOf("/")).toLowerCase().trim();
		
		System.out.println("---2����ȡ����url:��һ��/��HTTP/-----");
		System.out.println("���ܰ����������?ǰ���Ϊurl");
		// 1����ȡ/��λ��
		int startIdx = this.requestInfo.indexOf("/") + 1;
		// 2����ȡHTTP/��λ��
		int endIdx = this.requestInfo.indexOf("HTTP/");
		// 3���ָ��ַ���
		this.url = this.requestInfo.substring(startIdx, endIdx);
		System.out.println(this.url);
		// 4����ȡ?��λ��
		int queryIdx = this.url.indexOf("?");
		if (queryIdx >= 0) {// ��ʾ�����������
			String urlArray[] = this.url.split("\\?");
			this.url = urlArray[0];
			queryStr = urlArray[1];
		}
		System.out.println(this.url);

		System.out.println("---3����ȡ�������:���Get�Ѿ���ȡ,�����post������������---");
		if (method.equals("post") == true) {
			String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
			if (queryStr == null) {
				queryStr = qStr;
			} else {
				queryStr = queryStr + "&" + qStr;
			}
		}
		System.out.println(method + "   " + url + "  " + decode(queryStr, "utf-8"));
		// ת��Map fav=1&fav=2&uname=laogouge&age=18&others=
		convertMap();
	}

	// �����������ΪMap
	private void convertMap() {
		// 1���ָ��ַ���&
		String keyValues[] = this.queryStr.split("&");
		for (String querStr : keyValues) {
			// 2���ٴηָ��ַ���=
			String kv[] = querStr.split("=");
			kv = Arrays.copyOf(kv, 2);
			// ��ȡKey��value
			String key = kv[0];
			String value = kv[1] == null ? null : decode(kv[1], "utf-8");
			// �洢��Map��
			if (parameterMap.containsKey(key) != true) {
				parameterMap.put(key, new ArrayList<String>());
			}
			parameterMap.get(key).add(value);
		}

	}

	// ��������
	private String decode(String value, String encode) {
		try {
			return java.net.URLDecoder.decode(value, encode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ͨ��name��ȡ��Ӧ�Ķ��ֵ
	public String[] getParameterValues(String key) {
		List<String> values = this.parameterMap.get(key);
		if (values == null || values.size() < 1) {
			return null;
		}
		return values.toArray(new String[0]);
	}

	// ͨ��name��ȡ��Ӧ��һ��ֵ
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
