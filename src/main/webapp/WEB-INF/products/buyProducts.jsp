<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>购买固收类理财</title>
    
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
    <meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
    <meta name="description" content="申请实盘交易账户，直接进行实盘交易。">

<meta name="keywords" content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50">
<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。">
<link href="http://pro.ying158.com/resources/web/images/icon.ico" type="image/x-icon" rel="shortcut icon">

<link href="/winner/files/iconfont.css" rel="stylesheet" type="text/css">
<link href="/winner/files/common.css" rel="stylesheet">
<link href="/winner/files/jw.css" rel="stylesheet">

<script src="/winner/files/hm.js"></script><script src="/winner/files/jquery.js"></script>
<script type="text/javascript" src="/winner/files/layer.js"></script><link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss">
<script src="/winner/files/echarts.js"></script>    <link href="/winner/files/jquery.fancybox-1.3.4.css" rel="stylesheet">
    <script src="/winner/files/jquery.fancybox-1.3.4.js"></script>


<script type="text/javascript">
$(function(){
	$("#btn1").click(function(){
		if($("#mytext").val()>$("#myMoney").text()*1){
			alert("金额不足,请先充值!");
			return;
		}
		$("#form1").attr("action","/winner/itemweb/buy");
		$("#form1").submit();
	});
	});
	
// function fun(obj){
// 	var amountYuE=$("#amountYuE").val();//账户余额
// 	var mytext=obj.value;//输入框输入金额
// 	if(parseInt(amountYuE)<parseInt(mytext)){
// 		$("#btn1").attr("disabled", true); 
// 	}
// }
$(function(){
	$("#btn1").click(function(){
		var check=$("#cardHidden").val();//判断是否绑卡了
		var checkLogin=$("#hiddenLogin").val();//判断是否登录
		var mytext=$("#mytext").val();//输入框输入的起投金额
       var amountYuE=$("#amountYuE").val();//账户余额
		
		var reg = /^(\+)?\d+(\.\d+)?$/;//正则验证正数 包括小数
		var subject_id=$("#subject_id").val();//标ID
		if(checkLogin=='hasLogin'){
			if(check=='nocard'){
				$("#bank").show();
			}
			if(check=='hascard'){
				if((mytext!="")||mytext!=null){
					if (!reg.test(mytext)) {//说明输入的不是正确数字
						$("#num").show();//验证数值失败的div显示
						$("#atleast100").hide();
						$("#notenough").hide();
					}else{
						$("#num").hide();
						if(mytext<100){
							$("#atleast100").show();
							$("#notenough").hide();
						}else{
							$("#atleast100").hide();
							if(parseInt(mytext)>parseInt(amountYuE)){
								$("#notenough").show();
							}else{
								$("#notenough").hide();
							}
						}
					}
				}
			}
		}
	});
});	
	
</script>
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
<form action="" method="post" id="form1">
<div class="proMain">

<c:forEach items="${subject}" var="s">
    <div class="conTit">
