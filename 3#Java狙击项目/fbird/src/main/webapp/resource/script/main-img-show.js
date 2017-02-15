$(document).ready(function(){
    var $iBox = $('.imgBox'),
        $iNum = $('.imgNum'),  //缓存优化
        indexImg = 1,          //初始下标
        totalImg = 5,          //图片总数量
        imgSize = 520,         //图片尺寸 宽度
        moveTime = 1100,        //切换动画时间
        setTime = 2500,        //中间暂停时间
        clc = null;

    function moveImg(){
        if(indexImg != totalImg){
            $iBox.animate({
                left: -(indexImg*imgSize) + 'px'
            }, moveTime);
            $iNum.removeClass('mark-color')
                .eq(indexImg)
                .addClass('mark-color');
            indexImg++;
        }
        else{
            indexImg = 1;
            $iNum.removeClass('mark-color')
                .eq(indexImg - 1)
                .addClass('mark-color');
            $iBox.animate({
                left: 0
            }, moveTime);
        }
    }
    $iNum.hover(function(){
        $iBox.stop();                    //结束当前动画
        clearInterval(clc);              //暂停循环
        $iNum.removeClass('mark-color');
        $(this).addClass('mark-color');
        indexImg = $(this).index();
        $iBox.animate({
            left: -(indexImg*imgSize) + 'px'
        }, 500);
    },function(){
        clc = setInterval(moveImg, setTime);
    });

    //鼠标放上停止动画
    $iBox.hover(function(){
        $('.control').fadeIn(200);
        clearInterval(clc);              //暂停循环
    },function(){
        $('.control').hide();
        clc = setInterval(moveImg, setTime);
    });
    //显示左右
    $('.control').hover(function(){
        clearInterval(clc);
        $('.control').show();
//        return false;允许传播
    });
    //向右边前进
    $('.to-right').click(function(){
        if(indexImg != totalImg){
            $iBox.animate({
                left: -(indexImg*imgSize) + 'px'
            }, moveTime);
            $iNum.removeClass('mark-color')
                .eq(indexImg)
                .addClass('mark-color');
            indexImg++;
        }
        else{
            indexImg = 1;
            $iNum.removeClass('mark-color')
                .eq(indexImg - 1)
                .addClass('mark-color');
            $iBox.animate({
                left: 0
            }, moveTime);
        }
    });
    //向左边前进
    $('.to-left').click(function(){
        indexImg--;
        if(indexImg != 0){
            $iBox.animate({
                left: -((indexImg - 1)*imgSize) + 'px'
            }, moveTime);
            $iNum.removeClass('mark-color')
                .eq((indexImg - 1))
                .addClass('mark-color');
        }
        else{
            indexImg = totalImg;
            $iNum.removeClass('mark-color')
                .eq(indexImg - 1)
                .addClass('mark-color');
            $iBox.animate({
                left: -((indexImg - 1)*imgSize) + 'px'
            }, moveTime);
        }
    });


    clc = setInterval(moveImg, setTime);
});


