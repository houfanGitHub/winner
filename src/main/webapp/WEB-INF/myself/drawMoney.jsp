<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	<title>提款-会员中心-盈+</title>
	<link href="http://www.ying158.com/images/icon.ico" type="image/x-icon" rel="shortcut icon">
	<link href="/winner/files/common.css" rel="stylesheet">
	<link href="/winner/files/jw.css" rel="stylesheet">
    <link href="/winner/files/iconfont.css" rel="stylesheet">
    <script src="/winner/files/hm.js"></script>
    <script src="/winner/files/jquery.js"></script>
    <script src="/winner/files/bootstrap.js"></script>
	<script type="text/javascript" src="/winner/files/area.js"></script>
	<script type="text/javascript" src="/winner/files/location.js"></script>
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
	var baseContext = "";
    </script>
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

</style>
</head>
<body>

<div style=" width:1002px; height:94px; margin:0 auto;">
        <iframe src="/winner/files/iframetop.jsp" scrolling="no" frameborder="0" width="1002" height="94"></iframe>
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
					<li>
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
            <a href="#">
                <div class="img"><img src="/winner/files/userPic.jpg"></div>
                <h2>${memberinfo.name }，<span>您好!</span></h2>
            </a>
            <div class="safe">账户安全&nbsp;&nbsp;<span class="scroll"><em style="width:75%"></em></span></div>
            <ul class="listIco iconfont">
                <li class="active"><a href="http://pro.ying158.com/account/withdraw#1"></a><em></em></li>
                <li class="active"><a href="http://pro.ying158.com/account/withdraw#1"></a><em></em></li>
                <li class="active"><a href="http://pro.ying158.com/account/withdraw#1"></a><em></em></li>                                
                <li class=""><a href="http://pro.ying158.com/account/withdraw#1"></a><em></em></li>
            </ul>
        </td>
        <td align="right">
            <a href="/winner/index.jsp" class="loginOut"><span class="iconfont"></span>安全退出</a>
        </td>
    </tr>
</tbody></table>
<div class="countBox">
    <ul>
        <li>
        <h2>
        <c:if test="${empty memberinfo.memberAccounts }">0</c:if>
        <c:if test="${!empty memberinfo.memberAccounts }">
        <c:forEach items="${memberinfo.memberAccounts }" var="memberAccount">${memberAccount.useableBalance}</c:forEach>
        </c:if>
        </h2>
        <p>账户可用余额(元)<a href="javascript:;" class="iconfont"><span>账户可用余额</span><i></i></a></p></li>
        <li><h2>0</h2><p>账户总资产(元)<a href="javascript:;" class="iconfont"><span>可用余额+投资金额+累计收益</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">0</h2><p>投资金额(元)<a href="javascript:;" class="iconfont"><span>投资中资金</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">0</h2><p>累计收益(元)<a href="javascript:;" class="iconfont"><span>累计收益</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">0</h2><p>冻结金额(元)<a href="javascript:;" class="iconfont"><span>提现冻结金额</span><i></i></a></p></li>
    </ul>
    <a href="http://pro.ying158.com/account/deposit" class="cz">充值</a>
    <a href="http://pro.ying158.com/account/withdraw" class="tk">提款</a>
</div>	<div class="proMain clearfix">
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
        href="/winner/itemweb/withdraw" class="select"><em class="iconfont red"></em>提款记录</a></li>
        <li><a id="member_center_menu_bbinInfo_record"
         href="/winner/itemweb/experienceGold"><em class="iconfont red"></em>体验金记录</a></li>
    </ul>
    <h2>我的账户</h2>
			<ul>
				<li><a id="member_center_menu_deposit"
					href="/winner/itemweb/deposit"><em class="iconfont"></em>账户充值</a></li>
				<li><a id="member_center_menu_security" 
				href="/winner/itemweb/security"><em class="iconfont"></em>安全信息</a></li>
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
                    <a class="select" href="javascript:;">我要提款</a>
                    <a href="javascript:showAppleFor();" id="state">申请流程状态</a>                    
                </div>
                <div id="conBox">
                    <div class="box" style="display:block">
													
                        <table class="txTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tbody><tr>
                            <td width="140" align="right">账户余额：</td>
                            <td><strong><c:forEach items="${memberinfo.memberAccounts }" var="memberAccount">${memberAccount.useableBalance }</c:forEach></strong>元</td>
                          </tr>
							<tr>
								<td align="right"> 提款银行卡： </td>
								<td><strong>
								<c:forEach items="${memberinfo.memberBankcards }" var="memberBankcard">${memberBankcard.type }-${memberBankcard.cardNo }
									<input type="hidden" id="withdrawBankCard" value="${memberBankcard.cardNo }">
								</c:forEach></strong></td>
							</tr>
                          <tr>
                            <td align="right">提款金额：</td>
                            <td><input class="tytxt" type="text" id="withdrawAmount" style="width:250px"></td>
                          </tr>

                          <tr>
                            <td align="right"> 提款密码：</td>
                            <td>
                            <c:if test="${!empty memberinfo.withdrawPassword }">
                           		 <input type="text" name="withdrawPassword" id="withdrawPassword">
                           	</c:if>
                           	<c:if test="${empty memberinfo.withdrawPassword }">
                           		 &nbsp;
	                            <a href="javascript:;" onclick="$(&#39;#setWithdrawPWModel&#39;).modal(); return false;">设置提款密码</a>
								&nbsp;
                           	</c:if>
                            </td>
                          </tr>
                          <tr>
                            <td>&nbsp;</td>
                            <td><button class="tybutton" id="withdrawConfirm">提交</button></td>
                          </tr>
                        </tbody></table> 
                    </div>
                    <div class="box">                    	

