package lyons.goods.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.goods.entity.Goods;
import lyons.goods.service.GoodsServiceImpl;
import lyons.user.entity.Login;
import lyons.user.service.UserService;
import lyons.util.Iconst;

import com.sun.rowset.CachedRowSetImpl;

@SuppressWarnings("serial")
public class BuyGoodsAction extends HttpServlet
{
    String userName, backNews;
    
    LinkedList<String> car;
    
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
        
        // 判断是否登陆
        userName = (new UserService()).isLogin(request, response).trim();
        if ("".equals(userName) || userName == null){return;}
        
        // 从模型中直接拿取购物车信息
        HttpSession session = request.getSession(true);
        Login loginBean = (Login)session.getAttribute("loginBean");
        car = loginBean.getCar();
        GoodsServiceImpl goodsService = new GoodsServiceImpl();// 获取商品服务对象
        
        String backNews = goodsService.BuyGoods(userName,car);// 购物清算
        messShopping(request,response,backNews);     // 打印处理结果
        car.clear();
        
        //从数据中更新行集对象    马上改善这种实现方式
        updateInfo(request, response);
    }
    
    /**
     * 
     * 从数据库中更新行集对象 <功能详细描述>
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    private void updateInfo(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        CachedRowSetImpl rowSet = null;// 行集对象
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Goods goods = null;
        
        HttpSession session = request.getSession(true);
        goods = (Goods)session.getAttribute("goods");
        // ArrayList<Goods> goodsList = new ArrayList<Goods>();
        if (goods == null)
        {
            goods = new Goods();
            session.setAttribute("goods", goods);
        }
        
        conn = DbConn.getConn();
        
        String sqlListClear = "select * from commodity";
        try
        {
            pstmt = conn.prepareStatement(sqlListClear);
            rs = pstmt.executeQuery();
            System.out.println("3执行数据库操作");
            while (rs.next())
            {
                rowSet = new CachedRowSetImpl();
                rowSet.populate(rs);
                // goods.setRowSet(rowSet); 故意注释掉的
                System.out.println("3已经从数据库中获取到值，并塞进行集");
            }
        }
        catch (SQLException e)
        {
            System.out.println("GoodsDao.java k=3 再次查询时出现异常：" + e);
            PrintWriter out = response.getWriter();
            out.print(e + "<br>");
            out.print("返回" + "");
            out.print("<a href=/lyons.eaby.new/jsp/shoppingCar/lookShoppingCar.jsp>购物车</a>");
        }
        finally
        {
            DbClose.allClose(pstmt, rs, conn);
        }
        
    }
    
    /**
     * 
     * 打印商品购买处理结果
     * @param request
     * @param response
     * @param mess  返回的处理消息
     * @throws IOException
     */
    public static void messShopping(HttpServletRequest request, HttpServletResponse response, String mess)
        throws IOException
    {
        PrintWriter out = response.getWriter();
        
        out.print(Iconst.buy_goods_success_1 + mess + Iconst.buy_goods_success_2);
    }
}
