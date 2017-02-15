<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/jsp/common/headerBar.jsp" %>
	<div class="query-main">
            <div class="fa-text-shadow">
              <h1><i class="fa fa-search fa-lg"></i> 搜索结果</h1>
            </div>
          <c:choose>
	          <c:when test="${fn: length(goodsList) == 0}">
	          	没有吆，换关键字再搜搜试试
	          </c:when>
	          <c:otherwise>
		          <c:forEach var="item" items="${goodsList}" varStatus="idx" begin="0" end="${fn:length(goodsList)}">
					<div class="product-box">
		                <div class="inner-info" data-query="${idx.index}">
		                    <div>
		                        <span class="line-f40">|</span>
		                        <span class="text-title">${item.gName}</span>
		                        <span class="add-shopcar">
		                            <span class="line-f40">+</span>
		                            <a href="javascript:void(0)">加入购物车</a>
		                        </span>
		                        <i id=""></i>
		                        <input type="hidden" id="goodsId_${idx.index}" value="${item.gId}"/>
		                    </div>
		                    <div class="inner-left">
		                        <img src="${path}${item.gPic}" />
		                        <h1><a href="javascript:void(0)"><i class="fa fa-jpy"> ${item.gPrice }</i></a></h1>
			                    <span>
			                        <c:set var="zip" value="${item.gDescribe}"></c:set>
			                        ${fn:substring(zip, 0, 8)}
		                        </span>
		                    </div>
		                </div>
		            </div>
		          </c:forEach>	
	          </c:otherwise>
          </c:choose>
          	
	</div>
	<!--footer-->
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
</body>
	<script src="${path}resource/script/main.js" type="text/javascript"></script>
    <script src="${path}resource/script/goods.js" type="text/javascript"></script>
</html>