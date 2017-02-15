<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="${path }resource/static/style/css/detail.css">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/jsp/common/headerBar.jsp" %>
		<div class="detail">
		    <div class="fa-text-shadow">
              <h1>${goodsDetail.gName}</h1>
            </div>
				<div class="detail-left">
					<div class="detail-left-img">
						<img alt="商品详情" src="${path}${goodsDetail.gPic}">
					</div>
					<div class=detail-left-imgs"></div>
				</div>
				
				<div class="detail-right">
					<div class="detail-describe"><h1>${goodsDetail.gDescribe}</h1></div>
					<div class="detail-info">
						<dl class="detail-margin">
							<dt>促销价</dt>
							<dd>
								<div class="detail-metabit">              
									<em><i class="fa fa-jpy" ></i></em>
									<span class="tm-price">${goodsDetail.gPrice}</span>   
								</div>
							</dd>
						</dl>
						<dl class="detail-margin">
							<dt>运费</dt>
							<dd>
								<div class="detail-price">              
									<span>${goodsDetail.gMade} 至 北京    <em>快递: 0.00</em></span>   
								</div>
							</dd>
						</dl>
							
					</div>
					<div class="detail-buy">
						<dl class="detail-margin">
							<dt class="detail-metabit">数量</dt>
							<dd>
								<input type="number" id="detailNumber" value="1" min="1" max="${goodsDetail.gAmount}" /><span>件</span>
								<input type="hidden" id="detailgId" value="${goodsDetail.gId}"/>
								<span>库存<em>${goodsDetail.gAmount}</em> 件</span>
							</dd>
						</dl>
						<div class="detail-order">
								<a class="login-btn detail-order-buy" >立即购买</a>
								<a class="login-btn detail-order-car" >
									<i class="fa fa-cart-plus"></i> 加入购物车
								</a>
						</div>
					</div>
					<div>
						<dl class="detail-margin">
							<dt>服务承诺</dt>
							<dd>
								<ul  class="detail-service">
									<li><i class="fa fa-leaf"></i> 正品保证</li>
									<li><i class="fa fa-truck"></i> 极速退款</li>
									<li><i class="fa fa-plane"></i> 七天无理由退换</li>
								</ul>
							</dd>
						</dl>
					</div>
				</div>
			</div>
		
	<!--footer-->
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
</body>
    <script src="${path}resource/script/goods.js" type="text/javascript"></script>
</html>