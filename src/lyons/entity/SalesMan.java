package lyons.entity;

/**
 * SalesMan 售货员实体类
 * @author lyons(zhanglei)
 */

public final class SalesMan
{
	private int sId;
	private String sName;
	private String sPassWord;
	
	/**
	 * 验证用户登陆
	 * @param sId,spassWord
	 */
	public SalesMan(int sId,String spassWord)
	{
		this.sId = sId;
		this.sPassWord = spassWord;
	}
	
	/**
	 * 查询用户、更改用户密码
	 * @param sId,sName,sPassWord
	 */
	public SalesMan(int sId,String sName,String sPassWord)
	{
		this.sId = sId;
		this.sName = sName;
		this.sPassWord = sPassWord;
	}
	
	/**
	 * 添加用户
	 * @param NsNameame,sPassWord
	 */
	public SalesMan(String NsNameame, String sPassWord)
	{
		this.sName = NsNameame;
		this.sPassWord = sPassWord;
	}

		
	//共有get.set方法
		public int getSId()
		{
			return sId;
		}
		public void setSId(int id)
		{
			sId = id;
		}
		public String getSName()
		{
			return sName;
		}
		public void setSName(String name)
		{
			sName = name;
		}
		public String getSPassWord()
		{
			return sPassWord;
		}
		public void setSPassWord(String passWord)
		{
			sPassWord = passWord;
		}

}
