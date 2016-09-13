package lyons.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lyons.dao.OrderDaoImpl;
import lyons.order.entity.Order;

/**
 * 
 * 订单接口实现类
 * @author  lyons(zhanglei)
 */
public class OrderServiceImpl
{
    OrderDaoImpl dao = new OrderDaoImpl();
    
    /**
     * 查询所有用户所有订单列表
     * @return
     */
    public List<Order> orderAllList()
    {
        return dao.queryOrderAllList();
    }
    
    /**
     * 查询当前用户所有订单列表
     * @param userName
     * @return
     */
    public List<Order> orderList(String userName)
    {
        return dao.queryOrderListByuserName(userName);
    }
    
    /**
     * 根据用户名+关键字查询订单
     * @param condition
     * @return
     */
    public List<Order> orderListByKeyName(String queryUserName,String keyWord)
    {
        //用户什么都没有输入时返回全部订单列表
        if (queryUserName==null && "".equals(queryUserName.trim())&& keyWord==null && "".equals(keyWord.trim()))
        {
            return orderAllList();
        }
        
        Order orderList = new Order();
        if (!(queryUserName==null || "".equals(queryUserName.trim())))
        {
            orderList.setUserName(queryUserName);
        }
        if (!(keyWord==null || "".equals(keyWord.trim())))
        {
            orderList.setKeyWord(keyWord);
        }
        
        return dao.queryOrderByKeyName(orderList);
        
    }
    
    
    /**
     * 删除单个“所有”订单
     * @param userName
     * @return
     */
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
    public void deleteOrderBatch(String[] ids)
    {
        List<Integer> idList = new ArrayList<Integer>();
        if (ids==null||ids.length<=0)
        {
            String idTemp[] = {"-1"};
            ids = idTemp;//防止空指针异常
        }
        for (String id : ids)
        {
            idList.add(Integer.valueOf(id));
        }
        dao.deleteOrderBatch(idList);
        
    }
    
    /**
     * 
     * 批量添加订单
     * @param map
     */
    public void insertOrderBatch(List<Order> listOrder)
    {
        if (listOrder.size() >0 )
        {
            dao.insertOrderBatch(listOrder);
        }
        
    }
    
}
