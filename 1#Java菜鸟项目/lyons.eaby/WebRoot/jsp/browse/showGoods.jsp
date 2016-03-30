<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/navbar.jsp" %>
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
  
  		<% 
  			String key = request.getParameter("key"); 
  			if(!("4".equals(key)))
  			{%>
	  		<div class="showGoods"><!-- 静态包含始终不行 -->
	 			<form name="scanGoods" action="<%= path %>/lyons.dao/GoodsDao?key=4" method="post">
	    			<input type="submit" value="" width=0 height=0 />
	    		</form>
	    			 <script language="JavaScript" type="text/JavaScript">
						scanGoods.submit();
					 </script>
	   		</div>
  			
  			<%}
  		%>
  		
				 
				 
    	<jsp:useBean id="goods" class="lyons.entity.Goods" scope="session"/>
  		<% request.setCharacterEncoding("UTF-8"); %>
  		<% 
  			CachedRowSetImpl rowSet = goods.getRowSet();// 获取储存在模型中的行信息
  			if(rowSet==null)
  			{
  				out.print("商品数据库中没有哦");
  				return;
  			} else{out.print("u幼稚");}
  		
  		%> 
    	<center>
    	<!-- 
    	
    		<form action="<%= path %>/lyons.dao/GoodsDao?key=<%= request.getParameter("scanGoods") %>">
    		</form>
    	 -->
    			<table width="750" height="60">
    				<tr>
    					<td>
    					图片、价格、描述、产地
    					<img src=""/>￥
    					</td>
    				</tr>
    			</table>
    	</center>
  </body>
</html>
