/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.controller.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lyons.common.controller.BaseController;
import lyons.common.model.goods.GCar;
import lyons.common.service.goods.GCarService;
import lyons.common.utils.ResultUtil;
import lyons.common.utils.enums.GoodsStaEnum;

/**
 * @Description: 购物车删除、添加
 * @ClassName: CarController
 * @author: lyons<zhanglei>
 * @date: 2017年2月10日 下午8:29:30
 * @version: [1.0]
 */
@Controller
public class CarController extends BaseController
{
    @Autowired
    private GCarService gCarService;
    
    @RequestMapping("/myCar")
    public String myCar(Model model)
    {
        initData();
        model.addAttribute("carList", gCarService.findMyCar(getCurrentUsername()));
        
        return "/order/car";
    }
     
    /**
     * @Title: carDelete
     * @Description: 从购物车删除
     * @param car
     * @return: String
     */
    @RequestMapping(value="/carDelete", method = RequestMethod.POST,
        produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String delete(String gCarGId)
    {
        /**
         * TODO try catch抛异常
         */
        gCarService.carDelete(getCurrentUsername(),gCarGId);
        return ResultUtil.getJson(GoodsStaEnum.success.getState());

    }
    
    /**
     * @Title: add
     * @Description: 添加商品到购物车
     * @param car
     * @return
     * @return: String
     */
    @RequestMapping(value="/carAdd", method = RequestMethod.POST,
        produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String add(GCar car)
    {
        /**
         * TODO try catch抛异常
         */
        String username = getCurrentUsername();
        car.setgCarUName(username);
        gCarService.carAdd(car);
        return ResultUtil.getJson(GoodsStaEnum.success.getState());
        
    }
}
