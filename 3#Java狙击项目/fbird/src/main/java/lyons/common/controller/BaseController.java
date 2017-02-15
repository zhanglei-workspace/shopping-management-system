/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import lyons.common.model.goods.GCar;
import lyons.common.model.goods.Goods;
import lyons.core.shiro.token.TokenManager;

/**
 * @Description: Controller基础类
 * @ClassName: BaseController
 * @author: lyons<zhanglei>
 * @date: 2017年1月18日 下午4:49:16
 * @version: [1.0]
 */
public class BaseController
{
    protected ModelAndView modelAndView = new ModelAndView();
//    protected List<GOrder> orderList = new LinkedList<GOrder>();
    protected static List<Goods> goodsList = new LinkedList<Goods>();
    protected static List<GCar> carList = new LinkedList<GCar>();
    protected Goods goods;
    
    /**
     * @Title:BaseController
     * @Description:TODO
     */
    public BaseController()
    {
    }
    
    /**
     * @Title: getCurrentUsername
     * @Description: 获取当前用户名
     * @return: String
     */
    protected String getCurrentUsername()
    {
        return TokenManager.getToken().getuName();
    }
    
    /**
     * @Title: initData
     * @Description: 清空残余数据
     * @return: void
     */
    protected void initData()
    {
        carList.clear();
        goodsList.clear();
    }
    
}
