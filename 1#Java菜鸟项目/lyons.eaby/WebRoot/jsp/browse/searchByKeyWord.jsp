<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>查询商品</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>

  <style type="text/css">
    body{background-color:  #008B8B;}
    .bg-div{position:relative;background-image: url(../../image/page/river.jpg);width:1228px;height:690px;margin: 0 auto;}
    .logo{background-image: url(../../image/page/logo.png);height:53px;width: 107px; float: left;margin: -4px 18px 0 0;}
    .search-form{float: left; background-color: #fff;padding:5px;}
    .search-text{height:25px;line-height: 25px;float: left;width: 350px;border: 0;outline: none;}
    .search-button{background-image: url(../../image/page/search-button.png);width:29px;height:29px;float: left;border: 0}
    .search-box{position:absolute;top:150px;left: 200px; }
    .suggest{width:388px; background-color:#fff;position:absolute;margin:0;padding:0;border-width:1px;border-style:solid;border-color: #999;}
    .suggest ul{list-style:none;display:block;margin:0;padding:0}
    .suggest ul li {padding:3px;line-height:25px;font-size: 14px;color: #777;cursor: pointer;padding:3px;}
    .suggest ul li:hover{background-color:#e5e5e5;text-decoration: underline;}
    .suggest strong{color:#000;}
    .clearfix:after{display:block;clear:both;content:"";visibility:hidden;height:0px;}
    .clearfix{zoom:1}
    
    .nav{margin:0 auto; width:1228px;}
    .nav ul{list-style:none;margin:0;padding:0;}
    .nav ul li{float:left;padding:10px;}
    .nav ul li a{color:#999; text-decoration:none;font-size:12px; font-weight:bold;}
    a:hover {text-decoration: underline;}
    </style>
  
  <body>
			<% request.setCharacterEncoding("UTF-8"); %>
			<div class="nav">
			<ul class="clearfix">
			   <li><a href="/lyons.eaby/index.jsp">首  页</a></li>
			</ul>
			</div>
			 <div class="bg-div">
			    <div class="search-box">
			    <div class="logo"></div>
			    
			        <form class="search-form" action="/lyons.eaby/lyons.dao/GoodsDao" target="_self" id="search-form" method="post">
			            <input type="text" class="search-text" name="keyWord" id="search_input" autocomplete="off"/>
			            <input type="hidden" name="key" value="2" />
			            <input type="submit" class="search-button" value=""/>
			        </form>
			
			    </div>
			 </div>
			 <div class="suggest" id="search-suggest" style="display:none">
			                <ul id="search-result">
			                    <li> ipad </li>
			                    <li> 运动鞋 </li>
			                </ul>
			</div>
 </body>
 <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
 <script>
 $('#search_input').bind('keyup',function(){
    var jqueryInput = $(this);
    var searchText = jqueryInput.val();
    $.get('http://api.bing.com/qsonhs.aspx?keyWord='+searchText);
 });
$('#search-suggest').css({
    top:$('#search-form').offset().top+$('#search-form').height()+10,
    left:$('#search-form').offset().left
}).show();

 </script>
</html>
