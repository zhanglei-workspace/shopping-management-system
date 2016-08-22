<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/navbar.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
</head>
<body>
         <jsp:useBean id="userBean" class="lyons.user.entity.Register" scope="session" ></jsp:useBean>
		<div align="center">
			<form action="<%= basePath %>Register.action" method="post">
				<table border="1" cellpadding="10" cellspacing="1">
					<tr>
						<td>用户姓名:<input name="username" placeholder="*必填"/></td>
						<td>用户密码：<input type="password" name="userpass" placeholder="*必填(6-16字符之间)"/></td>
					</tr>
					<tr>
						<td>重复密码：<input type="password" name="again_userpass" placeholder="*必填"/></td>
						<td>联系电话：<input type="text" name="phone" placeholder="*选填"/></td>
					</tr>
					<tr>
						<td>邮寄地址：<input type="text" name="address" placeholder="*选填"/></td>
						<td>真实姓名：<input type="text" name="realname" placeholder="选填"/></td>
					</tr>
						<tr>
							<td>
								状态:<FONT color="red"><jsp:getProperty name="userBean" property="backNews"/></FONT>
							</td>
							<td>
								<input type="image" src="<%= basePath %>resource/image/page/submit.png" alt="submit" height="40" width="100"/>
							</td>
						</tr>
				</table>
				
			</form>
		
		</div>
		
</body>
</html>