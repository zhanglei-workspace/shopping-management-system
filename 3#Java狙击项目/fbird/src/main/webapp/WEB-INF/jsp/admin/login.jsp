<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/global.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/basejs.jsp"%>
<link rel="stylesheet" href="${path}resource/static/style/css/login.css" />

</head>
<body>
	<!-- header -->
	<div class="top-main-login">
		<a href="/index"> 
			<i class="fa fa-home fa-green fa-2x"></i><i class="ff-logo-cn">飞鸟速购</i> 
		</a>
		<a href="mailto:zhangleiworkspace@gmail.com target="_top">
			<i class="fa fa-commenting-o fa-gray advice"> 网站建设反馈</i>
		</a>
	</div>

	<!-- content -->
	<div class="content-top-login">
		<div class="login-left">
			<img alt="图片被误伤" src="${path}resource/static/style/image/ad/ad-login.jpg">
		<!-- 	<Canvas id="ad-login">图片被误伤</Canvas> -->
		</div>
		<div class="login-right">
			<div class="static-form">
				<div class="login-title text_shadow">
					<i class="fa fa-sign-in"> 飞鸟登录</i>
				</div>
				<form id="login-submit-form" method="post">
					<div class="field">
						<label><i class="fa fa-user-circle fa-2x login-icon" ></i></label>
		                <input type="text" id="uName" class="login-text" placeholder="username" min="5" maxlength="12">
						<div class="login-message">
							<span id="uNameMessage"></span>
						</div>
					</div>
					<div class="field">
						<label><i class="fa fa-key fa-2x login-icon" ></i></label>
	               		<input type="password" id="uPassword" class="login-text" placeholder="Password" min="6">
						<div class="login-message">
							<span id="pswdMessage"></span>
						</div>
					</div>
					<div class="field">
		               <input id="login-submit" type="button" class="login-button" value="登录">
		               <div class="login-message">
							<span id="submitMessage"></span>
					   </div>
					</div>
         	 	</form>
				<div class="login-links">
					<a class="fn-left pointer" target="_blank" tabindex="6" >忘记密码</a>
					<a class="pointer" id="register" target="_blank" tabindex="7">免费注册</a>
				</div>
			</div>
		</div>
	</div>

	<!--footer-->
	<%@ include file="/WEB-INF/jsp/common/footer.jsp"%>
	</div>
</body>
    <script src="${path}resource/script/login.js" type="text/javascript"></script>
</html>