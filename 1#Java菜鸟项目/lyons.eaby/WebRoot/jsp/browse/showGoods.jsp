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
  	<table border="1" bordercolor="#00ff00" cellpadding="10" cellspacing="2" width="400" height="80">
  		   <caption>商品简略信息表</caption>
  		    <tr>
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
  			int totalRecord = rowSet.getRow();
  			out.print("所查询的商品全部记录"+totalRecord);     //所查询的商品全部记录
  			int PageSize = goods.getPageSize();            //每页显示的记录数
  			int totalPages = goods.getTotalPage();         //总页数
  			
  			if(totalRecord % PageSize == 0)
  			{
  			   totalPages = totalRecord/PageSize;
  			}else
  			     {
  			       totalPages = totalRecord/PageSize+1;
  			     }
  			
  			goods.setPageSize(PageSize);
  			goods.setTotalPage(totalPages);
  			
  			if(totalPages >= 1)
  			{
  			   if(goods.getCurrentPage()<1)
  			   {
  			       goods.setCurrentPage(goods.getTotalPage());
  			   }
  			   if(goods.getCurrentPage()>goods.getTotalPage())
  			   {
  			       goods.setCurrentPage(1);
  			   }
  			   
  			   int index = (goods.getCurrentPage()-1)*PageSize+1;
  			   rowSet.absolute(index);                             //查询位置移动到currentPage页起始位置
  			   
  			   boolean flag = true;//不明确意图
  			   for(int i=1;i<=PageSize&&flag;i++)
  			   {
  			       String name = rowSet.getString(2);
  			       String price = rowSet.getString(4);
  			       
  			       String commodity = "("+name+","+price+")#"+price;//尾缀#，便于计算购物车价格
  			       commodity = commodity.replaceAll("\\p{Blank}","");
  			       
  			       String shopCarButton = "<form action='#' method='post'>"+
  			                       "<input type='hidden' name='shopCar' value="+commodity+">"+
  			                       "<input type='submit' value='加入购物车'></form>";
  			       String detail = "<form action='#' method='post'>"+
  			                       "<input type='hidden' name='detail' value="+price+">"+
  			                       "<input type='submit' value='查看详情'></form>";
  			       %>
  			           <tr>
  			               <td><%= name %></td>
  			               <td><%= price %>￥</td>
  			               <td><%= detail %></td>
  			               <td><%= shopCarButton %></td>
  			           </tr>
  			       <%
                   flag = rowSet.next();  			                       
  			   }
  			}
  		%> 
  	</table>
  	<br>每页最多显示<%= goods.getPageSize() %>条信息
  	<br><%= goods.getCurrentPage() %>/<%= goods.getTotalPage() %>页
  	
  	<table>
  	 <tr>
  	     <td>
  	         <form action="" method="post">
  	             <input type="hidden" name=currentPage value="<%= goods.getCurrentPage()-1 %>">
  	             <input type="submit" value="上一页">
  	         </form>
  	     </td>
  	     <td>
  	         <form action="" method="post">
  	             <input type="hidden" name=currentPage value="<%= goods.getCurrentPage()+1 %>">
  	             <input type="submit" value="下一页">
  	         </form>
  	     </td>
  	 </tr>
  	 <tr>
  	     <td>
  	         <form action="" method="post">
  	             每页显示<input type="text" name="pageSize" value="1" size="3">条记录
  	                 <input type="submit" value="确定">
  	         </form>
  	     </td>
  	 </tr>
  	 
  	</table>
  	
   </center>
  </body>
</html>
