package lyons.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HandleExit extends HttpServlet 
{
 /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
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

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession(true);//true一定要写。否则，获取不到当前session时会自动创建一个
		session.invalidate();
		response.sendRedirect("/lyons.eaby/jsp/join/login.jsp");
		
	}

	public void init() throws ServletException
	{
		// Put your code here
	}

}
