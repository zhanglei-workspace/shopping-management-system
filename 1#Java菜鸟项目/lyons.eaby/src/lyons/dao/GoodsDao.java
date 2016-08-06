package lyons.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.rowset.CachedRowSetImpl;

import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.Goods;
import lyons.entity.Login;

public class GoodsDao extends HttpServlet
{
	/**
     * serialVersionUID
     */
    private static final long serialVersionUID = 135785434567L;
 
	/**
	 * Constructor of the object.
	 */
	public GoodsDao()
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

		response.setContentType("text/html;chartset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String value = "";
		value = request.getParameter("key");
		int key = Integer.parseInt(value);
		System.out.println("检测是否有key:"+key);
		
		String keyWord = "";
		keyWord = request.getParameter("keyWord");
		System.out.println(keyWord);
		queryGoods(request, response, key,keyWord);
	}

	public void init() throws ServletException
	{
		// Put your code here
	}
	
	/**
	 * 商品查询
	 * @param request
	 * @param response
	 * @param key 查询的条件/int:4(简单查询)
	 * @return 商品信息数组
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryGoods(HttpServletRequest request, HttpServletResponse response,int key,String keyWord)
			throws ServletException, IOException
	{
	    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        CachedRowSetImpl rowSet = null;//行集对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Goods goods = null;
		Login username = null;
//		OrderForm orderForm = null;
		
		HttpSession session = request.getSession(true);
		username = (Login)session.getAttribute("loginBean");
		goods = (Goods)session.getAttribute("goods");
//		orderForm = (OrderForm)session.getAttribute("orderForm");
//		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		if (goods==null)
		{
			goods = new Goods();
			session.setAttribute("goods", goods);
		}
		if (username==null)
		{
		    username = new Login();
		    session.setAttribute("username", username);
		}
//		if (orderForm==null)
//		{
//		    orderForm = new OrderForm();
//		    session.setAttribute("orderForm", orderForm);
//		}
		  //判断用户是否登陆
		  String user = "";
          user = username.getUsername();//登陆者的用户名
          System.out.println("我是用户："+user);
          if (user.equals("userNull"))
          {
              out.print("<br>");
              out.print("<center><font color=#008B8B> 登陆之后才能看订单哦  </font>");
              out.print("<a href=/lyons.eaby/jsp/join/login.jsp><font color=red size=6>登陆</font></a></center>");
              return;
          }
		
		conn = DbConn.getConn();	

		switch (key)
		{
			case 1:
					/*//	key=1商品 数量 升序查询
					String sqlGnum = "SELECT * FROM GOODS ORDER BY GNUM ASC";
					try
					{
						pstmt = conn.prepareStatement(sqlGnum);
						rs = pstmt.executeQuery();
						while (rs.next())
						{
							
						}
					} catch (SQLException e)
					{
						e.printStackTrace();
					}finally
							{
								DbClose.allClose(pstmt, rs, conn);
							}*/
				break;
			case 2:
        			  //key=2 按照关键字查询 商品信息
                      
                        String sqlShowGoodsByKey =  
                        "select * from commodity WHERE commodity_name LIKE '%'||?||'%'";
                        try
                        {
                            pstmt = conn.prepareStatement(sqlShowGoodsByKey);
                            pstmt.setString(1, keyWord);
                            rs = pstmt.executeQuery();
                            System.out.println("--2查看订单执行数据库操作--");
                            if(rs.next())
                            {
                                rs = pstmt.executeQuery();//重新查询的原因是rs.next时光标偏移后，丢掉记录。
                                rowSet = new CachedRowSetImpl();
                                rowSet.populate(rs); 
                                goods.setRowSet(rowSet);
                                System.out.println("2已经从数据库中获取到值，并塞进行集");
                                request.getRequestDispatcher("/jsp/browse/showGoods.jsp").forward(request, response);
                            }else 
                                {
                                    out.print("<br><br><br><center>");
                                    out.print("<font color=green> 亲,查询出错啦.更换关键字再次 </font>");
                                    out.print("<a href=/lyons.eaby/jsp/browse/searchByKeyWord.jsp><font color=red size=6>查询</font></a>");
                                    out.print("</center>");     
                                }
                        } catch (SQLException e)
                        {
                            System.out.println("key=3查看订单异常："+e);
                            
                        }finally
                                {
                                    System.out.println("查看订单执行关闭流");
                                    DbClose.allClose(pstmt, rs, conn);
                                }
        				break;
			case 3:
                    //key=3 按照登录人查询订单 商品名字+数量
			      
                    String sqlOrder= 
                    "select commodity_name,sum(sum) from orderform where username=? group by commodity_name having sum(sum)>0";
                    try
                    {
                        pstmt = conn.prepareStatement(sqlOrder);
                        pstmt.setString(1, user);
                        rs = pstmt.executeQuery();
                        System.out.println("--查看订单执行数据库操作--");
                        if(rs.next())
                        {
                            rs = pstmt.executeQuery();//重新查询的原因是rs.next时光标偏移后，丢掉记录。
                            rowSet = new CachedRowSetImpl();
                            rowSet.populate(rs); 
                            goods.setRowSet(rowSet);
                            System.out.println("3已经从数据库中获取到值，并塞进行集");
                            request.getRequestDispatcher("/jsp/order/lookOrderForm.jsp").forward(request, response);
                        }else 
                            {
                                out.print("<br><br><br><center>");
                                out.print("<font color=green> 亲,订单是空的呢 </font>");
                                out.print("<a href=/lyons.eaby/lyons.dao/GoodsDao?key=4><font color=red size=6>Go Shopping</font></a>");
                                out.print("</center>");		
                            }
                    } catch (SQLException e)
                    {
                        System.out.println("key=3查看订单异常："+e);
                        
                    }finally
                            {
                                System.out.println("查看订单执行关闭流");
                                DbClose.allClose(pstmt, rs, conn);
                            }
                    break;
			case 4:
			        StringBuffer url = request.getRequestURL();
			        System.out.println("4324234=========="+url.toString());
					//key=4 浏览商品
					String sqlList= "select * from commodity";
					try
					{
						pstmt = conn.prepareStatement(sqlList);
						rs = pstmt.executeQuery();
						System.out.println("--4浏览商品执行数据库操作--");
						if(rs.next())
						{
						    rs = pstmt.executeQuery();//重新查询的原因是rs.next时光标偏移后，丢掉记录。
							rowSet = new CachedRowSetImpl();
							rowSet.populate(rs);
							goods.setRowSet(rowSet);
							System.out.println("4浏览商品已经从数据库中获取到值，并塞进行集");
							request.getRequestDispatcher("/jsp/browse/showGoods.jsp").forward(request, response);
						}else 
                        {
                                out.print("<br><br><br><center>");
                                out.print("<font color=green> 亲,卖家还没上货呢 </font>");
                                out.print("<a href=/lyons.eaby/lyons.dao/GoodsDao?key=4><font color=red size=6>进入首页</font></a>");
                                out.print("</center>");     
                            }
					} catch (SQLException e)
					{
						e.printStackTrace();
						response.sendRedirect("/lyons.eaby/jsp/browse/showGoods.jsp");
					}finally
							{
								DbClose.allClose(pstmt, rs, conn);
							}
					break;
			default:
				break;
		}
	}

}