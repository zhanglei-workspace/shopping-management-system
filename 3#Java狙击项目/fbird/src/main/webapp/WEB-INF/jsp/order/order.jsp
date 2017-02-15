<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="${path }resource/static/style/css/order.css">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/jsp/common/headerBar.jsp" %>
    <div class="order-top">
        <div class="order-Content">
            <div class="fa-text-shadow">
            	<h1><i class="fa fa-folder-open fa-2x"></i> 历史订单</h1>
            </div>            
            <div class="fix">
                <table class="tab">
                    <tbody>
						<tr>
							<th><a class="delete-batch" href=""><i class="fa fa-trash fa-lg fa-red"> Delete</i></a></a></th>
							<th>序号</th>
							<th>商品名称</th>
							<th>商品价格</th>
							<th>订单数量</th>
							<th>购买时间</th>
							<th>操作</th>
						</tr>
						<c:forEach varStatus="idx" begin="1" end="6">
	                 <tr>
		                 <td><input type="checkbox" name="deleteId" value="id"></td>
		                 <td>${idx.index}</td>
		                 <td>香槟</td>
		                 <td><i class="fa fa-jpy" > 20</i></td>
		                 <td>100</td>
		                 <td>2013-14-15</td>
		                 <td><a class="delete-batch" href=""><i class="fa fa-trash-o fa-lg fa-red"></i> Delete</a></a></td>
		              </tr>
	             </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
	<!--footer-->
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
</body>
</html>