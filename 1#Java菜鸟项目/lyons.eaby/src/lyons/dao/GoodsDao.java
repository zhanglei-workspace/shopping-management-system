package lyons.dao;

import java.io.IOException;
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

public class GoodsDao extends HttpServlet
{
	CachedRowSetImpl rowSet = null;//行集对象
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
		String value = null;
		value = request.getParameter("key");
		int key = Integer.parseInt(value);
		queryGoods(request, response, key);
		System.out.println("检测是否有key:"+key);
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
	public void queryGoods(HttpServletRequest request, HttpServletResponse response,int key)
			throws ServletException, IOException
	{	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Goods goods = null;
		
		HttpSession session = request.getSession(true);
		goods = (Goods)session.getAttribute("goods");
//		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		if (goods==null)
		{
			goods = new Goods();
			session.setAttribute("goods", goods);
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
				/* 	//	key=2
					String sqlGprice = "SELECT * FROM GOODS ORDER BY GPRICE ASC";
					try
					{
						pstmt = conn.prepareStatement(sqlGprice);
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
			case 3:
			  /*  //	key=3 购物完成后再次从数据库中获取商品最新信息
                String sqlListClear= "select * from commodity";
                try
                {
                    pstmt = conn.prepareStatement(sqlListClear);
                    rs = pstmt.executeQuery();
                    System.out.println("3执行数据库操作");
                    while (rs.next())
                    {
                        rowSet = new CachedRowSetImpl();
                        rowSet.populate(rs);
                        goods.setRowSet(rowSet);
                        System.out.println("3已经从数据库中获取到值，并塞进行集");
                    }
                } catch (SQLException e)
                {
                    System.out.println("GoodsDao.java k=3 再次查询时出现异常："+e);
                    PrintWriter out = response.getWriter();
                    out.print(e+"<br>");
                    out.print("返回"+"");
                    out.print("<a href=/lyons.eaby/jsp/shoppingCar/lookShoppingCar.jsp>购物车</a>");
                }finally
                        {
                            DbClose.allClose(pstmt, rs, conn);
                        }*/
                break;
			case 4:
					//key=4 浏览商品
					String sqlList= "select * from commodity";
					try
					{
						pstmt = conn.prepareStatement(sqlList);
						rs = pstmt.executeQuery();
						System.out.println("4执行数据库操作");
						while (rs.next())
						{
							rowSet = new CachedRowSetImpl();
							rowSet.populate(rs);
							goods.setRowSet(rowSet);
							System.out.println("4已经从数据库中获取到值，并塞进行集");
							request.getRequestDispatcher("/jsp/browse/showGoods.jsp").forward(request, response);
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