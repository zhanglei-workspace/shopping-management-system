package lyons.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import lyons.db.DbAccess;
import lyons.goods.entity.Goods;

/**
 * 商品维护类-学习面向接口编程
 * 
 * commodity.sql
 */
public class GoodsDaoImpl implements GoodsDao
{

	
	List<GoodsDao> goodsList = new ArrayList<GoodsDao>();
    Goods goods = new Goods();
    GoodsDao goodsDao = null;
    
	DbAccess dbAccess = new DbAccess();
	SqlSession sqlSession = null;
	
	/**
     * 
     * 查询商品列表-commodity.sql
     * 根据（关键字||分类）or（关键字&&分类）
     * 
     * 此查询函数不再改为接口式编程，作为知识留存
     * 
     * @return 商品列表数组
     * 
     */
    public List<Goods> queryGoodsByKeyClassify(Goods goodsList)
    {
        try
        {
            sqlSession = dbAccess.getSqlSession();
            return sqlSession.selectList("lyons.dao.GoodsDao.queryGoodsByKeyClassify", goodsList);//空间名.查询语句id
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
	 * @return 商品列表数组
	 * 
	 */
	public List<Goods> goodsAllList()
    {
	    try
        {
            sqlSession = dbAccess.getSqlSession();
            goodsDao = sqlSession.getMapper(GoodsDao.class);
            return goodsDao.goodsAllList();
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
            goodsDao =  sqlSession.getMapper(GoodsDao.class);
            return goodsDao.queryGoodsByKey(keyWord);
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
            
            sqlSession.getMapper(GoodsDao.class).deleteOneGoodsById(goodsId);
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