package lyons.user.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lyons.dao.UserDaoImp;
import lyons.user.entity.User;

/**
 * 
 * 用户注册服务类
 * 
 * @author  lyons(zhanglei)
 * 
 * 合法验证应该留给前端js
 */
public class RegisterService
{
    String username;
    String userpass;
    String again_userpass;
    String phone;
    User userBean = new User();
    UserDaoImp userDao = new  UserDaoImp();
    UserService userService = new UserService();
//    Map<String, Object> registerUserMap = new HashMap<String, Object>();
    public void register(HttpServletRequest request, HttpServletResponse response,
        Map<String, String> registerMap) throws ServletException, IOException
    {
        username = registerMap.get("username");
        userpass = registerMap.get("userpass");
        again_userpass = registerMap.get("again_userpass");
        phone = registerMap.get("phone");
        
        request.setAttribute("userBean", userBean);
        
        if (username==null)
        {
            username = "";
        }
        if (userpass==""||userpass==null)
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
//                      String regex = "[\\w]{4,16}";
//                      boolean userFlag = username.matches(regex) && userpass.length()>5;
                        if (userpass.length()>5) //密码长度限制 至少六位数
                        {
                            
                            if (userService.isExistence(username))
                            {
                                backNews = "该用户名已被注册"+"<br>";  //这样的验证留给js前端验证
                                userBean.setBackNews(backNews);
                                request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
                            }else {
                                    userDao.insertUser(registerMap);//去注册
                                    backNews = "注册成功";
                                    userBean.setBackNews(backNews);
                                    request.getRequestDispatcher("/jsp/join/registerSuccess.jsp").forward(request, response);
                            }
                        }else 
                            {
                                userBean.setBackNews("密码不合法");
                                request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
                            }
                    }
        
    }
    
}
