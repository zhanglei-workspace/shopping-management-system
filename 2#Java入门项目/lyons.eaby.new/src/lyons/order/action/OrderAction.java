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
        /**
         *      jsp传来的key参数说明
         * 1：查询当前用户所有订单列表
         * 2：查询所有用户订单列表
         * 3：按照条件查询订单 用户名+商品关键字(未使用)
         * 4：删除单个订单
         * 5：
         * 6：
         */
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //判断是否登陆
        String user = "";
        user = (new UserService()).isLogin(request, response).trim();
        if ( "".equals(user) || user == null ){return;}
        
        String id = "";                         //商品唯一标识id 
        String key = "";                        //选择查询条件
        String keyWord = "";                    //查询的关键字
        String queryUserName = "";              //查询的用户名
        id = request.getParameter("id");
        key = request.getParameter("key");
        keyWord = request.getParameter("keyWord");
        queryUserName = request.getParameter("queryUserName");
        
        String str[] = {id,key,keyWord,queryUserName,user};  
        queryCondition(str,request,response);//key 代表查询条件，keyWord代表要查询的关键字
        
    }
    /**
     * 
     * 根据条件选择查询的业务
     * @param str
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void queryCondition(String str[],HttpServletRequest request, HttpServletResponse response) 
         throws IOException, ServletException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        
        String idStr = str[0];             //商品唯一标识id
        String keyStr = str[1];            //选择查询条件
        String keyWord = str[2];           //查询的关键字
        String queryUserName = str[3];     //查询的用户名
        String user = str[4];              //当前用户
        
        int id = -1;
        if (!(idStr==null || "".equals(idStr)))
        {
            id = Integer.parseInt(idStr);
        }
        int key = Integer.parseInt(keyStr);
          
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
                            out.print("<a href=/lyons.eaby.new/lyons.dao/GoodsDao?key=4><font color=red size=6>Go Shopping</font></a>");
                            out.print("</center>");     
                        }
                    
                break;
            case 2:
                    //查询所有用户订单列表
                
                    order = new Order();
                    //查询订单
                    orderList = orderService.orderAllList();
                  
                    //不管有没有查询到值到要返回订单列表
                    order.setOrderList(orderList);
                    session.setAttribute("orderAllList", order);
                    request.getRequestDispatcher("/jsp/manageGoods/OrderList.jsp").forward(request, response);
                    
                break;
            case 3:
                    //key=3 按照条件查询订单 用户名+商品关键字(未使用)
                
                    //将查询信息封装到对象中
                    order = new Order();
                    order.setUserName(queryUserName);
                    order.setKeyWord(keyWord);
                    
                    
                    //查询订单
                    orderList = orderService.orderListByKeyName(order);
                    
                    order.setOrderList(orderList);
                    session.setAttribute("orderAllList", order);
                    request.getRequestDispatcher("/jsp/manageGoods/OrderList.jsp").forward(request, response);
                  
                    break;
              case 4:
                      //删除单个订单
                      order = new Order();
                      System.out.println("开始删除");
                      orderService.deleteOrderOneById(id);       //删除订单
                      System.out.println("开始查询");
                      orderList = orderService.orderAllList();   //重新查询订单列表
                      System.out.println("查询结束");
                    
                      //不管有没有查询到值到要返回订单列表
                      order.setOrderList(orderList);
                      session.setAttribute("orderAllList", order);
                      request.getRequestDispatcher("/jsp/manageGoods/OrderList.jsp").forward(request, response);
                  
                  break;
              case 5:
                  break;
              case 6:
                  break;
            default:
                break;
        }
    }  
}
