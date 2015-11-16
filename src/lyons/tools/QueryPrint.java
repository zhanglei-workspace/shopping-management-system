package lyons.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lyons.dao.GoodsDao;
import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.Goods;
import lyons.entity.SalesMan;

public class QueryPrint
{
	/*
	 * 精确查询函数小工具
	 * 可调用此代码的函数： 更改商品	GoodsPage.upateGoodsPage()
	 * 				     删除商品  GoodsPage.deleteGoodsPage()
	 * 	@return int gid				  
	 */
		public static int query(String oper) //参数用来确定此函数调用者.代碼优化了，
		{
			int gid = -1;	//用来返回查询到的信息的gid		
			int shoppingGid = -1;								//参数解析：调用按照商品名-选择商品函数
			String shopping = ScannerChoice.ScannerInfoString(); //参数解析：接受商品名字-并作为参数传给精确查找函数
			ArrayList<Goods> goodsList = new QueryPrint().queryGoodsKey(shoppingGid,shopping);  //調用 精确查询函数 QueryPrint.queryGoodsKey() 確定用戶所要操作的数据
			    if (goodsList == null || goodsList.size() <= 0) //判断结果：查无此商品
				{
						System.err.println("\t！！查无此商品 ！！");
						
						//調用选择函数，选择下一步
						ScannerChoice.changedInfoNext(oper);
						
				}else	//查到有此商品，实现进行 更改商品 信息操作！
				{		//这些重复的代码让我想吐！！！
					Goods goods = goodsList.get(0);
					
					System.out.println("\t\t\t\t\t商品列表\n\n");
					System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注\n");
					System.out.print("\t"+goods.getGid()+"\t\t"+goods.getGname()+"\t\t"+goods.getGprice()+"\t\t"+goods.getGnum());
					if (goods.getGnum()==0)
					{
						System.out.println("\t\t该商品已售空");
					}else if (goods.getGnum()<10)
							{
								System.out.println("\t\t该商品已不足10件");
							}else {
								System.out.println("\t\t-");
							}
					gid =	goods.getGid(); //将商品编号返回给调用者
					
				}
		 return gid;
		} 
	
	/*
	 * 模糊查询函数小工具
	 * 可调用此代码的函数： 购物结算	GoodsPage.shoppingSettlement()
	 * 					  
	 */
		public static int querySettlement() 
		{
			int gid = -1;	//用来返回错误信息的gid
			ArrayList<Goods> goodsSettlement= new GoodsDao().queryGoods(0);  //調用 模糊查询函数 GoodsDao.queryGoods() 確定用戶所要操作的数据
			    if (goodsSettlement == null || goodsSettlement.size() <= 0) //判断结果：查无此商品
				{
						System.err.println("\t！！查无此商品 ！！\n");
						gid = -3; //返回值代表，无此商品		
				}else	//查到有此商品，实现进行 更改商品 信息操作！
					{		//这些重复的代码让我想吐！！！
						System.out.println("\t\t\t\t\t商品列表\n\n");
						System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注\n");
						for (int i = 0; i < goodsSettlement.size(); i++)
						{
							Goods goods = goodsSettlement.get(i);
							if (goods.getGnum() > 0)
							{
								System.out.print("\t"+goods.getGid()+"\t\t"+goods.getGname()+"\t\t"+goods.getGprice()+"\t\t"+goods.getGnum());
									
								if (goods.getGnum()==0)
								{
									System.out.println("\t\t该商品已售空");
								}else if (goods.getGnum()<10)
										{
											System.out.println("\t\t该商品已不足10件");
										}else 
											{
												System.out.println("\t\t-");
											}
									if (goodsSettlement.size()==1)
									{
										gid = goods.getGid(); //将商品编号返回给调用者,
									}else 
										{
										gid = -2;
										}
							}
						}
					}
		 return gid; //当商品件数有且只有一件时返回gid号，没有符合条件时返回 -1. >1件时返回-2 . 查无此商品时返回-3
		} 
	

	/*
	 *
	 * 精确查询商品函数  //很无奈，复制的模糊查询函数重新建立的函数，大动刀了。 只有sql方面是重新写的
	 */
		public ArrayList<Goods> queryGoodsKey(int  gId,String gName) 
		{										
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet 		rs 	 	 = null;
			ArrayList<Goods> goodsList = new ArrayList<Goods>();
			conn = DbConn.getconn();	
			
				//商品 精确 查询商品-功能实现
				String sql = "SELECT * FROM GOODS WHERE GID=? OR GNAME=?"; 
				   try
				   {
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, gId);
						pstmt.setString(2, gName);
						rs = pstmt.executeQuery();
						while (rs.next())
						{
							int gid = rs.getInt("gid");
							String gname = rs.getString(2);
							int gprice = rs.getInt(3);
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
			
			return goodsList;
		
		}	
		
	/*
	 * 精确查询售货员信息函数
	 * 调用者： 删除售货员函数：SalesManPage.deleteSalesManPage()
	 */
	
		public ArrayList<SalesMan> querySalesMan(String sName)
		{
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet 		rs 	 	 = null;
			ArrayList<SalesMan> SalesManList = new ArrayList<SalesMan>();
			conn = DbConn.getconn();	
			String sql = "SELECT * FROM SALESMAN WHERE SNAME=?";  //居然不能直接跟 % .只能用连接字符串的方式
			   try
			   {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sName);
					rs = pstmt.executeQuery();
					while (rs.next())
					{
						int sid = rs.getInt("sid");
						String sname = rs.getString(2);
						String sPassWord = rs.getString(3);
						
						SalesMan salesMan = new SalesMan(sid,sname,sPassWord);
						SalesManList.add(salesMan);
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}finally
						{
							DbClose.queryClose(pstmt, rs, conn);
						}
			return SalesManList;
		}
}
