package lyons.util;

/**
 * 
 *常用的公共常量
 * @author  lyons(zhanglei)
 */
public interface Iconst
{
    
   /**
    * 根据条件查询，返回结果为空
    */
   public static final String QUERY_BY_CONDITION_NULL = "<br><br><br><center> " +
   		                                                 "<font color=green> 客官,查询无此商品啦.更换关键字再次" +
   		                                                 " </font> <a href=/lyons.eaby.new/jsp/browse/searchByKeyWord.jsp>" +
   		                                                 "<font color=red size=6>查询</font></a></center>";
}
