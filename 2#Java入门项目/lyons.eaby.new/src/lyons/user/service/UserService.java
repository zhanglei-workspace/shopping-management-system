package lyons.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lyons.entity.Login;

/**
 * 
 * 用户服务类
 * 
 * @author  lyons(zhanglei)
 */
public class UserService extends HttpServlet
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1001;

    /**
     * 
     * 判断用户是否登陆
     * 
     * @param request
     * @param response
     * @return 用户名user
     * @throws ServletException
     * @throws IOException
     */
    public String isLogin(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException
    
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Login username = null;
        
        HttpSession session = request.getSession(true);
        username = (Login)session.getAttribute("loginBean");
       
        if (username==null)
        {
            username = new Login();
            session.setAttribute("username", username);
        }
          //判断用户是否登陆
          String user = "";
          user = username.getUsername();//登陆者的用户名
          if ("userNull".equals(user)||user==null)
          {
              out.print("<br>");
              out.print("<center>" +
                      		"<font color=#008B8B> 客官，</font>" +
                      		"<a href=/lyons.eaby.new/jsp/join/login.jsp><font color=red size=6>登陆</font></a>" +
                      		"<font color=#008B8B> 之后才能操作哦  </font>" +
              		   "</center>");
              return "";
          }
          return user;
    }
    
}
