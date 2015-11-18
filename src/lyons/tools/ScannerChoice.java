package lyons.tools;

/**
 * 各種完成操作后的 选择下一步
 * 以及界面選擇操作
 * @author 張磊
 *
 */

import java.util.Scanner;

import lyons.page.GoodsPage;
import lyons.page.MainPage;
import lyons.page.SalesManPage;

public final class ScannerChoice
{
	/*
	 * 获取用户--界面选择
	 *         选项选择
	 * @return int
	 */
		public static int ScannerCho()
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("您的选择：");
			int info = scanner.nextInt();//读取这一行信息
			System.out.println();
			return info;
		}
		/*
		 * 获取用户--界面选择
		 *         选项选择
		 * @return String
		 */
		public static String ScannerChoString()
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("您的选择：");
			String info = scanner.next();//读取这一行信息
			return info;
		}
	/*
	 * 获取用户--界面选择
	 *         选项选择
	 * @return String
	 */
			public static String ScannerChoSting()
			{
				Scanner scanner = new Scanner(System.in);
				System.out.print("您的选择：");
				String info = scanner.next();//读取这一行信息
				return info;
			}
		
	/*
	 * 获取用户--界面选择
	 * 		   Y/N 选择
	 * @return Srting
	 */
		public static String ScannerNext()
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("您的选择：");
			String info = scanner.next();//读取这一行信息
			return info;
		}
	/*
	 * 获取用户--輸入图书信息
	 * @return double 
	 */
		public static double ScannerInfo()
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("请输入：");
			double info = scanner.nextDouble();//读取这一行信息
			return info;
		}
		/*
		 * 获取用户--輸入图书信息
		 * @return int 
		 */
		public static int ScannerInfoInt()
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("请输入：");
			int info = scanner.nextInt();//读取这一行信息
			
			return info;
		}
		
		/*
		 * 获取用户--輸入图书信息
		 * @return Sting 
		 */
			public static String ScannerInfoString()
			{
				Scanner scanner = new Scanner(System.in);
				System.out.print("请输入：");
				String info = scanner.next();//读取这一行信息
				return info;
			}
		
	/*
	 * 获取用户-更改完商品-下一步  已校验！
	 * 获取用户-添加完商品-下一步
	 */
		public static void changedInfoNext(String choiceFunction)
		{		
			boolean boolNext = true;
			 do
			{
					System.out.println("是否继续进行-当前操作:(Y/N)");
					String choice = ScannerChoice.ScannerNext();
				
					 if ("y".equals(choice) || "Y".equals(choice)) //在JAVA: Equals比较的是值,==比较的是地址
						{
							 boolNext = false;
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
									boolNext = false;
				 					MainPage.MaintenancePage();
								}
				 	System.out.println("\n输入有误！请重新输入.");
			} while (boolNext);
		}
	
		/*
		 * 获取用户-更改-完售货员-下一步
		 * 获取用户-添加-完售货员-下一步
		 * 获取用户-查询-完售货员-下一步
		 * 获取用户-删除-完售货员-下一步
		 */
			public static void choiceSalesManNext(String choiceFunction)
			{	
				boolean boolNext = true;
				 do
				{		
						System.out.println("是否继续进行-当前操作:(Y/N)");
						String choice = ScannerChoice.ScannerNext();
					
						 if ( "y".equals(choice) || "Y".equals(choice) ) //在JAVA: Equals比较的是值,==比较的是地址  .将比较的常量放在前面，方直空指针异常
							{
								 boolNext = false;
								//下面的嵌套if-else 是让用户选择继续操作当前步骤所跳转到指定页面。（因为不同函数调用，跳转的指定函数不同）
								if ("updateSalesMan".equals(choiceFunction)) //equals时，常量放在前面，提高效率！
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
										boolNext = false;
										MainPage.salesManManagementPage();
									}
					 	System.err.println("\t输入有误！");
				} while (boolNext);
			}	
			
			
}
