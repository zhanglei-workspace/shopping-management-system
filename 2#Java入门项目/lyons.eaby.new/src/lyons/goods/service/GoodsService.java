package lyons.goods.service;

import java.util.List;

import lyons.goods.entity.Goods;

/**
 * 
 * 商品接口
 * 
 * @author  (Lyons)zhanglei
 * 
 */
public interface GoodsService
{
    /** 查询信息列表 **/
    public List<Goods> queryList();
    
    /** 根据关键字查询商品信息 **/
    public List<Goods> queryGoodsByKey(String condition);
}
