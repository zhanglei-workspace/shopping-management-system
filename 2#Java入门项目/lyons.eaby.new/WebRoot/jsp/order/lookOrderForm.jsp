<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/join/isLogin.jsp" %>
<%@ include file="/index.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单</title>
</head>
  <body>     
        <jsp:useBean id="orderList" class="lyons.order.entity.Order" scope="session"/>
        <% request.setCharacterEncoding("UTF-8"); %>
  <br/><br/>
  <center>
  
        
    <table border="1" bordercolor="#00ff00" cellpadding="5" cellspacing="1" width="300" height="80">
          <caption><b>我的订单</b><br></caption>
            <tr>
                <th>序号</th>
                <th>商品名称</th>
                <th>购买数量</th>
            </tr>

            
            <%
            for (int i = 0,num=orderList.getOrderList().size(); i < num; i++)
               {%>
                   <tr <% if(i%2 == 0){%> bgcolor="#20B2AA" <%}else{%> bgcolor="#008B8B" <%};//隔行换颜色%>>
                   <td><%= i %></td>
                   <td><%= orderList.getOrderList().get(i).getCommodity_name() %></td>
                   <td><%= orderList.getOrderList().get(i).getSum() %> </td>
               </tr>
               <%}
            %>
     
    </table>
    
   </center>
  </body>
</html>