package lyons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.Goods;
import lyons.entity.Gsales;
import lyons.tools.ScannerChoice;

public final class GoodsDao 
{
		 Connection        conn  = null;
		 PreparedStatement pstmt = null;
		 ResultSet 		rs 	 	 = null;
	
	/*
	 * 1.添加商品到数据库-功能实现 已实现！
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

	/*
	 * 2.更改商品  已实现！
	 */
	public boolean updateGoods(int key,Goods goods) //参数解释：key选择执行哪一步。choiceGid : 将要执行的商品的gid编号。
	{
		boolean bool = false;
		conn = DbConn.getconn();
			switch (key)
			{
			case 1:			//		System.out.println("\t\t1.更改商品名称");
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
			case 2:			//		System.out.println("\t\t2.更改商品价格");
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
			case 3:			//		System.out.println("\t\t3.更改商品数量");
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
	
	/*
	 * 3.刪除商品  已实现！
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
	
	/*
	 *  4.查询商品界面--功能实现  已实现！
	 * 商品数量升序查询、按商品价格升序查询、输入关键字查询商品
	 * 
	 * 函数解释：在上一级菜单GoodsPage.queryGoodsPage()中接收用户选择的查询方式
	 *			当做此函数的参数。用参数的来作为if-else的条件选择执行的语句！
	 */
		public ArrayList<Goods> queryGoods(int key) //获取用户查询的选择来确定用哪一个sql,避免代码冗杂!也可以用内部类实现
		{											//代码还是太冗杂，想办法把try-catch成立一个函数，调用它
			ArrayList<Goods> goodsList = new ArrayList<Goods>();
			conn = DbConn.getconn();	
	
			switch (key)
			{
				case 1:
						//4.1商品 数量 升序查询-功能实现
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
					 	//4.2商品 价格 升序查询-功能实现
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
				default:
						//4.3商品 关键字 查询商品-功能实现0
						String nameGet = ScannerChoice.ScannerInfoString();
					
						String gName = "%"+nameGet+"%";							//从用户处获取的字符串加上 % 符号，来达到模糊查询的目的
						String sqlGname = "SELECT * FROM GOODS WHERE GNAME LIKE ?";  //居然不能直接跟 % .只能用连接字符串的方式
						   try
						   {
								pstmt = conn.prepareStatement(sqlGname);
								pstmt.setString(1, gName);
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
			}
			return goodsList;
		}
	
	/*
	 * 5.显示所有商品-功能实现 已实现！
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
					int gprice = rs.getInt("gprice"); //是双引号,当然也可以用数字表示。主要是提醒自己有两种方式
					int gnum = rs.getInt(4);
					
					Goods goods = new Goods(gid,gname,gprice,gnum);	//创建Goods对象，并赋值。
					goodsList.add(goods);						//添加到数组类中！
				}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
				{
					DbClose.queryClose(pstmt, rs, conn);
				}
		return goodsList;	//需要返回给调用者值
		
	}

	/*
	 * 购物结算
	 * 
	 * 选中的商品在数据库中进行删除并记录！
	 * 
	 * 这个地方实际上是向sales表插入商品数据！
	 * 调试时自己得打印是否操作成功！
	 */
	
		public boolean  shoppingSettlement(Gsales gSales)
		{
			boolean bool = false;
			conn = DbConn.getconn();
			String sql = "INSERT INTO GSALES(GID,SID,SNUM) VALUES(?,?,?)";
				
				try
				{
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1,gSales.getGId());
					pstmt.setInt(2,gSales.getSId());
					pstmt.setInt(3,gSales.getSNum());
			
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
		
}