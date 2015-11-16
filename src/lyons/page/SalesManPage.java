package lyons.page;

import java.util.ArrayList;

import lyons.dao.SalesManDao;
import lyons.entity.SalesMan;
import lyons.tools.QueryPrint;
import lyons.tools.ScannerChoice;

public class SalesManPage
{
	/*
	 * 1.添加售货员界面 已实现！
	 */
	public static void  addSalesManPage()
	{
			System.out.println("\t正在执行添加售货员操作\n");
			
			System.out.println("\n添加售货员-姓名");
			String sName = ScannerChoice.ScannerChoSting();
			
			System.out.println("\n添加售货员-密码");
			String sPssswd = ScannerChoice.ScannerChoSting();
			
			SalesMan salesMan = new SalesMan(sName,sPssswd);//创建售货员对象
			boolean bool = new SalesManDao().addSalesMan(salesMan);
			
				if (bool)
				{
					System.out.println("\n\t!您已成功添加售货员到数据库!");
				}else {
					System.out.println("添加售货员失败");	
				}
			ScannerChoice.choiceSalesManNext("addSalesMan");
	}
	
	/*
	 * 2.更改售货员界面 已实现！
	 */
	public static void updateSalesManPage()
	{
		System.out.println("\t正在执行更改售货员操作\n");
		System.out.println("请输入想要更改的售货员名字");
		String sName = ScannerChoice.ScannerInfoString();

		//调用精确查找售货员函数
		ArrayList<SalesMan> salesManList = new QueryPrint().querySalesMan(sName);
			if (salesManList.size() <= 0)
			{
				System.err.println("\t！！查无此人！！");
				ScannerChoice.choiceSalesManNext("updateSalesMan"); //选择下一步
			}else 
				{
					//显示将要更改的售货员信息
					System.out.println("\t\t\t售货员信息\n\n");
					System.out.println("\t售货员编号\t\t售货员姓名\t\t售货员密码");
					
					SalesMan salesMan = salesManList.get(0); //上面的精确查找中，只能返回一组数。无需遍历！
					System.out.println("\t"+salesMan.getSId()+"\t\t\t"+salesMan.getSName()+"\t\t\t"+salesMan.getSPassWord());
					System.out.println();
					
					//选择更改售货员内容
					System.out.println("\n--------请选择您要更改的内容\n");
					System.out.println("\t1.更改售货员-姓名");
					System.out.println("\t2.更改售货员-密码");
					boolean boolNext = true;
					do
					{
						String choice = ScannerChoice.ScannerChoString();
						if ("0".equals(choice) || "1".equals(choice) || "2".equals(choice))
						{
							int info = Integer.parseInt(choice);
							boolNext = false;
								switch (info)
								{
								case 0:
										MainPage.salesManManagementPage();
									break;
								case 1:
										System.out.println("更改售货员-新姓名");
										String sNewName = ScannerChoice.ScannerInfoString();
										
										SalesMan salesManName = new SalesMan(salesMan.getSId(),sNewName,null);
										boolean boolsName = new SalesManDao().updateSalesMan(1, salesManName);
										
										if (boolsName)
										{
											System.out.println("\n\t！！成功更新售货员名字至数据库！！\n");
										}else {
											System.err.println("\n\t！！更新售货员名字失敗！！");
										}
										ScannerChoice.choiceSalesManNext("updateSalesMan");
									break;
								case 2:
										System.out.println("更改售货员-新密码");
										String sNewPasswd = ScannerChoice.ScannerInfoString();
										
										SalesMan salesManPasswd = new SalesMan(salesMan.getSId(),null,sNewPasswd);
										boolean boolsPasswd = new SalesManDao().updateSalesMan(2, salesManPasswd);
										
										if (boolsPasswd)
										{
											System.out.println("\n\t！！成功更新售货员密码至数据库！！\n");
										}else {
											System.err.println("\n\t！！更新售货员密码失敗！！");
										}
										ScannerChoice.choiceSalesManNext("updateSalesMan");
									break;
								default:
									break;
								}
						}
						System.out.println("\t!输入有误!");
						System.out.println("\n请选择选项.或者按 0 返回上一级菜单.");
					} while (boolNext);
		
				}
	}