<div class="ajaxContainer">

	<table class="tzlist" id="tab" width="100%" border="1" bordercolor="#e9e9e9" cellspacing="0" cellpadding="0">
		<thead>
	      <tr>
	        <th width="10%">流程id</th>
			<th width="25%">银行卡号</th>
			<th width="10%">取款金额</th>
			<th width="10%">申请账号</th>
			<th width="10%">查看状态</th>
	      </tr>
	   </thead>
		<tbody id="tbody-result"></tbody>
	</table>

</div>
<script type="text/javascript">
	function getJsonInfo(url) {
		$.get(url, 'json', function(data) {
			$(".ajaxContainer").empty();
			$(".ajaxContainer").append(data);
		});
	}
	
	function showAppleFor(){
		$.post("/winner/itemweb/selectFlowState",function(msg){
// 			for(var i=0;i<msg.length;i++){
// 				alert(msg[i].processInstanceId);
// 			}
			var str = "";  
//              alert(msg);
             for (i in msg) {
            	 if(msg[i].processState=='1'){
            		 str += "<tr>" +  
                     "<td>" + msg[i].processInstanceId + "</td>" +  
                     "<td>" + msg[i].bankCard + "</td>" +  
                     "<td>" + msg[i].withdrawAmount + "</td>" +  
                     "<td>" + msg[i].memberID + "</td>" + 
                     "<td><a target='_blank' href=/winner/itemweb/showImg/"+msg[i].processInstanceId+">审核中</a></td></tr>"; 
            	 }else if(msg[i].processState=='2'){
            		 str += "<tr>" +  
                     "<td>" + msg[i].processInstanceId + "</td>" +  
                     "<td>" + msg[i].bankCard + "</td>" +  
                     "<td>" + msg[i].withdrawAmount + "</td>" +  
                     "<td>" + msg[i].memberID + "</td>" + 
                     "<td>已完成</td></tr>"; 
            	 }
                  
             }  
             $("#tbody-result").append(str);
		});
	}
</script>                    </div>
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
                            <a href="http://pro.ying158.com/account/withdraw" target="_blank" rel="nofollow">
                                <em class="ico_sns ico_sinawb"></em>
                                <span class="txt">新浪微博</span>
                            </a>
                        </li>
                        <li>
                            <a href="http://pro.ying158.com/account/withdraw" target="_blank" rel="nofollow">
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
</script><div id="setWithdrawPWModel" class="modal fade infoModal" role="dialog">
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

<div class="modal fade errorInfo infoModal" id="withdrawErrorModal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content jddModalContnt" style="border-radius: 0px;width:400px;">
            <div class="modal-header">
                <span>通知</span>
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
            </div>
            <div class="modal-body">
                <div id="withdrawError"></div>
                <button class="btn btn-success confirmBtn" data-dismiss="modal">确认</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade errorInfo infoModal" id="setWithdrawPWResultModel" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content jddModalContnt" style="border-radius: 0px;width:400px;">
					<div class="modal-header">
						<span>通知</span>
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
					</div>
					<div class="modal-body">
						<div id="setwithdrawError"></div>
						<button class="btn btn-success confirmBtn" data-dismiss="modal">确认</button>
					</div>
				</div>
			</div>
