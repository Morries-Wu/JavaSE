package Server;

public class LoginServlet implements Servlet {

	@Override
	public void service(Request_Test02 request, Response response) {
		response.print("<html>");
		response.print("<head>");
		response.print("<title>");

		response.print("��һ��Servlet");

		response.print("</title>");
		response.print("</head>");
		response.print("<body>");

		response.print("��ӭ����:" + request.getParameter("uname"));

		response.print("</body>");
		response.print("</html>");

	}
}
