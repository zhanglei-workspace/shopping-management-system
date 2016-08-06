package lyons.order.service;

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
     * 查询当前所有订单列表
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
        return dao.queryOrderByKeyName(condition);
    }
}
