package lyons.goods.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import lyons.goods.entity.Goods;
import lyons.goods.service.GoodsServiceImpl;
import lyons.user.service.UserService;

/**
 * 
 * 处理商品
 * @author  lyons(zhanglei)
 * 
 */
public class GoodsAction extends HttpServlet
{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 001;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        this.doPost(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/html;chartset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        //判断是否登陆
        String user = "";
        user = (new UserService()).isLogin(request, response).trim();
        if ( "".equals(user) || user == null ){return;}
        
        String value = "";
        value = request.getParameter("key");
        int key = Integer.parseInt(value);
        
        String keyWord = "";
        keyWord = request.getParameter("keyWord");
        queryCondition(key,keyWord,request,response);//key 代表查询条件，keyWord代表要查询的关键字
        
    }

    public void queryCondition(int key, String keyWord,HttpServletRequest request, HttpServletResponse response) 
         throws IOException, ServletException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(true);

        List<Goods> goodsList = new ArrayList<Goods>();
        GoodsServiceImpl goodsService = new GoodsServiceImpl();//获取商品服务对象
        Goods goods = null;
        goods = (Goods)session.getAttribute("goods");
        if (goods==null)
        {
            goods = new Goods();
            session.setAttribute("goods", goods);
        }
        switch (key)
        {
            case 1:
                   //key=1 管理员查询他人
                    
                break;
            case 2:
                
                    //key=2 按照关键字查询 商品信息
                    goodsList = goodsService.queryGoodsByKey(keyWord);
                    if(goodsList.size()>0)
                    {
                        goods.setGoodsList(goodsList);
                        session.setAttribute("goods", goods);
                        System.out.println("2已经从数据库中获取到值，并塞进行集");
                        request.getRequestDispatcher("/jsp/browse/showGoods.jsp").forward(request, response);
                    }else 
                        {
                            out.print("<br><br><br><center>");
                            out.print("<font color=green> 亲,查询出错啦.更换关键字再次 </font>");
                            out.print("<a href=/lyons.eaby.new/jsp/browse/searchByKeyWord.jsp><font color=red size=6>查询</font></a>");
                            out.print("</center>");     
                        }
                    break;
            case 3:
                    break;
            case 4:
                        //查询商品列表
                        goodsList = goodsService.queryList();
                        if(goodsList.size()>0)
                        {
                           goods.setGoodsList(goodsList);
                           session.setAttribute("goods", goods);
                           request.getRequestDispatcher("/jsp/browse/showGoods.jsp").forward(request, response);
                        }else 
                            {
                                out.print("<br><br><br><center>");
                                out.print("<font color=green> 亲,卖家还没上货呢 </font>");
                                out.print("<a href=/lyons.eaby.new/lyons.dao/GoodsDao?key=4><font color=red size=6>进入首页</font></a>");
                                out.print("</center>");     
                            }
                 
                    break;
            default:
                break;
        }
        
    }
    
}
