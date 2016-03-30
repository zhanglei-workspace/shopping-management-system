<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="lyons.entity.Login"%>
<%
	
	Login isLogin = (Login)session.getAttribute("loginBean");
	if(isLogin==null)
	{%>
		<jsp:forward page="login.jsp" />
	<%}
%>



