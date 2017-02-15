/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.controller.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lyons.common.controller.BaseController;
import lyons.common.model.goods.GOrder;
import lyons.common.model.goods.Goods;
import lyons.common.service.goods.GOrderService;
import lyons.common.service.goods.GoodsService;

/**
 * @Description: 商品展示
 * @ClassName: GoodsController
 * @author: lyons<zhanglei>
 * @date: 2017年2月6日 下午6:22:29
 * @version: [1.0]
 */
@Controller
public class GoodsController extends BaseController
{
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GOrderService orderService;
    
    
    @RequestMapping("/buy")
    public String buy(Model model,String detailgId)
    {
        goodsList.clear();
        goodsList.add(goodsService.findDetail(detailgId));
        
        model.addAttribute("buyingList", goodsList);
        return "/goods/buy";
    }
    
    
    /**
     * @Title: show
     * @Description: 查询所有商品
     * @return: List<Goods>
     */
    @RequestMapping(value="/goods/show",method = RequestMethod.POST)
    public List<Goods> show()
    {
      return  goodsService.findAllGoods();
    }
    
    /**
     * @Title: query
     * @Description: 搜索商品
     * @param keyword
     * @param model
     * @return: void
     */
    @RequestMapping(value="/queryGoodsByKeyword")
    public String query(@RequestParam("keyword") String keyword,Model model)
    {
        model.addAttribute("goodsList", goodsService.queryByKeyword(keyword));
        return "goods/query";
    }
    
    /**
     * @Title: detail
     * @Description: 商品详情
     * @param gId
     * @param map
     * @return: String
     */
    @RequestMapping("/goodsDetail")
    public ModelAndView detail(@RequestParam("gId") String gId,Model model)
    {
        goods = goodsService.findDetail(gId);
        if (goods != null)
        {
            model.addAttribute("goodsDetail", goods);
            modelAndView.setViewName("/goods/detail");
        }else {
            modelAndView.setViewName("error/404");
        }
        
        return modelAndView;
    }

    /**
     * @Title: buy
     * @Description: 购买商品
     * @param order
     * @return: int
     */
    @RequestMapping(value="/goods/buy",method = RequestMethod.POST)
    public int buy(List<GOrder> orders)
    {
        
        /*
         * 减库存
         */
        
        
        /*
         *添加到订单表中 
         */
        orderService.buyInsertsOrder(orders);
        return 1;
    }
}
