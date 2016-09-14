package lyons.user.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lyons.dao.UserDaoImp;
import lyons.user.entity.User;

/**
 * 
 * 用户服务类
 * 
 * @author  lyons(zhanglei)
 */
@SuppressWarnings("serial")
public class UserService extends HttpServlet
{
    
    UserDaoImp userDao;
    String userPass;
    List<User> userList;
    
    /**
     * 
     * 用户登录
     * @param request
     * @param response
     * @param userMap
     * @throws ServletException
     * @throws IOException
     */
    public void userLogin(HttpServletRequest request, HttpServletResponse response, Map<String, String> userMap) 
        throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        handleCookies(request,response,userMap.get("username"),
        userMap.get("userpass"),userMap.get("cookies"));//处理cookies信息
        
        userDao = new UserDaoImp();
        userList = new ArrayList<User>();
        
        //为了使用map，也是醉了   另外：map取值时对大小写敏感
        Map<String, Object> map = new Hashtable<String, Object>();
        Map<String, String> namePass = new Hashtable<String, String>();
        namePass.put(userMap.get("username"), userMap.get("userpass"));
        map.put("userMap", namePass);
        
        //登录结果
        userList = userDao.queryByuserNamepassWord(map);//get user Info by userName
        if (userList != null && userList.size() > 0 )
        {
            success(request,response,userMap.get("username"));
            request.getRequestDispatcher("/jsp/join/landing.jsp").forward(request, response);
        }else {
            fail(request, response, "用户名或密码错误");
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
        User username = null;
        
        HttpSession session = request.getSession(true);
        username = (User)session.getAttribute("loginBean");
       
        if (username==null)
        {
            username = new User();
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
    
    /**
     * 登陆成功，储存用户信息
     */
    public void success(HttpServletRequest request,HttpServletResponse response, String username)
    {
        User loginBean = null;
        HttpSession session = request.getSession(true);
        
        try
        {
            loginBean = (User) session.getAttribute("loginBean");//获取session中可能存在的loginBean对象
            if (loginBean == null)
            {
                loginBean = new User();
                session.setAttribute("loginBean", loginBean);//注意jsp获取时需要用到该name的属性名字
                session.setMaxInactiveInterval(600);//十分钟的存活期 单位：秒
                loginBean = (User) session.getAttribute("loginBean");
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
    public void fail(HttpServletRequest request,HttpServletResponse response,String backNews)
    {
        try
        {
            PrintWriter out = response.getWriter();
            out.print(backNews+"<br>");
            out.print("返回"+"<a href=/lyons.eaby.new/jsp/join/login.jsp>登陆界面</a>");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
