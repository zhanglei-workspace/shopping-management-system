<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/global.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/WEB-INF/jsp/common/basejs.jsp"%>
</head>
<body id="headerBarBody">
	<!--scroll-head-->
    <div class="scroll-head"></div>
    <!--top-->
    <div class="top-wrapper">
        <div class="top-info">
            <div class="top-left">
                <!-- <a class="a-float-left" href="javascript:void(0)">预留链接</a> -->
            	<shiro:authenticated>
	                <div data-toggle="arrowdown" id="arrow1" class="user-name">
	                    <a href="javascript:void(0)">飞鸟阁下</a>
	                    <span class="down-icon"></span>
	                </div>
                </shiro:authenticated>
                <shiro:guest>
                	<a href="/login" target="_top" class="fa-green">  亲，请登录  </a>
                	<a href="javascript:void(0)">免费注册</a>
                </shiro:guest>
                <!--hidden-box-->
                <div data-toggle="hidden-box" id="nav-box1" class="user-box">
                    <img class="my-head" src="${path}resource/static/style/image/common/icon/user-head.jpg" />
                    <div class="my-grow">
                        <h1><a href="javascript:void(0)">账号管理</a>&nbsp;|&nbsp;<a href="javascript:void(0);" onclick="logout();">退出</a></h1>
                        <p>
                            <h2><a href="javascript:void(0)">查看我会员特权</a></h2>
                            <a href="javascript:void(0)">我的成长</a>
                        </p>
                    </div>
               </div>
            </div>
            <!--top-right-->
            <div class="top-right">
                <div data-toggle="arrowdown" id="arrow3" class="user-name">
                    <a href="javascript:void(0)">我的飞鸟</a>
                    <span class="down-icon"></span>
                </div>
                <div data-toggle="arrowdown" id="arrow4" class="user-name">
                    <i class="fa fa-shopping-cart fa-green"></i>
                    <a href="javascript:void(0)">购物车</a>
                    <span class="down-icon"></span>
                </div>
                <div data-toggle="arrowdown" id="arrow5" class="user-name">
                    <i class="fa fa-star fa-gray"></i>
                    <a href="javascript:void(0)">收藏夹</a>
                    <span class="down-icon"></span>
                </div>
                <span class="vertical-line">|</span>
                <div data-toggle="arrowdown" id="arrow6" class="user-name">
                    <a href="javascript:void(0)">卖家中心</a>
                    <span class="down-icon"></span>
                </div>
                <div data-toggle="arrowdown" id="arrow7" class="user-name">
                    <i class="fa fa-list-ul fa-green"></i>
                    <a href="javascript:void(0)">网站导航</a>
                    <span class="down-icon"></span>
                </div>
                <!--hidden-box-->
                <div data-toggle="hidden-box" id="nav-box3" class="my-taobao-box">
                    <ul>
                        <li>已买到的宝贝</li>
                        <li>新欢</li>
                        <li>我的足迹</li>
                        <li>我的上新</li>
                        <li>我的优惠</li>
                    </ul>
                </div>
                <div data-toggle="hidden-box" id="nav-box4" class="shopping-box">
                    <span>您购物车里还没有任何宝贝。</span><a class="check-shopp" href="javascript:void(0)">查看我的购物车</a>
                </div>
                <div data-toggle="hidden-box" id="nav-box5" class="get-box">
                    <ul>
                        <li>收藏的宝贝</li>
                        <li>收藏的店铺</li>
                    </ul>
                </div>
                <div data-toggle="hidden-box" id="nav-box6" class="center-box">
                    <ul>
                        <li>已售罄的宝贝</li>
                        <li>出售中的宝贝</li>
                        <li>已卖出的宝贝</li>
                    </ul>
                </div>
                <div data-toggle="hidden-box" id="nav-box7" class="nav-box">
                    <div class="sub-nav top-sub-nav">
                        <!--<input type="button" class="more-btn" value="更多"/>-->
                        <!--sub-nav-cell-->
                        <div class="sub-nav-cell right-shadow">
                            <h3 class="orange">主题市场</h3>
                            <ul class="sub-nav-box">
                                <li><a href="javascript:void(0)">爱美女人</a></li>
                                <li><a href="javascript:void(0)">品质男人</a></li>
                            </ul>
                        </div>
                        <div class="sub-nav-cell right-shadow">
                            <h3 class="green-sp">特色购物</h3>
                            <ul class="sub-nav-box sp">
                                <li><a href="javascript:void(0)">家用电器</a></li>
                                <li><a href="javascript:void(0)">狠爱</a></li>
                                <li><a href="javascript:void(0)">网络游戏</a></li>
                                <li><a href="javascript:void(0)">潮流设计</a></li>
                                <li><a href="javascript:void(0)">飞鸟星愿</a></li>

                            </ul>
                        </div>
                        <div class="sub-nav-cell right-shadow">
                            <h3 class="red-now">当前热点</h3>
                            <ul class="sub-nav-box now">
                                <li><a href="javascript:void(0)">爱美女人</a></li>
                                <li><a href="javascript:void(0)">品质男人</a></li>
                            </ul>
                        </div>
                        <div class="sub-nav-cell">
                            <h3 class="blue-more">更多精彩</h3>
                            <ul class="sub-nav-box more">
                                <li><a href="javascript:void(0)">爱美女人</a></li>
                                <li><a href="javascript:void(0)">品质男人</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--scroll-top-->
        <div class="scroll-search">
            <div class="search-litter">
                <img class="scroll-logo" src="${path}resource/static/style/image/common/icon/ffbird.bmp" />
                <!--scroll-search-->
                <div class="search-wrapper-scroll">
                    <div class="search-box-scroll">
                        <div data-toggle="arrowdown" id="arrow9" class="search-toggle-scroll">
                            宝贝<span class="down-icon"></span>
                        </div>
                        <input class="search-in-scroll" type="text" placeholder="    搜‘暖宝宝’试试" />
                        <input type="button" class="search-but-scroll" value="搜索">
                        <!-- <div data-toggle="hidden-box" id="nav-box9" class="search-toggle-box-scroll">店铺</div> -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- top main -->
    <div class="top-main">
        <img src="${path}resource/static/style/image/common/icon/ffbird-logo.jpg" />
        <div class="search-wrapper">
            <div class="search-box">
                <div data-toggle="arrowdown" id="arrow8" class="search-toggle">
                    宝贝<span class="down-icon"></span>
                </div>
                <input class="search-in" type="text" placeholder="    搜‘暖宝宝’试试">
                <input type="button" class="search-but" value="搜索">
                <!-- <div data-toggle="hidden-box" id="nav-box8" class="search-toggle-box">店铺</div> -->
            </div>
        </div>
        <!--two-code-->
        <div class="two-code">
            <h3>飞鸟科技</h3>
            <img src="${path}resource/static/style/image/common/icon/code.png" />
            <div class="close-code"><i class="fa fa-times"></i></div>
        </div>
    </div>
    
</body>
    <script src="${path }resource/script/header.js" type="text/javascript"></script>
</html>