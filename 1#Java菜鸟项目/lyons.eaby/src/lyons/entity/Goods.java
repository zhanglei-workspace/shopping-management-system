package lyons.entity;

import java.io.Serializable;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 商品实体类
 * @author lyons(zhanglei)
 *
 */
public class Goods implements Serializable
{
	private static final long serialVersionUID = 1324861781715292607L;
	
	CachedRowSetImpl rowSet = null; //表中所有的行集对象
	
	private int pageSize = 5;	//每页显示多少条记录
	private int currentPage = 1;//当前页数
	private int totalPRecord = 1;//总记录数
	private int totalPage = 1;	 //总页数
	
	public Goods(){}
	
	public Goods(CachedRowSetImpl rowSet, int pageSize, int currentPage,
			int totalPRecord, int totalPage)
	{
		super();
		this.rowSet = rowSet;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalPRecord = totalPRecord;
		this.totalPage = totalPage;
	}

	
	public CachedRowSetImpl getRowSet()
	{
		return rowSet;
	}
	public void setRowSet(CachedRowSetImpl rowSet)
	{
		this.rowSet = rowSet;
	}
	public int getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	public int getCurrentPage()
	{
		return currentPage;
	}
	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}
	public int getTotalPRecord()
	{
		return totalPRecord;
	}
	public void setTotalPRecord(int totalPRecord)
	{
		this.totalPRecord = totalPRecord;
	}
	public int getTotalPage()
	{
		return totalPage;
	}
	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}

}
