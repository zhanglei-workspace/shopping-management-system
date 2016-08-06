<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="lyons.entity.Login"%>
<%
	
	Login Logined = (Login)session.getAttribute("loginBean");
	if(Logined==null)
	{
		response.sendRedirect("lyons.eaby/jsp/join/login.jsp");
	}
%>



