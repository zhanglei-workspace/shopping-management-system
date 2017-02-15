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
            	<h1><i class="fa fa-cart-arrow-down fa-2x"></i> 购物车</h1>
            </div>            
            <div class="fix">
                <table class="tab">
                
                	<c:choose>
                		<c:when test="${fn: length(carList) == 0}">
                			购物车空空的，抓紧去购物吧
                		</c:when>
                		<c:otherwise>
		                    <tbody>
								<tr>
									<th><a class="car-batch" href=""><i class="fa fa-cart-plus fa-lg fa-red"> 结算</i></a></a></th>
									<th>序号</th>
									<th>商品名称</th>
									<th>商品价格</th>
									<th>商品数量</th>
									<th>产地</th>
									<th>操作</th>
								</tr>
								<c:forEach var="item" items="${carList}"  varStatus="idx" begin="0" end="${fn:length(carList)}">
					                 <tr>
						                 <td><input type="checkbox" name="carBuyId" checked="checked" value="${item.gCarGId}"></td>
						                 <td>${idx.index + 1}</td>
						                 <td>${item.gCarGName}</td>
						                 <td><i class="fa fa-jpy" > ${item.gCarPrice}</i></td>
						                 <td><input type="number" id="carNumber_${idx.index}" value="${item.gCarNumber}" min="1" max="10"></td>
						                 <td>${item.gCarGMade}</td>
						                 <td>
						                 	<i class="fa fa-trash-o fa-lg fa-red"></i>
						                 	<a data-car="${idx.index}" class="car-delete" href="javascript:void(0)"> Delete</a>
						                 	<input type="hidden" id="carId_${idx.index}" value="${item.gCarGId}" />
						                 </td>
						              </tr>
					             </c:forEach>
		                    </tbody>
                		</c:otherwise>
                	</c:choose>
                </table>
            </div>
        </div>
    </div>
	<!--footer-->
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
</body>
	<script src="${path}resource/script/goods.js" type="text/javascript"></script>
</html>