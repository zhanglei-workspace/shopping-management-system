package lyons.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HandleExit extends HttpServlet
{

	/**
	 * Constructor of the object.
	 */
	public HandleExit()
	{
		super();
	}

	public void destroy()
	{
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setCharacterEncoding("text/html;chartset=UTF-8");
		HttpSession session = request.getSession(true);
		session.invalidate();
		response.sendRedirect("/lyons.eaby/jsp/join/login.jsp");
		
	}

	public void init() throws ServletException
	{
		// Put your code here
	}

}
