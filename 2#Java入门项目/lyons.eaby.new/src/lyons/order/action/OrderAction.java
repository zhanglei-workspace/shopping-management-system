package lyons.order.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lyons.order.entity.Order;
import lyons.order.service.OrderServiceImpl;
import lyons.user.service.UserService;

public class OrderAction extends HttpServlet
{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 002;
    

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        
        String value = "";
        value = request.getParameter("key");
        int key = Integer.parseInt(value);
        System.out.println("检测是否有key:"+key);
        
        String keyWord = "";
        String queryUserName = "";
        keyWord = request.getParameter("keyWord");
        queryUserName = request.getParameter("queryUserName");
        
        queryCondition(key,queryUserName,keyWord,request,response);//key 代表查询条件，keyWord代表要查询的关键字
        
    }
    
    public void queryCondition(int key, String keyWord,String queryUserName,HttpServletRequest request, HttpServletResponse response) 
         throws IOException, ServletException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        
        //判断是否登陆
        String user = "";
        user = (new UserService()).isLogin(request, response).trim();
        if ( "".equals(user) || user == null ){return;}
          
        OrderServiceImpl orderService = new OrderServiceImpl();//获取订单服务对象
        List<Order> orderList = new ArrayList<Order>();
        Order order = null;
        order = (Order)session.getAttribute("order");
        if (order==null)
        {
            order = new Order();
            session.setAttribute("order", order);
        }
        switch (key)
        {
            case 1:
                    //key=1 查询当前用户所有订单列表
                
                    //将查询信息封装到对象中
                    order = new Order();
                    //查询订单
                    orderList = orderService.orderList(user);
                  
                    if(orderList.size()>0)
                    {
                        order.setOrderList(orderList);
                        session.setAttribute("orderList", order);
                        request.getRequestDispatcher("/jsp/order/lookOrderForm.jsp").forward(request, response);
                    }else 
                        {
                            out.print("<br><br><br><center>");
                            out.print("<font color=green> 亲,您的订单是空的呢 </font>");
                            out.print("<a href=/lyons.eaby/lyons.dao/GoodsDao?key=4><font color=red size=6>Go Shopping</font></a>");
                            out.print("</center>");     
                        }
                    
                break;
            case 3:
                    //key=3 按照条件查询订单 用户名+商品关键字(未使用)
                
                    //将查询信息封装到对象中
                    order = new Order();
                    order.setUserName(queryUserName);
                    order.setKeyWord(keyWord);
                    
                    //查询订单
                    orderList = orderService.orderListByKeyName(order);
                  
                    System.out.println("--查看订单执行数据库操作--");
                    if(orderList.size()>0)
                    {
                        order.setOrderList(orderList);
                        session.setAttribute("orderListByKeyName", order);
                        request.getRequestDispatcher("/jsp/order/lookOrderForm.jsp").forward(request, response);
                    }else 
                        {
                            out.print("<br><br><br><center>");
                            out.print("<font color=green> 亲,根据此此条件检索的订单是空的呢 </font>");
                            out.print("<a href=/lyons.eaby/lyons.dao/GoodsDao?key=4><font color=red size=6>Go Shopping</font></a>");
                            out.print("</center>");     
                        }
                  
                    break;
            default:
                break;
        }
    }  
}
