/*Copyright ©  2017 Lyons. All rights reserved. */
package lyons.common.service.goods;

import java.util.List;

import lyons.common.model.goods.Goods;

/**
 * @Description: 商品服务类
 * @ClassName: GoodsService
 * @author: lyons<zhanglei>
 * @date: 2017年2月6日 下午6:49:04
 * @version: [1.0]
 */
public interface GoodsService
{
    /** find all goods **/
    List<Goods> findAllGoods();

    /** find goods by keyword*/
    List<Goods> queryByKeyword(String keyword);

    /** find goods by id*/
    Goods findDetail(String gId);
}
