package lyons.tools;

/**
 * 各種完成操作后的 选择下一步
 * 以及界面選擇操作
 * @author 張磊
 */

import java.util.Scanner;

import lyons.page.GoodsPage;
import lyons.page.MainPage;
import lyons.page.SalesManPage;

public class ScannerChoice
{
	/*
	 * 获取用户--輸入图书信息
	 * 商品价格
	 * @return double 
	 */
	public static double ScannerInfo()
	{
		double num = 0.00;
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("保留小数点后两位,请输入：");
			String info = sc.next();
			
			String regex = "(([1-9][0-9]*)\\.([0-9]{2}))|[0]\\.([0-9]{2})";//保留小数点后2位小数
			if (info.matches(regex))
			{
				num = Double.parseDouble(info);
			}else 
				{
					System.err.println("！输入有误！");
					continue;
				}
			break;
		} while (true);
			
		return num;
	}
		/*
		 * 获取用户--輸入图书信息
		 * 商品数量
		 * @return int 
		 */
		public static int ScannerNum()
		{
			int num = 0;
			String regex = "([1-9])|([1-9][0-9]+)";//商品数量
			do
			{
				Scanner sc = new Scanner(System.in);
				System.out.print("请输入：");
				String nums = sc.next();
				
				if (nums.matches(regex))
				{
					num = Integer.parseInt(nums);
				}else 
					{
						System.err.println("！输入有误！");
						continue;
					}
			 break;
			} while (true);
			
			return num;
		}
		
		/*
		 * *获取用户--界面选择
		 *        --选项选择
		 *        --用户输入
		 * @return Sting 
		 */
			public static String ScannerInfoString()
			{
				Scanner scanner = new Scanner(System.in);
				System.out.print("请输入：");
				return scanner.next();
			}
		
	/*
	 * 获取用户-更改完商品-下一步  已校验！
	 * 获取用户-添加完商品-下一步
	 */
		public static void changedInfoNext(String choiceFunction)
		{		
			 do
			{
					System.out.println("是否继续进行-当前操作:(Y/N)");
					String choice = ScannerChoice.ScannerInfoString();
				
					 if ("y".equals(choice) || "Y".equals(choice)) //在JAVA: Equals比较的是值,==比较的是地址
						{
							//下面的嵌套if-else 是让用户选择继续操作当前步骤所跳转到指定页面。（因为不同函数调用，跳转的指定函数不同）
							if ("upateGoodsPage".equals(choiceFunction))
								{
									 GoodsPage.upateGoodsPage();
								}else if ("deleteGoodsPage".equals(choiceFunction)) 
										{
											GoodsPage.deleteGoodsPage();
										}else if ("addGoodsPage".equals(choiceFunction))
												 {
			 										GoodsPage.addGoodsPage();
		 					 					 }
								//上面的嵌套结束
						}else if ("N".equals(choice) || "n".equals(choice)) 
								{
				 					MainPage.MaintenancePage();
								}
				 	System.out.println("\n输入有误！请重新输入.");
			} while (true);
		}
	
		/*
		 * 获取用户-更改-完售货员-下一步
		 * 获取用户-添加-完售货员-下一步
		 * 获取用户-查询-完售货员-下一步
		 * 获取用户-删除-完售货员-下一步
		 */
			public static void choiceSalesManNext(String choiceFunction)
			{	
				 do
				{		
						System.out.println("是否继续进行-当前操作:(Y/N)");
						String choice = ScannerChoice.ScannerInfoString();
					
						 if ( "y".equals(choice) || "Y".equals(choice) ) //在JAVA: Equals比较的是值,==比较的是地址  .将比较的常量放在前面，方直空指针异常
							{
								//下面的嵌套if-else 是让用户选择继续操作当前步骤所跳转到指定页面。（因为不同函数调用，跳转的指定函数不同）
								if ("updateSalesMan".equals(choiceFunction))
									{
										 SalesManPage.updateSalesManPage();
									}else if ("deleteSalesMan".equals(choiceFunction)) 
											{
												SalesManPage.deleteSalesManPage();
											}else if ("addSalesMan".equals(choiceFunction))
													 {
														SalesManPage.addSalesManPage();
			 					 					 }else if ("querySalesMan".equals(choiceFunction)) 
			 					 					 		{
			 					 						 		SalesManPage.querySalesManPage();	
			 					 					 		}  
								//上面的嵌套结束
							}else if ("N".equals(choice) || "n".equals(choice)) 
									{
										MainPage.salesManManagementPage();
									}
					 	System.err.println("\t输入有误！");
				} while (true);
			}	
			
}
