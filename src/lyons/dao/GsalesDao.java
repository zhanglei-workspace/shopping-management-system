package lyons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.Gsales;

/**
 * 商品售卖情况
 * @author 张磊
 */
public final class GsalesDao
{
	/*
	 * 每日卖出商品列表
	 *
	 */
	
	
	public ArrayList<Gsales> dailyGsales()
	{
		Connection        conn  = null;
	    PreparedStatement pstmt = null;
		ResultSet 		rs 	 	 = null;
		 
		ArrayList<Gsales> GsalesList = new ArrayList<Gsales>(); 
		conn = DbConn.getconn();

		//我的天！终于研究出这句sql来了！trunc(sdate) =trunc(sysdate)
		//sql: gname,gprice,gnum, allSum (各种商品的销售总和)
		//oracle语句解释见sql文件！
		String sql = "select gname,gprice,gnum, allSum from goods, (select gid as salesid,sum(snum) as allSum from gsales where trunc(sdate) =trunc(sysdate) group by gid) where gid = salesid"; 
		try
		{
			pstmt = conn.prepareStatement(sql);
			rs 	  = pstmt.executeQuery();
				
				while (rs.next())
				{
					String gName = rs.getString(1);
					double gPrice = rs.getDouble(2);
					int gNum = rs.getInt(3);
					int allSnum = rs.getInt("allSum");
					
					Gsales Gsales = new Gsales(gName,gPrice,gNum,allSnum);	//创建Gsales对象，并赋值。
					GsalesList.add(Gsales);						//添加到数组类中！
				}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally
				{
					DbClose.queryClose(pstmt,rs,conn);
				}
		return GsalesList;	//需要返回给调用者值:gid，各销售商品总和
		
	}

}
