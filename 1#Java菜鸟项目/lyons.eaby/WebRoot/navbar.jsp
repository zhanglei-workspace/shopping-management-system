<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>导航条</title>
</head>
<style type="text/css">
  
  *{
	margin:0; 
	padding:0; 
	font-size:16px
 }
.nav{
	list-style:none; 
	height:50px;
	border-bottom:5px solid #F60;
	padding-left:30px;
  }
.nav li{
	float:left;
	margin-top:25px;
  }
.nav li a{
	background-color:#ccc;
	text-decoration:none;
	display:block;
	height:25px;
	line-height:25px;
	width:120px;
	margin-right:1px;
	text-align:center;
	background:url(/lyons.eaby/image/page/nav.png);
 }
.nav li a.on, .nav li a:hover
	{
		color:#fff;
		background-position:0 -30px;
    }
    
.user{list-style:none;padding-right:18px; }
.user li{float:right;}
.user li a{
	text-decoration:none;
	color:#f60;
	height:15px;
	line-height:25px;
 }
  
  </style>
  
  <body>
   		<div>
  			<ul class="nav">
    			<li><a class="on" href="index.jsp">首  页</a></li>
    			<li><a href="#">我的订单</a></li>
    			<li><a href="#"> 购物车</a></li>
    			<li><a href="#">浏览商品</a></li>
    			<li><a href="#">查询商品</a></li>
    		</ul>
   		</div>
  </body>

</html>