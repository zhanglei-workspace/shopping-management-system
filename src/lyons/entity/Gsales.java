package lyons.entity;

import java.sql.Date;

public class Gsales
{
	
	private int gSid;
	private int gId;
	private int sId;
	private Date date;
	private int sNum;
	
	private String gName; 
	private String gPrice;
	private int gNum;
	private int allSnum; //各种商品销量总和
	
	
	
	
	/*
	 * 购物结算
	 */
	
	public Gsales(int gId,int sId, int sNum)
	{
		this.gId = gId;
		this.sId = sId;
		this.sNum = sNum;
	}
	/*
	 * 展现商品列表
	 * gName,gPrice,gNum,allSnum
	 */

	public Gsales(String gName,String gPrice,int gNum,int allSnum)
	{
		this.gName = gName;
		this.gPrice = gPrice;
		this.gNum = gNum;
		this.allSnum = allSnum;
	}

	//共有set、get
	public int getGSid()
	{
		return gSid;
	}
	public void setGSid(int sid)
	{
		gSid = sid;
	}
	public int getGId()
	{
		return gId;
	}
	public void setGId(int id)
	{
		gId = id;
	}
	public int getSId()
	{
		return sId;
	}
	public void setSId(int id)
	{
		sId = id;
	}
	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}
	public int getSNum()
	{
		return sNum;
	}
	public void setSNum(int num)
	{
		sNum = num;
	}

	public String getGName()
	{
		return gName;
	}

	public void setGName(String name)
	{
		gName = name;
	}

	public String getGPrice()
	{
		return gPrice;
	}

	public void setGPrice(String price)
	{
		gPrice = price;
	}

	public int getGNum()
	{
		return gNum;
	}

	public void setGNum(int num)
	{
		gNum = num;
	}

	public int getAllSnum()
	{
		return allSnum;
	}

	public void setAllSnum(int allSnum)
	{
		this.allSnum = allSnum;
	}

}
