<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
<meta name="keywords" content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50">
<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。">
<link href="http://pro.ying158.com/resources/web/images/icon.ico" type="image/x-icon" rel="shortcut icon">


	
	<meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
	<meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
	<meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
	<title>安全信息-会员中心-盈+</title>
	<link href="/winner/files/common.css" rel="stylesheet">
	<link href="/winner/files/jw.css" rel="stylesheet">
    <link href="/winner/files/iconfont.css" rel="stylesheet">
    <script src="/winner/files/hm.js"></script><script src="/winner/files/jquery.js"></script>
    <script src="/winner/files/bootstrap.js"></script>
    <script>
	$(function(){
		$(".picTab a").click(function(){
			if(!$(this).hasClass("select")){
				var num=$(this).index();
				$(this).addClass("select").siblings().removeClass("select");
				$(".txtCon p").eq(num).show().siblings().hide();
			}
		})
		$(".tbConBox .tab a").click(function(){
			if(!$(this).hasClass("select")){
				var num=$(this).index();
				$(this).addClass("select").siblings().removeClass("select");
				$("#conBox .box").eq(num).show().siblings().hide();
			}
		})
	})	
    </script>
</head>
<body>

<div class="logo container">
    <div class="row">
        <div class="logoImg">
            <a href="http://www.ying158.com/home"><img src="/winner/files/logo2.png" onmouseover="this.src = &#39;/resources/web/images/logo1.png&#39;" onmouseout="this.src = &#39;/resources/web/images/logo2.png&#39;"></a>
        </div>
        <div class="telInfo">
            <img src="/winner/files/400Icon.png" onmousemove="this.src = &#39;/resources/web/images/400IconActive.png&#39;" onmouseout="	this.src = &#39;/resources/web/images/400Icon.png&#39;">
            <div class="detail">

                    	<div style="font-size:16px;float:right;margin-top:5px;color:#917739;">  欢迎userName,<a href="http://pro.ying158.com/account/touZiList">[会员中心]</a>,<a href="http://pro.ying158.com/web/logout">[退出]</a></div>
                <br>4000-999-158
            </div>
        </div>
    </div>
</div>
<div class="jwNav">
    <div class="container">
        <div class="row">
            <ul class="topNav">
                <li>
                    <a class="item first" href="/winner/index.jsp">
                        首页
                    </a>
                </li>
                <li>
                    <a class="item" href="/winner/itemweb/experience">
                        网上体验中心
                    </a>
                </li>
                <li class="item">
                    <a class="item" href="/winner/itemweb/products">
                        产品中心
                    </a>
                </li>
                <li>
                    <a class="item" href="/winner/itemweb/news">
                        新闻中心
                    </a>
                </li>
                <li>
                    <a class="item" href="/winner/itemweb/download">
                      下载中心
                    </a>
                </li>
                <li>
                    <a class="item " href="/winner/itemweb/business">
                        盈+商学院
                    </a>
                </li>
                <li>
                    <a class="item" href="/winner/itemweb/research">
                        投研中心
                    </a>
                </li>
                <li>
                    <a class="item last" href="/winner/itemweb/myself">
                        我的加法库
                    </a>
                </li>



            </ul>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        function showIn(url){
            var info="<div class='mydig'><div class='bg'></div><div class='imgbox'><a href="+url+"></a></div></div>";
            $('body').append(info);
        }
            if (1!=null&&1==0){
                showIn("/account/bbinInfo/getBbinInfo");
            }

    });

</script><table height="160" class="peopleInfo" width="970" border="0" cellspacing="0" cellpadding="0">
    <tbody><tr>
        <td align="left" valign="middle" class="info">
            <a href="/winner/itemweb/security">
                <div class="img"><img src="/winner/files/userPic.jpg"></div>
                <h2>${memberinfo.name }，<span>您好!</span></h2>
            </a>
            <div class="safe">账户安全&nbsp;&nbsp;<span class="scroll"><em style="width:75%"></em></span></div>
            <ul class="listIco iconfont">
                <li class="active"><a href="http://pro.ying158.com/account/security#1"></a><em></em></li>
                <li class="active"><a href="http://pro.ying158.com/account/security#1"></a><em></em></li>
                <!-- <li class=""><a href="#1">&#xe61f;</a><em>&#xe61b;</em></li> -->
                <li class="active"><a href="http://pro.ying158.com/account/security#1"></a><em></em></li>                                
                <li class=""><a href="http://pro.ying158.com/account/security#1"></a><em></em></li>
            </ul>
        </td>
        <td align="right">
            <a href="/winner/itemweb/webMemberLogout"  class="loginOut"><span class="iconfont"></span>安全退出</a>
        </td>
    </tr>
