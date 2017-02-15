<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!--top-->
	<%@ include file="/WEB-INF/jsp/common/headerBar.jsp" %>
</head>
<body>
    <!--content-top-->
    <div class="content-top">
        <!--sidebar-->
        <div class="sidebar">
            <h3>商品服务分类</h3>
            <!--sidebar-info-->
            <div class="sidebar-info">
                <ul class="side-li">
                    <li class="s_1"><h3>服装内衣<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_2"><h3>鞋包配饰<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_3"><h3>运动户外<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_4"><h3>珠宝手表<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_5"><h3>手机数码<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_6"><h3>家电办公<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_7"><h3>护肤彩妆<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_8"><h3>母婴用品<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_9"><h3>家纺居家<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_10"><h3>家具建材<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_11"><h3>美食特产<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_12"><h3>日用百货<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_13"><h3>汽车摩托<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_14"><h3>文化娱乐<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_15"><h3>本地生活<span class="fa fa-angle-right fa-loc"></span></h3></li>
                    <li class="s_16"><h3>虚拟服务<span class="fa fa-angle-right fa-loc"></span></h3></li>
                </ul>
                <!--hidden-li-box-->
                <ul class="hiden-box">
					<c:forEach varStatus="idx" begin="1" end="16">
						<li data-hidden="li" id="hiden-${idx.index}">
							<div class="hidden-title">
								<a href="javascript:void(0)">2精品女鞋</a><span class="right-box"><i
									class="fa fa-angle-right"></i></span> <a href="javascript:void(0)">2最in女装</a><span
									class="right-box"><i class="fa fa-angle-right"></i></span> <a
									href="javascript:void(0)">2飞鸟男人</a><span class="right-box"><i
									class="fa fa-angle-right"></i></span> <a href="javascript:void(0)">2女人搭配</a><span
									class="right-box"><i class="fa fa-angle-right"></i></span>
							</div>
							<div class="sub-nav-right">
								<div class="cell-box">
									<h1>印记鞋子</h1>
									<div class="a-box">
										<a href="javascript:void(0)">大妈</a><span>|</span> <a href="javascript:void(0)">鞋子</a><span>|</span>
										<a href="javascript:void(0)">预留字段</a>
									</div>
								</div>
								<div class="cell-box">
									<h1>印记女装</h1>
									<div class="a-box">
										<a href="javascript:void(0)">1</a><span>|</span> <a href="javascript:void(0)">裤子</a><span>|</span>
										<a href="javascript:void(0)">小西装</a><span>|</span> <a href="javascript:void(0)">长袖村上</a><span>|</span>
										<a href="javascript:void(0)" class="orange">春季外套</a> <a href="javascript:void(0)">郑志山</a><span>|</span>
										<a href="javascript:void(0)">毛衣</a><span>|</span> <a href="javascript:void(0)">长袖T恤</a><span>|</span>
										<a href="javascript:void(0)">唯一</a><span>|</span> <a href="javascript:void(0)">雪绒钱</a><span>|</span>
										<a href="javascript:void(0)">大地亏</a> <a href="javascript:void(0)">半身全</a><span>|</span> <a href="javascript:void(0)">风衣</a><span>|</span> <a href="javascript:void(0)">类似雪纺</a><span>|</span>
										<a href="javascript:void(0)">毛衣外套</a><span>|</span> <a href="javascript:void(0)">棒球服</a> <a href="javascript:void(0)">牛仔装</a><span>|</span> <a href="javascript:void(0)">礼服</a><span>|</span>
										<a href="javascript:void(0)">婚纱</a><span>|</span> <a href="javascript:void(0)">大妈</a><span>|</span>
										<a href="javascript:void(0)">Zara</a><span>|</span> <a href="javascript:void(0)">22</a> <ahref="javascript:void(0)">23</a> <a href="javascript:void(0)">24</a> <a href="javascript:void(0)">25</a>
									</div>
								</div>
								<div class="cell-box">
									<h1>印记女装</h1>
									<div class="a-box">
										<a href="javascript:void(0)">棒球服</a> <a href="javascript:void(0)">牛仔装</a><span>|</span>
									</div>
								</div>
							</div>
							<div class="sub-nav-left">
								<div class="cell-box">
									<h1>印记女装</h1>
									<div class="a-box">
										<a href="javascript:void(0)">牛仔装</a><span>|</span> <a href="javascript:void(0)">礼服</a><span>|</span>
									</div>
								</div>
								<div class="cell-box">
									<h1>印记女装</h1>
									<div class="a-box">
										<a href="javascript:void(0)">婚纱</a><span>|</span>
									</div>
								</div>
								<div class="cell-box">
									<h1>印记女装</h1>
									<div class="a-box">
										<a href="javascript:void(0)">连衣裙</a><span>|</span>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
                </ul>
            </div>
        </div>
        <!--right-con-->
        <div class="right-con">
            <div class="nav">
                <a id="spe-a1" href="javascript:void(0)">4预留字段</a>
                <a id="spe-a2" href="javascript:void(0)">4预留字段</a>
                <span class="line-a">|</span>
                <a href="javascript:void(0)">4预留字段</a>
            </div>
            <!--show-box-->
            <div class="show-box">
                <!--content-->
                <div class="content">
                    <ul class="imgBox">
                        <li><a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/1.jpg"></a></li>
                        <li><a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/2.jpg"></a></li>
                        <li><a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/3.jpg"></a></li>
                        <li><a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/4.jpg"></a></li>
                        <li><a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/5.jpg"></a></li>
                    </ul>
                    <div class="currentNum">
                        <span class="imgNum mark-color"></span>
                        <span class="imgNum"></span>
                        <span class="imgNum"></span>
                        <span class="imgNum"></span>
                        <span class="imgNum"></span>
                    </div>
                    <div class="control to-left"><i class="fa fa-angle-left"></i></div>
                    <div class="control to-right"><i class="fa fa-angle-right"></i></div>
                </div>
               <a style="float: left" href="javascript:void(0)"><img src="../resource/static/style/image/fbird/6.6.jpg" /></a>
                <!--content-down-->
                <div class="content-down">
                    <ul class="imgBox1">
                        <li>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/01.png" /></a>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/02.jpg" /></a>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/03.png" /></a>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/04.png" /></a>
                        </li>
                        <li>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/01.png" /></a>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/02.jpg" /></a>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/03.png" /></a>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/04.png" /></a>
                        </li>
                        <li>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/01.png" /></a>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/02.jpg" /></a>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/03.png" /></a>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/04.png" /></a>
                        </li>
                        <li>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/01.png" /></a>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/02.jpg" /></a>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/03.png" /></a>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/04.png" /></a>
                        </li>
                        <li>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/01.png" /></a>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/02.jpg" /></a>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/03.png" /></a>
                            <a href="javascript:void(0)"><img src="../resource/static/style/image/fbird/04.png" /></a>
                        </li>
                    </ul>
                    <div class="currentNum-down">
                        <span class="imgNum1 mark-color"></span>
                        <span class="imgNum1"></span>
                        <span class="imgNum1"></span>
                        <span class="imgNum1"></span>
                        <span class="imgNum1"></span>
                    </div>
                    <div class="control1 to-left1"><i class="fa fa-angle-left"></i></div>
                    <div class="control1 to-right1"><i class="fa fa-angle-right"></i></div>
                </div>
                <a style="float: left" href="javascript:void(0)"><img src="../resource/static/style/image/fbird/15.jpg" /></a>
            </div>
            <!--right-sidbar-->
            <div class="right-sidebar">
                <div class="info-box">
                    <ul class="tab-nav">
                        <li id="li-1" class="li-nav li-nav-hover li-border">公告</li>
                        <li id="li-2" class="li-nav">规则</li>
                        <li id="li-3" class="li-nav">论坛</li>
                        <li id="li-4" class="li-nav">安全</li>
                        <li style="border-right: none" id="li-5" class="li-nav">公益</li>
                    </ul>
                    <div id="box-1" style="display: block" class="hiddenBox">

                        <a href="javascript:void(0)">飞鸟2014:开放多样性</a>
                        <a href="javascript:void(0)">舌尖中国二季 天猫首尝</a>
                    </div>
                    <div id="box-2" class="hiddenBox">

                        <a href="javascript:void(0)">[重要] 淘点点规范</a>
                        <a href="javascript:void(0)">[重要] 虚假交易新规<br></a>
                        <a href="javascript:void(0)">[重要] 新增认证规则</a>
                        <a href="javascript:void(0)">[重要] 购买刀具实名</a>
                    </div>
                    <div id="box-3" class="hiddenBox">
                        <a href="javascript:void(0)">[聚焦] 新消保法全解析</a>
                    </div>
                    <div id="box-4" class="hiddenBox">
                        <a href="javascript:void(0)">注意骗子的技术升级了</a>
                    </div>
                    <div id="box-5" class="hiddenBox">
                        <a href="javascript:void(0)">[聚焦] 新消保法全解析</a>
                    </div>
                </div>
                <!--user-info-->
                <div class="user-info">
                    <div class="gold-top">
                        <img width="62px" height="62px" src="${path}resource/static/style/image/common/icon/user-head.jpg" />
                    </div>
                    <shiro:authenticated>
	                    <div class="inner-user fa-green">
	                       <h3>您好：<shiro:principal property="uName"/></h3>
	                    </div>
                    </shiro:authenticated>
                    <!--login-->
                    <shiro:guest>
	                    <div class="login">
	                        <a class="login-btn" href="/login"><i class="fa fa-user fa-user-loc"></i>登录</a>
	                        <a class="login-btn free" href="javascript:void(0)">免费注册</a>
	                    </div>
                    </shiro:guest>
                </div>
                <!--service-->
                <div class="service">
                    <h3>便民服务</h3>
                    <div id="service-1" class="service-cell service-z">
                        <h5 class="service-i"><img src="/resource/static/style/image/common/service/phone.png" /></h5>
                        <h6>话费</h6>
                        <i class="fa fa-angle-down"></i>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="/resource/static/style/image/common/service/game.png" /></h5>
                        <h6>游戏</h6>
                        <i class="fa fa-angle-down"></i>
                    </div>
                    <div  class="service-cell">
                        <h5 class="service-i"><img src="/resource/static/style/image/common/service/plane.png" /></h5>
                        <h6>旅行</h6>
                        <i class="fa fa-angle-down"></i>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="/resource/static/style/image/common/service/save.png" /></h5>
                        <h6>保险</h6>
                        <i class="fa fa-angle-down"></i>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="/resource/static/style/image/common/service/lottery.png" /></h5>
                        <h6>彩票</h6>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="/resource/static/style/image/common/service/move.png" /></h5>
                        <h6>电影</h6>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="/resource/static/style/image/common/service/eat.png" /></h5>
                        <h6>点外卖</h6>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="/resource/static/style/image/common/service/money.png" /></h5>
                        <h6>理财</h6>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="/resource/static/style/image/common/service/book.png" /></h5>
                        <h6>电子书</h6>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="/resource/static/style/image/common/service/miusc.png" /></h5>
                        <h6>音乐</h6>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="/resource/static/style/image/common/service/bag.png" /></h5>
                        <h6>水电煤</h6>
                    </div>
                    <div class="service-cell">
                        <h5 class="service-i"><img src="/resource/static/style/image/common/service/more.png" /></h5>
                        <h6>请期待</h6>
                    </div>
                </div>
                <!--service-box-->
                <div id="service-box-1" class="service-box">
                    <div class="service-head">
                        <a href="javascript:void(0)">话费充值</a>
                        <a href="javascript:void(0)">流量充值</a>
                        <span class="fa fa-times"></span>
                    </div>
                    <div class="feihua-in">
                        <span>号码</span>
                        <input class="tell-num" type="text"  placeholder="手机号、固话号"/>
                    </div>
                    <div class="feihua-in">
                        <span>面值</span>
                        <input class="money-in" type="text" value="50" />
                        <span class="fa fa-angle-down sel-money"></span>
                    </div>
                    <div class="gary-text"><span>售价&nbsp;￥&nbsp;</span><span class="orange">49-49.8</span></div>
                    <div style="margin-top: 10px">
                        <a href="javascript:void(0)" class="now-chongzhi">立即充值</a>
                        <a href="javascript:void(0)" class="now-chongzhi dingqi">定期充值</a>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </div>
    
    
    <!--main-->
    <div class="main">
        <div class="main-left">
            <div class="main-title">
                <h1>万能的飞鸟<span class="show-title">下面有 ${fn:length(goodsList)} 个商品限时抢购哦 </span></h1>
            </div>
            
            <c:forEach var="item" items="${goodsList}" varStatus="idx" begin="0" end="9">
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
	                        <h1><a href="javascript:void(0)###"><i class="fa fa-jpy"> ${item.gPrice }</i></a></h1>
	                        <span>
		                        <c:set var="zip" value="${item.gDescribe}"></c:set>
		                        ${fn:substring(zip, 0, 8)}
	                        </span>
	                    </div>
	                </div>
	            </div>
            </c:forEach>
            
        </div>
        <div class="main-right">
            <div class="time-go">
                <div class="time-cell">
                    <h1><a href="javascript:void(0)" class="text_shadow">我收藏的店铺上新</a><span class="now-news">更新<span class="">3</span></span></h1>
                    <div class="inner-show">
                        <a href="javascript:void(0)">
                            <img src="../resource/static/style/image/fbird/inner1.png">
                            <p class="price-info">￥118.00</p>
                        </a>
                        <a href="javascript:void(0)">
                            <img src="../resource/static/style/image/fbird/inner2.png">
                            <p>￥118.00</p>
                        </a>
                        <a href="javascript:void(0)">
                            <img src="../resource/static/style/image/fbird/inner3.png">
                            <p>￥118.00</p>
                        </a>
                        <h3><a href="$">更多店铺上新</a><i class="fa fa-angle-right"></i></h3>
                    </div>
                </div>
                <div class="time-cell">
                    <h1><a href="javascript:void(0)" class="text_shadow">你可能新欢的店铺推荐</a></h1>
                </div>
                <div class="time-cell">
                    <h1><a href="javascript:void(0)" class="text_shadow">我的足迹</a></h1>
                </div>
                <!--goto-see-->
                <h1 class="goto-see text_shadow">微淘动态<a href="javascript:void(0)">去广场看看</a></h1>
                <!--dynamic动态-->
                <div class="dynamic">
                    <!--<h3 class="text_shadow">天猫美妆<span>04-19 10:00</span><span class="follow">√&nbsp;<a href="javascript:void(0)">已关注</a>&nbsp;|&nbsp;<a href="javascript:void(0)">取消</a></span></h3>-->
                    <p>【美妆课堂】“羽”你相约步步惊情 若曦四爷再续... <a href="javascript:void(0)" style="color: #5684bc;">查看全文</a></p>
                    <a href="javascript:void(0)"><img width="80px" height="80px" src="../resource/static/style/image/fbird/dynamic1.jpg"></a>
                    <a href="javascript:void(0)"><img width="80px" height="80px" src="../resource/static/style/image/fbird/dynamic2.jpg"></a>
                    <a href="javascript:void(0)"><img width="80px" height="80px" src="../resource/static/style/image/fbird/dynamic3.jpg"></a>
                    <h6><a href="javascript:void(0)">评论(26)</a></h6>
                    <h4><a href="javascript:void(0)">更多动态&nbsp;</a><i class="fa fa-angle-right"></i></h4>
                    <div class="arrow"></div>
                </div>
                <!--circle-big-->
                <div class="circle-new">新</div>
                <div class="circle-go">逛</div>
                <!--time-circle-->
                <div class="time-circle"></div>
                <div class="time-circle bottom-circle"></div>
            </div>
                <!--last-->
                <div class="last-box">
                    <img src="../resource/static/style/image/fbird/last1.png" />
                    <img src="../resource/static/style/image/fbird/last2.jpg" />
                </div>
            </div>

        </div>
    </div>
    
	<!--footer-->
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
	
    <!--backtoTop1-->
    <!--兼容所有现代浏览器同时包括 ie6/7/8/9 （ie6会有一点点抖动）-->
    <div class="backtoTop" id="backToTop1">
        <div id="backToTop-up" class="up-back"><i class="fa fa-angle-up"></i></div>
        <div id="backToTop-down" class="down-back"><i class="fa fa-angle-down"></i></div>
    </div>
    
 
</body>
    <script src="${path}resource/script/main-img-show.js" type="text/javascript"></script>
    <script src="${path}resource/script/main.js" type="text/javascript"></script>
    <script src="${path}resource/script/goods.js" type="text/javascript"></script>
</html>