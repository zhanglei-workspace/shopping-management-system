/**
 * 登录.js
 */
$(function() {
		//封装登录函数
		var login = {
				
				URL : {
					loginGet : function(){
						return "/login";
					},
					loginPost : function() {
						return "/admin/login";
					},
		
					logout : function() {
						return "/admin/logout";
					},
					
					register : function() {
						return "/admin/register";
					},
					registerSucess : function() {
						return "/registerSucess";
					}
		
				},
				//登录验证
				validate : {
					uName : function(uName) {
						var username = uName.replace(/(^\s*)|(\s*$)/g, "").length;
						if (username == 0) {
							return " 请输入用户名";
						}else if (username < 5 || username >12) {
							return " 用户名长度:5~12个字符";
						}else {
							return "true";
						}
					},
					pswd : function(uPassword) {
						var pswd = uPassword.replace(/(^\s*)|(\s*$)/g, "").length;
						if (pswd == 0) {
							return " 请输入密码";
						}else if (pswd < 6 || pswd > 60) {
							return " 密码长度至少为6个字符";
						}else {
							return "true";
						}
					},
					email : function(email) {
						var emailReg = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/,
							inputEmail = email.replace(/(^\s*)|(\s*$)/g, "");
						
						if (emailReg.test(inputEmail)) {
							return "true";
						}else {
							return "请输入正确的邮箱地址";
						}
					}
					
				},
				
				result : {
					
					//输入错误
					error : function(id,result) {
						$(id).attr("display" ,"inline-block").css("color","#ea1111");
						//输入错误信息
						$(id).hide().html('<i class="fa fa-exclamation-triangle" ></i>'+'<span id="+id+">' + result + '</span>').show(300);
					},
					
					//输入正确
					right : function(id) {
						$(id).css("color", "#1ec32c");
						$(id).hide().html('<i class="fa fa-check-circle fa-lg" ></i>').show(200);
					}
				},
				
				
				submit : {
					
					error : function(id,result) {
						$(id).attr("display" ,"inline-block").css("color","#ea1111");
						//错误提示信息
						$(id).hide().html('<i class="fa fa-exclamation fa-2x"  ></i>'+'<span id="+id+"> '+result+'......</span>').fadeIn(100).fadeOut(5000);
					
					},
					
					right : function(id) {
						$(id).hide().html('');
					}
				}
		}
	 
		
		//用户名
		$('#uName').blur(function() {
				var inputUname = $(this).val(),
				 	result = login.validate.uName(inputUname);
				if (result != "true") {
					login.result.error("#uNameMessage", result);
				} else {
					login.result.right("#uNameMessage");
					//用户名写入cookie(30天过期)
					$.cookie('inputUname', inputUname, {
						expires : 30,
						path : '/ffbird'
					});
				}
			});
		
		//密码
		$('#uPassword').blur(function() {
					var inputPswd = $(this).val();
					var result = login.validate.pswd(inputPswd);
					if (result != "true"){
						login.result.error("#pswdMessage", result);
					}else {
						login.result.right("#pswdMessage");
					}
				});
	
		//请求后台登录
		$('#login-submit').click(function() {
			var uName = $('#uName').val(),
			    uPassword = $('#uPassword').val(),
			    data = {
						uName : uName,
						uPassword : uPassword
					   },
			uNameResult = login.validate.uName(uName),
			uPasswordResult = login.validate.pswd(uPassword);
			if ( uNameResult == "true" && uPasswordResult == "true") {
				login.submit.right("#submitMessage");
				$.post(login.URL.loginPost(),data ,function(result){
					if (result.state == 200) {
						window.location.href = result.url;//跳转到之前登录网站或首页
					}else {
							login.submit.error("#submitMessage", result.message);
						  }
				},"json");
			}else {
				login.submit.error("#submitMessage"," 输入有误");
			}
		});
		
		//请求注册界面
		$('#register').click(function() {
			window.location.href = login.URL.register();//跳转到注册界面
		});

		/* ------------------*****register*******--------------- */
		//背景轮播
	    $('.register-content').backstretch([
	                   "/resource/static/style/image/common/register/1.jpg"
	                 , "/resource/static/style/image/common/register/2.jpg"
	                 , "/resource/static/style/image/common/register/3.jpg"
	                 ], {duration: 3000, fade: 750});
		
	    //校验邮箱
		$('#registerEmail').blur(function() {
			var inputEmail = $(this).val();
			var result = login.validate.email(inputEmail);
			if (result != "true"){
				login.result.error("#registerEmailMessage", result);
			}else {
				login.result.right("#registerEmailMessage");
			}
		});
	    
		//请求后台注册
		$('#register-submit').click(function() {
			var uName = $('#uName').val(),
			    uPassword = $('#uPassword').val(),
			    inputEmail = $('#registerEmail').val(),
			    data = {
						uName : uName,
						uPassword : uPassword,
						uEmail	: inputEmail
					   },
			uNameResult = login.validate.uName(uName),
			uPasswordResult = login.validate.pswd(uPassword),
			emailResult = login.validate.email(inputEmail);
			if ( uNameResult == "true" && uPasswordResult == "true" && emailResult == "true") {
				login.submit.right("#registerSubmitMessage");
				$.post(login.URL.register(),data ,function(result){
					if (result.state == 200) {
						window.location.href = login.URL.registerSucess();//跳转到注册成功界面
					}else {
							login.submit.error("#registerSubmitMessage", result.message);
						  }
				},"json");
			}else {
				login.submit.error("#registerSubmitMessage"," 输入有误");
			}
		});
	    
		//请求登录界面
		$('.login-now').click(function() {
			window.location.href = login.URL.loginGet();//跳转到登录界面
		});
});