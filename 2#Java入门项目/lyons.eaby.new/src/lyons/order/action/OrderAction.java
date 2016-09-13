package lyons.order.action;

import java.io.IOException;
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

@SuppressWarnings("serial")
public class OrderAction extends HttpServlet
{
    int keys = -1;                     //默认的查询值（即：default ）
    String user;                       //当前用户
    String key;                        //选择查询条件
    String keyWord;                    //查询的关键字
    String queryUserName;              //查询的用户名
    String id;                         //商品唯一标识id 
    String ids[];                      //批量删除商品的ids
    List<Order> orderList = new ArrayList<Order>();
    OrderServiceImpl orderService = new OrderServiceImpl();//获取订单服务对象
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        this.doPost(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //判断是否登陆
        user = (new UserService()).isLogin(request, response).trim();
        if ( "".equals(user) || user == null ){return;}
        
        /**
         *    jsp传来的key参数说明
         *      
         * 1：查询当前用户所有订单列表
         * 2：查询所有用户订单列表
         * 3：按照条件查询订单 用户名+商品关键字
         * 
         * 4：删除单个订单
         * 5：批量删除订单
         * 6：
         */
        key = request.getParameter("key").trim();
        System.out.println(key+"---------");
        if (key.matches("[1-3]"))
        {
            keyWord = request.getParameter("keyWord");
            queryUserName = request.getParameter("queryUserName");
            String str[] = {key,keyWord,queryUserName,user};
            queryCondition(str,request,response);//key 代表查询条件，keyWord代表要查询的关键字
            
        }else if (key.matches("[4-5]")) {
            
            id = request.getParameter("id");        
            ids = request.getParameterValues("deleteId");
            String str[] = {key,id};
            deleteCondition(str,ids,request,response);
        }
        
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
        HttpSession session = request.getSession(true);
        
        key = str[0];               //选择查询条件
        keyWord = str[1];           //查询的关键字
        queryUserName = str[2];     //查询的用户名
        user = str[3];              //当前用户
        keys = Integer.parseInt(key);  
        orderList.clear();
        Order order = null;
//        order = new Order();
        order = (Order)session.getAttribute("order");
        if (order==null)
        {
            order = new Order();
            session.setAttribute("order", order);
        }
        
        //key=1 查询当前用户所有订单列表
        //key=2 查询所有用户订单列表
        //key=3 按照条件查询订单 用户名+商品关键字
        if ("1".equals(key)){
            orderList = orderService.orderList(user);
        }else if ("2".equals(key)) {
                    orderList = orderService.orderAllList();
                 }else if ("3".equals(key)) {
                             //将查询信息封装到对象中
                             orderList = orderService.orderListByKeyName(queryUserName,keyWord);
                         }
        
        order.setOrderList(orderList);
        session.setAttribute("orderAllList", order);
        request.getRequestDispatcher("/jsp/manageGoods/OrderList.jsp").forward(request, response);
    }
    
    /**
     * 
     * 根据条件选择删除订单的业务
     * 
     * @param str
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void deleteCondition(String str[],String ids[],HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException
    {
       response.setContentType("text/html;charset=UTF-8");
       HttpSession session = request.getSession(true);
       
       key = str[0]; 
       id = str[1];
         
       Order order = null;
       order = new Order();
       orderList.clear();
       order = (Order)session.getAttribute("order");
       if (order==null)
       {
           order = new Order();
           session.setAttribute("order", order);
       }
       
        if ("4".equals(key)){
           orderService.deleteOrderOneById(id);       //删除单个订单
           orderList = orderService.orderAllList();   //重新查询订单列表(应该根据之前的检索条件查询)
        }else if ("5".equals(key)) {
                   orderService.deleteOrderBatch(ids);        //批量删除订单
                   orderList = orderService.orderAllList();   //重新查询订单列表(应该根据之前的检索条件查询)
                 }
        
        //不管有没有查询到值都要返回订单列表
        order.setOrderList(orderList);
        session.setAttribute("orderAllList", order);
        request.getRequestDispatcher("/jsp/manageGoods/OrderList.jsp").forward(request, response);
      
    }
}
