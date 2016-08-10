package lyons.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import lyons.db.DbAccess;
import lyons.order.entity.Order;

/**
 * 订单维护类
 * 
 * orderForm.sql
 */
public class OrderDaoImpl implements OrderDao
{
    List<Order> orderList =  new ArrayList<Order>();
    OrderDao orderDao = null;
    DbAccess dbAccess = new DbAccess();
    SqlSession sqlSession = null;
    
    
    /**
     * 
     * 查询当前用户全部订单列表-orderForm.sql
     * 
     * @return 商品列表数组
     * 
     */
    public List<Order> queryOrderListByuserName(String userName)
    {
        try
        {
            sqlSession = dbAccess.getSqlSession();
            orderDao = sqlSession.getMapper(OrderDao.class);
            return orderDao.queryOrderListByuserName(userName);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            sqlSesionClose();
        }
        
        return null;
    }
    
    /**
     * 
     * 查询订单列表-orderForm.sql
     * 根据用户名+关键字查询
     * @return 商品列表数组
     * 
     */
    public List<Order> queryOrderByKeyName(Order condition)
    {
        try
        {
            sqlSession = dbAccess.getSqlSession();
            orderDao = sqlSession.getMapper(OrderDao.class);
            return orderDao.queryOrderByKeyName(condition);//对象封装传递多个参数
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            sqlSesionClose();
        }
        
        return null;
    }
    
    /**
     * 
     * 查询所有用户订单列表
     * @return
     */
    public List<Order> queryOrderAllList()
    {
        try
        {
            sqlSession = dbAccess.getSqlSession();
            orderDao = sqlSession.getMapper(OrderDao.class);
            return orderDao.queryOrderAllList();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            sqlSesionClose();
        }
        
        return null;
    }
    
    
    
    
    
    /**
     * 
     * 根据商品唯一标识删除单个订单
     * @param id
     */
    public void deleteOrderOneById(int id)
    {
        try
        {
            sqlSession = dbAccess.getSqlSession();
            orderDao = sqlSession.getMapper(OrderDao.class);
            orderDao.deleteOrderOneById(id);
            sqlSession.commit();//删除需要提交
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            sqlSesionClose();
        }
    }
    
    /**
     * 
     * 批量删除订单
     * @param ids
     */
    public void deleteOrderBatch(List<Integer> ids)
    {
        
        try
        {
            sqlSession = dbAccess.getSqlSession();
            orderDao = sqlSession.getMapper(OrderDao.class);
            orderDao.deleteOrderBatch(ids);
            sqlSession.commit();//删除需要提交
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            sqlSesionClose();
        }
        
    }
    
    /*
     * 关闭数据库连接会话
     */
    private void sqlSesionClose()
    {
        if (sqlSession != null)
        {
            sqlSession.close();
        }
    }
    
    
}
