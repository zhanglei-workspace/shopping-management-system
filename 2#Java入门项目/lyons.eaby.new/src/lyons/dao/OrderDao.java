package lyons.dao;

import java.util.List;

import lyons.order.entity.Order;

/**
 * 
 * Order.xml 对应的接口
 * 
 * @author lyons(zhanglei)
 * 
 */
public interface OrderDao
{
    /** 查询全部订单 **/
    public List<Order> queryOrderAllList();
    /** 查询订单 By 用户名 **/
    public List<Order> queryOrderListByuserName(String useName);
    /** 查询（关键字||用户名）or（关键字&&用户名） **/
    public List<Order> queryOrderByKeyName(Order order);
    
    /** 删除单条 By id **/
    public void deleteOrderOneById(int id);
    /** 删除批量 By id **/
    public void deleteOrderBatch(List<Integer> ids);


}
