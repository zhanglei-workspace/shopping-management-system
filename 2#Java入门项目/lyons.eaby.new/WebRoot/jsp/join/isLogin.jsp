<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="lyons.user.entity.User"%>
<%
	
	User Logined = (User)session.getAttribute("loginBean");
	if(Logined==null)
	{
		response.sendRedirect("lyons.eaby.new/jsp/join/login.jsp");
	}
%>



