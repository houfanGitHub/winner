<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta name="viewport"
	content="width=device-width,maximum-scale=1.0,user-scalable=yes">
<title>绑卡管理-盈+</title>
<link href="/winner/files/common.css" rel="stylesheet">
<link href="/winner/files/jw.css" rel="stylesheet">
<link href="/winner/files/iconfont.css" rel="stylesheet">
<script src="/winner/files/hm.js"></script>
<script src="/winner/files/jquery.js"></script>
<script src="/winner/files/bootstrap.js"></script>
<script type="text/javascript" src="/winner/files/area.js"></script>
<script type="text/javascript" src="/winner/files/location.js"></script>
<style>
.clearfix:after {
	content: '\0020';
	display: block;
	height: 0;
	clear: both;
}

.clearfix {
	*zoom: 1;
}

#conBox .box .title {
	font-weight: bold;
	font-size: 20px;
	padding-top: 20px;
	padding-left: 30px;
	margin-bottom: 40px;
}

.myBankCards {
	
}

.myBankCards .card {
	float: left;
	width: 300px;
	border: 1px solid #eaeaea;
	padding: 5px;
	position: relative;
	margin-left: 35px;
	margin-bottom: 20px;
}

.myBankCards .card .banklogo {
	width: 150px;
	height: 45px;
}

.myBankCards .card img {
	width: 150px;
	margin-left: 10px;
}

.myBankCards .card .cardno {
	margin-top: 5px;
	margin-left: 15px;
}

.myBankCards .card .btns {
	position: absolute;
	right: 1px;
	bottom: 1px;
	display: none;
}

.myBankCards .card .btns a {
	background: #d7d7d7;
	color: #9b8888;
	text-decoration: none;
}
</style>

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

	<table height="160" class="peopleInfo" width="970" border="0"
		cellspacing="0" cellpadding="0">
		<tbody>
			<tr>
				<td align="left" valign="middle" class="info"><a
					href="/winner/itemweb/security">
						<div class="img">
							<img src="/winner/files/userPic.jpg">
						</div>
						<h2>${memberinfo.name }，<span>您好!</span></h2>
				</a>
					<div class="safe">
						账户安全&nbsp;&nbsp;<span class="scroll"><em style="width: 50%"></em></span>
					</div>
					<ul class="listIco iconfont">
						<li class=""><a href="#"></a><em></em></li>
						<li class="active"><a href="#"></a><em></em></li>
						<li class="active"><a href="#"></a><em></em></li>
						<li class=""><a href="#"></a><em></em></li>
					</ul></td>
				<td align="right"><a href="/winner/itemweb/webMemberLogout" 
					class="loginOut"><span class="iconfont"></span>安全退出</a></td>
			</tr>
		</tbody>
	</table>
	<div class="countBox">
     <ul>
        <li><h2>
        <c:if test="${empty memberinfo.memberAccounts }">0</c:if>
        <c:if test="${!empty memberinfo.memberAccounts }">
        <c:forEach items="${memberinfo.memberAccounts }" var="memberAccount">${memberAccount.useableBalance}</c:forEach>
        </c:if>
        </h2>
        <p>账户可用余额(元)<a href="javascript:;" class="iconfont"><span>账户可用余额</span><i></i></a></p></li>
         <li><h2>
          <c:if test="${empty memberinfo.memberAccounts }">0</c:if>
        <c:if test="${!empty memberinfo.memberAccounts }">
        <c:forEach items="${memberinfo.memberAccounts }" var="memberAccount">${memberAccount.useableBalance+memberAccount.investAmount+memberAccount.totalProfit}</c:forEach>
        </c:if>
         </h2><p>账户总资产(元)<a href="javascript:;" class="iconfont"><span>可用余额+投资金额+累计收益</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">
         <c:if test="${empty memberinfo.memberAccounts }">0</c:if>
        <c:if test="${!empty memberinfo.memberAccounts }">
        <c:forEach items="${memberinfo.memberAccounts }" var="memberAccount">${memberAccount.investAmount}</c:forEach>
        </c:if>
        </h2><p>投资金额(元)<a href="javascript:;" class="iconfont"><span>投资中资金</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">
		 <c:if test="${empty memberinfo.memberAccounts }">0</c:if>
        <c:if test="${!empty memberinfo.memberAccounts }">
        <c:forEach items="${memberinfo.memberAccounts }" var="memberAccount">${memberAccount.totalProfit}</c:forEach>
        </c:if>
        </h2><p>累计收益(元)<a href="javascript:;" class="iconfont"><span>累计收益</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">
        <c:if test="${empty memberinfo.memberAccounts }">0</c:if>
        <c:if test="${!empty memberinfo.memberAccounts }">
        <c:forEach items="${memberinfo.memberAccounts }" var="memberAccount">${memberAccount.imusealeBalance}</c:forEach>
        </c:if>
        </h2><p>冻结金额(元)<a href="javascript:;" class="iconfont"><span>提现冻结金额</span><i></i></a></p></li>
    </ul>
    <a href="/winner/itemweb/deposit" class="cz">充值</a>
    <a href="/winner/itemweb/drawMoney" class="tk">提款</a>
