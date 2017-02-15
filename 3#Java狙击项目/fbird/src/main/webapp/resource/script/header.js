/**
 * header相关
 */

//账户退出
function logout() {
	window.location.href = "/admin/logout";
}

//按照条件查询商品
$(document).ready(function(){
	
	var query = {
			 queryByKeyword : function(who,value) {
				$(who).click(function() {
					var keyword  = $(value).val(),
						length = keyword.replace(/(^\s*)|(\s*$)/g, "").length/*,
						data = {
							keyword : keyword
						};*/
				if (length != 0) {
					window.location.href = "/queryGoodsByKeyword?keyword="+keyword;
				}
				})
			}
		}
	
	query.queryByKeyword(".search-but",".search-in");
	query.queryByKeyword(".search-but-scroll",".search-in-scroll");
});


//下拉框
(function(){
    var num = 0;

    $('[data-toggle=arrowdown]').hover(function(){
        var _id = $(this).attr('id');
        num = _id.substring(5, _id.length);
        $(this).find('span')
            .removeClass('run-down')
            .addClass('run-up');
        $('#nav-box'+num).slideDown(100);
    }, function(){
        $(this).find('span')
            .removeClass('run-up')
            .addClass('run-down');
        $('#nav-box'+num).hide();
    });
    $('[data-toggle=hidden-box]').hover(function(){
        var _id =  $(this).attr('id');
        num = _id.substring(7, _id.length);
        $('#arrow'+num).addClass('nav-hover')
            .find('span').removeClass('run-down')
            .addClass('run-up');
        $(this).show();
    }, function(){
        $('#arrow'+num).removeClass('nav-hover')
            .find('span').removeClass('run-up')
            .addClass('run-down');
        setTimeout(function(){
            $('#arrow'+num).find('span').removeClass('run-down');
        }, 500);
        $(this).slideUp(100);
    });
})(jQuery);

//search-box
(function(){
    $('.search-box').hover(function(){
        $(this).find('span')
            .addClass('down-icon-circle').css({
                background: '#45c54a url(/resource/static/style/image/common/icon/arrow-white.png) no-repeat center'
            });
    }, function(){
        $(this).find('span')
            .removeClass('down-icon-circle').css({
                background: ''
            });
    });
})(jQuery);
//滚动出现固定导航
(function(){
    $(window).scroll(function(){
        var scTop = $(window).scrollTop(),
            $scS = $('.scroll-search'),
            $frS = $('.fix-right-sub'),
            rW;
        rW = ($(window).width() - 1190)/2;

        scTop >= 200 ? $scS.slideDown(200) : $scS.slideUp(200);
        if(scTop >= 2700 && scTop < 4400){
            $frS.css({position: 'fixed', top: '-541px', right: rW, marginTop: ''});
        }
        else if(scTop >= 4400){
            $frS.css({position: '', marginTop: 1728});
        }
        else{
            $frS.css({position: ''});
        }
    });
})(jQuery);

//关闭二维码
(function(){
  $('.close-code').click(function(){
      $('.two-code').fadeOut(200);
  });
})();