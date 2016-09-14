package lyons.goods.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import lyons.dao.GoodsDaoImpl;
import lyons.goods.entity.Goods;
import lyons.order.entity.Order;
import lyons.order.service.OrderServiceImpl;


/**
 * 
 * 商品服务处理逻辑类
 * 
 * @author  (Lyons)zhanglei
 * 
 */
public class GoodsServiceImpl
{
    Order order;
    Goods goods;
    String[] goodsArr;
    Map<String, Integer> map;
    List<Order> listOrder;
    List<Goods> Listgoods;
    GoodsDaoImpl goodsDaoImpl;
    
    public GoodsServiceImpl()
    {
        goodsDaoImpl = new GoodsDaoImpl();
    }
    
    /**
     * 
     * 查询商品服务实现类
     * 查询全部商品列表
     * @return
     */
    public List<Goods> queryList()
    {
        return goodsDaoImpl.goodsAllList();
    }
    
    /**
     * 
     * 查询商品服务实现类
     * 根据关键字查询
     * @return
     */
    public List<Goods> queryGoodsByKey(String keyWord)
    {
        return goodsDaoImpl.queryGoodsByKey(keyWord);
    }

    /**
     * 
     * 查询商品信息 
     * （关键字||分类）or（关键字&&分类）
     * @return
     */
    public List<Goods> queryGoodsByKeyClassify(String keyWord, String goodsClassify)
    {
        Goods goodsList = null;
        goodsList = new Goods();
        
        if (((goodsClassify == null || "".equals(goodsClassify.trim()))
                &&(keyWord == null || "".equals(keyWord))))
        {
            return new ArrayList<Goods>(); //用户关键字与分类都没有输入的时候返回空集合
        }
        
        if (!(goodsClassify == null || "".equals(goodsClassify.trim())))
        {
            goodsList.setCommodity_id(Integer.parseInt(goodsClassify));
        }
        if (!(keyWord == null || "".equals(keyWord.trim())))
        {
            goodsList.setCommodity_name(keyWord);
        }
        
        return goodsDaoImpl.queryGoodsByKeyClassify(goodsList);
    }
    
    
    
    
    /**
     * 
     * 购买商品
     * <功能详细描述>
     * @param car
     * @return
     * 2-安踏运动鞋-福州-120-800-002.jpg-1- 10-ipad5-北京-5900-500-010.jpg-4- 10-ipad5-北京-5900-500-010.jpg-4-
     * 
     * commodity_number = goods[0];//商品编号
     * commodity_name = goods[1];
     * commodity_price = Double.parseDouble(goods[3]);
     * commodity_balance = Integer.parseInt(goods[4]) - 1; //重新设置商品数量，达到购买的效果，-1代表商品数量减一
     */
    public String BuyGoods(String userName,LinkedList<String> car)
    {
        if (car.size() <= 0){return "购物车为空";}
        
        map = new Hashtable<String, Integer>();
        listOrder = new ArrayList<Order>();
        Listgoods = new ArrayList<Goods>();
        
        String temp = null;
        map.clear();
        OrderServiceImpl orderServiceImpl = new OrderServiceImpl();//获取order表服务类
        
        for (int i = 0; i < car.size(); i++)
        {
            order = new Order();
            goods = new Goods();
            goodsArr = car.get(i).split(",");//一条String商品的信息分割到一个数组中
            for (int j = 0; j < goodsArr.length; j++)
            {
                order.setUserName(userName);
                order.setCommodity_name(goodsArr[1]);
                order.setCommodity_price(Double.parseDouble(goodsArr[3]));
                order.setSum(1);
                
//  (如果前端实现了单条商品数量可选就不再需要map临时缓存了，那时，下面的代码将变的很简单，不再这样复杂)学好js会省很多事情
                temp = goodsArr[0];//商品唯一标识充当map的key  
                goods.setCommodity_number(Integer.parseInt(goodsArr[0]));
                if (j == 4) //当 j=4:购物数量
                {
                    if (map.containsKey(temp))//利用map缓存一下，目的:减数量。  
                    {
                        if (map.get(temp)-1 <= 0){return "数据库中商品数量不足";}
                        map.put(temp, map.get(temp)-1);//map已经存在该商品,再次出现故只需将数量减一即可
                        System.out.println(i+"+递减进入："+map.get(temp));
                    }else{
                        map.put(temp, Integer.parseInt(goodsArr[4])-1);
                        if (map.get(temp) <= 0){return "数据库中商品数量不足";}
                        
                        System.out.println(i+"-首次进入："+map.get(temp));
                    }
                    goods.setCommodity_balance(map.get(temp));
                }
                
            }
            listOrder.add(order);
            Listgoods.add(goods);
            
        }
        
        orderServiceImpl.insertOrderBatch(listOrder);
        goodsDaoImpl.updateGoods(Listgoods);
        
        
        return "您已将购物车中的商品买回家了";
    }
    
    
}
