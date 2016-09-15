package lyons.user.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lyons.user.service.RegisterService;


/**
 * 注册处理
 * @author Lyons(zhanglei)
 *
 */

@SuppressWarnings("serial")
public class RegisterAction extends HttpServlet
{

//    String username;
//    String userpass;
//    String again_userpass;
//    String phone;
//    String address;
//    String realname;
    Map<String, String> registerMap;
    RegisterService registerService;

    public void init() throws ServletException
    {
        registerMap = new HashMap<String, String>();
        registerService = new RegisterService();
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
		request.setCharacterEncoding("UTF-8");
		
		
		registerMap.put("username", request.getParameter("username").trim());
		registerMap.put("userpass", request.getParameter("userpass").trim());
		registerMap.put("again_userpass", request.getParameter("again_userpass").trim());
		registerMap.put("phone", request.getParameter("phone").trim());
		registerMap.put("address", request.getParameter("address").trim());
		registerMap.put("realname", request.getParameter("realname").trim());
		
		registerService.register(request, response, registerMap);
		
		/*if (username==null)
		{
			username = "";
		}
		if (userpass==""|userpass==null)
		{
			userpass = "error";
		}

		String regex = "[\\d]{11}";
		if (!(again_userpass.equals(userpass)))
		{
			userBean.setBackNews("两次密码不一致,注册失败");
			request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
		}else if (phone!=null&&phone.length()>0&&!phone.matches(regex)) 
				{
						userBean.setBackNews("请正确填写11位手机号");
						request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
						return;
				}else 
					{
						String backNews = ""; 
//						String regex = "[\\w]{4,16}";
//						boolean userFlag = username.matches(regex) && userpass.length()>5;
						boolean userFlag = userpass.length()>5;
						if (userFlag)
						{
							Connection        conn  = null;
							PreparedStatement pstmt = null;
							
							conn = DbConn.getConn();
							String sql = "INSERT INTO vip(username,userpass,phone,address,realname) VALUES(?,?,?,?,?)";
							
							try
							{
								pstmt = conn.prepareStatement(sql);
								pstmt.setString(1,username);
								pstmt.setString(2,userpass); 
								pstmt.setString(3,phone);
								pstmt.setString(4,address);
								pstmt.setString(5,realname);
								
								int rs = pstmt.executeUpdate();
								if (rs > 0)
								{
									backNews = "注册成功";
									userBean.setBackNews(backNews);
									request.getRequestDispatcher("/jsp/join/registerSuccess.jsp").forward(request, response);
								}
							} catch (SQLException e)
							{
							    System.out.println(e);
								backNews = "该用户名已被注册"+"<br>";
								userBean.setBackNews(backNews);
								request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
							}finally
							{
								DbClose.close(pstmt, conn);
							}
						}else 
    						{
    							userBean.setBackNews("密码不合法");
    							request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
    						}
					}*/
	}


}
