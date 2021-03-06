<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<meta name="renderer" content="webkit">
<meta name="viewport"
	content="width=device-width,maximum-scale=1.0,user-scalable=yes">
<meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
<meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
<title>产品中心- 盈+</title>

<meta name="keywords"
	content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50">
<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。">
<link href="http://pro.ying158.com/resources/web/images/icon.ico"
	type="image/x-icon" rel="shortcut icon">

<link href="/winner/files/iconfont.css" rel="stylesheet" type="text/css">
<link href="/winner/files/common.css" rel="stylesheet">
<link href="/winner/files/jw.css" rel="stylesheet">

<script src="/winner/files/hm.js"></script>
<script src="/winner/files/jquery.js"></script>
<script type="text/javascript" src="/winner/files/layer.js"></script>
<link rel="stylesheet" href="/winner/files/layer.css"
	id="layui_layer_skinlayercss">
<script src="/winner/files/echarts.js"></script>
<script data-require-id="echarts/chart/pie" src="/winner/files/pie.js"
	async=""></script>
</head>
<body>

	<div style="width: 1002px; height: 94px; margin: 0 auto;">
		<iframe src="/winner/files/iframetop.jsp" scrolling="no"
			frameborder="0" width="1002" height="94"></iframe>
	</div>
	<div class="jwNav">
		<div class="container">
			<div class="row">
				<ul class="topNav">
					<li><a class="item first" href="/winner/index.jsp"> 首页 </a></li>
					<li><a class="item" href="/winner/itemweb/experience">
							网上体验中心 </a></li>
					<li><a class="item" href="/winner/itemweb/products"> 产品中心
					</a></li>
					<li><a class="item" href="/winner/itemweb/news"> 新闻中心 </a></li>
					<li><a class="item" href="/winner/itemweb/download"> 下载中心
					</a></li>
					<li><a class="item " href="/winner/itemweb/business">
							盈+商学院 </a></li>
					<li><a class="item" href="/winner/itemweb/research"> 投研中心
					</a></li>
					<li><a class="item last" href="/winner/itemweb/myself">
							我的加法库 </a></li>



				</ul>
			</div>
		</div>
	</div>


<meta name="keywords" content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50">
<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。">

	<div>
		<img src="/winner/files/yjhf.png">
	</div>
	<script type="text/javascript">
$("#f1").click(function(){
	$("#f1").submit();
});	
	function setValue3(m){
			alert(m);
			$("#status").val(m);
	
     document.forms[0].action="/winner/itemweb/product";
    document.forms[0].submit(); 
	}
		
		function setValue1(rate,flag){
			$("#yearRate").val(rate);
			$("#delflag").val(flag);
			document.forms[0].action="/winner/itemweb/product";
			document.forms[0].submit();
		}
		function setValue2(day1,day2){
			$("#raiseStart").val(day1);
			$("#raiseEnd").val(day2);
			document.forms[0].action="/winner/itemweb/product";
			document.forms[0].submit();
		}


