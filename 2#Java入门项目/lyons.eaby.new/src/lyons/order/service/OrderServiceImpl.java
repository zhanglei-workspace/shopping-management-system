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
        //至少一个查询条件为真才能查询，否则返回全部订单列表。
        if (!((condition.getUserName()==null||"".equals(condition.getUserName().trim()))&&
            (condition.getKeyWord()==null||"".equals(condition.getKeyWord().trim()))))
            {
                return dao.queryOrderByKeyName(condition);
            }
        
        return orderAllList();
    }
    
    
    /**
     * 删除单个“所有”订单
     * @param userName
     * @return
     */
    @Override
    public void deleteOrderOneById(String idstr)
    {
        if (!(idstr==null || "".equals(idstr)))
        {
           int id = Integer.parseInt(idstr);
           dao.deleteOrderOneById(id);
        }
        
        return;
        
    }
    
    /**
     * 
     * 批量删除订单 By ids
     * @param userName
     * @return
     */
    @Override
    public void deleteOrderBatch(String[] ids)
    {
        if (ids==null||ids.length<=0)
        {
            String idTemp[] = {"-1"};
            ids = idTemp;//防止空指针异常
        }
        dao.deleteOrderBatch(ids);
        
    }
    
}
