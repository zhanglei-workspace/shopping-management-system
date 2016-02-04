package lyons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.Goods;
import lyons.tools.ScannerChoice;

/**
 * 数据库goods表操作
 * @author lyons(zhanglei)
 */
public final class GoodsDao 
{
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet 		  rs    = null;
	
	/**
	 * 1.添加商品到数据库goods表
	 * @param goods 商品对象
	 * @return boolean
	 */
	public boolean addGoods(Goods goods)
	{
		boolean bool = false;
		conn = DbConn.getconn();
		String sql = "INSERT INTO GOODS(GNAME,GPRICE,GNUM) VALUES(?,?,?)";
			
			try
			{
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,goods.getGname());
				pstmt.setDouble(2,goods.getGprice());
				pstmt.setInt(3,goods.getGnum());
				
				int rs = pstmt.executeUpdate();
				if (rs > 0)
				{
					bool = true;
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}finally
					{
						DbClose.addClose(pstmt,conn);
					}
	 return bool;
	}

	/**
	 * 2.更改商品信息到数据库goods表
	 * @param key   选择要更改商品信息
	 * @param goods 商品对象
	 * @return boolean
	 */
	public boolean updateGoods(int key,Goods goods)
	{
		boolean bool = false;
		conn = DbConn.getconn();
			switch (key)
			{
			case 1:		//	key=1,更改商品名称
						String sqlName = "UPDATE GOODS SET GNAME=? WHERE GID=?";
						
					    try
						{
							pstmt = conn.prepareStatement(sqlName);
							pstmt.setString(1, goods.getGname());
							pstmt.setInt(2,goods.getGid());
							
							int rs = pstmt.executeUpdate();
							if (rs > 0)
							{
								bool = true;
							}
						} catch (SQLException e)
						{
							e.printStackTrace();
						}finally{
									DbClose.addClose(pstmt,conn);
								}
				break;
			case 2:		//	key=2,更改商品价格
						String sqlPrice = "UPDATE GOODS SET GPRICE=? WHERE GID=?";
						
						try
						{
							pstmt = conn.prepareStatement(sqlPrice);
							pstmt.setDouble(1, goods.getGprice());
							pstmt.setInt(2,goods.getGid());
							
							int rs = pstmt.executeUpdate();
							if (rs > 0)
							{
								bool = true;
							}
						} catch (SQLException e)
						{
							e.printStackTrace();
						}finally{
									DbClose.addClose(pstmt,conn);
								}
				break;
			case 3:		//	key=3,更改商品数量
						String sqlNum = "UPDATE GOODS SET GNUM=? WHERE GID=?";
							
						try
						{
							pstmt = conn.prepareStatement(sqlNum);
							pstmt.setInt(1, goods.getGnum());
							pstmt.setInt(2,goods.getGid());
							
							int rs = pstmt.executeUpdate();
							if (rs > 0)
							{
								bool = true;
							}
						} catch (SQLException e)
						{
							e.printStackTrace();
						}finally{
									DbClose.addClose(pstmt,conn);
								}
				break;
			default:
				break;
			}
		return bool;
	}
	
	/**
	 * 3.从数据库goods表中-刪除商品
	 * @param gid 商品编号
	 * @return boolean
	 */
	public boolean deleteGoods(int gid)
	{
		boolean bool = false;
		conn = DbConn.getconn();
		String sql = "DELETE FROM GOODS WHERE GID=?";
		
			try
			{
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,gid);
				int rs = pstmt.executeUpdate();
				if (rs > 0)
				{
					bool = true;
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}finally{
						DbClose.addClose(pstmt,conn);
					}
		return bool;
	}
	
	/**
	 *4.查询商品信息
	 * @param key 查询方式
	 * @return ArrayList<Goods>
	 */
	public ArrayList<Goods> queryGoods(int key) 
	{										
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DbConn.getconn();	

		switch (key)
		{
			case 1:
					//	key=1商品 数量 升序查询
					String sqlGnum = "SELECT * FROM GOODS ORDER BY GNUM ASC";
					try
					{
						pstmt = conn.prepareStatement(sqlGnum);
						rs = pstmt.executeQuery();
						while (rs.next())
						{
							int gid = rs.getInt("gid");
							String gname = rs.getString(2);
							double gprice = rs.getDouble(3);
							int gnum = rs.getInt(4);
							
							Goods goods = new Goods(gid,gname,gprice,gnum);
							goodsList.add(goods);
						}
					} catch (SQLException e)
					{
						e.printStackTrace();
					}finally
							{
								DbClose.queryClose(pstmt, rs, conn);
							}
				break;
			case 2:
				 	//	key=2商品 价格 升序查询
					String sqlGprice = "SELECT * FROM GOODS ORDER BY GPRICE ASC";
					try
					{
						pstmt = conn.prepareStatement(sqlGprice);
						rs = pstmt.executeQuery();
						while (rs.next())
						{
							int gid = rs.getInt("gid");
							String gname = rs.getString(2);
							double gprice = rs.getDouble(3);
							int gnum = rs.getInt(4);
							
							Goods goods = new Goods(gid,gname,gprice,gnum);
							goodsList.add(goods);
						}
					} catch (SQLException e)
					{
						e.printStackTrace();
					}finally
							{
								DbClose.queryClose(pstmt, rs, conn);
							}
				break;
			case 3:
					//	key=3商品 关键字 查询
					String nameGet = ScannerChoice.ScannerInfoString();
					String sqlGname = "SELECT * FROM GOODS WHERE GNAME LIKE '%'||?||'%'";
					try
					{
						pstmt = conn.prepareStatement(sqlGname);
						pstmt.setString(1, nameGet);
						rs = pstmt.executeQuery();
						while (rs.next())
						{
							int gid = rs.getInt("gid");
							String gname = rs.getString(2);
							double gprice = rs.getDouble(3);
							int gnum = rs.getInt(4);
							
							Goods goods = new Goods(gid,gname,gprice,gnum);
							goodsList.add(goods);
						}
					} catch (SQLException e)
					{
						e.printStackTrace();
					}finally
					{
						DbClose.queryClose(pstmt, rs, conn);
					}
					break;
			default:
				break;
		}
		return goodsList;
	}

	/**
	 *5.显示所有商品信息
	 * @return ArrayList<Goods>
	 */
	public ArrayList<Goods> displayGoods()
	{
		ArrayList<Goods> goodsList = new ArrayList<Goods>(); 
		conn = DbConn.getconn();
		String sql = "SELECT * FROM GOODS";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			rs 	  = pstmt.executeQuery();
				
				while (rs.next())
				{
					int gid = rs.getInt(1);
					String gname = rs.getString(2);
					double gprice = rs.getDouble("gprice"); 		//双引号+主键名,也可用数字表示.
					int gnum = rs.getInt(4);
					
					Goods goods = new Goods(gid,gname,gprice,gnum);	//创建Goods对象，并赋值.
					goodsList.add(goods);							//添加信息到动态数组中.
				}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
				{
					DbClose.queryClose(pstmt, rs, conn);
				}
		return goodsList;
		
	}
		
}