</tbody></table>
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
</div>    <div class="proMain clearfix">
<div class="adminLeft">
     <h2>我的投资</h2>
    <ul>
        <li><a id="member_center_menu_invests" 
        href="/winner/itemweb/invests"><em class="iconfont red"></em>投资记录</a></li>
        <li><a id="member_center_menu_profit_record"
        href="/winner/itemweb/myself"><em class="iconfont red"></em>收益记录</a></li>
        <li><a id="member_center_menu_deposit_record"
         href="/winner/itemweb/rechargeRecords"><em class="iconfont red"></em>充值记录</a></li>
        <li><a id="member_center_menu_withdraw_record"
         href="/winner/itemweb/withdraw"><em class="iconfont red"></em>提款记录</a></li>
        <li><a id="member_center_menu_bbinInfo_record"
         href="/winner/itemweb/experienceGold"><em class="iconfont red"></em>体验金记录</a></li>
    </ul>
   <h2>我的账户</h2>
			<ul>
				<li><a id="member_center_menu_deposit"
					href="/winner/itemweb/deposit"><em class="iconfont"></em>账户充值</a></li>
<!-- 				<li><a id="member_center_menu_security"  -->
<!-- 				href="/winner/itemweb/security"  class="select"><em class="iconfont"></em>安全信息</a></li> -->
				<li><a id="member_center_menu_withdraw" 
				href="/winner/itemweb/drawMoney"><em class="iconfont"></em>我要提款</a></li>
			</ul>
</div>
<script>
  var menu_item="";
 $("#"+menu_item).addClass("select");
</script>

        <div class="admin-right">
        	<div class="tbConBox">
                <div class="tab">
                    <a class="select" href="javascript:;">安全中心</a>
                </div>
                <div id="conBox">
                    <div class="box" style="display:block">
                    	
                            &nbsp;
	                            					&nbsp;
&nbsp;  							                         
                          
								&nbsp;
														&nbsp;
&nbsp;
							
                             &nbsp;
	                            <table class="safeTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tbody><tr><td class="first"><span class="iconfont active"><a href="http://pro.ying158.com/account/security#1"></a><em></em></span></td>
	                            <td><p style="color:#ff503f">实名认证</p></td>
	                            <td>423***013</td>
	                            <td><p style="color:#888">保障账户安全，只有完成实名认证才能充值提款</p></td>
	                            <td>认证完成</td></tr>
							<tr><td class="first"><span class="iconfont active"><a href="http://pro.ying158.com/account/security#1"></a><em></em></span></td>
									<td><p style="color:#ff503f">绑卡认证</p></td>
									<td>已绑定</td>
									<td><p style="color:#888">保障账户安全，只有完成绑卡认证才能充值提款</p></td>
									<td><a href="http://pro.ying158.com/account/security/memberBankcardView" class="renzheng">查看</a></td></tr>
                          <tr>
                            <td class="first"><span class="iconfont active"><a href="http://pro.ying158.com/account/security#1"></a><em></em></span></td>
                            <td><p style="color:#ff503f">绑定手机</p></td>
                            <td>1582702****</td>
                            <td><p style="color:#888">手机号码是您在盈+金融的重要身份凭证</p></td>
                            <td>绑定完成</td>
                            <!--<td><a onclick="$('#changeTelModal').modal(); return false;" href="javascript:;" class="renzheng">修改</a></td>-->
                          </tr>
