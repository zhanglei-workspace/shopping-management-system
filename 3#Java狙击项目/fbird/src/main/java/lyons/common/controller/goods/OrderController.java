/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.controller.goods;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 商品订单
 * @ClassName: OrderController
 * @author: lyons<zhanglei>
 * @date: 2017年2月10日 下午4:49:50
 * @version: [1.0]
 */
@Controller
public class OrderController
{
    
    @RequestMapping("order")
    public String order()
    {
        return "/order/order";
    }
/*    
    @RequestMapping(value="/order/order", method = RequestMethod.POST,
        produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String queryOrder()
    {
        
    }*/
    
}
