package lyons.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.Login;

/**
 * 登陆处理
 * @author Lyons(zhanglei)
 *
 */

public class HandleLogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L; //设置序列号
	public HandleLogin()
	{
		super();
	}
	public void init() throws ServletException
	{
	}
	public void destroy()
	{
		super.destroy(); // Just puts "destroy" string in log
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");//servlet中也要此项，否则取值乱码
		String username = "";
		String userpass = "";
		String cookies  = "";
		username = request.getParameter("username");
		userpass = request.getParameter("userpass");
		cookies = request.getParameter("isCookie");
		handleCookies(request,response,username,userpass,cookies);//处理cookies信息
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = DbConn.getConn();
		
		String sql = "select * from vip where username=? and userpass=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, userpass);
			rs = pstmt.executeQuery();
			if (rs.next())
			{
				//登陆成功
				success(request,response,username);
				request.getRequestDispatcher("/jsp/join/landing.jsp").forward(request, response);
			}else 
				{
					String backNews = "用户名或者密码错误";
					fail(request, response, backNews);
				}
		} catch (SQLException e)
		{
			String backNews = "登录失败"+e;
			fail(request, response, backNews);
		}finally
			{
				DbClose.allClose(pstmt, rs, conn);
			}
	}
	
	/**
	 * 处理用户cookies信息
	 * @param request
	 * @param response
	 * @param username
	 * @param userpass
	 */
	public void handleCookies(HttpServletRequest request,HttpServletResponse response, 
			String name,String pass,String isCookie)throws ServletException, IOException
	{
		if ("isCookie".equals(isCookie))//用户选择了记住密码
		{
			String username = URLEncoder.encode(name,"UTF-8");//编码，解决cookie无法保存字符串的问题
			String userpass = URLEncoder.encode(pass,"UTF-8");
			
			Cookie nameCookie = new Cookie("username",username );//设置与登陆时的name对应的键值对
			Cookie passCookie = new Cookie("userpass",userpass );
			
			nameCookie.setPath("/");//设置的cookie的存储路径很重要，不然取不到值
			passCookie.setPath("/");
			nameCookie.setMaxAge(864000); //设置生命期限十天 单位秒
			passCookie.setMaxAge(864000);
			response.addCookie(nameCookie); //保存信息
			response.addCookie(passCookie); 
		}else 
			{
			//用户未选择记住密码，删除浏览器中可能存在的cookie
				Cookie[] cookies = null;
				cookies = request.getCookies();
				if (cookies!=null&&cookies.length>0)
				{
					for (Cookie c : cookies)
					{
						if ("username".equals(c.getName())||"userpass".equals(c.getName()))
						{
							c.setMaxAge(0);//设置cookie失效
							c.setPath("/");//务必设置
							response.addCookie(c);
						}
					}
				}
			}
	}
	
	/**
	 * 登陆成功，储存用户信息
	 */
	public void success(HttpServletRequest request,
			HttpServletResponse response, String username)
	{
		Login loginBean = null;
		HttpSession session = request.getSession(true);
		
		try
		{
			loginBean = (Login) session.getAttribute("loginBean");//获取session中可能存在的loginBean对象
			if (loginBean == null)
			{
				loginBean = new Login();
				session.setAttribute("loginBean", loginBean);//注意jsp获取时需要用到该name的属性名字
				session.setMaxInactiveInterval(600);//十分钟的存活期 单位：秒
				loginBean = (Login) session.getAttribute("loginBean");
			}
			
			String name = loginBean.getUsername();
			if (username.equals(name))
			{
				loginBean.setBackNews(username + "您已登陆，无需再次登录");
				loginBean.setUsername(username);
			} else
				{
					loginBean.setBackNews(username + "登陆成功");
					loginBean.setUsername(username);
				}
		} catch (Exception e)
		{
			String backNews = "登录失败"+e;
			fail(request, response, backNews);
		}
	
	}
	
	/**
	 * 登陆失败
	 */
	public void fail(HttpServletRequest request,
			HttpServletResponse response,String backNews)
	{
		try
		{
			PrintWriter out = response.getWriter();
			out.print(backNews+"<br>");
			out.print("返回"+"<a href=/lyons.eaby/jsp/join/login.jsp>登陆界面</a>");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}