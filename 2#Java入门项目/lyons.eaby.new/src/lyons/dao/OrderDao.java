package lyons.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import lyons.db.DbAccess;
import lyons.order.entity.Order;

public class OrderDao
{
    List<Order> orderList =  new ArrayList<Order>();
    DbAccess dbAccess = new DbAccess();
    SqlSession sqlSession = null;
    
    
    /**
     * 
     * 查询当前用户全部订单列表-orderForm.sql
     * 
     * @return 商品列表数组
     * 
     */
    public List<Order> queryOrderList(String userName)
    {
        try
        {
            sqlSession = dbAccess.getSqlSession();
            return sqlSession.selectList("Order.queryOrderList",userName);
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
            return sqlSession.selectList("Order.queryOrderByKeyName", condition);//对象封装传递多个参数
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
            return sqlSession.selectList("Order.queryOrderAllList");//对象封装传递多个参数
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
     * 根据商品唯一标识删除订单
     * @param id
     */
    public void deleteOrderOneById(int id)
    {
        try
        {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("Order.deleteOrderOneById",id);//对象封装传递多个参数
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
    
    
    
    
//    public static void main(String[] args)
//    {
//       List<Order> orderList =null;
//       Order order = new Order();
//       OrderDao orderDao = new OrderDao();
//       
//       order.setKeyWord("鞋");
//       order.setUserName("lyons");
//       orderList = orderDao.queryOrderByKeyName(order);
//       System.out.println(orderList.size());
//       
//       for (int i = 0,num=orderList.size(); i < num; i++)
//       {
//           System.out.print("货名："+orderList.get(i).getCommodity_name());
//           System.out.println("\t\t用户名："+orderList.get(i).getUserName());
//                
//       }
//       
//       
//    }
    
}
