<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../join/isLogin.jsp" %>
<%@ include file="/index.jsp" %>
<%@page import="com.sun.rowset.CachedRowSetImpl"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>浏览商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>

  <body>	 
    	<jsp:useBean id="goods" class="lyons.entity.Goods" scope="session"/>
  		<% request.setCharacterEncoding("UTF-8"); %>
  <br/><br/>
  <center>		
  	<table border="1" bordercolor="#00ff00" cellpadding="10" cellspacing="2" width="500" height="80">
  		  <caption><b>商品简略信息表</b><br></caption>
  		    <tr>
  		        <th>商品编号</th>
  		        <th>商品名称</th>
  		        <th>商品价格</th>
  		        <th>查看详情</th>
  		        <th>添加到购物车</th>
  		    </tr>
  		<% 
  			CachedRowSetImpl rowSet = goods.getRowSet();// 获取储存在模型中的行信息
  			if(rowSet==null)
  			{
  				out.print("商品数据库中没有哦");
  				return;
  			}
  			rowSet.last();
  			int totalRecord = rowSet.getRow();             //所查询的商品全部记录
  			int PageSize = goods.getPageSize();            //每页显示的记录数
  			int totalPages = goods.getTotalPage();         //总页数
  			int currentPage = goods.getCurrentPage();      //当前页码数
  			
  			
  			//检查是否用户自定义了页数
  			if(request.getParameter("newPageSize")!=null)
  			{
  			   PageSize = Integer.parseInt(request.getParameter("newPageSize"));
  			}
  			//检查是否用户点击了下、上一页操作
  			if(request.getParameter("currentPage") != null)
  			{
  			   int newCurrentPageInt = Integer.parseInt(request.getParameter("currentPage"));
  			   if(newCurrentPageInt <= totalPages && newCurrentPageInt>0)//下一页必须小于总页数，大于0
  			   {
  			       currentPage = newCurrentPageInt;
  			   }else
  			       {
  			           currentPage = goods.getCurrentPage();//页数大于总页数或者小于零后，还原数据
  			       }
  			}
  			
  			//分页
  			if(totalRecord % PageSize == 0)
  			{
  			   totalPages = totalRecord/PageSize;
  			}else
  			     {
  			       totalPages = totalRecord/PageSize+1;
  			     }
  			goods.setCurrentPage(currentPage);
  			goods.setPageSize(PageSize);
  			goods.setTotalPage(totalPages);
  			
  			if(totalPages >= 1)
  			{
  			   if(goods.getCurrentPage()<1)
  			   {
  			       goods.setCurrentPage(goods.getTotalPage());//点击上一页提交时CurrentPage+1，但当前页面已经是最后一页，会出现此表达式会成立
  			   }
  			   
  			   if(goods.getCurrentPage()>goods.getTotalPage()) //点击下一页提交时CurrentPage+1，但当前页面已经是最后一页，会出现此表达式会成立
  			   {
  			       goods.setCurrentPage(1);
  			   }
  			   
  			   int index = ((goods.getCurrentPage()-1)*PageSize)+1;
  			   rowSet.absolute(index);//查询位置移动到currentPage页起始位置
  			   
  			   boolean flag = true;
  			   for(int i=1,j=goods.getPageSize();i<=j&&flag;i++)
  			   {
  			       int number = rowSet.getInt(1);
  			       String name = rowSet.getString(2);
  			       String price = rowSet.getString(4);
  			       String commodity = "("+number+","+name+","+price+")#"+price;//尾缀#，便于计算购物车价格
  			       commodity = commodity.replaceAll("\\p{Blank}","");
  			       
  			       String shopCarButton = "<form action='#' method='post'>"+
  			                       "<input type='hidden' name='shopCar' value="+commodity+">"+
  			                       "<input type='submit' value='加入购物车'></form>";
  			       String detail = "<form action='lyons.dao/GoodsDao?key=3' method='post'>"+
  			                       "<input type='hidden' name='detail' value="+price+">"+
  			                       "<input type='submit' value='商品详情'></form>";
  			       %>
  			           <tr>
  			               <td><%= number %></td>
  			               <td><%= name %></td>
  			               <td><%= price %>￥</td>
  			               <td><%= detail %></td>
  			               <td><%= shopCarButton %></td>
  			           </tr>
  			       <%
                  flag = rowSet.next(); //查看是否还有值 	
  			   }
  			}
  		%> 
  	</table>
  	
  	<br><%= goods.getCurrentPage() %>/<%= goods.getTotalPage() %> 页
  	
  	<table>
  	 <tr>
  	     <td>
  	         <form action="" method="post">
  	             <input type="hidden" name=currentPage value="<%= (currentPage-1) %>">
  	             <input type="submit" value="上一页">
  	         </form>
  	     </td>
  	     <td>
  	         <form action="" method="post">
  	             <input type="hidden" name=currentPage value="<%= (currentPage+1) %>">
  	             <input type="submit" value="下一页">
  	         </form>
  	     </td>
  	 </tr>
  	 <tr>
  	     <td>
  	         <form action="" method="post">
  	         <br>总计：<%= totalRecord %>记录.
  	             每页显示<input type="text" name="newPageSize" value="<%= PageSize %>" size="2">条.
  	                 <input type="submit" value="确定">
  	         </form>
  	     </td>
  	 </tr>
  	 
  	</table>
  	
   </center>
  </body>
</html>