	/*
	 * 3.删除售货员界面
	 */
	public static void deleteSalesManPage()
	{
		
		System.out.println("\t正在执行 删除售货员 操作\n");
		System.out.println("请输入想要删除的售货员名字");
		String sName = ScannerChoice.ScannerInfoString();
		
		//调用精确查找售货员函数
		ArrayList<SalesMan> salesManList = new QueryPrint().querySalesMan(sName);
			if (salesManList.size() <= 0)
			{
				System.err.println("\t！！查无此人！！");
				ScannerChoice.choiceSalesManNext("deleteSalesMan"); //选择下一步
			}else 
				{
					//显示将要删除的售货员信息
					System.out.println("\t\t\t删除售货员信息\n\n");
					System.out.println("\t售货员编号\t\t售货员姓名\t\t售货员密码");
					
					for (int i = 0,length = salesManList.size(); i < length; i++)
					{
						SalesMan salesMan = salesManList.get(i);
						System.out.println("\t"+salesMan.getSId()+"\t\t\t"+salesMan.getSName()+"\t\t\t"+salesMan.getSPassWord());
						System.out.println();
					}
					//确认是否真的删除！
					boolean bool = true;
					do
					{
						System.out.println("\n确认删除该售货员：Y/N");
						String choice = ScannerChoice.ScannerNext();
						if ("y".equals(choice) || "Y".equals(choice))
						{
							bool = false;//跳出do-while循环
							//进行刪除-数据库操作
							
							boolean boolDeleteSalesMan = new SalesManDao().deleteSalesMan(sName);//調用刪除功能
							
							if (boolDeleteSalesMan)
							{
								System.err.println("\t！！已成功刪除该售货员！！\n");
							}else 
							{
								System.err.println("\t！！刪除该售货员失敗！！");
							}
							ScannerChoice.choiceSalesManNext("deleteGoods"); //选择下一步
						}else if ("N".equals(choice) || "n".equals(choice)) 
						{
							bool = false;
							MainPage.salesManManagementPage();
						}
						System.err.println("\t!!输入有误,请重新输入!!");
					} while (bool);
				}
	}
	
	
	/*
	 * 4.查询售货员界面 已实现！
	 */
		public static void querySalesManPage()
		{
			System.out.println("\t\t  正在执行查询售货员操作\n");
			System.out.println("要查询的售货员关键字");
			String sName = ScannerChoice.ScannerInfoString();
			
			ArrayList<SalesMan> salesManList = new SalesManDao().querySalesMan(sName);
				
				if (salesManList.size() <=0)
				{
					System.err.println("\t！没有人员符合查询条件！");
				}else 
					{
						System.out.println("\t\t\t所有售货员列表\n\n");
						System.out.println("\t售货员编号\t\t售货员姓名\t\t售货员密码");
						
						for (int i = 0,length = salesManList.size(); i < length; i++)
						{
							SalesMan salesMan = salesManList.get(i);
							System.out.println("\t"+salesMan.getSId()+"\t\t\t"+salesMan.getSName()+"\t\t\t"+salesMan.getSPassWord());
							System.out.println();
						}
					}
				ScannerChoice.choiceSalesManNext("querySalesMan"); //参数：告诉被调用者是谁在调用！以确定一下步的选择
		}
	/*
	 * 5.显示所有售货员界面 已实现！
	 */
	public static void displaySalesManPage()
	{
		ArrayList<SalesMan> salesManList = new SalesManDao().displaySalesMan();
		//SalesManList 为空的情况没有考虑//已优化！
		if (salesManList.size() <= 0)
		{
			System.err.println("\t！！售货员列表为空！！");
			MainPage.salesManManagementPage();
		}else 
			{
				System.out.println("\t\t\t所有售货员列表\n\n");
				System.out.println("\t售货员编号\t\t售货员姓名\t\t售货员密码");
				
				for (int i = 0,length = salesManList.size(); i < length; i++)
				{
					SalesMan salesMan = salesManList.get(i);
					System.out.println("\t"+salesMan.getSId()+"\t\t\t"+salesMan.getSName()+"\t\t\t"+salesMan.getSPassWord());
					System.out.println();
				}
				//下面的代码块完全是写着玩,就是逼着用户输入0. 如果用户不输入数字，怎么办？
				boolean bool = true;
				do
				{
					System.out.println("\n\n输入 0 返回上一级菜单");
					String choice = ScannerChoice.ScannerChoString();
					
					if (choice.equals("0"))
					{
						MainPage.salesManManagementPage();
						bool = false;
					}
					System.err.print("\t输入有误！");
				} while (bool);
			}
	}
}