</div>
	<div class="proMain clearfix">
		<div class="adminLeft">
			<h2>我的投资</h2>
			<ul>
				<li><a id="member_center_menu_invests" href="/winner/itemweb/invests"><em
						class="iconfont red"></em>投资记录</a></li>
				<li><a id="member_center_menu_profit_record" href="/winner/itemweb/myself"><em
						class="iconfont red"></em>收益记录</a></li>
				<li><a id="member_center_menu_deposit_record" href="/winner/itemweb/rechargeRecords"><em
						class="iconfont red"></em>充值记录</a></li>
				<li><a id="member_center_menu_withdraw_record" href="/winner/itemweb/withdraw"><em
						class="iconfont red"></em>提款记录</a></li>
				<li><a id="member_center_menu_bbinInfo_record" href="/winner/itemweb/experienceGold"><em
						class="iconfont red"></em>体验金记录</a></li>
			</ul>
			<h2>我的账户</h2>
			<ul>
				<li><a id="member_center_menu_deposit"
					href="/winner/itemweb/deposit"  class="select"><em class="iconfont"></em>账户充值</a></li>
<!-- 				<li><a id="member_center_menu_security"  -->
<!-- 				href="/winner/itemweb/security"><em class="iconfont"></em>安全信息</a></li> -->
				<li><a id="member_center_menu_withdraw" 
				href="/winner/itemweb/drawMoney"><em class="iconfont"></em>我要提款</a></li>
			</ul>
		</div>

		<c:if test="${empty memberinfo.memberBankcards}">
			<div class="admin-right">
				<div class="tbConBox">
					<div class="tab">
						<a class="select" href="javascript:;">银行卡管理</a>
					</div>
					<div id="conBox">
						<div class="box" style="display: block">
							<div class="myBankCards clearfix">
								<div class="title">绑定银行卡</div>
								<table class="txTable" width="100%" border="0" cellspacing="0"
									cellpadding="0">
									<tbody>
										<tr>
											<td width="140" align="right">身份证：</td>
											<td><input type="text" class="tytxt" id="identity"
												name="identity" placeholder="身份证"></td>
											<td style="color: #ff6a00">一个身份证只能绑定一个帐号</td>
										</tr>

										<tr>
											<td align="right">开户银行：</td>
											<td colspan="2"><select class="form-control" id="type"
												name="type">
													<option value="工商银行">工商银行</option>
													<option value="光大银行">光大银行</option>
													<option value="广发银行">广发银行</option>
													<option value="华夏银行">华夏银行</option>
													<option value="建设银行">建设银行</option>
													<option value="交通银行">交通银行</option>
													<option value="民生银行">民生银行</option>
													<option value="农业银行">农业银行</option>
													<option value="浦发银行">浦发银行</option>
													<option value="兴业银行">兴业银行</option>
													<option value="邮政储蓄">邮政储蓄</option>
													<option value="招商银行">招商银行</option>
													<option value="中国银行">中国银行</option>
													<option value="中信银行">中信银行</option>
											</select></td>
										</tr>

										<tr>
											<td align="right">开户地：</td>
											<td colspan="2"><div style="float: left;">
													<select id="loc_province" style="width: 80px;"
														selectedindex="0"><option value="">省份</option>
														<option value="1">北京市</option>
														<option value="22">天津市</option>
														<option value="44">上海市</option>
														<option value="66">重庆市</option>
														<option value="108">河北省</option>
														<option value="406">山西省</option>
														<option value="622">内蒙古</option>
														<option value="804">辽宁省</option>
														<option value="945">吉林省</option>
														<option value="1036">黑龙江省</option>
														<option value="1226">江苏省</option>
														<option value="1371">浙江省</option>
														<option value="1500">安徽省</option>
														<option value="1679">福建省</option>
														<option value="1812">江西省</option>
														<option value="1992">山东省</option>
														<option value="2197">河南省</option>
														<option value="2456">湖北省</option>
														<option value="2613">湖南省</option>
														<option value="2822">广东省</option>
														<option value="3015">广西</option>
														<option value="3201">海南省</option>
														<option value="3235">四川省</option>
														<option value="3561">贵州省</option>
														<option value="3728">云南省</option>
														<option value="3983">西藏</option>
														<option value="4136">陕西省</option>
														<option value="4334">甘肃省</option>
														<option value="4499">青海省</option>
														<option value="4588">宁夏</option>
														<option value="4624">新疆</option>
														<option value="4802">香港</option>
														<option value="4822">澳门</option>
														<option value="4825">台湾省</option></select> <select id="loc_city"
														style="width: 100px;"><option value="">地级市</option></select>
													<select id="loc_town" style="width: 120px;"><option
															value="">市、县、区</option></select> <input type="hidden"
														name="location_id" id="cardaddress" name="cardaddress">
												</div></td>
											<td></td>
										</tr>
										<tr>
											<td align="right">开户支行：</td>
											<td><div style="float: left;">
													<input type="text" class="tytxt" name="cardaddress1"
														id="cardaddress1" placeholder="开户支行">
												</div></td>
											<td></td>
										</tr>
										<tr>
											<td align="right">银行卡号：</td>
											<td><input type="text" class="tytxt" id="bankCardNum"
												name="cardNo" placeholder="银行卡号"></td>
										</tr>
										<tr>
											<td align="right">确认卡号：</td>
											<td><input type="text" class="tytxt"
												id="bankCardNumConfirm" placeholder="确认卡号"></td>
											<td></td>
										</tr>
										<tr>
											<td>&nbsp;</td>
											<td><button class="tybutton" id="buttonsubmit">保存</button></td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${!empty memberinfo.memberBankcards }">
			<div class="admin-right">
				<div class="tbConBox">
					<div class="tab">
						<a class="select" href="javascript:;">网银充值</a>
					</div>
					<div id="conBox">
						<div class="box" style="display: block">
							<div class="picTab">
								<a class="select" href="javascript:"> <img height="42px"
									src="/winner/files/fuiou.png">
									<p>通过富友支付平台进行网银充值</p>
								</a>
							</div>
							<div class="formBox">
								<div class="czbox">
									<form id="depositForm" action="/winner/itemweb/accountRecharge" method="POST" target="_blank">
										<div>
											充值银行卡：<strong> 
											<c:forEach items="${memberinfo.memberBankcards }" var="memberBankcard">${memberBankcard.type }-${memberBankcard.cardNo }</c:forEach>
											</strong>
										</div>
										<br>
										<div>
											充值金额：<input class="tytxt" id="fee" name="fee" type="number">
										</div>
										<button class="tybutton" id="btn_go_pay" type="submit">前往充值</button>
									</form>
								</div>
							</div>
							<div class="txtCon">
								<p style="display: block;">上海富友金融网络技术有限公司自2008年创立至今，已发展成为一家大型综合性金融支付服务集团公司——注册资本2.0007亿元，实收资本3.8亿元，下设6家全资子公司，同时拥有6张支付及金融服务牌照，并在全国设立了35家分公司。富友以“打造便利金融生活”为愿景，以“专业——分享——价值”为理念，以“专业创新，差异化经营”为手段，立志成为网络金融和网络生活服务的领先者——用便利金融，让生活更美好。
									2011年获得中国人民银行颁发的银行卡收单和互联网支付牌照，同时获得人民银行颁发的预付卡发行与受理牌照。2013年富友金融获得中国银联“收单外包机构注册认证”，在全国范围建立银行卡收单服务网络。2014年成为“上海市网络信贷服务业企业联盟”成员单位，在目前国家已颁布牌照的269家第三方支付公司中，获此殊荣的仅有4家公司</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
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
						<li><a href="http://pro.ying158.com/account/deposit"
							target="_blank" rel="nofollow"> <em
								class="ico_sns ico_sinawb"></em> <span class="txt">新浪微博</span>
						</a></li>
						<li><a href="http://pro.ying158.com/account/deposit"
							target="_blank" rel="nofollow"> <em class="ico_sns ico_txwb"></em>
								<span class="txt">腾讯微博</span>
						</a></li>
					</ul>

					<div class="contactUs">
						<div class="title"
							style="padding-left: 10px; font-weight: normal; font-size: 20px; color: #ccc;">
							联系我们</div>
						<div class="contactInfo" style="padding-left: 30px;">
							<a
								style="display: inline-block; height: 50px; width: 50px; text-align: center;"
								target="_blank"
								href="http://wpa.qq.com/msgrd?v=3&amp;uin=508886246&amp;site=qq&amp;menu=yes"><img
								src="/winner/files/qqIcon.png"></a> <span class="kefu">在线客服</span><span
								class="time">08:30 - 21:00</span>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>
	<div class="foot3">
		<div class="container">
			<div class="row">
				Copyright © 2010 - 2015 www.ying158.com All Rights Reserverd
				杭州吉威投资管理有限公司 版权所有<br> 浙ICP备14030807号-3 杭州市江干区钱江新城迪凯银座19F
				4000-999-158
			</div>
		</div>
	</div>

	<!-- 绑定银行卡 -->
	<script type="text/javascript">
		var baseContext = "";
		$("#buttonsubmit").click(
				function() {
					var identity = $("#identity").val();
					var bankCard = $("#bankCardNum").val();
					var bankCardConfirm = $("#bankCardNumConfirm").val();
					var cardaddress1 = $("#cardaddress1").val();
					var type = $("#type").val();
					var loc_province = $("#loc_province").find(
							"option:selected").text();
					var loc_city = $("#loc_city").find("option:selected")
							.text();
					var loc_town = $("#loc_town").find("option:selected")
							.text();
					var cardaddress = loc_province + "-" + loc_city + "-"
							+ loc_town + "-" + cardaddress1;

					if (identity == "" || identity == undefined) {
						$("#withdrawError").html("请输入身份证");
						$("#withdrawErrorModal").modal();
						return;
					}
					if (!isIdentityNumber(identity)) {
						$("#withdrawError").html("请输入正确的身份证号码");
						$("#withdrawErrorModal").modal();
						return;
					}
					if (loc_province == "省份") {
						$("#withdrawError").html("请选择省份");
						$("#withdrawErrorModal").modal();
						return;
					}
					if (loc_city == "地级市") {
						$("#withdrawError").html("请选择地级市");
						$("#withdrawErrorModal").modal();
						return;
					}
					if (loc_town == "市、县、区") {
						$("#withdrawError").html("请选择市、县、区");
						$("#withdrawErrorModal").modal();
						return;
					}
					if (cardaddress1 == "") {
						$("#withdrawError").html("请输入开户支行");
						$("#withdrawErrorModal").modal();
						return;
					}

					if (bankCard == "" || bankCard == undefined) {
						$("#withdrawError").html("请输入银行卡号");
						$("#withdrawErrorModal").modal();
						return;
					}

					if (bankCardConfirm == "" || bankCardConfirm == undefined) {
						$("#withdrawError").html("请再次输入银行卡号");
						$("#withdrawErrorModal").modal();
						return;
					}
					if (bankCardConfirm != bankCard) {
						$("#withdrawError").html("两次输入的银行卡号不一致");
						$("#withdrawErrorModal").modal();
						return;
					}

					$("#buttonsubmit").addClass("disabled");
					$.post("/winner/itemweb/TiedCard", {
						cardNo : bankCard,
						cardaddress : cardaddress,
						type : type
					}, function(falg) {
						if (falg) {
							alert("添加成功");
							$("#depositId").click();
						} else {
							alert("添加失败");
						}
					});
				});
	</script>
</body>
</html>