</div>

<script type="text/javascript">
	$("#setWithdrawPWResultModel").on('hidden.bs.modal', function () { window.location.reload(); });
	function withdrawPWError(txt) {
		if (txt) {
			$('#setWithdrawPWForm #withdrawPWGroup').addClass('has-error');
			$('#setWithdrawPWForm #withdrawPWGroup .error-info').text(txt);
		} else {
			$('#setWithdrawPWForm #withdrawPWGroup').removeClass('has-error');
			$('#setWithdrawPWForm #withdrawPWGroup .error-info').text('');
		}
	}

	function withdrawPWConfirmError(txt) {
		if (txt) {
			$('#setWithdrawPWForm #withdrawPWConfirmGroup').addClass('has-error');
			$('#setWithdrawPWForm #withdrawPWConfirmGroup .error-info').text(txt);
		} else {
			$('#setWithdrawPWForm #withdrawPWConfirmGroup').removeClass('has-error');
			$('#setWithdrawPWForm #withdrawPWConfirmGroup .error-info').text('');
		}
	}

	var setWithdrawPw = function() {
		var withdrawPw = $("#setWithdrawPWModel #withdrawPW").val();
		var pattter = new RegExp(/^[a-zA-Z0-9!@#$%^&*()_+|]{8,30}$/);
		if (!withdrawPw) {
			withdrawPWError('提款密码不能为空');
			return;
		} else {
			if (!pattter.test(withdrawPw)) {
				withdrawPWError('8-30位数字和字母组成');
				return;
			}
			withdrawPWError(false);
		}
		var withdrawPwConfirm = $("#setWithdrawPWModel #withdrawPWConfirm").val();
		if (!withdrawPwConfirm) {
			withdrawPWConfirmError('确认提款密码不能为空');
			return;
		} else {
			if (withdrawPwConfirm != withdrawPw) {
				withdrawPWConfirmError('两次输入的提款密码不一致');
				return;
			}
			withdrawPWConfirmError(false);
		}
		$.ajax({
			type : "POST", 
			dataType : "json", 
			async : true,
			url : '/winner/itemweb/insertDrawMoney', 
			data : {
				password : withdrawPw		
			},
			success : function(resp) {
				if (resp.code) {
					$("#setwithdrawError").html("设置提款密码成功");
				} else {
					$("#setwithdrawError").html(resp.msg);
				}
				$("#setWithdrawPWModel").modal("hide");
				$("#setWithdrawPWResultModel").modal();
			}
		});
	}

	$("#withdrawConfirm").click(function () {
		var bankCard = $("#withdrawBankCard").val();
		var withdrawAmount = $("#withdrawAmount").val();
		var withdrawPW = $("#withdrawPassword").val();
		if ($.trim(withdrawAmount) == "") {
			$("#withdrawError").html("请填写提款金额");
			$("#withdrawErrorModal").modal();
			$("#withdrawAmount").focus();
			return;
		}
		if (isNaN(withdrawAmount)) {
			$("#withdrawError").html("请填写正确的提款金额");
			$("#withdrawErrorModal").modal();
			$("#withdrawAmount").val("");
			$("#withdrawAmount").focus();
			return;
		}
		if (withdrawAmount < 10) {
			$("#withdrawError").html("提款金额不可少于10元");
			$("#withdrawErrorModal").modal();
			$("#withdrawAmount").val("");
			$("#withdrawAmount").focus();
			return;
		}
		if ($.trim(withdrawPW) == "") {
			$("#withdrawError").html("请填写提款密码");
			$("#withdrawErrorModal").modal();
			$("#withdrawPW").focus();
			return;
		}
		$("#withdrawConfirm").addClass("disabled");

		$.post(
			"/winner/itemweb/drawMoneyApplyFor",
			{
				withdrawAmount : withdrawAmount,
				withdrawPW:withdrawPW,
				bankCard: bankCard
			},
			function(falg) {
				if (falg == 'yes') {
					$("#withdrawError").html("提款申请提交成功");
					$("#withdrawErrorModal").modal();
					$("#withdrawErrorModal").on('hide.bs.modal', function () {
						window.location.reload();
					});
					setTimeout(function () { $("#withdrawErrorModal").modal('hide'); }, 3000);
// 					$("#state").click();
				} else {
					$("#withdrawError").html(falg);
					$("#withdrawErrorModal").modal();
				}
				$("#withdrawConfirm").removeClass("disabled");
			});
		});
</script>


</body>
</html>
