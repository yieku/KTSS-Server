<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>看图识树  | CQU</title>
<link rel="stylesheet" href="css/onepage-scroll.css">
<style>
* { margin: 0; padding: 0;}
ul, ol { list-style-type: none;}
.f-cb:after { display: table; content: ''; clear: both;}
.f-cb { zoom: 1;}
a { text-decoration: none;}

html { overflow-x: auto;}
body { min-width: 1024px; font: 12px/18px "Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif; color: #fff;}
.loading { background: url(images/loading.gif) 50% no-repeat;}
.loading .main { opacity: 0; opacity: 0;}

.main { -webkit-transition:opacity .6s; -moz-transition:opacity .6s; -o-transition:opacity .6s; transition: opacity .6s;}
.page { position: relative; overflow: hidden;}
.page .txt { z-index: 2}
.page .txt p { font-size: 19px; line-height: 1.6316;}
.page img { z-index: 1;}
.page1 { background: url(images/img2.jpg) background-color: #fff;}
.page2 { background: url(images/texture_20.png) repeat scroll 0 0 / 160px auto, url(images/gradient_black.png) repeat scroll 0 0 / 20px 100% rgba(0, 0, 0, 0); background-color: #5f5f61;}
.page3 { background: url(images/texture_50.png) repeat scroll 0 0 / 160px auto, url(images/gradient_gold_reverse.png) repeat scroll 0 0 / 20px 100% rgba(0, 0, 0, 0); background-color: #e2d5c5;}
.page4 { background: url(images/texture_50.png) repeat scroll 0 0 / 160px auto, url(images/gradient_silver.png) repeat scroll 0 0 / 20px 100% rgba(0, 0, 0, 0); background-color: #cecfd3;}
.page5 { background: url(images/gradient_white.png) repeat scroll 0 0 / 20px 100% rgba(0, 0, 0, 0); background-color: #f4f4f4;}

.mainNav { width: 980px; height: 36px; margin: 18px auto; border-radius: 5px; background: url(images/globalheader.png) 0 0 repeat-x;}
.mainNav ul { display: table; float: left; width: 845px; table-layout: fixed;}
.mainNav ul li { display: table-cell; height: 36px; overflow: hidden;}
.mainNav li a { display: block; line-height: 36px; font-size: 12px; text-align: center; color: #fff;}
.mainNav li:nth-child(1) { border-radius: 5px 0 0 5px;}
.mainNav li a:hover { background-color: #333;}

 

.subNav { width: 980px; margin: 0 auto; padding-bottom: 10px; border-bottom: 1px solid #d1c6b3;}

.subNav ul { float: right; padding-top: 8px;}
.subNav li { float: left; font-size: 12px; margin: 0 8px 0 24px;}
.subNav a { float: left; line-height: 25px; color: #333;}


.page1 .txt { position: absolute; left: 50%; top: 50%; margin: -100px 0 0 -490px; width: 433px; height: 310px;}

.page1 p { width: 340px;}
.page1  img { position: absolute; left: 45%; top: 187px; margin-left: -105px;}

.page2 .txt { position: absolute; left: 50%; bottom: 15%; width: 980px; margin-left: -490px;}
.page2 .txt h2 { width: 980px; margin: 0 auto; height: 61px; background-image: url(images/forward_title.png);}
.page2 .txt p { width: 630px; margin: 0 auto; line-height: 1.6316; font-size: 19px; text-align: center; color: #fff;}
.page2 .txt span { white-space: nowrap;}
.page2 img { position: absolute; left: 50%; top: 50%; margin-left: -773px; margin-top: -756px;}

.page3 .txt { position: absolute; left: 50%; top: 50%; width: 980px; margin-left: -490px; margin-top: 130px; font-size: 16px; line-height: 1.6875; text-align: center;}
.page3 .txt h2 { width: 980px; height: 114px; margin-bottom: 5px; text-indent: -9999px; background-image: url(images/smart_title.png);}
.page3 img{ position: absolute; left: 50%; top: 50%; margin-left: -773px; margin-top: -756px;}

.page4 img { position: absolute; left: 50%; top: 50%; margin-left: -773px; margin-top: -756px;}
.page4 .txt { position: absolute; left: 50%; top: 50%; width: 980px; height: 114px; margin-left: -191px; margin-top: -184px;}

.page4 p { width: 500px; margin-left: 220px; line-height: 1.6316; font-size: 19px;}

.page5 img { position: absolute; left: 50%; top: 50%; margin-left: -773px; margin-top: -756px;}
.page5 .txt { position: absolute; left: 50%; top: 0; width: 980px; margin-left: -490px; margin-top: 120px;}

.page5 p { width: 610px; margin-left: 220px; line-height: 1.6316; font-size: 19px; text-align: center;}

.responsive-height-lt790 .page .txt p { font-size: 16px; line-height: 1.6875;}

.responsive-height-lt790 .page1 .txt { margin-top: -100px;}

.responsive-height-lt790 .page2 .txt { bottom: 10%;}
.responsive-height-lt790 .page2 img {   margin-top: -399px;}

.responsive-height-lt790 .page3 .txt { margin-top: 0;}
.responsive-height-lt790 .page3 img {   margin-top: -399px;}

.responsive-height-lt790 .page4 img {  margin-top: -399px; }
.responsive-height-lt790 .page4 .txt { margin-left: -270px; margin-top: -135px;}

.responsive-height-lt790 .page5 img {margin-top: -399px;}
.responsive-height-lt790 .page5 .txt { margin-top: 30px;}
</style>
</head>

<body class="loading">
<div class="main" id="main">
   
	<div class="page page1">
		<div class="mainNav f-cb">
			<ul>
				<li><a href="http://www.cqu.edu.cn/" target="_blank"  rel='external'>CQU</a></li>
				<li><a href="login.jsp">登陆</a></li>
				<li><a href="introduce.jsp">网站介绍</a></li>
				<li><a href="use.jsp">使用说明</a></li>
				<li><a href="other_message.jsp">其他信息</a></li>
				<li><a href="support.jsp">技术支持</a></li>
			</ul>
			<div class="search"></div>
		</div>
		<div class="subNav f-cb">
			
			<ul>
				<li><a href="http://baike.baidu.com/link?url=tjK5SUyzhCNuEcT2vB0-liCIv24bM6klxW_XmLOzstfI0_pe_Ozoh_Qm26w9kBiurY4GssF42h4_EKMfFMqrMq" target="_blank" >深度学习</a></li>
				
				
			</ul>
		</div>
		<img  src="images/hua320.png" >
	</div>
	<div class="page page2">
		<div class="txt">
			<h2></h2>
			<p>卷积神经网络的建立<br>开启学习的过程<br>时间<br>会让她茁壮成长</p>
		</div>
		<img class="responsiveImg" date-small="images/img2.jpg" date-big="images/img2.jpg" src="images/img2.jpg" >
	</div>
	<div class="page page3">
		<div class="txt">
			
			<p class="txt">
			各种角色
			<br>
			普通用户    专家    管理员
			<br>
			应有尽有
			<br>
			赶紧来体验吧.
			
			
			
			<p>
		</div>
			<img class="responsiveImg" date-small="images/img3.jpg" date-big="images/img3.jpg" src="images/img3.jpg" >
	</div>
	<div class="page page4 ">
	 
		<div class="txt">
			
			<p>
			你还在为不认识树而苦恼么
			<br>
			你还在纠结这是什么树么
			<br>
			答案就在这里
			
			
			
			
			</p>
			
		</div>
		<img class="responsiveImg" date-small="images/img4.jpg" date-big="images/img2-b.png" src="images/img4.jpg" >
	</div>
	<div class="page page5">
		
			<div class="txt">
			
			<p>感谢你浏览到此处
			<br>
			赶紧登陆
			<br>
			体验不一样的服务
			<br>
			</p>
			
		</div>
		 
		<img class="responsiveImg" date-small="images/img2-s.png" date-big="images/img2-b.png" src="images/img2-b.png" >
	</div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/jquery.onepage-scroll.min.js"></script>
<script src="js/jQuery.resizeEnd.min.js"></script>
<script src="js/modernizr.custom.07427.js"></script>
<script>
$(function(){
	var $window = $(window);
	var $wh = $window.height();
	var $body = $('body');
	var $main = $('.main');
	var $responsiveImg = $('.responsiveImg');
	var $responsiveFallback = false;

	//页面加载时判断是否需要更换图片
	if($wh < 790){
		responsiveFn1();
	}

	//浏览器检测，判断是否为高级浏览器
	if(Modernizr.cssanimations){
		$responsiveFallback = false;
	} else {
		$responsiveFallback = true;
	}

	//onepage_scroll方法
	$main.onepage_scroll({
		sectionContainer: '.page',
		responsiveFallback: $responsiveFallback
	});

	//窗口改变大小切换不同的图片
	$window.resizeEnd({
		delay : 500
	}, function(){
		var $wh = $window.height();
		if($wh < 790){
			responsiveFn1();
		} else {
			responsiveFn2();
		}
	});

	function responsiveFn1(){
		$body.addClass('responsive-height-lt790')
		$responsiveImg.each(function(){
			var $dateSmall = $(this).attr('date-small');
			$(this).attr('src', $dateSmall);
		});
	}

	function responsiveFn2(){
		$body.removeClass('responsive-height-lt790')
		$responsiveImg.each(function(){
			var $dateBig = $(this).attr('date-big');
			$(this).attr('src', $dateBig);
		});
	}

	$('a').click(function(){
		return true;
	});
});

//页面加载时的 Loading 效果
$(window).load(function(){
	window.setTimeout(function(){
		$('body').removeClass('loading');
	}, 1000);
});
</script>
</body>
</html>