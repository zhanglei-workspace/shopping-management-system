package lyons.util;

/**
 * 
 *常用的公共常量
 * @author  lyons(zhanglei)
 */
public interface Iconst
{
    
   /**
    * Goods表根据条件查询，返回结果为空
    */
   public static final String QUERY_ALLGOODS_BY_CONDITION_RETURN_NULL = "<br><br><br><center> " +
   		                                                 "<font color=green> 客官,查询无此商品啦.更换关键字再次" +
   		                                                 " </font> <a href=/lyons.eaby.new/jsp/browse/searchByKeyWord.jsp>" +
   		                                                 "<font color=red size=6>查询</font></a></center>";
   /**
    * Goods表数据库中无任何信息
    */
   public static final String QUERY_ALLGOODS_RETURN_NULL =  "<br><br><br><center>" +
                                                       		"<font color=green> 亲,卖家还没上货呢 </font>" +
                                                       		"<a href=/lyons.eaby.new/Goods.action?key=4>" +
                                                       		"<font color=red size=6>进入首页</font></a></center>";
   
  /**
   * Goods表购买商品成功
   * 需要两个字符串一齐使用
   */
   public static final String buy_goods_success_1 = "<br><br><br><center><font size=5 color=red><B>";
   public static final String buy_goods_success_2 ="</font>&nbsp;<br><br><br>" +
                                               		"<a href=/lyons.eaby.new/Goods.action?key=4>返回继续购物</a>" +
                                               		"&nbsp;or&nbsp;" +
                                               		"<a href=/lyons.eaby.new/Order.action?key=1>查看我的订单</a></center>";
   		
   
}
