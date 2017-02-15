/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.service.goods;


import java.util.List;

import lyons.common.model.goods.GOrder;

/**
 * @Description: 订单服务类
 * @ClassName: GOrderService
 * @author: lyons<zhanglei>
 * @date: 2017年2月12日 下午6:56:37
 * @version: [1.0]
 */
public interface GOrderService
{
    /** batch inserts into goods order*/
    int buyInsertsOrder(List<GOrder> listOrders);
}
