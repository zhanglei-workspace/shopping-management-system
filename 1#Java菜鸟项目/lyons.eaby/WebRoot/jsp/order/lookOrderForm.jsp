<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/join/isLogin.jsp" %>
<%@ include file="/index.jsp" %>
<%@page import="com.sun.rowset.CachedRowSetImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单</title>
</head>
  <body>     
        <jsp:useBean id="goods" class="lyons.entity.Goods" scope="session"/>
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
            CachedRowSetImpl rowSet = goods.getRowSet();// 获取储存在模型中的行信息
            if(rowSet==null)
            {
                out.print("商品数据库中没有哦");
                return;
            }
            rowSet.last();
            int totalRecord = rowSet.getRow();             //所查询的商品全部记录
            int PageSize = goods.getPageSize();            //每页显示的记录数
            int totalPages = goods.getTotalPage();         //总页数
            int currentPage = goods.getCurrentPage();      //当前页码数
            
            
            //检查是否用户自定义了页数
            if(request.getParameter("newPageSize")!=null)
            {
               PageSize = Integer.parseInt(request.getParameter("newPageSize"));
               currentPage = 1;//从第一页开始显示
            }
            //检查是否用户点击了下、上一页操作
            if(request.getParameter("currentPage") != null)
            {
               int newCurrentPageInt = Integer.parseInt(request.getParameter("currentPage"));
               if(newCurrentPageInt <= totalPages && newCurrentPageInt>0)//下一页必须小于总页数，大于0
               {
                   currentPage = newCurrentPageInt;
               }else
                   {
                       currentPage = goods.getCurrentPage();//页数大于总页数或者小于零后，还原数据
                   }
            }
            
            //分页
            if(totalRecord % PageSize == 0)
            {
               totalPages = totalRecord/PageSize;
            }else
                 {
                   totalPages = totalRecord/PageSize+1;
                 }
            goods.setCurrentPage(currentPage);
            goods.setPageSize(PageSize);
            goods.setTotalPage(totalPages);
            
            if(totalPages >= 1)
            {
               if(goods.getCurrentPage()<1)
               {
                   goods.setCurrentPage(goods.getTotalPage());//点击上一页提交时CurrentPage+1，但当前页面已经是最后一页，会出现此表达式会成立
               }
               
               if(goods.getCurrentPage()>goods.getTotalPage()) //点击下一页提交时CurrentPage+1，但当前页面已经是最后一页，会出现此表达式会成立
               {
                   goods.setCurrentPage(1);
               }
               
               int index = ((goods.getCurrentPage()-1)*PageSize)+1;
               rowSet.absolute(index);//查询位置移动到currentPage页起始位置
               
               boolean flag = true;
               for(int i=1,j=goods.getPageSize();i<=j&&flag;i++)
               {
                   String commodity_name = rowSet.getString(1);
                   String orderNumber = rowSet.getString(2);
                   
                   %>
                       <tr <% if(i%2 == 0){%> bgcolor="#20B2AA" <%}else{%> bgcolor="#008B8B" <%};//隔行换颜色%>>
                           <td><%= i %></td>
                           <td><%= commodity_name %></td>
                           <td><%= orderNumber %></td>
                       </tr>
                   <%
                  flag = rowSet.next(); //查看是否还有值   
               }
            }
        %> 
    </table>
    
    <br><%= goods.getCurrentPage() %>/<%= goods.getTotalPage() %> 页
    
    <table>
     <tr>
         <td>
             <form action="" method="post">
                 <input type="hidden" name=currentPage value="<%= (currentPage-1) %>">
                 <input type="submit" value="上一页">
             </form>
         </td>
         <td>
             <form action="" method="post">
                 <input type="hidden" name=currentPage value="<%= (currentPage+1) %>">
                 <input type="submit" value="下一页">
             </form>
         </td>
     </tr>
     
     <tr>
         <td><BR>
             <form action="" method="post">
                总计：<%= totalRecord %>条记录.每页显示<input type="text" name="newPageSize" value="<%= PageSize %>" size="2">条.
                     <input type="submit" value="确定">
             </form>
         </td>
     </tr>
     
    </table>
    
   </center>
  </body>
</html>