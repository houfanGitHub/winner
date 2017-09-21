<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
	<meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
	<meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
	<title>登录 - 盈+</title>
    <style type="text/css">
       .error{
           color: #d43f3a;
        }
    </style>
	
<meta name="keywords" content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50">
<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。">
<link href="http://pro.ying158.com/resources/web/images/icon.ico" type="image/x-icon" rel="shortcut icon">

<link href="/winner/files/iconfont.css" rel="stylesheet" type="text/css">
<link href="/winner/files/common.css" rel="stylesheet">
<link href="/winner/files/jw.css" rel="stylesheet">

<script src="/winner/files/hm.js"></script><script src="/winner/files/jquery.js"></script>
<script type="text/javascript" src="/winner/files/layer.js"></script><link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss">
<script src="/winner/files/echarts.js"></script></head>
<body>

<div style=" width:1002px; height:94px; margin:0 auto;">
        <iframe src="/winner/files/iframetop.jsp" scrolling="no" frameborder="0" width="1002" height="94"></iframe>
    </div>
	<div class="jwNav">
		<div class="container">
			<div class="row">
				<ul class="topNav">
					<li class="active">
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

    });

</script>    <div class="proMain">
    	<div class="container">
            <div class="row login">
                <div class="loginPic">
                    <img src="/winner/files/loginImg.png">
                </div>
                <div class="loginBlock">
                    <img class="cornerImg" src="/winner/files/loginCorner.png">
                   
                    <form action="/winner/itemweb/memberLogin" method="post">
                 
                    	<div class="item item1">
	                        <div class="lLabel">
	                            用户名
	                        </div>
	                        <div class="lInput">
	                            <img src="/winner/files/userIcon.png"><input type="text" placeholder="用户名" id="name" name="name" class="form-control name"><span class="errorInfo">用户名不能为空</span>
	                        </div>
	                    </div>
	                    <div class="item">
	                        <div class="lLabel">
	                            登录密码
	                        </div>
	                        <div class="lInput">
	                            <img src="/winner/files/passwordIcon.png"><input type="password" placeholder="密码" id="password" name="password" class="form-control password"><span class="errorInfo"></span>
	                        </div>
	                    </div>
	                    <div class="rest">
	                        <p><font color="#D43F3A">${errorinfo}</font></p>
	                        <span id="loginError"></span><a class="forgetLink" href="/winner/itemweb/forgetPassword">忘记密码？</a>
	                    </div>
	                    <div class="rest">
	                        <button class="btn loginBtn submit">立即登录</button>
	                    </div>
                    </form>
                    <div class="rest">
                        <span class="registUrl">没有账号？<a href="/winner/itemweb/toRegistration">免费注册</a></span>
                    </div>
        
                </div>
            </div>
        </div>
    </div>
<script type="text/javascript" src="/winner/files/login.js"></script>
<script type="text/javascript">
$(function(){
	var b = "";
	login(b);
});
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
                            <a style="display:inline-block; height:50px; width:50px; text-align:center; " target="_blank"><img src="/winner/files/qqIcon.png"></a>
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
</script>
</body>
</html>