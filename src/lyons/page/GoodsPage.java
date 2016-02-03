package lyons.page;

import java.util.ArrayList;

import lyons.dao.GoodsDao;
import lyons.entity.Goods;
import lyons.tools.QueryPrint;
import lyons.tools.ScannerChoice;


public final class GoodsPage extends ScannerChoice
{

	/*
	 * 1.添加商品 已实现！ 已校验！
	 */
			public static void  addGoodsPage()
			{
				
				System.out.println("\t正在执行添加商品操作\n");
				
				System.out.println("\n請輸入添加商品-名称");
				String goodsName = ScannerInfoString();
				
				System.out.println("\n請輸入添加商品-价格");
				double goodsPrice = ScannerInfo();
			
				System.out.println("\n請輸入添加商品-数量");
				int goodsNumber = ScannerNum();
				
				Goods goods  = new Goods(goodsName,goodsPrice,goodsNumber);
				boolean bool = new GoodsDao().addGoods(goods);
				
					if (bool)
					{
						System.out.println("\n\t!您已成功添加商品到数据库!");			
					}else 
						{
							System.out.println("添加商品失败");	
						}
					//用户选择操作完 添加商品 后的下一步。
					changedInfoNext("addGoodsPage");
			}

	/*
	 * 2.更改商品 已实现！
	 */
			public static void  upateGoodsPage()
			{
				System.out.println("\t正在执行 更改商品 操作\n");
				System.out.println("请输入想要更改的商品名字");
				
					//调用查找商品函数，显示将要更改的商品
					int gid = QueryPrint.query("upateGoodsPage"); //返回的是查询的信息编号
		
				System.out.println("\n--------请选择您要更改的内容\n");
				System.out.println("\t1.更改商品-名称");
				System.out.println("\t2.更改商品-价格");
				System.out.println("\t3.更改商品-数量");
				System.out.println("\n请输入选项,或者按0返回上一级菜单.");
				 do
				{
					 String choice = ScannerInfoString();
					 String regex = "[0-3]";
					 if (choice.matches(regex))
					 { 
						 int info = Integer.parseInt(choice);
						 switch (info)
						 {
						 case 0:
							 MainPage.MaintenancePage();
							 break;
						 case 1:
							 System.out.println("请输入商品-新名称");
							 String gname = ScannerInfoString();
							 Goods goodsName = new Goods(gid,gname);
							 boolean boolName = new GoodsDao().updateGoods(1, goodsName);
							 if (boolName)
							 {
								 System.out.println("\n\t！！成功更新商品名至数据库！！\n");
							 }else 
							 	{
								 	System.err.println("\n\t！！更新商品名失敗！！");
							 	}
							 changedInfoNext("upateGoodsPage");
							 break;
						 case 2:
							 System.out.println("请输入商品-新价格 ");
							 double gprice = ScannerInfo();
							 Goods  goodsPrice = new Goods(gid,gprice);
							 boolean boolPrice = new GoodsDao().updateGoods(2,goodsPrice);
							 
							 if (boolPrice)
							 {
								 System.out.println("\n\t！！成功更新商品价格至数据库！！\n");
							 }else 
							 	{
								 	System.err.println("\n\t！！更新商品价格失敗！！");
							 	}
							 changedInfoNext("upateGoodsPage");
							 break;
						 case 3:
							 System.out.println("请输入商品-新数量 ");
							 int gNum = ScannerNum();	
							 Goods  goodsNum= new Goods(gid,gNum);
							 boolean boolNum = new GoodsDao().updateGoods(3,goodsNum);
							 if (boolNum)
							 {
								 System.out.println("\n\t！！成功更新商品数量至数据库！！\n");
							 }else 
							 	{
								 	System.err.println("\n\t！！更新商品数量失敗！！");
							 	}
							 	changedInfoNext("upateGoodsPage");
							 break;
						 default:
							 System.out.println("请输入正确的选择！");
						 break;
						 }
					 }
					 System.err.println("！输入有误！");
					System.out.println("请重新选择,或者按0返回上一级菜单.");
				 } while (true);	
			}
	
	/*
	 * 3.删除商品界面 已实现！
	 */
			public static void deleteGoodsPage()
			{
				System.out.println("\t正在执行 删除商品 操作\n");
				System.out.println("请输入想要删除的商品名字");
				
				//调用查找商品函数，显示将要删除的商品
				int gid = QueryPrint.query("deleteGoodsPage"); //返回的是查询的信息编号
				
				//确认是否真的删除！
					do
					{
						System.out.println("\n确认删除该商品：Y/N");
						String choice = ScannerInfoString();
							if ("y".equals(choice) || "Y".equals(choice))
							{
									//进行刪除-数据库操作
									boolean boolDeleteGoods = new GoodsDao().deleteGoods(gid);//調用刪除功能
									
									if (boolDeleteGoods)
									{
										System.err.println("\t！！已成功刪除该商品！！\n");
									}else 
										{
											System.err.println("\n\t！！刪除该商品失敗！！");
										}
									changedInfoNext("deleteGoodsPage"); 
							}else if ("N".equals(choice) || "n".equals(choice)) 
									{
										MainPage.MaintenancePage();
									}
						System.out.println("\t!!输入有误,请重新输入!!\n");
					} while (true);
				
				
			}
	