//图片二
$(document).ready(function(){
    var $iBox = $('.imgBox1'),
        $iNum = $('.imgNum1'),  //缓存优化
        indexImg = 1,          //初始下标
        totalImg = 5,          //图片总数量
        imgSize = 520,         //图片尺寸 宽度
        moveTime = 1200,        //切换动画时间
        setTime = 2800,        //中间暂停时间
        clc = null;

    function moveImg(){
        if(indexImg != totalImg){
            $iBox.animate({
                left: -(indexImg*imgSize) + 'px'
            }, moveTime);
            $iNum.removeClass('mark-color')
                .eq(indexImg)
                .addClass('mark-color');
            indexImg++;
        }
        else{
            indexImg = 1;
            $iNum.removeClass('mark-color')
                .eq(indexImg - 1)
                .addClass('mark-color');
            $iBox.animate({
                left: 0
            }, moveTime);
        }
    }
    $iNum.hover(function(){
        $iBox.stop();                    //结束当前动画
        clearInterval(clc);              //暂停循环
        $iNum.removeClass('mark-color');
        $(this).addClass('mark-color');
        indexImg = $(this).index();
        $iBox.animate({
            left: -(indexImg*imgSize) + 'px'
        }, 500);
    },function(){
        clc = setInterval(moveImg, setTime);
    });


    //鼠标放上停止动画
    $iBox.hover(function(){
        $('.control1').fadeIn(200);
        clearInterval(clc);              //暂停循环
    },function(){
        $('.control1').hide();
        clc = setInterval(moveImg, setTime);
    });
    //显示左右
    $('.control1').hover(function(){
        clearInterval(clc);
        $('.control1').show();
//        return false;允许传播
    });

    //向右边前进
    $('.to-right1').click(function(){
        if(indexImg != totalImg){
            $iBox.animate({
                left: -(indexImg*imgSize) + 'px'
            }, moveTime);
            $iNum.removeClass('mark-color')
                .eq(indexImg)
                .addClass('mark-color');
            indexImg++;
        }
        else{
            indexImg = 1;
            $iNum.removeClass('mark-color')
                .eq(indexImg - 1)
                .addClass('mark-color');
            $iBox.animate({
                left: 0
            }, moveTime);
        }
    });
    //向左边前进
    $('.to-left1').click(function(){
        indexImg--;
        if(indexImg != 0){
            $iBox.animate({
                left: -((indexImg - 1)*imgSize) + 'px'
            }, moveTime);
            $iNum.removeClass('mark-color')
                .eq((indexImg - 1))
                .addClass('mark-color');
        }
        else{
            indexImg = totalImg;
            $iNum.removeClass('mark-color')
                .eq(indexImg - 1)
                .addClass('mark-color');
            $iBox.animate({
                left: -((indexImg - 1)*imgSize) + 'px'
            }, moveTime);
        }
    });

    clc = setInterval(moveImg, setTime);
});



//图片三
$(document).ready(function(){
    var $iBox = $('.imgBox2'),
        $iNum = $('.imgNum2'),  //缓存优化
        indexImg = 1,          //初始下标
        totalImg = 3,          //图片总数量
        imgSize = 220,         //图片尺寸 宽度
        moveTime = 1200,        //切换动画时间
        setTime = 2800,        //中间暂停时间
        clc = null;

    function moveImg(){
        if(indexImg != totalImg){
            $iBox.animate({
                left: -(indexImg*imgSize) + 'px'
            }, moveTime);
            $iNum.removeClass('mark-color')
                .eq(indexImg)
                .addClass('mark-color');
            indexImg++;
        }
        else{
            indexImg = 1;
            $iNum.removeClass('mark-color')
                .eq(indexImg - 1)
                .addClass('mark-color');
            $iBox.animate({
                left: 0
            }, moveTime);
        }
    }
    $iNum.hover(function(){
        $iBox.stop();                    //结束当前动画
        clearInterval(clc);              //暂停循环
        $iNum.removeClass('mark-color');
        $(this).addClass('mark-color');
        indexImg = $(this).index();
        $iBox.animate({
            left: -(indexImg*imgSize) + 'px'
        }, 500);
    },function(){
        clc = setInterval(moveImg, setTime);
    });

    //鼠标放上停止动画
    $iBox.hover(function(){
        $('.control2').fadeIn(200);
        clearInterval(clc);              //暂停循环
    },function(){
        $('.control2').hide();
        clc = setInterval(moveImg, setTime);
    });

    //显示左右
    $('.control2').hover(function(){
        clearInterval(clc);
        $('.control2').show();
//        return false;允许传播
    });
    //向右边前进
    $('.to-right2').click(function(){
        if(indexImg != totalImg){
            $iBox.animate({
                left: -(indexImg*imgSize) + 'px'
            }, moveTime);
            $iNum.removeClass('mark-color')
                .eq(indexImg)
                .addClass('mark-color');
            indexImg++;
        }
        else{
            indexImg = 1;
            $iNum.removeClass('mark-color')
                .eq(indexImg - 1)
                .addClass('mark-color');
            $iBox.animate({
                left: 0
            }, moveTime);
        }
    });
    //向左边前进
    $('.to-left2').click(function(){
        indexImg--;
        if(indexImg != 0){
            $iBox.animate({
                left: -((indexImg - 1)*imgSize) + 'px'
            }, moveTime);
            $iNum.removeClass('mark-color')
                .eq((indexImg - 1))
                .addClass('mark-color');
        }
        else{
            indexImg = totalImg;
            $iNum.removeClass('mark-color')
                .eq(indexImg - 1)
                .addClass('mark-color');
            $iBox.animate({
                left: -((indexImg - 1)*imgSize) + 'px'
            }, moveTime);
        }
    });

    clc = setInterval(moveImg, setTime);
});