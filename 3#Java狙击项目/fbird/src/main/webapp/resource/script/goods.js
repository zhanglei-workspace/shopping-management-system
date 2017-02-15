
//hidden-title
(function(){

})();

	/********************* goods detail*******************/
//查看商品详情
$(document).ready(function(){
	$('.inner-info').click(function() {
		var index = "#goodsId_"+$(this).attr("data-query"),
		    gId = $(index).val();
		window.location.href = "/goodsDetail?gId="+gId;
	});
});

//立即购买
$(document).ready(function(){
	$('.detail-order-buy').click(function() {
		var detailgId = $('#detailgId').val();
		window.location.href = "/buy?detailgId="+detailgId;//跳转到购买界面
	});
});

	/********************* car detail*******************/

//购物车单条删除
$(document).ready(function(){
	
	$('.car-delete').click(function() {
		var index = $(this).attr("data-car"),
			gCarGId = $("#carId_"+index).val(),
		    data = {
				gCarGId : gCarGId
			   };

		$.post("/carDelete",data ,function(result){
			if (result.state == 200) {
				window.location.href = "/myCar"; // Refresh my shoping car
			}else {
					/**
					 * TODO 删除失败
					 */
				  }
		},"json");
	});
});
/*//购物车单条删除
$(document).ready(function(){
	
	$('.car-delete').click(function() {
		var index = $(this).attr("data-car"),
		gCarGId = $("#carId_"+index).val(),
		gCarNumber = $("#carNumber_"+index).val(),
		data = {
			gCarGId : gCarGId,
			gCarNumber : gCarNumber
		};
		
		$.post("/carDelete",data ,function(result){
			if (result.state == 200) {
				window.location.href = login.URL.registerSucess();//跳转到注册成功界面
			}else {
				login.submit.error("#registerSubmitMessage", result.message);
			}
		},"json");
	});
});
*/



















