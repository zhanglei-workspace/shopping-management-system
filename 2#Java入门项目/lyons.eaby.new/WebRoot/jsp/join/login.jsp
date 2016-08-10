<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/navbar.jsp" %>
<%@ page import="java.net.URLDecoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<% 
		/* 从本地磁盘中获取已保存的cookie */
		request.setCharacterEncoding("UTF-8");
		String username = "";
		String userpass = "";
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if(cookies!=null && cookies.length>0)
		{
			for(Cookie c:cookies)
			{
				if("username".equals(c.getName()))
				{
					username = URLDecoder.decode(c.getValue(),"UTF-8");//解码并取值、赋值
				}
				if("userpass".equals(c.getName()))
				{
					userpass = URLDecoder.decode(c.getValue(),"UTF-8");
				}
			}
		}
	%>
	<div align="center">
		<form action="<%= basePath %>Login.action" method="post">
		
			<table border="0" cellpadding="15" cellspacing="1">
				<tr>
					<td colspan="2">
						<input name="username" value="<%= username %>" placeholder="username"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="password" name="userpass" value="<%= userpass %>" placeholder="password"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="checkbox" name="isCookie" value="isCookie" checked="checked">记我十天
					</td>
					
					<td>
						<input type="submit" value="登陆"/>
					</td>
				</tr>
			</table>
			
		</form>
	</div>
</body>
</html>