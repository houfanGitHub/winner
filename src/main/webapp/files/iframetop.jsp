<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
	<meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
	<meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
	<title>我的加法库 - 盈+</title>
	
<meta name="keywords" content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50">
<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。">

<link href="iconfont.css" rel="stylesheet" type="text/css">
<link href="common.css" rel="stylesheet">
<link href="jw.css" rel="stylesheet">
<link rel="stylesheet" href="layer.css" id="layui_layer_skinlayercss">
</head>
<body>
<div class="logo container">
    <div class="row">
        <div class="logoImg">
            <a target="_parent" href="/winner/itemweb/index"><img src="/winner/files/logo2.png"></a>
        </div>
       <div class="telInfo">
        <c:if test="${empty memberinfo }">
	            <img src="/winner/files/400Icon.png">
	            <div class="detail">
	                        <a target="_parent" style="font-size:18px;float:right;margin-top:5px;color:#917739;" href="/winner/itemweb/toLogin">登录</a>
	                        <a target="_parent" style="font-size:18px;float:right;margin-right:15px;margin-top:5px;color:#917739;" href="/winner/itemweb/toRegistration">注册</a>
	                <br>4000-999-158
	            </div>
        </c:if>
        <c:if test="${!empty memberinfo }">
	            <img src="/winner/files/400Icon.png">
	            <div class="detail">
	                <div style="font-size:16px;float:right;margin-top:5px;color:#917739;">
	                		  欢迎${memberinfo.name },<a target="_parent" href="#">[会员中心]</a>,
	                  <a target="_parent" href="/winner/itemweb/webUserLogout">[退出]</a>
	                  </div>
	                <br>4000-999-158
	            </div>
        </c:if>
        </div>
    </div>
</div>

</body>
</html>