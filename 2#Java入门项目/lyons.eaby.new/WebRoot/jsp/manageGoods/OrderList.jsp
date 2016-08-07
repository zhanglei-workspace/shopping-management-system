<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
        <title>内容列表页面</title>
        <link href="<%= basePath %>resource/css/all.css" rel="stylesheet" type="text/css" />
        <script src="<%= basePath %>resource/js/jquery-1.8.0.min.js"></script>
        <script src="<%= basePath %>resource/js/OrderList.js"></script>
    </head>
    <body style="background: #e1e9eb;">
    
        <jsp:useBean id="orderAllList" class="lyons.order.entity.Order" scope="session"/>
        <% request.setCharacterEncoding("UTF-8"); %>
        
        <form action="<%= basePath %>Order.action?key=3" id="mainForm" method="post">
            <div class="right">
                <div class="current">当前位置：<a href="<%= basePath %>index.jsp" style="color:#6E6E6E;">订单管理</a> &gt; 订单列表</div>
                <div class="rightCont">
                    <p class="g_title fix">订单详情 <a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a class="btn03" href="javaScript:deleteOrderBatch('<%= basePath %>');">删 除</a></p>
                    <table class="tab1">
                        <tbody>
                            <tr>
                                <td width="90" align="right">用户名：</td>
                                <td>
                                    <input name="queryUserName" type="text" class="allInput" value=""/>
                                </td>
                                <td width="90" align="right">关键字：</td>
                                <td>
                                    <input name="keyWord" type="text" class="allInput" value=""/>
                                </td>
                                <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="zixun fix">
                        <table class="tab2" width="100%">
                            <tbody>
                                <tr>
                                    <th><input type="checkbox" id="all" onclick="#"/></th>
                                    <th>序号</th>
                                    <th>商品名称</th>
					                <th>商品价格</th>
					                <th>订单数量</th>
					                <th>订单日期</th>
                                    <th>操作</th>
                                </tr>
						              <%
						               for (int i = 0,num=orderAllList.getOrderList().size(); i < num; i++)
						               {
						                   int ID = orderAllList.getOrderList().get(i).getId();
						                   String name = orderAllList.getOrderList().get(i).getCommodity_name();
						                   Double price = orderAllList.getOrderList().get(i).getCommodity_price();
						                   int number = orderAllList.getOrderList().get(i).getSum();
						               
						               %>
						                   <tr <% if(i%2 == 0){%> bgcolor="#FFE4B5" <%}else{%> bgcolor="#FFFACD" <%};//隔行换颜色%>>
						                   <td><input type="checkbox" name="deleteId" value=<%= ID %>></td>
						                   <td><%= i %></td>
						                   <td><%= name %></td>
						                   <td><%= price%> $</td>
						                   <td><%= number %> </td>
						                   <td><a href="#">查看详情</a></td>
						                   <td>
						                       <a href="#">修改</a>&nbsp;&nbsp;&nbsp;
						                       <a href="<%= basePath %>Order.action?key=4&id=<%= ID %>">删除</a>
						                   </td>
							               </tr>
							               <%}
						               %>
                            </tbody>
                        </table>
                        <div class='page fix'>
                            共 <b>4</b> 条
                            <a href='###' class='first'>首页</a>
                            <a href='###' class='pre'>上一页</a>
                            当前第<span>1/1</span>页
                            <a href='###' class='next'>下一页</a>
                            <a href='###' class='last'>末页</a>
                            跳至&nbsp;<input type='text' value='1' class='allInput w28' />&nbsp;页&nbsp;
                            <a href='###' class='go'>GO</a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
