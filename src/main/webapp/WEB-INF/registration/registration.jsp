<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	
	<meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
	<meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
	<meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
	<title>注册 - 盈+</title>
	
<meta name="keywords" content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50">
<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。">
<!-- <link href="http://pro.ying158.com/resources/web/images/icon.ico" type="image/x-icon" rel="shortcut icon"> -->

<link href="/winner/files/iconfont.css" rel="stylesheet" type="text/css">
<link href="/winner/files/common.css" rel="stylesheet">
<link href="/winner/files/jw.css" rel="stylesheet">

<!-- <script src="/winner/files/hm.js"></script> -->
<!-- <script src="/winner/files/jquery.js"></script> -->
<script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
<!-- <script type="text/javascript" src="/winner/files/layer.js"></script> -->
<link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss">
<!-- <script src="/winner/files/echarts.js"></script> -->
<script type="text/javascript">
  	function changeValidateCode(obj){
  		var timeNow = new Date().getTime();
  		obj.src="/winner/checkCode/service.do?time="+timeNow;
  	}	
  </script>
</head>
<body>

<div class="logo container">
    <div class="row">
        <div class="logoImg">
            <a href="#"><img src="/winner/files/logo2.png" onmouseover="this.src = &#39;/resources/web/images/logo1.png&#39;" onmouseout="this.src = &#39;/resources/web/images/logo2.png&#39;"></a>
        </div>
        <div class="telInfo">
            <img src="/winner/files/400Icon.png" onmousemove="this.src = &#39;/resources/web/images/400IconActive.png&#39;" onmouseout="	this.src = &#39;/resources/web/images/400Icon.png&#39;">
            <div class="detail">

                        <a style="font-size:18px;float:right;margin-top:5px;color:#917739;" href="http://pro.ying158.com/web/login">登录</a>
                        <a style="font-size:18px;float:right;margin-right:15px;margin-top:5px;color:#917739;" href="http://pro.ying158.com/web/regis">注册</a>
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
                    <a class="item first" href="#">
                        首页
                    </a>
                </li>
                <li>
                    <a class="item" href="#">
                        网上体验中心
                    </a>
                </li>
                <li class="item">
                    <a class="item" href="#">
                        产品中心
                    </a>
                </li>
                <li>
                    <a class="item" href="#">
                        新闻中心
                    </a>
                </li>
                <li>
                    <a class="item" href="#">
                      下载中心
                    </a>
                </li>
                <li>
                    <a class="item " href="#">
                        盈+商学院
                    </a>
                </li>
                <li>
                    <a class="item" href="#">
                        投研中心
                    </a>
                </li>
                <li>
                    <a class="item last" href="#">
                        我的加法库
                    </a>
                </li>



            </ul>
        </div>
    </div>
</div>

<script type="text/javascript" src="/winner/files/regis.js"></script>
<div class="proMain">
    	</div>
	<div class="row register">
		<div class="title">
			<div class="left">
				<hr>
			</div>
			<div class="mid">
				15秒快速注册
			</div>
			<div class="right">
				<hr>
			</div>
		</div>
       
       <form action="/winner/itemweb/userRegistration" method="post">
       
        <div class="item">
            <div class="rLabel">
                用户名
            </div>
            <div class="rInput">
                <input type="text" placeholder="请输入用户名" id="name" name="name" class="form-control textInput youname"><span class="errorInfo">用户名不能为空</span>
            </div>
        </div>
        <div class="item">
            <div class="rLabel">
		真实姓名
            </div>
            <div class="rInput">
                <input type="text" placeholder="请输入用户名" id="userName" name="userName" class="form-control textInput username">（需用实名注册）<span class="errorInfo">姓名不能为空</span>
            </div>
        </div>
        <div class="item">
			<div class="rLabel">
				手机号
			</div>
			<div class="rInput">
				<input type="text" placeholder="请输入手机号" id="phone" name="mobile_Phone" class="form-control textInput phone"><span class="errorInfo">手机号码不能为空</span>
			</div>
		</div>
		 <div class="item">
            <div class="rLabel">
                图形验证码
            </div>
            <div class="rInput">
                <input type="text" placeholder="图片验证码" id="picCode" class="form-control textInput imgcode">
                <img src="/winner/checkCode/service.do" id="captcha" onclick="changeValidateCode(this)" title="看不清楚,点击换一张" alt="看不清楚,点击换一张" class="picCodeImg">
                <span class="errorInfo">请输入图形验证码</span>
            </div>
        </div>

		<div class="item">
			<div class="rLabel">
				登录密码
			</div>
			<div class="rInput">
				<input type="password" placeholder="请输入密码" id="password" name="password" class="form-control textInput password"><span class="errorInfo"></span>（数字和字母组合，不少于6位）
			</div>
		</div>
		<div class="item">
			<div class="rLabel">
				确认密码
			</div>
			<div class="rInput">
				<input type="password" placeholder="请再输入密码" id="password2" name="password2" class="form-control textInput password2"><span class="errorInfo"></span>
			</div>
		</div>
        <div class="item">
            <div class="rLabel">
                理财师邀请码
            </div>
            <div class="rInput">
                <input type="text" placeholder="选填" id="invitationCode" name="invitationCode" class="form-control textInput invitationCode">（填写理财师邀请码，将会有更多惊喜）
            </div>
        </div>
		<div class="item">
			<div class="rLabel">
				&nbsp;
			</div>
			<div class="rInput">
				<label>
					<input type="checkbox" id="registerRule" class="registerRule" checked="checked"><span>我已阅读并同意<a href="javascript:showAgreement();">《本网站服务协议》</a></span>
				</label>
				<span class="ruleError">请先阅读并同意网站服务协议</span>
			</div>
		</div>
		<div class="item">
			<div class="rLabel">
				&nbsp;
			</div>
			<div class="rInput">
				<button class="btn registBtn submit" onclick="doSubmit();">立即注册</button>
			</div>
		</div>
		
		</form>
		
		<div class="item">
			<div class="rLabel">
				&nbsp;
			</div>
			<div class="rInput loginChoose">
				我已经注册，现在就<a href="http://pro.ying158.com/web/login">登录</a>
			</div>
		</div>
	</div>
	

<script type="text/javascript">
	$(function(){
		var b = "";
		regis(b);
	});
	function showAgreement(){
		window.open("/web/zcxy","注册协议","height=800,width=1000,scrollbars=yes, resizable=no,location=no, status=no,screenX=100") 
	}
</script>
 

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
                            <a href="http://pro.ying158.com/web/regis" target="_blank" rel="nofollow">
                                <em class="ico_sns ico_sinawb"></em>
                                <span class="txt">新浪微博</span>
                            </a>
                        </li>
                        <li>
                            <a href="http://pro.ying158.com/web/regis" target="_blank" rel="nofollow">
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

</body>
</html>