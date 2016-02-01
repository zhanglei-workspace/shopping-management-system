package lyons.entity;
/**
 * 商品名称
 * 重载构造函数-滿足各種操作需求
 * 实际是为多态做准备工作
 * @author 张磊
 */
public final class Goods
{
	 	//数据库Goods表主鍵
		private int gid;
		private String gname;
		private double gprice;
		private int gnum;

	/*
	 * 用于-添加商品-信息
	 */
	public Goods(String gname,double gprice,int gum)
	{
		this.gname  = gname;
		this.gprice = gprice;
		this.gnum 	= gum;
	}
	/*
	 * 用于-展示所有商品-方法
	 */
	public Goods(int gid,String gname,double gprice,int gum)
	{
		this.gid	= gid;
		this.gname  = gname;
		this.gprice = gprice;
		this.gnum 	= gum;
	}
	
	/*
	 * 根据编号-更改-商品信息构造函数
	 * 接收类型 int
	 */
	public  Goods(int gid,int gnum)
	{
		this.gid	= gid;
		this.gnum 	= gnum;
	}
	/*
	 * 根据编号-更改-商品信息构造函数
	 * 接收类型 double
	 */
	public  Goods(int gid,double gprice)
	{
		this.gid	= gid;
		this.gprice = gprice;
	}
	
	/*
	 * 根据编号-更改-商品信息构造函数
	 * 接收类型 int
	 */
	public  Goods(int gid,String gname)
	{
		this.gid	= gid;
		this.gname  = gname;
	}

	//共有-get、set-方法。
		public int getGid()
		{
			return gid;
		}
		public void setGid(int gid)
		{
			this.gid = gid;
		}
		public String getGname()
		{
			return gname;
		}
		public void setGname(String gname)
		{
			this.gname = gname;
		}
		public double getGprice()
		{
			return gprice;
		}
		public void setGprice(double gprice)
		{
			this.gprice = gprice;
		}
		public int getGnum()
		{
			return gnum;
		}
		public void setGnum(int gnum)
		{
			this.gnum = gnum;
		}						
}
