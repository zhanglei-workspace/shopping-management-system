package lyons.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import lyons.db.DbAccess;
import lyons.goods.entity.Goods;
import lyons.order.entity.Order;

/**
 * 商品维护类
 * commodity.sql
 */
public class GoodsDao
{

	
	List<Goods> GoodsCopy = new ArrayList<Goods>();
	DbAccess dbAccess = new DbAccess();
	SqlSession sqlSession = null;
	
	/**
	 * 
	 * 查询商品列表-commodity.sql
	 * @return 商品列表数组
	 * 
	 */
	public List<Goods> queryGoods()
    {
	    try
        {
            sqlSession = dbAccess.getSqlSession();
            
            //执行sql
            return sqlSession.selectList("Goods.goodsAllList");
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
     * 查询商品列表-commodity.sql
     * 根据关键字查询
     * @return 商品列表数组
     * 
     */
	public List<Goods> queryGoodsByKey(String keyWord)
	{
	    try
        {
            sqlSession = dbAccess.getSqlSession();
            return sqlSession.selectList("Goods.queryGoodsByKey", keyWord);//如果检索条件为多个，则进行对象封装传递
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
     * 删除单个商品
     * By Goods ID
     */
    public void deleteOneGoodsById(int goodsId)
    {
        try
        {
            sqlSession = dbAccess.getSqlSession();
            
            //执行sql
            sqlSession.delete("Goods.deleteOneGoodsById", goodsId);
            sqlSession.commit();//默认不自动提交，需要手工提交
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
     * 批量删除商品
     */
    public void deleteGoodsByMany()
    {
        
    }
    
    /**
     * 增加商品
     */
    public void addGoods()
    {
        
    }
    
    /**
     * 更新商品
     */
    public void updateGoods()
    {
        
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
	
	
//	public static void main(String[] args)
//    {
//       GoodsDao gDaoCopy = new GoodsDao();
//       List<Goods> goodsList = gDaoCopy.queryGoods();
//       for (int i = 0,num=goodsList.size(); i < num; i++)
//       {
//           System.out.print("货名："+goodsList.get(i).getCommodity_name());
//           System.out.println("\t\t价格："+goodsList.get(i).getCommodity_balance());
//                
//       }
//       
//       
//    }
	
	
	
	
	
	
	
	
}