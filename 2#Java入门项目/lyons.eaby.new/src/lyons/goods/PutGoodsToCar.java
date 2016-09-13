package lyons.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lyons.user.entity.Login;

@SuppressWarnings("serial")
public class PutGoodsToCar extends HttpServlet
{
    
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
        String goods = null;
        goods = request.getParameter("GoodsCar");
        
        if (goods==null)
        {
            response.sendRedirect("/lyons.eaby.new/index.jsp");
        }else 
            {
                String[] details = null;
                details = goods.split(",");//数组内储存的信息与数据库一致。
                
                //将物品信息放进模型中
                HttpSession session = request.getSession(true);
                Login loginBean = (Login)session.getAttribute("loginBean");
                LinkedList<String> car = null;
                car = loginBean.getCar();
               /* if (request.getAttribute("clear")!=null) //购物车完成结算，清空数据！
                {
                   car = null;
                }*/
                car.add(goods);
                loginBean.setCar(car);
                
                backNews(request, response, details[1]);//参数三：商品吗名称
            }
     
    }
    
    
    /**
     * 
     * 返回用户消息
     * 添加购物车成功后，返回提示操作信息
     * @param request
     * @param response
     * @param goodsName
     * @throws IOException
     */
    private void backNews(HttpServletRequest request, HttpServletResponse response, String goodsName) throws IOException
    {
        
        PrintWriter out = response.getWriter();
        out.print("<br><br><br>");
        out.print("<center><font size=5 color=red><B>"+goodsName+"</B></font>&nbsp;已成功添加购物车");
        out.print("<br><br><br>");
        out.print("<a href=/lyons.eaby.new/jsp/browse/showGoods.jsp>返回继续购物</a>");
        out.print("&nbsp;or&nbsp;");
        out.print("<a href=/lyons.eaby.new/jsp/shoppingCar/lookShoppingCar.jsp>查看购物车</a></center>");
        
    }
    
}
