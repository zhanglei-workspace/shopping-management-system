package lyons.order.service;

import java.util.ArrayList;
import java.util.List;

import lyons.dao.OrderDao;
import lyons.order.entity.Order;

/**
 * 
 * 订单接口实现类
 * @author  lyons(zhanglei)
 */
public class OrderServiceImpl implements OrderService
{
    
    OrderDao dao = new OrderDao();
    
    /**
     * 查询所有用户所有订单列表
     * @return
     */
    @Override
    public List<Order> orderAllList()
    {
        return dao.queryOrderAllList();
    }
    
    /**
     * 查询当前用户所有订单列表
     * @param userName
     * @return
     */
    @Override
    public List<Order> orderList(String userName)
    {
        return dao.queryOrderList(userName);
    }
    
    /**
     * 根据用户名+关键字查询订单
     * @param condition
     * @return
     */
    @Override
    public List<Order> orderListByKeyName(Order condition)
    {
        //至少一个查询条件为真才能查询，否则返回空对象。
        if (!((condition.getUserName()==null||"".equals(condition.getUserName().trim()))&&
            (condition.getKeyWord()==null||"".equals(condition.getKeyWord().trim()))))
            {
                return dao.queryOrderByKeyName(condition);
            }
        
        return new ArrayList<Order>();
    }
    
    /**
     * 删除单个“所有”订单
     * @param userName
     * @return
     */
    @Override
    public void deleteOrderOneById(int id)
    {
       dao.deleteOrderOneById(id);
    }
    
}
