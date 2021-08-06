package lyons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.SalesMan;

/**
 * 数据库SalesMan表操作
 * @author lyons(zhanglei)
 */
public final class SalesManDao
{
	 Connection        conn  = null;
	 PreparedStatement pstmt = null;
	 ResultSet 		rs 	 	 = null;
	
	/**
	 * 1.前台收银登陆
	 * @param sName 用户名
	 * @return ArrayList<SalesMan> sPassWord,sId
	 */
 	public ArrayList<SalesMan> checkstandLog(String sName)
	{
 		ArrayList<SalesMan> salesManInfo = new ArrayList<SalesMan>();
		conn = DbConn.getconn();
		String sql = "SELECT SID,SPASSWORD FROM SALESMAN WHERE SNAME=?";
				try
				{
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,sName);
					
					rs 	  = pstmt.executeQuery();
					while (rs.next())
					{
						String sPassWord = rs.getString("spassword");
						int sId = rs.getInt("sId");
						SalesMan salesMan = new SalesMan(sId,sPassWord); 
						salesManInfo.add(salesMan);						
					}
				} catch (SQLException e1)
				{
					e1.printStackTrace();
				}finally
				{
					DbClose.queryClose(pstmt, rs, conn);
				}
	 return salesManInfo;
	}

 	/**
	 * 2.添加售货员
	 * @param sName 用户名
	 * @return boolean
	 */
		public boolean addSalesMan(SalesMan sName)
		{
			boolean bool = false;
			conn = DbConn.getconn();
			String sql = "INSERT INTO SALESMAN(SNAME,SPASSWORD) VALUES(?,?)";
				
				try
				{
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,sName.getSName());
					pstmt.setString(2,sName.getSPassWord());
					
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
	 * 3.更改售货员信息
	 * @param key 	要更改项
	 * @param sName 用户名
	 * @return boolean
	 */
	public  boolean updateSalesMan(int key,SalesMan sName)
	{
		
		boolean bool = false;
		conn = DbConn.getconn();
			switch (key)
			{
			case 1:		//	3.1 更改售货员姓名
						String sqlName = "UPDATE SALESMAN SET SNAME=? WHERE SID=?";
						
						try
					{
						pstmt = conn.prepareStatement(sqlName);
						pstmt.setString(1, sName.getSName());
						pstmt.setInt(2,sName.getSId());
						
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
			case 2:		//	3.2 更改售货员密码
						String sqlPrice = "UPDATE SALESMAN SET SPASSWORD=? WHERE SID=?";
						
						try
					{
						pstmt = conn.prepareStatement(sqlPrice);
						pstmt.setString(1,sName.getSPassWord());
						pstmt.setInt(2, sName.getSId());
						
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
	 * 4.删除售货员
	 * @param sName 用户名
	 * @return boolean
	 */
	public boolean deleteSalesMan(String sName)
	{
		boolean bool = false;
		conn = DbConn.getconn();
		String sql = "DELETE FROM SALESMAN WHERE SNAME=?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,sName);
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
	 * 5.模糊查询售货员
	 * @param sName 用户名
	 * @return ArrayList<SalesMan>
	 */
	public ArrayList<SalesMan> querySalesMan(String sName)
	{
		ArrayList<SalesMan> SalesManList = new ArrayList<SalesMan>();
		conn = DbConn.getconn();	
	
		sName = "%"+sName+"%";	//从用户处获取的字符串加上 % 符号，来达到模糊查询的目的.字符串 的连接还有更优秀的方式，待优化代码！
		String sql = "SELECT * FROM SALESMAN WHERE SNAME LIKE ?";  //居然不能直接跟 % .只能用连接字符串的方式
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
	
	/**
	 * 6.显示所有售货员
	 * @return ArrayList<SalesMan>
	 */
	public  ArrayList<SalesMan> displaySalesMan()
	{
		ArrayList<SalesMan> salesManList = new ArrayList<SalesMan>();
		conn = DbConn.getconn(); 
		String sql = "SELECT * FROM SALESMAN";
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			while (rs.next())
			{
				int sId = rs.getInt(1);
				String sName = rs.getString(2);
				String sSpassWord = rs.getString(3);
				
				SalesMan salesMan = new SalesMan(sId,sName,sSpassWord);
				salesManList.add(salesMan);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
				{
					DbClose.queryClose(pstmt, rs, conn);
				}
	 return salesManList;
	}
	
}
