package Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

//��װ����Э��:��ȡ method uri�Լ��������
public class Request_Test01 {

	private String requestInfo;
	private String method;// ����ʽ
	private String url;// ����url
	private String queryStr;// �������
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
		// �ֽ��ַ���
		parseRequestInfo();
	}

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
		System.out.println(method + "   " + url + "  " + queryStr);
	}

}