<!--         <span><a style="color:#9d8440;" href="/FinancingProject/IndexController/product">其他标的</a></span> -->
        <h2><em>￥</em>${s.name}</h2>
    </div>
 </c:forEach>
    <table class="conTable" width="100%" border="0" cellspacing="0" cellpadding="0">
        <tbody>
        <c:forEach items="${subject}" var="s">
        <input type="hidden" name="subject_id" value="${s.id}">
        <tr>
            <td class="txtInfo">
                <div class="txt1">
                    <h2>${s.bought}</h2>
                    <p>已购人数(人)</p>
                </div>
                <div class="txt2">
                    <h2>${s.yearRate }%</h2>
                    <p>年化收益</p>
                </div>
                <div class="txt1">
                    <h2>${s.period}</h2>
                    <p>投资期限(天)</p>
     			
                </div>
            </td>
      
            <!-- !!!!!!!!!!!!!!!!!--------右侧购买--------!!!!!!!!!!!!!!!!!!!!!! -->
            <td width="360" rowspan="2" align="center";="" valign="middle" height="320">
                <div class="tbBox">
                    <input type="hidden" id="account" value="0">
                    <h2>
				<script type="text/javascript">
				  var id='${s.id}';
				  $.ajaxSetup({  
					    async : false  
					}); 
				  var num1=0;
				  $.post("/FinancingProject/subject/getTotalMoney",{id:id},function(data){
					 num1=data;
				  });
				  document.write("¥"+num1);
				 </script>
					</h2>
                    <p>已投金额(元)</p>
                  <!--   <div class="li4" style=""><span id="checkmoney" style="color: red;"></span></div> -->
                   
                   <div style="display:none;" id="num"> 
                   <span style="color:red;">请输入正确的金额</span>
                   </div>
                   <div style="display:none;" id="atleast100"> 
                   <span style="color:red;">起头金额不能低于100</span>
                   </div>
                   <div style="display:none;" id="notenough"> 
                   <span style="color:red;">余额不足，请充值</span>
                   </div> 
                   <div style="display:none;" id="bank"> 
                   <span style="color:red;">请先绑定银行卡</span>
                   <a href="/FinancingProject/IndexController/membercrad">绑卡</a>
                   </div>
                   <c:if test="${empty memberBankcard }">
                    	<input type="hidden" value="nocard" id="cardHidden">
                   </c:if>
                    <c:if test="${!empty memberinfo }">
                    	<input type="hidden" value="hascard" id="cardHidden">
                    </c:if>
                    <div class="tit">
                    	<c:if test="${!empty memberinfo }">
                    	<span class="fr">
<%--                <input type="hidden" value="${memberAccount.useableBalance }"  id="amountYuE" name="amountYuE"> --%>
	          <span id="myMoney">
	          <c:forEach items="${memberinfo.memberAccounts }" var="memberAccount">${memberAccount.useableBalance+memberAccount.investAmount+memberAccount.totalProfit}</c:forEach>
	          </span>元&nbsp;&nbsp;
	                    <a href="/winner/itemweb/deposit">充值&nbsp;&nbsp;&nbsp;</a>
						</span>
                        <h2>账户余额</h2>
                         	<input type="hidden" value="${memberAccount.useableBalance }" id="hiddenLogin">
                         </c:if>
                         <c:if test="${empty memberinfo }">
                       	 <h2 style="color:red; text-align: center; width: 100%;" >登录后可购买</h2>
                         <input type="hidden" value="noLogin" id="hiddenLogin">
                        </c:if>
                        <div id="count">预期所得收益<i data-num="0.000822" id="num">0</i>元
                        </div>
                    </div>
                         <input id="mytext" class="txt" name="mytext" placeholder="起投金额100元以上" type="text" onkeyup="fun(this)">
                        <span style="float: right;margin-top: -40px;position: relative; line-height: 40px; padding: 0 10px;color: #f00;" id="addMoney"></span>
                    <p class="preBox">
                        <input type="checkbox" id="registerRule" class="registerRule" checked="checked"><span class="fl">同意《产品协议》</span>
<!--                    		<button id="redPacket">使用红包</button> -->
<!--                         <button id="bbinAll">体验金全投</button> -->
                    </p>
                    <button class="submit" id="btn1">确认抢购</button>
                </div>
            </td>
        </tr>
        
        <tr>
            <td>
                <ul class="conInfoList">
                    <li class="info">
                        <p>计息日期：<font color="#00baff">${s.createDate}</font></p>
                        <p>还款方式：<font color="#00baff">
                        <c:if test="${s.refundWay==0}">一次性还本付息</c:if>
                        <c:if test="${s.refundWay==1}">阶段性还本付息</c:if>
                        </font></p>
                        <p>资金到账日：<font color="#00baff"> ${s.startDate}至${s.endDate}
                     </font>
                        </p>
                    </li>
                    <li class="info">
                        <p>保障方式：<font color="#00baff">
                        <c:if test="${s.safeGuard_way==0}">企业担保</c:if>
						<c:if test="${s.safeGuard_way==1}">个人担保</c:if>
                       </font></p>
                        <p>
                        	资金安全：<font color="#00baff">中国人保财险承保</font>
                        </p>
                        <p></p>
                    </li>
                </ul>
            </td>
        </tr>
         </c:forEach> 
    </tbody>
	</table>
