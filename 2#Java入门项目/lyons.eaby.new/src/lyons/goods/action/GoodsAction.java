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
import lyons.util.Iconst;

/**
 * 
 * 处理Goods表  等待代码重构，太乱
 * @author  lyons(zhanglei)
 * 
 */
@SuppressWarnings("serial")
public class GoodsAction extends HttpServlet
{

    String user;
    String key;
    String keyWord;
    String goodsClassify;
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
        user = (new UserService()).isLogin(request, response).trim();
        if ( "".equals(user) || user == null ){return;}
        
        key = request.getParameter("key");
        keyWord = request.getParameter("keyWord");
        goodsClassify = request.getParameter("goodsClassify");
        
        queryCondition(key,keyWord,goodsClassify,request,response);//key 代表查询条件，keyWord代表要查询的关键字
    }

    public void queryCondition(String key, String keyWord,String goodsClassify,HttpServletRequest request, HttpServletResponse response) 
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
        
        
        //key=1 查询商品信息 （关键字||分类）or（关键字&&分类）
        //key=2 按照关键字查询 商品信息
        //key=4 查询商品列表
        if ("1".equals(key)){
                goodsList = goodsService.queryGoodsByKeyClassify(keyWord,goodsClassify);
        }else if ("2".equals(key)) {
                      goodsList = goodsService.queryGoodsByKey(keyWord);
                 }else if ("4".equals(key)) {
                               goodsList = goodsService.queryList();
                         }
        //处理查询结果
        if(goodsList.size()>0)
        {
            goods.setGoodsList(goodsList);
            session.setAttribute("goods", goods);
            request.getRequestDispatcher("/jsp/browse/showGoods.jsp").forward(request, response);
        }else if("4".equals(key)){
                    out.print(Iconst.QUERY_ALLGOODS_RETURN_NULL);
              }else{
                 out.print(Iconst.QUERY_ALLGOODS_BY_CONDITION_RETURN_NULL);     
              }

    }
    
}
