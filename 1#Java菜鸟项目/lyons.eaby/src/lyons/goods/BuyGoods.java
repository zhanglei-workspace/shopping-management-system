package lyons.goods;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.Login;

public class BuyGoods extends HttpServlet
{
    
    /**
     * Constructor of the object.
     */
    public BuyGoods()
    {
        super();
    }
    
    /**
     * Destruction of the servlet. <br>
     */
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
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        //从模型中直接拿取购物车信息
        HttpSession session = request.getSession(true);
        Login loginBean = (Login)session.getAttribute("loginBean");
        LinkedList<String> car = null;
        car = loginBean.getCar();
        
        //购物车是否为空，向数据库中删除与插入数据
        if (car.size()!=0)
        {
           /* Connection        conn  = null;
            PreparedStatement pstmt = null;
            
            conn = DbConn.getConn();*/
            
            //将商品数据遍历到数组中,并对应  修改sqlCommodity、写入sqlOrder
            for (int i = 0,m=car.size(); i < m; i++)
            {
                String[] goods = null;
                goods = car.get(i).split(",");
                    
         /*       String sqlCommodity = "update Commodity set commodity_balance=? where commodity_number=?";
                String sqlOrder = "";
                try
                {
                    pstmt = conn.prepareStatement(sqlCommodity);
                    
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
                        request.getRequestDispatcher("/jsp/join/register.jsp")
                                                                    .forward(request, response);
                    }
                } catch (SQLException e)
                {
                    backNews = "该用户名已被注册"+"<br>"+e;
                    userBean.setBackNews(backNews);
                    request.getRequestDispatcher("/jsp/join/register.jsp")
                                                                    .forward(request, response);
                }finally
                {
                    DbClose.close(pstmt, conn);
                }*/
                    
                    
                    
                System.out.println();
            }
            
            
            
            //付款成功，清除数据模型中的数据
            car.clear();
        }
        return;
     
    }

    public void init()
        throws ServletException
    {
        // Put your code here
    }
    
}
