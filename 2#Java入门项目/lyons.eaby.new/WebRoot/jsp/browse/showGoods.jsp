<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/index.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    
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
        <jsp:useBean id="goods" class="lyons.goods.entity.Goods" scope="session"></jsp:useBean>	 
  		<% request.setCharacterEncoding("UTF-8"); %>
  	
  <br/><br/>
  <center>		
  	<table border="1" bordercolor="#00ff00" cellpadding="10" cellspacing="2" width="500" height="80">
  		  <caption><b>商品简略信息表</b><br></caption>
  		    <tr>
  		        <th>序号</th>
  		        <th>商品名称</th>
  		        <th>商品价格</th>
  		        <th>查看详情</th>
  		        <th>添加到购物车</th>
  		    </tr>
  		    
  	        <%
	  	       for (int i = 0,num=goods.getGoodsList().size(); i < num; i++)
               {
                   int ID = goods.getGoodsList().get(i).getCommodity_id();
                   String name = goods.getGoodsList().get(i).getCommodity_name();
                   String made = goods.getGoodsList().get(i).getCommodity_made();
                   Double price = goods.getGoodsList().get(i).getCommodity_price();
                   int number = goods.getGoodsList().get(i).getCommodity_balance();
                   String pic = goods.getGoodsList().get(i).getCommodity_pic();
                   int category = goods.getGoodsList().get(i).getCommodity_id();
               
                   String commodity = null;
                   commodity = ID+","+name+","+made+","+price+","+number+","+pic+","+category;//尾缀#，便于计算购物车价格
                   commodity = commodity.toString().replaceAll("\\p{Blank}","");
                   
                   String detail = "<form action='jsp/browse/showDetail.jsp' method='post'>"+
                                   "<input type='hidden' name='detail' value="+commodity+">"+
                                   "<input type='submit' value='商品详情'></form>";      
                   String shopCarButton = "<form action='"+basePath+"lyons.goods/PutGoodsToCar' method='post'>"+
                                   "<input type='hidden' name='GoodsCar' value="+commodity+">"+
                                   "<input type='submit' value='加入购物车'></form>";
               %>
	               <tr <% if(i%2 == 0){%> bgcolor="#FFE4B5" <%}else{%> bgcolor="#FFFACD" <%};//隔行换颜色%>>
	               <td><%= i %></td>
	               <td><%= name %></td>
	               <td><%= price%> $</td>
	               <td><%= detail %></td>
	               <td><%= shopCarButton %></td>
               </tr>
               <%}
  	        %>
  	      
  	</table>
  	
   </center>
  </body>
</html>