<!--                           <tr>
                            <td class="first"><span class="iconfont active"><a href="#1">&#xe61f;</a><em>&#xe61b;</em></span></td>
                            <td><p style="color:#ff503f">绑定邮箱</p></td>
                            <td>未设置</td>
                            <td><p style="color:#888">绑定邮箱后，可作登录时使用</p></td>
                            <td><a onclick="$('#setEmailModal').modal(); return false;" href="javascript:;" class="renzheng">设置</a></td>
                          </tr> -->
                          <tr>
                            <td class="first"><span class="iconfont active"><a href="http://pro.ying158.com/account/security#1"></a><em></em></span></td>
                            <td><p style="color:#ff503f">登录密码</p></td>
                            <td>已设置</td>
                            <td><p style="color:#888">登录盈+金融网站时需要输入的密码</p></td>
                            <td><a onclick="$(&#39;#changePWModal&#39;).modal(); return false;" href="javascript:;" class="renzheng">修改</a></td>
                          </tr>
                          <tr><td class="first"><span class="iconfont"><a href="http://pro.ying158.com/account/security#1"></a><em></em></span></td>
	                            <td><p style="color:#ff503f">提款密码</p></td>
	                            <td>未设置</td>
	                            <td><p style="color:#888">保障资金安全，提款需要设置提款密码</p></td>
	                            <td><a onclick="$(&#39;#setWithdrawPWModel&#39;).modal(); return false;" href="javascript:;" class="renzheng">设置</a></td>								
                          </tr>
                        </tbody></table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="security">
        <div class="item">
            <img src="/winner/files/indexSecurity1.png">
            <div class="detail">
                资金银行监管
                <div class="desc">
                    平台资金由第三方银行监管
                </div>
            </div>
        </div>
        <div class="item">
            <img src="/winner/files/indexSecurity2.png">
            <div class="detail">
                交易证监会监管
                <div class="desc">
                    投资交易由证监会监管
                </div>
            </div>
        </div>
        <div class="item">
            <img src="/winner/files/indexSecurity3.png">
            <div class="detail">
                风控盈+监管
                <div class="desc">
                    盈+全自动风控系统为您保驾护航
                </div>
            </div>
        </div>
    </div>
	<div class="foot">
		<div class="container">
            <div class="row">
                <div class="hzhb_box">
                    <div class="title" style=" padding-left:10px; font-weight:normal; font-size:20px; color:#ccc;">
                        主要合作机构
                    </div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.picc.com/"><img onmouseover="this.src = &#39;/resources/web/images/hzhb/1_on.png&#39;" onmouseout="this.src = &#39;/resources/web/images/hzhb/1.jpg&#39;" src="/winner/files/1.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.fuioupay.com/"><img onmouseover="this.src = &#39;/resources/web/images/hzhb/2_on.png&#39;" onmouseout="    this.src = &#39;/resources/web/images/hzhb/2.jpg&#39;" src="/winner/files/2.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.nanhua.net/"><img onmouseover="this.src = &#39;/resources/web/images/hzhb/3_on.png&#39;" onmouseout="    this.src = &#39;/resources/web/images/hzhb/3.jpg&#39;" src="/winner/files/3.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.zttrust.com.cn/stations/526623d20a/index.php/5268e6b50a"><img onmouseover="this.src = &#39;/resources/web/images/hzhb/4_on.png&#39;" onmouseout="    this.src = &#39;/resources/web/images/hzhb/4.jpg&#39;" src="/winner/files/4.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://sc.hkex.com.hk/TuniS/www.hkex.com.hk/eng/index.htm/"><img onmouseover="this.src = &#39;/resources/web/images/hzhb/5_on.png&#39;" onmouseout="    this.src = &#39;/resources/web/images/hzhb/5.jpg&#39;" src="/winner/files/5.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.cmegroup.com/cn-s/"><img onmouseover="this.src = &#39;/resources/web/images/hzhb/6_on.png&#39;" onmouseout="    this.src = &#39;/resources/web/images/hzhb/6.jpg&#39;" src="/winner/files/6.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.sgx.com/wps/portal/sgxweb_ch/home/!ut/p/a1/04_Sj9CPykssy0xPLMnMz0vMAfGjzOKNHB1NPAycDSz9wwzMDTxD_Z2Cg8PCDANdjYEKIoEKDHAARwNC-sP1o8BK8JhQkBthkO6oqAgAzDYPQQ!!/dl5/d5/L2dBISEvZ0FBIS9nQSEh/"><img onmouseover="this.src = &#39;/resources/web/images/hzhb/7_on.png&#39;" onmouseout="    this.src = &#39;/resources/web/images/hzhb/7.jpg&#39;" src="/winner/files/7.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.neeq.com.cn/index/"><img onmouseover="this.src = &#39;/resources/web/images/hzhb/8_on.png&#39;" onmouseout="    this.src = &#39;/resources/web/images/hzhb/8.jpg&#39;" src="/winner/files/8.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.cmbchina.com/"><img onmouseover="this.src = &#39;/resources/web/images/hzhb/9_on.png&#39;" onmouseout="    this.src = &#39;/resources/web/images/hzhb/9.jpg&#39;" src="/winner/files/9.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.bankcomm.com/BankCommSite/default.shtml"><img onmouseover="this.src = &#39;/resources/web/images/hzhb/10_on.png&#39;" onmouseout="this.src = &#39;/resources/web/images/hzhb/10.jpg&#39;" src="/winner/files/10.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.ccb.com/cn/home/index.html"><img onmouseover="this.src = &#39;/resources/web/images/hzhb/11_on.png&#39;" onmouseout="    this.src = &#39;/resources/web/images/hzhb/11.jpg&#39;" src="/winner/files/11.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.icbc.com.cn/icbc/"><img onmouseover="this.src = &#39;/resources/web/images/hzhb/12_on.png&#39;" onmouseout="    this.src = &#39;/resources/web/images/hzhb/12.jpg&#39;" src="/winner/files/12.jpg"></a></div>
                </div>

                <div class="ft_item ft_item_sns">
                    <div class="ft_item_tit">关注我们</div>
                    <ul style=" margin-bottom:0px;" class="ft_sns_list clearfix">
                        <li>
                            <div class="wx_tips j_tips">
                                <div class="tips_hd">
                                    <em class="ico_sns ico_weixin"></em>
                                    <span class="txt">微信公众号</span>
                                </div>
                                <div class="tips_bd">
                                    <em class="arrow"></em>
                                    <img src="/winner/files/yj.jpg" alt="微信公共平台">
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="http://pro.ying158.com/account/security" target="_blank" rel="nofollow">
                                <em class="ico_sns ico_sinawb"></em>
                                <span class="txt">新浪微博</span>
                            </a>
                        </li>
                        <li>
                            <a href="http://pro.ying158.com/account/security" target="_blank" rel="nofollow">
                                <em class="ico_sns ico_txwb"></em>
                                <span class="txt">腾讯微博</span>
                            </a>
                        </li>
                    </ul>

                    <div class="contactUs">
                       <div class="title" style=" padding-left:10px; font-weight:normal; font-size:20px; color:#ccc;">
                          联系我们
                        </div>
                        <div class="contactInfo" style="padding-left:30px;">
                            <a style="display:inline-block; height:50px; width:50px; text-align:center; " target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=508886246&amp;site=qq&amp;menu=yes"><img src="/winner/files/qqIcon.png" onmouseover="$(this).css(&#39;height&#39;, &#39;52px&#39;);" onmouseout="    $(this).css(&#39;height&#39;, &#39;48px&#39;);"></a>
                            <span class="kefu">在线客服</span><span class="time">08:30 - 21:00</span>
                        </div>
                    </div>

                </div>

			</div>
		</div>
	</div>
	<div class="foot3">
		<div class="container">
			<div class="row">
				Copyright © 2010 - 2015 www.ying158.com All Rights Reserverd 杭州吉威投资管理有限公司 版权所有<br>
				浙ICP备14030807号-3 杭州市江干区钱江新城迪凯银座19F 4000-999-158
			</div>
		</div>
	</div>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?06cf97732baac1a65bed8ae95f2384aa";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>    <!--<div id="realNameModal" class="modal fade infoModal" role="dialog">-->
	<!--<div class="modal-dialog">-->
		<!--<div class="modal-content" style="border-radius: 0px;">-->
			<!--<div class="modal-header">-->
				<!--<span>请进行实名登记</span>-->
				<!--<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>-->
			<!--</div>-->
			<!--<div class="modal-body text-center">-->
				<!--<form class="form-horizontal" id="realNameRegisterForm">-->
					<!--<div class="form-group" id="fullNameGroup">-->
						<!--<label class="control-label col-sm-3" for="fullName">真实姓名: </label>-->
						<!--<div class="col-sm-5">-->
							<!--<input type="text" class="form-control" id="fullName" placeholder="真实姓名" />-->
						<!--</div>-->
						<!--<div class="col-sm-4 help-block text-left">-->
							<!--<span class="error-info"></span>-->
						<!--</div>-->
					<!--</div>-->
					<!--<div class="form-group" id="idCodeGroup">-->
						<!--<label class="control-label col-sm-3" for="idCode">身份证号码: </label>-->
						<!--<div class="col-sm-5">-->
							<!--<input type="text" class="form-control" id="idCode" placeholder="身份证号码" />-->
						<!--</div>-->
						<!--<div class="col-sm-4 help-block text-left">-->
							<!--<span class="error-info"></span>-->
						<!--</div>-->
					<!--</div>-->
				<!--</form>-->
				<!--<div class="col-sm-offset-1">-->
					<!--<p class="text-left">-->
						<!--实名信息提交后不可修改，请务必认真填写真实资料。-->
					<!--</p>-->
					<!--<p class="text-left">-->
						<!--一个身份证只能绑定一个帐号-->
					<!--</p>-->
					<!--<p class="text-left">-->
						<!--如遇到问题，请联系客服 <b>4000-999-158</b>-->
					<!--</p>-->
                    <!--<p class="text-left" style="color:#ff6a00">-->
                        <!--我已知晓金融投资的市场风险和交易风险，清楚市场及交易细则。<br />经审慎考虑，决定自己参与，风险自担。-->
                    <!--</p>-->
				<!--</div>-->
			<!--</div>-->
			<!--<div class="modal-footer">-->
				<!--<button type="button" class="btn btn-primary" onclick="registerRealName();">提交</button>-->
				<!--<button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">取消</button>-->
			<!--</div>-->
		<!--</div>-->
	<!--</div>-->
<!--</div>-->
<!--<div id="realNameRegisteredModal" class="modal fade infoModal" role="dialog">-->
	<!--<div class="modal-dialog">-->
		<!--<div class="modal-content jddModalContnt" style="border-radius: 0px;width:400px;">-->
			<!--<div class="modal-header">-->
				<!--<span>操作成功</span>-->
				<!--<button type="button" class="close" data-dismiss="modal" >-->
					<!--<span aria-hidden="true">×</span>-->
					<!--<span class="sr-only">关闭</span>-->
				<!--</button>-->
			<!--</div>-->
			<!--<div class="modal-body text-center">-->
				<!--<div class="content">-->
					<!--真实姓名和身份证号已登记-->
				<!--</div>-->
			<!--</div>-->
		<!--</div>-->
	<!--</div>-->
<!--</div>-->


	<!--<div id="changeTelModal" class="modal fade infoModal" role="dialog">-->
		<!--<div class="modal-dialog">-->
			<!--<div class="modal-content" style="border-radius: 0px;">-->
				<!--<div class="modal-header">-->
					<!--<span>修改绑定手机</span>-->
					<!--<button type="button" class="close" data-dismiss="modal" ><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>-->
				<!--</div>-->
				<!--<div class="modal-body text-center">-->
					<!--<div class="form-horizontal" id="changeTelForm">-->
						<!--<div class="form-group" id="fullNameGroup">-->
							<!--<label class="control-label col-sm-3">原手机号码: </label>-->
							<!--<div class="col-sm-5">-->
								<!--<div style="line-height:30px;text-align: left;">1582702****</div>-->
							<!--</div>-->
						<!--</div>-->
						<!--<div class="form-group" id="changeTelvCodeGroup">-->
							<!--<label class="control-label col-sm-3" for="changeTelvCode">验证码: </label>-->
							<!--<div class="col-sm-5">-->
								<!--<input type="text" class="form-control" id="changeTelvCode" placeholder="手机验证码" />-->
							<!--</div>-->
							<!--<div class="col-sm-4 help-block text-left">-->
								<!--<button class="btn clickBtn" id="changeTelVcodeBtn" onclick="changeTelSendVCode()" type="button">获取手机验证码</button>-->
							<!--</div>-->
						<!--</div>-->
					<!--</div>-->
				<!--</div>-->
				<!--<div class="modal-footer">-->
					<!--<button type="button" class="btn btn-success" onclick="changeTel();">下一步</button>-->
					<!--<button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">取消</button>-->
				<!--</div>-->
			<!--</div>-->
		<!--</div>-->
	<!--</div>-->
	<!--<div id="setNewTelModal" class="modal fade infoModal" role="dialog">-->
		<!--<div class="modal-dialog">-->
			<!--<div class="modal-content" style="border-radius: 0px;">-->
				<!--<div class="modal-header">-->
					<!--<span>绑定新手机</span>-->
					<!--<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>-->
				<!--</div>-->
				<!--<div class="modal-body text-center">-->
					<!--<div class="form-horizontal" id="setNewTelForm">-->
						<!--<div class="form-group" id="NewTelGroup">-->
							<!--<label class="control-label col-sm-3" for="NewTel">手机号码: </label>-->
							<!--<div class="col-sm-5">-->
								<!--<input type="text" class="form-control" id="NewTel" placeholder="手机号码" />-->
							<!--</div>-->
							<!--<div class="col-sm-4 help-block text-left">-->
								<!--<span class="error-info"></span>-->
							<!--</div>-->
						<!--</div>-->
						<!--<div class="form-group" id="setNewTelvCodeGroup">-->
							<!--<label class="control-label col-sm-3" for="setNewTelvCode">验证码: </label>-->
							<!--<div class="col-sm-5">-->
								<!--<input type="text" class="form-control" id="setNewTelvCode" placeholder="手机验证码" />-->
							<!--</div>-->
							<!--<div class="col-sm-4 help-block text-left">-->
								<!--<button class="btn clickBtn" id="setNewTelVcodeBtn" onclick="setNewTelSendVCode()" type="button">获取手机验证码</button>-->
							<!--</div>-->
						<!--</div>-->
					<!--</div>-->
				<!--</div>-->
				<!--<div class="modal-footer">-->
					<!--<button type="button" class="btn btn-success" onclick="setNewTel()">确定</button>-->
					<!--<button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">取消</button>-->
				<!--</div>-->
			<!--</div>-->
		<!--</div>-->
	<!--</div>-->

	<!--<div id="changeTelResultModal" class="modal fade infoModal" role="dialog">-->
		<!--<div class="modal-dialog">-->
			<!--<div class="modal-content jddModalContnt" style="border-radius: 0px;width:400px;">-->
				<!--<div class="modal-header">-->
					<!--<span>操作成功</span>-->
					<!--<button type="button" class="close" data-dismiss="modal">-->
						<!--<span aria-hidden="true">×</span>-->
						<!--<span class="sr-only">关闭</span>-->
					<!--</button>-->
				<!--</div>-->
				<!--<div class="modal-body text-center">-->
					<!--<div class="content">-->
						<!--修改绑定手机成功-->
					<!--</div>-->
				<!--</div>-->
			<!--</div>-->
		<!--</div>-->
	<!--</div>-->

	

<!--<div id="setEmailModal" class="modal fade infoModal" role="dialog">-->
	<!--<div class="modal-dialog">-->
		<!--<div class="modal-content" style="border-radius: 0px;">-->
			<!--<div class="modal-header">-->
				<!--<span>绑定新邮箱</span>-->
				<!--<button type="button" class="close" data-dismiss="modal" ><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>-->
			<!--</div>-->
			<!--<div class="modal-body text-center">-->
				<!--<div class="form-horizontal" id="setEmailForm">-->
					<!--<div class="form-group" id="setEmailGroup">-->
						<!--<label class="control-label col-sm-3" for="email">邮箱: </label>-->
						<!--<div class="col-sm-5">-->
							<!--<input type="text" class="form-control" id="email" placeholder="邮箱地址" />-->
						<!--</div>-->
						<!--<div class="col-sm-4 help-block text-left">-->
							<!--<span class="error-info"></span>-->
						<!--</div>-->
					<!--</div>-->
					<!--<div class="form-group" id="setEmailVCodeGroup">-->
						<!--<label class="control-label col-sm-3" for="setEmailVCode">验证码: </label>-->
						<!--<div class="col-sm-5">-->
							<!--<input type="text" class="form-control" id="setEmailVCode" placeholder="邮箱验证码" />-->
						<!--</div>-->
						<!--<div class="col-sm-4 help-block text-left">-->
							<!--<button class="btn clickBtn" id="setEmailVCodeBtn" onclick="setEmailgetVcode(); return false;" type="button">获取邮箱验证码</button>-->
						<!--</div>-->
					<!--</div>-->
				<!--</div>-->
			<!--</div>-->
			<!--<div class="modal-footer">-->
				<!--<button type="button" class="btn btn-success" onclick="setEmail();">确认</button>-->
				<!--<button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">取消</button>-->
			<!--</div>-->
		<!--</div>-->
	<!--</div>-->
<!--</div>-->


<div id="changePWModal" class="modal fade infoModal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content" style="border-radius: 0px;">
			<div class="modal-header">
				<span>修改登录密码</span>
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
			</div>
			<div class="modal-body text-center">
				<form class="form-horizontal" id="changePWModalForm">
					<div class="form-group" id="oldLoginPwGroup">
						<label class="control-label col-sm-3" for="oldLoginPw">原登录密码: </label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="oldLoginPw" placeholder="原登录密码">
						</div>
						<div class="col-sm-4 help-block text-left">
							<span class="error-info"></span>
						</div>
					</div>
					<div class="form-group" id="newLoginPwGroup">
						<label class="control-label col-sm-3" for="newLoginPw">新登录密码: </label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="newLoginPw" placeholder="新登录密码">
						</div>
						<div class="col-sm-4 help-block text-left">
							<span class="error-info"></span>
						</div>
					</div>
					<div class="form-group" id="newLoginPwConfirmGroup">
						<label class="control-label col-sm-3" for="newLoginPwConfirm">确认新密码: </label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="newLoginPwConfirm" placeholder="确认新密码">
						</div>
						<div class="col-sm-4 help-block text-left">
							<span class="error-info"></span>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success" onclick="changeLoginPW();">提交</button>
				<button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>
</div>
<div id="changePWResultModal" class="modal fade infoModal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content jddModalContnt" style="border-radius: 0px;width:400px;">
			<div class="modal-header">
				<span>操作成功</span>
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span>
					<span class="sr-only">关闭</span>
				</button>
			</div>
			<div class="modal-body text-center">
				<div class="content">
					修改登录密码成功
				</div>
			</div>
		</div>
	</div>
</div>

    <div id="setWithdrawPWModel" class="modal fade infoModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content" style="border-radius: 0px;">
                <div class="modal-header">
                    <span>设置提款密码</span>
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                </div>
                <div class="modal-body text-center">
                    <form class="form-horizontal" id="setWithdrawPWForm">
                        <div class="form-group" id="withdrawPWGroup">
                            <label class="control-label col-sm-3" for="withdrawPW">提款密码: </label>
                            <div class="col-sm-5">
                                <input type="password" class="form-control" id="withdrawPW" placeholder="提款密码">
                            </div>
                            <div class="col-sm-4 help-block text-left">
                                <span class="error-info"></span>
                            </div>
                        </div>
                        <div class="form-group" id="withdrawPWConfirmGroup">
                            <label class="control-label col-sm-3" for="withdrawPWConfirm">确认提款密码: </label>
                            <div class="col-sm-5">
                                <input type="password" class="form-control" id="withdrawPWConfirm" placeholder="确认提款密码">
                            </div>
                            <div class="col-sm-4 help-block text-left">
                                <span class="error-info"></span>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" onclick="setWithdrawPw();">提交</button>
                    <button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
    

<div id="setWithdrawPWResultModel" class="modal fade infoModal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content jddModalContnt" style="border-radius: 0px;width:400px;">
			<div class="modal-header">
				<span class="title">操作成功</span>
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span>
					<span class="sr-only">关闭</span>
				</button>
			</div>
			<div class="modal-body text-center">
				<div class="content">
					设置提款密码成功
				</div>
			</div>
		</div>
	</div>
</div>
  

<script type="text/javascript">
	var baseContext = "";
</script>
<!--<script src="/resources/web/js/security_realname.js"></script>-->
<!--<script src="/resources/web/js/security_changemobile.js"></script>-->
<script src="/winner/files/security_changeloginpwd.js"></script>
<script src="/winner/files/security_withdrawpwd.js"></script>
</body>
</html>