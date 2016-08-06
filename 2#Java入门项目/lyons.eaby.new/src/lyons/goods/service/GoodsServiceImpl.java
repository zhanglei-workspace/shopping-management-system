package lyons.goods.service;

import java.util.List;

import lyons.dao.GoodsDao;
import lyons.goods.entity.Goods;

/**
 * 
 * 商品服务处理逻辑类
 * 
 * @author  (Lyons)zhanglei
 * 
 */
public class GoodsServiceImpl implements GoodsService
{
    GoodsDao goodsDao = new GoodsDao();
    
    /**
     * 
     * 查询商品服务实现类
     * 查询全部商品列表
     * @return
     */
    @Override
    public List<Goods> queryList()
    {
        return goodsDao.queryGoods();
    }
    
    /**
     * 
     * 查询商品服务实现类
     * 根据关键字查询
     * @return
     */
    @Override
    public List<Goods> queryGoodsByKey(String keyWord)
    {
        return goodsDao.queryGoodsByKey(keyWord);
    }
    
    
    
}
