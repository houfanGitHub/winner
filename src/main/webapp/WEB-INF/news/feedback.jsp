<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
	<meta name="Keywords" content="股指配资，股票配资，股指期货，沪深300">
	<meta name="description" content="提供证券、商品期货、金融期货投融资等相关新闻。">
	<title>新闻中心 - 盈+</title>
<!-- 	<link href="http://www.ying158.com/Content/images/jw/icon.ico" type="image/x-icon" rel="shortcut icon"> -->
	<script src="/winner/files/hm.js"></script>
	<script type="text/javascript" src="/winner/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="/winner/ueditor/ueditor.all.min.js"></script>
	<link href="/winner/files/common" rel="stylesheet">
	<link href="/winner/files/jw.less" rel="stylesheet">
	<script src="/winner/files/jquery"></script>
	<script src="/winner/files/bootstrap"></script>


	<style>
		* {
			margin: 0;
			padding: 0;
			list-style: none;
		}
		.rides-cs {
			font-size: 12px;
			background: #29a7e2;
			position: fixed;
			top: 250px;
			right: 0px;
			_position: absolute;
			z-index: 1500;
			border-radius: 6px 0px 0 6px;
		}

			.rides-cs a {
				color: #00A0E9;
			}

				.rides-cs a:hover {
					color: #ff8100;
					text-decoration: none;
				}

			.rides-cs .floatL {
				width: 36px;
				float: left;
				position: relative;
				z-index: 1;
				margin-top: 21px;
				height: 181px;
			}

				.rides-cs .floatL a {
					font-size: 0;
					text-indent: -999em;
					display: block;
				}

			.rides-cs .floatR {
				width: 130px;
				float: left;
				padding: 5px;
				overflow: hidden;
			}

				.rides-cs .floatR .cn {
					background: #F7F7F7;
					border-radius: 6px;
					margin-top: 4px;
				}

			.rides-cs .cn .titZx {
				font-size: 14px;
				color: #333;
				font-weight: 600;
				line-height: 24px;
				padding: 5px;
				text-align: center;
			}

			.rides-cs .cn ul {
				padding: 0px;
			}

				.rides-cs .cn ul li {
					line-height: 38px;
					height: 38px;
					border-bottom: solid 1px #E6E4E4;
					overflow: hidden;
					text-align: center;
				}

					.rides-cs .cn ul li span {
						color:#333;
					}

					.rides-cs .cn ul li a {
						color: #777;
					}

					.rides-cs .cn ul li img {
						vertical-align: middle;
					}

			.rides-cs .btnOpen, .rides-cs .btnCtn {
				position: relative;
				z-index: 9;
				top: 25px;
				left: 0;
				background-image: url(/Content/images/jw/qqkefu.png);
				background-repeat: no-repeat;
				display: block;
				height: 146px;
				padding: 8px;
			}

			.rides-cs .btnOpen {
				background-position: 0 0;
			}

			.rides-cs .btnCtn {
				background-position: -37px 0;
			}

			.rides-cs ul li.top {
				border-bottom: solid #ACE5F9 1px;
			}

			.rides-cs ul li.bot {
				border-bottom: none;
			}

        .topNav {
            padding: 0;
            margin: 0;
        }
	li {
		margin: 0;
		padding: 8px 0;
	}

	li.active {
		/*background: #323030;*/
        background:none;
	}

	li.active a {
		color: white;
	}
	
 img{
 width:auto;
 height:auto;
 max-width:100%;
 max-height:100%;
}
.green {
	color: #e8f0de;
	border: solid 1px #538312;
	background: #64991e;
	background: -webkit-gradient(linear, left top, left bottom, from(#7db72f), to(#4e7d0e));
	background: -moz-linear-gradient(top,  #7db72f,  #4e7d0e);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#7db72f', endColorstr='#4e7d0e');
}
.green:hover {
	background: #538018;
	background: -webkit-gradient(linear, left top, left bottom, from(#6b9d28), to(#436b0c));
	background: -moz-linear-gradient(top,  #6b9d28,  #436b0c);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#6b9d28', endColorstr='#436b0c');
}
.green:active {
	color: #a9c08c;
	background: -webkit-gradient(linear, left top, left bottom, from(#4e7d0e), to(#7db72f));
	background: -moz-linear-gradient(top,  #4e7d0e,  #7db72f);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#4e7d0e', endColorstr='#7db72f');
}
	</style>

</head>
<script type="text/javascript">	
$(function(){	
	var ue = UE.getEditor('content',{
	    initialFrameWidth:975,  //初始化编辑器宽度,默认1000
	    initialFrameHeight:200,//初始化编辑器高度,默认320
		});
	var id= new Array();
	var szhu= new Array();
	id = document.getElementsByName("imgid");
	
	for(var i=0;i<id.length;i++){
	if(szhu[i] = id[i].innerText){
	   var	a= document.getElementsByName("tt")[i];
		a.innerHTML='<img id=tp'+i+' />';	
	}
	}
	$.post(
			"/winner/imgs/"+szhu,
			function(msg){
            for(var i=0;i<msg.length;i++){
            	if(msg[i].id == szhu[i]){
            	$("#tp"+i+"").attr('src',msg[i].path+"/"+msg[i].fileName); 
            	}
            }
			}
			)
});
</script>
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

	<div class="main">
		


<div class="container helpCenter">
  <div align="center"><h2  style="color: #9D843F ">意见反馈</h2></div>
 <div>
 <table border="1" bgcolor="#EFF4FB">
 <c:forEach items="${feedbacklist}" var="f">
 <div style="display: none;" name="imgid" >${f.member.headid }</div>
  <tr>
 <td colspan="2" align="right">${f.createDate}</td>
 </tr>
 <tr bgcolor="#EFF4FB">
 <td bgcolor="#EFF4FB"><div class="p"> 名称： ${f.member.name}</div><div style="height: 100px;width:100px;" name="tt"></td>
 <td width="1000px;" bgcolor="#ECECEC"><span style="width: 80px;">&nbsp&nbsp&nbsp&nbsp</span> ${f.content}</td>
 </tr>
 </c:forEach>
 </table>
</div>
 <form  method="post">
 <b>${memberinfo.name} 请发表你的建议：</b>
 <br><br><div><script  name="content"  id="content" type="text/plain" style="width:1024px;height:500px;"></script></div></br></br>
 <div align="center"> 
 <input type="button"  value="发表" class="green" style="height: 30px;width: 100px;"   onclick="saveFeed(${memberinfo.id});" />
 </div>
 </form>
</div>
<div class="modal fade" id="fkui">  
  <div class="modal-dialog">  
    <div class="modal-content message_align">  
      <div class="modal-header">  
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>  
        <h4 class="modal-title">提示信息</h4>  
      </div>  
      <div class="modal-body">
        <p>请您登陆后反馈</p>  
      </div>  
      <div class="modal-footer">  
         <input type="hidden" id="url"/>  
         <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>  
      </div>
     </div><!-- /.modal-content -->  
  </div><!-- /.modal-dialog -->  
</div><!-- /.modal --> 
<script>

    var cid = "B8C8DD38-0805-4EF4-BFF6-17B835FCA8AA";
    var container = "#reports";

   

    $(document).ready(function () {
        var url = window.location.href.toLowerCase();
        if (url.indexOf("strategy") >= 0) {
          
            $("#strategyTab").click();
        } else if (url.indexOf("reports") >= 0) {
         
            $("#reportsTab").click();
        } else if (url.indexOf("lastest") >= 0) {
        
            $("#lastestTab").click();
        }
        else if (url.indexOf("zuixin") >= 0) {

        	$("#zuixinsTab").click();
        }
        else if (url.indexOf("topNews") >= 0) {

        	$("#topNewsTab").click();
        }
    });

    function pagation(pageIndex) {
        $.get("/allnews/" + cid + "/10/" + pageIndex, function (rel) {
            $(container).find("ul.newsList").html(rel);
        });
    }


    $(".helpCenter .left").on("click", ".item", function () {

        var className = $(this).attr("class");
        if (className.indexOf("active") >= 0) {
            return;
        } else {
            var idName = $(this).attr("name");
            $(".helpCenter .left .item").removeClass("active");
            $(this).addClass("active");
            $(".content").hide();
            var height = "";
            switch (idName) {
                case "strategy":
                    $("#strategy").show();
                    cid = "60573482-BDDC-445B-8557-3EF264552977";
                    container = "#strategy";
                    height = $("#strategy").css("height");
                    break;
                case "reports":
                    $("#reports").show();
                    cid = "B8C8DD38-0805-4EF4-BFF6-17B835FCA8AA";
                    container = "#reports";
                    height = $("#reports").css("height");
                    break;
                case "lastest":
                    $("#lastest").show();
                    cid = "DEF1B712-29AE-42E5-9A35-A5D163D6F384";
                    container = "#lastest";
                    height = $("#lastest").css("height");
                    break;
            	case "topNews":
            		$("#topNews").show();
            		cid = "C121BC77-2E19-4419-8B47-F4D568A3B34C";
            		container = "#topNews";
            		height = $("#topNews").css("height");
            		break;
            	case "zuixins":
            		$("#zuixins").show();
            		cid = "EE2E7057-881C-46B5-92AC-E9CE5D2E0FF8";
            		container = "#zuixins";
            		height = $("#zuixins").css("height");
            		break;
                default:
                    break;
            }

            height = height.split("px")[0];
            var blankHeight = (height - 120) + "px";
            $(".blank").css("height", blankHeight);

        }
    });
</script>

		<div class="container index">
			<div class="row">
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

				
			</div>
		</div>
	</div>

    <style type="text/css">
        .hzhb_box {float:left;  width:610px; margin-top:32px;}
        .hzhb_item {float:left;margin:5px;  border: solid 1px #aaa;border-radius:3px;}
        .hzhb_item img { width:120px; height:40px;}

        
        .ft_item{ float: left; width: 239px; }
        .ft_item_tit{ height: 28px; line-height: 28px; font-size: 20px; color: #ccc;padding-left:40px;}
        .ft_links_list{ margin-top: 10px;}
        .ft_links_list .ft_link{ height: 30px; line-height: 30px;}
        .ft_item_sns{ float:right;width: 340px;}
        .ft_sns_list{ margin-left:40px;}
        .ft_sns_list li{ float: left; width: 74px; margin: 5px;}
        .ft_sns_list a{ display: block; width: 74px;}
        .ft_sns_list .txt{ display: block; line-height: 32px; text-align: center; color:#ccc;}
        .ft_sns_list .ico_sns{ display: block; width: 62px; height: 62px; margin: 0 auto; background: url(/images/ft_sns.png) no-repeat;}
        .ft_sns_list .ico_weixin{ background-position: 0 0;}
        .ft_sns_list .ico_sinawb{ background-position: -63px 0;}
        .ft_sns_list .ico_txwb{ background-position: -126px 0;}
        .ft_sns_list a:hover .ico_sinawb{ background-position: -63px -63px;}
        .ft_sns_list a:hover .ico_txwb{ background-position: -126px -63px;}
        .ft_sns_list a:hover .txt{color:#3D9FE1}
        .ft_sns_list .wx_tips{ cursor: pointer; position: relative;}
        .ft_sns_list .wx_tips .tips_hd{}
        .ft_sns_list .wx_tips .tips_bd{ display: none; position: absolute; left: 90px; top: -10px;}
        .ft_sns_list .wx_tips .tips_bd .arrow{ width: 0; height: 0; overflow: hidden; border-color:transparent #fff transparent transparent;border-width:8px 8px 8px 8px;border-style:dashed solid dashed none; position: absolute; top: : -8px;}
        .ft_sns_list .wx_tips .tips_bd img{ width: 180px; height: 180px;}
        .ft_sns_list .wx_tips .tips_bd .txt{ font-size: 14px; line-height: 32px;  color: #3D9FE1;}
        .ft_sns_list .wx_tips:hover .ico_weixin{ background-position: 0 -63px;}
        .ft_sns_list .wx_tips:hover .txt{ color: #3D9FE1;}
        .ft_sns_list .wx_tips:hover .tips_bd{ display: block;}

    </style>

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
                <script type="text/javascript">
var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
                    document.write(unescape("%3Cspan id='cnzz_stat_icon_1255940205'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s11.cnzz.com/z_stat.php%3Fid%3D1255940205%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E"));
                </script><span id="cnzz_stat_icon_1255940205"><a href="http://www.cnzz.com/stat/website.php?web_id=1255940205" target="_blank" title="站长统计"><img border="0" hspace="0" vspace="0" src="/winner/files/pic1.gif"></a></span><script src="/winner/files/z_stat.php" type="text/javascript"></script><script src="/winner/files/core.php" charset="utf-8" type="text/javascript"></script>
				Copyright © 2010 - 2015 www..com All Rights Reserverd 襄阳市赢+理财股份有限公司 版权所有<br>
				鄂ICP备14030807号-3 襄阳市江干区钱江新城迪凯银座19F 4000-999-158
			</div>
		</div>
	</div>
	<div class="modal fade loginModal infoModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content" style="width:400px;">
				<div class="modal-header">
					<span>用户登录</span>
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
				</div>
				<div class="modal-body text-center">
					<div class="content" style="padding:20px 40px;">
						<input type="text" class="form-control" placeholder="用户名/手机/邮箱" id="modalUser"><br>
						<input type="password" class="form-control" placeholder="密码" id="modalPw">
					</div>
					<div>
						<button class="btn btn-primary" onclick="loginFromModal()" style="padding-left:20px;padding-right:20px;">登录</button>
						<a class="btn btn-info" href="http://www.ying158.com/Account/Regist" target="blank" style="padding-left:20px;padding-right:20px;margin-left:20px;">注册</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade loginInfo infoModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content" style="width:400px;">
				<div class="modal-header">
					<span>错误信息</span>
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
				</div>
				<div class="modal-body text-center">
					<div class="content" id="loginFail">
					</div>
					<button class="btn btn-primary confirmBtn" data-dismiss="modal">确认</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade infoModal" id="infosModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content" style="border-radius: 0px;width:400px;">
				<div class="modal-header">
					<span>通知</span>
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
				</div>
				<div class="modal-body">
					<div id="infosModalError"></div>
					<button class="btn btn-success confirmBtn" data-dismiss="modal">确认</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade infoModal" id="infosSuccessModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content" style="border-radius: 0px;width:400px;">
				<div class="modal-header">
					<span>通知</span>
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
				</div>
				<div class="modal-body">
					<div id="infosSuccessModalError"></div>
					<button class="btn btn-success confirmBtn" data-dismiss="modal">确认</button>
				</div>
			</div>
		</div>
	</div>

	<div id="feedbackModal" class="modal fade infoModal">
	<div data-bind="" class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<span>填写反馈</span>
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only"></span></button>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="feedbackForm">
					<div class="form-group">
						<div class="col-sm-12">
							

                            <select name="MsgType" class="form-control" id="MsgType" data-val-required="留言类型 字段是必需的。" data-val="true">
                                <option selected="selected" value="0">请选择反馈类型</option>
                                <option value="1">终止实盘结算申请</option>
                                <option value="6">追加保证金</option>
                                <option value="7">交易问题</option>
                                <option value="3">功能使用问题</option>
                                <option value="4">大额预约</option>
                                <option value="50">其他问题</option>
                            </select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<input type="text" class="form-control" id="contact" placeholder="请输入手机号或邮箱">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
                            <textarea class="form-control" id="content" placeholder="请填写你的用户名、实盘帐号并说明是结算申请还是追加保证金！"></textarea>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success" id="submitFeedback" onclick="submitFeedback();">提交</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	function submitFeedback() {
		var type = $('#feedbackForm #MsgType').val();
		var contact = $('#feedbackForm #contact').val();
		var content = $('#feedbackForm #content').val();
		$('#submitFeedback').attr('disabled', true);
		$.post('/api/feedback/create', { msgType: type, contact: contact, content: content }).done(function(res) {
			if (res.isSuccess) {
				alert('感谢您的反馈，我们会尽快给您做出答复！');
				$('#feedbackModal').modal('hide');
				$('#feedbackForm #contact').val('');
				$('#feedbackForm #content').val('');
			} else {
				alert(res.errorMessage);
			}
		}).always(function() {
			$('#submitFeedback').attr('disabled', false);
		});
	}
</script>

	<div id="bannedStockModal" class="modal fade infoModal">
	<div data-bind="" class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<span>今日限制购买的股票</span>
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only"></span></button>
			</div>
			<div class="modal-body">
				<div class="row">
							<span>今日暂时没有限购的股票</span>

				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn-straight" data-dismiss="modal" style="margin-top:initial;">确认</button>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">



	function showBannedStocks() {
		$('#bannedStockModal').modal('show');
	}
</script>


	<script>
		$("#aFloatTools_Show").click(function () {
			$('#divFloatToolsView').animate({ width: 'show', opacity: 'show' }, 100, function () { $('#divFloatToolsView').show(); });
			$('#aFloatTools_Show').hide();
			$('#aFloatTools_Hide').show();
		});
		$("#aFloatTools_Hide").click(function () {
			$('#divFloatToolsView').animate({ width: 'hide', opacity: 'hide' }, 100, function () { $('#divFloatToolsView').hide(); });
			$('#aFloatTools_Show').show();
			$('#aFloatTools_Hide').hide();
		});
		$('*[data-toggle="tooltip"]').tooltip();
		$(document).ready(function () {
			var href = window.location.href.toLowerCase();

			if (href.indexOf("/account/") >= 0) {
				$(".topNav li:eq(7)").addClass("active");

			} else if (href.indexOf("/home/help") >= 0) {

				$(".topNav li:eq(5)").addClass("active");

			} else if (href.indexOf("/home/kcenter") >= 0) {

				$(".topNav li:eq(1)").addClass("active");

			} else if (href.indexOf("/home/newscenter") >= 0 || href.indexOf("/news/") >= 0) {

				$(".topNav li:eq(3)").addClass("active");

			} else if (href.indexOf("/home/rule") >= 0) {

				$(".topNav li:eq(3)").addClass("active");

			} else if (href.indexOf("/tradingsoftware") >= 0) {

				$(".topNav li:eq(6)").addClass("active");

			} else if (href.indexOf("/gzpeizi") >= 0) {

				$(".topNav li:eq(2)").addClass("active");

			}
			else if (href.indexOf("jiameng") >= 0) {

				$(".topNav li:eq(4)").addClass("active");

			} else {

				$(".topNav li:eq(0)").addClass("active");
			}


		});
		var gotoTop = function () {
			$("html,body").animate({ scrollTop: 0 }, 1000);
		}
     
		function saveFeed(id){
			 if(id != null){
				document.forms[0].action="/winner/saveFeed/"+id;
				document.forms[0].submit();
			}else{
			$("#fkui").modal('show');
			} 
			}
	</script>



</body>
</html>