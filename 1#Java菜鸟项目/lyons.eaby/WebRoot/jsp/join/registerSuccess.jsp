<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'landing.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="refresh" content="3; url=<%= path %>/jsp/join/login.jsp"> 
	
	<!-- <link rel="stylesheet" type="text/css" href="<%= path %>/css/nav.css">  -->

  </head>
  
  <body>
  
   		<% request.setCharacterEncoding("UTF-8"); %>
   		
				<b><font color="red">注册成功</font></b>
				
				三秒后跳转到登陆界面.....

  </body>
</html>
