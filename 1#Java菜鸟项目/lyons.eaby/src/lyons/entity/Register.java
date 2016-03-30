package lyons.entity;

import java.io.Serializable;

/**
 * 用户注册实体类
 * @author Lyons(zhagnlei)
 *
 */
public class Register implements Serializable
{
	private static final long serialVersionUID = -1465928336863533909L;
	
	private String username;
	private String userpass;
	private String phone;
	private String address;
	private String realname;
	private String backNews = "请注册";

	public Register()
	{
		super();
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUserpass()
	{
		return userpass;
	}
	public void setUserpass(String userpass)
	{
		this.userpass = userpass;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getRealname()
	{
		return realname;
	}
	public void setRealname(String realname)
	{
		this.realname = realname;
	}

	public String getBackNews()
	{
		return backNews;
	}

	public void setBackNews(String backNews)
	{
		this.backNews = backNews;
	}
	
	
}
