package Server;

public class OthersServlet implements Servlet {

	@Override
	public void service(Request_Test02 request, Response response) {
		response.print("ÆäËû²âÊÔÒ³Ãæ");
	}
}
