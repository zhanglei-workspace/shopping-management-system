<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="${path }resource/static/style/css/buy.css">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/jsp/common/headerBar.jsp" %>
		<div class="buy-tip">
				<div class="fa-text-shadow">
					<h1>订单信息</h1>
				</div>
				<div class="buy-tip-column-5">
					<div class="buy-td td-0 fa-gray">店铺宝贝</div>
					<div class="buy-td td-1 fa-gray" >商品属性</div>
					<div class="buy-td td-2 fa-gray">单价</div>
					<div class="buy-td td-3 fa-gray">数量</div>
					<div class="buy-td td-4 fa-gray">小计</div>
				</div>

				<c:forEach var="item" items="${buyingList}" varStatus="idx" begin="0" end="${fn:length(buyingList)}">
					<div class="buy-tip-column">
							<div class="th-left td-0">${item.gName}</div>
							<div class="th-left td-1">${item.gMade}</div>
							<div class="th-left td-2"><i class="fa fa-jpy" ></i>${item.gPrice}</div>
							<div class="th-left td-3"><input type="number" id="buyNumber" value="1" min="1" max="${item.gAmount}">件</div>
							<div class="th-left td-4  fa-red"><i class="fa fa-jpy" ></i>16.9</div>
					</div>
				</c:forEach>
				
				<div class="buy-confirm">
					<div class="buy-address">
						<div>实付款: 50$</div>
						<div>寄送至：</div>
						<div>
							<span>收货人:<shiro:principal property="uName"/></span>
							<span>张磊</span>
							<span>15853123329</span>
						</div>
					</div>
					<div class="buy-submit login-btn">
						<a href="javascript:void(0)">提交订单</a>
					</div>
				</div>
				
			</div>
		</div>
	<!--footer-->
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
</body>
</html>