</script>
	   <form action="" method="post" id="f1" name="f1">
			<input type="hidden" name="yearRate" id="yearRate" value="${yearRate }"/>
			<input type="hidden" name="type" id="type" value="${type}"   />
			<input type="hidden" name="status" id="status" valus="${status }">
			<input type="hidden" name="delflag" id="delflag" value="${delflag}"/>
			<input type="hidden" name="raiseStart" id="raiseStart" value="${raiseStart}">
			<input type="hidden" name="raiseEnd" id="raiseEnd" value="${raiseEnd }">
  </form>
	<div class="proMain">
		<div class="hwpzNav">
			<ul>
				<li class="first"><a class="active"
					href="javascript:function(0);">固收类理财</a></li>
			</ul>
		</div>
		<div class="sdShaix">
			<ul>
				<li class="first">年化收益：</li>
				<li><a
					href="/winner/itemweb/queryType?yearRate=-1"
					id="21" <c:if test="${ empty yearRate}"> class="select"  </c:if>>全部</a></li>
				<li><a
					href="/winner/itemweb/queryType?yearRate=6"
					id="22" <c:if test="${yearRate==6}">class="select" </c:if>>6.0%</a></li>
				<li><a
					href="/winner/itemweb/queryType?yearRate=7"
					id="23" <c:if test="${yearRate==7}">class="select" </c:if>>7.0%</a></li>
				<li><a
					href="/winner/itemweb/queryType?yearRate=8"
					id="24" <c:if test="${yearRate==8}">class="select" </c:if>>8.0%</a></li>
				<li><a
					href="/winner/itemweb/queryType?yearRate=9"
					id="25" <c:if test="${yearRrate==9}">class="select" </c:if>>9.0%</a></li>
				<li><a
					href="/winner/itemweb/queryType?yearRate=10"
					id="26" <c:if test="${yearRrate==10}">class="select" </c:if>>10.0%以上</a></li>
			</ul>
			<ul>
				<li class="first">项目期限：</li>
				<li><a
					href="/winner/itemweb/queryType?days=-1" id="31"
					<c:if test="${empty days}">class="select" </c:if>>全部</a></li>
				<li><a
					href="/winner/itemweb/queryType?days=1"
					<c:if test="${days==1}">class="select" </c:if> id="32">15天以下</a></li>
				<li><a
					href="/winner/itemweb/queryType?days=2" id="33"
					<c:if test="${days==2}">class="select" </c:if>>15-30天</a></li>
				<li><a
					href="/winner/itemweb/queryType?days=3" id="34"
					<c:if test="${days==3}">class="select" </c:if>>30-180天</a></li>
				<li><a
					href="/winner/itemweb/queryType?days=4" id="35"
					<c:if test="${days==4}">class="select" </c:if>>180-365天</a></li>
				<li><a
					href="/winner/itemweb/queryType?days=5" id="36"
					<c:if test="${days==5}">class="select" </c:if>>一年以上</a></li>
			</ul>
			<ul>
				<li class="first">标的状态：</li>
				<li><a
					href="/winner/itemweb/queryType?status=-1"
					id="41" <c:if test="${ empty status}">class="select" </c:if>>全部</a></li>
				<li><a
					href="/winner/itemweb/queryType?status=0" id="42"
					<c:if test="${status==0}">class="select" </c:if>>投标中</a></li>
				<li><a
					href="/winner/itemweb/queryType?status=1" id="43"
					<c:if test="${status==1}">class="select" </c:if>>还款中</a></li>
				<li><a
					href="/winner/itemweb/queryType?status=2" id="44"
					<c:if test="${status==2}">class="select" </c:if>>已完成</a></li>
			</ul>
		</div>

		<meta name="keywords"
			content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50">
		<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。">

		<div class="ajaxContainer">

			<!-- 异步内容开始 -->
			<c:forEach items="${subject}" var="s">
				<ul class="tbList">
					<li class="first"><span class="ico zq"></span>
						<h2>
							<em>投</em>${s.name }</h2>+ <i></i></li>
					<li class="second">
						<div class="txt1">
							<h2>${s.yearRate }<span style="font-size: 18px;">+1.0%</span>
							</h2>
							<p>年化收益</p>
						</div>
						<div class="txt2">
							<h2>￥${s.floorAmount }</h2>
							<p>起购金额(元)</p>
						</div>
						<div class="txt2">
							<h2>${s.period }天</h2>
							<p>投资期限</p>
						</div>
					</li>
					<li class="three"><a href="#1">企业担保</a><span>中国人保财险承保</span>
						<p>
							计息日期：当天投资，立即计息<br>已购人数：${s.bought }人
						</p></li>
					<li class="four"></li>
					<li class="five"><a class="abtn"
						href="/winner/itemweb/buyproduct?id=${s.id }">购买</a>
					</li>
				</ul>
			</c:forEach>
			<!-- 异步内容结束 -->


			<div class="llpage">
				<div class="in">

					<a class="prev_page">上页</a> <a class="now">1</a> <a
						class="next_page" rel="next">下页</a>
				</div>
			</div>
		</div>
	</div>


	<div class="security">
		<div class="item">
			<img src="/winner/files/indexSecurity1.png">
			<div class="detail">
				资金银行监管
				<div class="desc">平台资金由第三方银行监管</div>
			</div>
		</div>
		<div class="item">
			<img src="/winner/files/indexSecurity2.png">
			<div class="detail">
				交易证监会监管
				<div class="desc">投资交易由证监会监管</div>
			</div>
		</div>
		<div class="item">
			<img src="/winner/files/indexSecurity3.png">
			<div class="detail">
				风控盈+监管
				<div class="desc">盈+全自动风控系统为您保驾护航</div>
			</div>
		</div>
	</div>
	<div class="foot">
		<div class="container">
			<div class="row">
				<div class="hzhb_box">
					<div class="title"
						style="padding-left: 10px; font-weight: normal; font-size: 20px; color: #ccc;">
						主要合作机构</div>
					<div class="hzhb_item">
						<a target="_blank" href="http://www.picc.com/"><img
							src="/winner/files/1.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank" href="http://www.fuioupay.com/"><img
							src="/winner/files/2.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank" href="http://www.nanhua.net/"><img
							src="/winner/files/3.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank"
							href="http://www.zttrust.com.cn/stations/526623d20a/index.php/5268e6b50a"><img
							src="/winner/files/4.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank"
							href="http://sc.hkex.com.hk/TuniS/www.hkex.com.hk/eng/index.htm/"><img
							src="/winner/files/5.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank" href="http://www.cmegroup.com/cn-s/"><img
							src="/winner/files/6.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank"
							href="http://www.sgx.com/wps/portal/sgxweb_ch/home/!ut/p/a1/04_Sj9CPykssy0xPLMnMz0vMAfGjzOKNHB1NPAycDSz9wwzMDTxD_Z2Cg8PCDANdjYEKIoEKDHAARwNC-sP1o8BK8JhQkBthkO6oqAgAzDYPQQ!!/dl5/d5/L2dBISEvZ0FBIS9nQSEh/"><img
							src="/winner/files/7.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank" href="http://www.neeq.com.cn/index/"><img
							src="/winner/files/8.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank" href="http://www.cmbchina.com/"><img
							src="/winner/files/9.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank"
							href="http://www.bankcomm.com/BankCommSite/default.shtml"><img
							src="/winner/files/10.jpg"></a>
					</div>

					<div class="hzhb_item">
						<a target="_blank" href="http://www.ccb.com/cn/home/index.html"><img
							src="/winner/files/11.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank" href="http://www.icbc.com.cn/icbc/"><img
							src="/winner/files/12.jpg"></a>
					</div>
				</div>

				<div class="ft_item ft_item_sns">
					<div class="ft_item_tit">关注我们</div>
					<ul style="margin-bottom: 0px;" class="ft_sns_list clearfix">
						<li>
							<div class="wx_tips j_tips">
								<div class="tips_hd">
									<em class="ico_sns ico_weixin"></em> <span class="txt">微信公众号</span>
								</div>
								<div class="tips_bd">
									<em class="arrow"></em> <img src="/winner/files/yj.jpg"
										alt="微信公共平台">
								</div>
							</div>
						</li>
						<li><a target="_blank" rel="nofollow"> <em
								class="ico_sns ico_sinawb"></em> <span class="txt">新浪微博</span>
						</a></li>
						<li><a target="_blank" rel="nofollow"> <em
								class="ico_sns ico_txwb"></em> <span class="txt">腾讯微博</span>
						</a></li>
					</ul>

					<div class="contactUs">
						<div class="title"
							style="padding-left: 10px; font-weight: normal; font-size: 20px; color: #ccc;">
							联系我们</div>
						<div class="contactInfo" style="padding-left: 30px;">
							<a
								style="display: inline-block; height: 50px; width: 50px; text-align: center;"
								target="_blank"><img src="/winner/files/qqIcon.png"></a> <span
								class="kefu">在线客服</span><span class="time">08:30 - 21:00</span>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>
	<div class="foot3">
		<div class="container">
			<div class="row">
				Copyright © 2010 - 2015 www..com All Rights Reserverd 襄阳市赢+理财股份有限公司 版权所有<br>
				鄂ICP备14030807号-3 襄阳市江干区钱江新城迪凯银座19F 4000-999-158
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('#11').addClass("select");
			$('#21').addClass("select");
			$('#31').addClass("select");
			$('#41').addClass("select");
		});
	</script>

</body>
</html>