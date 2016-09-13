package lyons.dao;

import java.util.List;
import java.util.Map;

import lyons.goods.entity.Goods;

/**
 * 
 * Goods.xml 对应的接口
 * 
 * @author lyons(zhanglei)
 * 
 * 1.接口名与配置文件namespace的值相同(自定义的名字，只要一致就行)
 * 2.方法名与查询语句的id相同
 * 3.方法参数与parameterType的返回类型相同
 * 4.返回值的类型与resultMap类型相同
 */
public interface GoodsDao
{
    /** 查询所有商品列表**/
    public List<Goods> goodsAllList();
    /** 商品名关键字查询　**/
    public List<Goods> queryGoodsByKey(String keyWord);
    /** （关键字||分类）or（关键字&&分类） 查询  **/
    public List<Goods> queryGoodsByKeyClassify(Goods goods);
    
    /** 通过商品唯一标识单个删除数据 **/
    public void deleteOneGoodsById(int goodsId);
    
    /** 更新商品信息**/
    public void updateGoods(List<Goods> listgoods);
    
}