</form>


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
                    <div class="hzhb_item"><a target="_blank" href="http://www.picc.com/"><img src="/winner/files/1.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.fuioupay.com/"><img src="/winner/files/2.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.nanhua.net/"><img src="/winner/files/3.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.zttrust.com.cn/stations/526623d20a/index.php/5268e6b50a"><img src="/winner/files/4.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://sc.hkex.com.hk/TuniS/www.hkex.com.hk/eng/index.htm/"><img src="/winner/files/5.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.cmegroup.com/cn-s/"><img src="/winner/files/6.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.sgx.com/wps/portal/sgxweb_ch/home/!ut/p/a1/04_Sj9CPykssy0xPLMnMz0vMAfGjzOKNHB1NPAycDSz9wwzMDTxD_Z2Cg8PCDANdjYEKIoEKDHAARwNC-sP1o8BK8JhQkBthkO6oqAgAzDYPQQ!!/dl5/d5/L2dBISEvZ0FBIS9nQSEh/"><img src="/winner/files/7.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.neeq.com.cn/index/"><img src="/winner/files/8.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.cmbchina.com/"><img src="/winner/files/9.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.bankcomm.com/BankCommSite/default.shtml"><img src="/winner/files/10.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.ccb.com/cn/home/index.html"><img src="/winner/files/11.jpg"></a></div>
                    <div class="hzhb_item"><a target="_blank" href="http://www.icbc.com.cn/icbc/"><img src="/winner/files/12.jpg"></a></div>
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
                            <a target="_blank" rel="nofollow">
                                <em class="ico_sns ico_sinawb"></em>
                                <span class="txt">新浪微博</span>
                            </a>
                        </li>
                        <li>
                            <a target="_blank" rel="nofollow">
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
                            <a style="display:inline-block; height:50px; width:50px; text-align:center; " target="_blank"><img src="/winner/files/qqIcon.png" onmouseover="$(this).css(&#39;height&#39;, &#39;52px&#39;);" onmouseout="    $(this).css(&#39;height&#39;, &#39;48px&#39;);"></a>
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
				Copyright © 2010 - 2015 www..com All Rights Reserverd 襄阳市赢+理财股份有限公司 版权所有<br>
				鄂ICP备14030807号-3 襄阳市江干区钱江新城迪凯银座19F 4000-999-158
			</div>
		</div>
	</div>
<div id="fancybox-tmp"></div><div id="fancybox-loading"><div></div></div><div id="fancybox-overlay"></div><div id="fancybox-wrap"><div id="fancybox-outer"><div class="fancybox-bg" id="fancybox-bg-n"></div><div class="fancybox-bg" id="fancybox-bg-ne"></div><div class="fancybox-bg" id="fancybox-bg-e"></div><div class="fancybox-bg" id="fancybox-bg-se"></div><div class="fancybox-bg" id="fancybox-bg-s"></div><div class="fancybox-bg" id="fancybox-bg-sw"></div><div class="fancybox-bg" id="fancybox-bg-w"></div><div class="fancybox-bg" id="fancybox-bg-nw"></div><div id="fancybox-content"></div><a id="fancybox-close"></a><div id="fancybox-title"></div><a href="javascript:;" id="fancybox-left"><span class="fancy-ico" id="fancybox-left-ico"></span></a><a href="javascript:;" id="fancybox-right"><span class="fancy-ico" id="fancybox-right-ico"></span></a></div></div></body>
</html>