	/*
	 * 4.查询商品界面   已实现！
	 * 商品数量升序查询、按商品价格升序查询、输入关键字查询商品
	 */
			public static void queryGoodsPage()
			{
				System.out.println("\t\t  正在执行查询商品操作\n");
				System.out.println("\t\t1.按照商品 数量升序 查询");
				System.out.println("\t\t2.按照商品 价格升序 查询");
				System.out.println("\t\t3.输入商品  关键字  查询");
				System.out.println("\n请输入选项,或者按0返回上一级菜单.");
					
				//思考：1. 如果用户不输入数字，怎么办？	可能答案在while括号中
				//用户查找的信息在数据库中无，怎样判断？（已经解决，等会儿总结方法）
				//用户选择上面的提示信息
						 do
						{
							 String  info = ScannerInfoString();
							 String regex = "[0-3]";
							 if (info.matches(regex))
							 { 
								 int choice = Integer.parseInt(info);
								 switch (choice)
								 {
								 case 0:
									 MainPage.MaintenancePage();
									 break;
								 case 1:
								 case 2:
								 case 3:
									 if (choice == 3)//当用户使用3（即关键字查询）时，需要打印此项目。
									 {
										 System.out.println("\t\t正在执行商品  关键字  查询操作\n");
										 System.out.println("\n请输入商品关键字");
									 }
									 //调用查询功能
									 ArrayList<Goods> goodsList = new GoodsDao().queryGoods(choice);
									 if (goodsList == null || goodsList.size() <= 0) //很好的解决了判断动态数组是否为空的问题
									 {
										 System.err.println("\n\t!!您查询的商品不存在!!\n");
										 queryGoodsPage();
									 } else
									 	  {
											 if (choice == 1) //打印目录，不要放在功能函数中，会影响其他程序调用
											 {	
												 System.out.println("\t\t\t\t\t商品按照 数量升序 列表\n\n");
											 }else if (choice == 2) 
													 {
														 System.out.println("\t\t\t\t\t商品按照 价格升序 列表\n\n");
													 }else
														 {
															 System.out.println("\t\t\t\t\t您所查找的商品如下\n\n");
														 }
											 System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注\n");
											 
											 //遍历数组（存放用户查找的信息） 
											 for (int i = 0,length = goodsList.size(); i < length; i++)
											 {
												 Goods goods = goodsList.get(i);
												 System.out.print("\t"+goods.getGid()+"\t\t"+goods.getGname()+"\t\t"+goods.getGprice()+"\t\t"+goods.getGnum());
												 int gnum = goods.getGnum();
												 if (gnum ==0)
												 {
													 System.out.println("\t\t该商品已售空！");
												 }else if (gnum<10)
														 {
															 System.out.println("\t\t该商品已不足10件");
														 }else 
															 {
																 System.out.println("\t\t-");
															 }
												 System.out.println("\t");
											 }
											 	System.out.println("---------------------");
												 do
												{
													 System.out.println("输入 0 返回上一级菜单");
													 String choiceNext = ScannerInfoString();
													
													 if ("0".equals(choiceNext))
													{
														 MainPage.MaintenancePage();
													}
													 System.err.println("输入有误！");
												} while (true);
									 	  }
									 break;
								 default:
								 break;
								 }
							 break;
							 }
							 System.err.println("输入有误！");
							 System.out.println("请重新选择,或者按0返回上一级菜单.");
						} while (true);
	
					 //用户选择操作完查询后的下一步

						System.out.println("\n\n输入 0 返回上一级菜单");
						boolean boolNext = true;
						 do
						{
							 String choice = ScannerInfoString();
								
							 if ("0".equals(choice))
							 { 
								 boolNext = false;
								 queryGoodsPage();
							 }
							System.err.println("!输入有误!");
							System.out.println("请输入 0 返回上一级菜单");
						} while (boolNext);	
				}

	/*
	 * 5.展示所有商品界面 已实现！
	 */
	public static void displayGoodsPage()
	{
		System.out.println("\t\t\t\t\t所有商品列表\n\n");
		ArrayList<Goods> goodsList = new GoodsDao().displayGoods();
		
		if (goodsList.size() <= 0)
		{
			System.err.println("！库存为空！");
			MainPage.MaintenancePage();
		}else 
			{
				System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注\n");
				for (int i = 0,length = goodsList.size(); i < length; i++) //避免重复计算变量，浪费资源！
				{
					Goods goods = goodsList.get(i);
					System.out.print("\t"+goods.getGid()+"\t\t"+goods.getGname()+"\t\t"+goods.getGprice()+" $\t\t"+goods.getGnum());
					
					int gNum = goods.getGnum();
					if (gNum==0)
					{
						System.out.println("\t\t该商品已售空！");
					}else if (gNum<10) 
							{
								System.out.println("\t\t该商品已不足10件");
							}else
								{
									System.out.println("\t\t-");
								}
					System.out.println("\t");
				}
				//下一步
				System.out.println("---------------------");
				do
				{
					System.out.println("输入 0 返回上一级菜单");
					String choice = ScannerInfoString();
					
					if ("0".equals(choice))
					{
						MainPage.MaintenancePage();
					}
					System.out.println("输入有误！");
				} while (true);
			}
	}
}
