package Server;

public class LoginServlet implements Servlet {

	@Override
	public void service(Request_Test02 request, Response response) {
		response.print("<html>");
		response.print("<head>");
		response.print("<title>");

		response.print("第一个Servlet");

		response.print("</title>");
		response.print("</head>");
		response.print("<body>");

		response.print("欢迎回来:" + request.getParameter("uname"));

		response.print("</body>");
		response.print("</html>");

	}
}
