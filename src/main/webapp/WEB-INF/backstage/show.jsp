<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>赢+官网网站后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/winner/backstage/show/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="/winner/backstage/show/font-awesome.min.css">
<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
<link rel="stylesheet" href="/winner/backstage/show/ace.min.css">
<link rel="stylesheet" href="/winner/backstage/show/ace-rtl.min.css">
<link rel="stylesheet" href="/winner/backstage/show/ace-skins.min.css">
<link rel="stylesheet" href="/winner/backstage/show/style.css">
<script src="/winner/backstage/show/ace-extra.min.js"></script>
<script src="/winner/backstage/show/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	if ("ontouchend" in document)
		document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
				+ "<"+"script>");
</script>
<script src="/winner/backstage/show/bootstrap.min.js"></script>
<script src="/winner/backstage/show/typeahead-bs2.min.js"></script>
<script src="/winner/backstage/show/ace-elements.min.js"></script>
<script src="/winner/backstage/show/ace.min.js"></script>
<script src="/winner/backstage/show/layer.js" type="text/javascript"></script>
<link rel="stylesheet" href="/winner/backstage/show/layer.css"
	id="layui_layer_skinlayercss">
<script src="/winner/backstage/show/laydate.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet"
	href="/winner/backstage/show/laydate.css">
<link type="text/css" rel="stylesheet"
	href="/winner/backstage/show/laydate(1).css" id="LayDateSkin">
<script src="/winner/backstage/show/jquery.nicescroll.js"
	type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		var cid = $('#nav_list> li>.submenu');
		cid.each(function(i) {
			$(this).attr('id', "Sort_link_" + i);

		})
	})
	jQuery(document)
			.ready(
					function() {
						$.each($(".submenu"), function() {
							var $aobjs = $(this).children("li");
							var rowCount = $aobjs.size();
							var divHeigth = $(this).height();
							$aobjs.height(divHeigth / rowCount);
						});
						//初始化宽度、高度

						$("#main-container").height($(window).height() - 76);
						$("#iframe").height($(window).height() - 140);

						$(".sidebar").height($(window).height() - 99);
						var thisHeight = $("#nav_list").height(
								$(window).outerHeight() - 173);
						$(".submenu").height();
						$("#nav_list").children(".submenu").css("height",
								thisHeight);

						//当文档窗口发生改变时 触发  
						$(window).resize(
								function() {
									$("#main-container").height(
											$(window).height() - 76);
									$("#iframe").height(
											$(window).height() - 140);
									$(".sidebar").height(
											$(window).height() - 99);

									var thisHeight = $("#nav_list").height(
											$(window).outerHeight() - 173);
									$(".submenu").height();
									$("#nav_list").children(".submenu").css(
											"height", thisHeight);
								});
						$(document)
								.on(
										'click',
										'.iframeurl',
										function() {
											var cid = $(this).attr("name");
											var cname = $(this).attr("title");
											$("#iframe").attr("src", cid)
													.ready();
											$("#Bcrumbs").attr("href", cid)
													.ready();
											$(".Current_page a").attr('href',
													cid).ready();
											$(".Current_page")
													.attr('name', cid);
											$(".Current_page").html(cname).css(
													{
														"color" : "#333333",
														"cursor" : "default"
													}).ready();
											$("#parentIframe")
													.html(
															'<span class="parentIframe iframeurl"> </span>')
													.css("display", "none")
													.ready();
											$("#parentIfour").html('').css(
													"display", "none").ready();
										});

					});
	/******/
	$(document).on('click', '.link_cz > li', function() {
		$('.link_cz > li').removeClass('active');
		$(this).addClass('active');
	});
	/*******************/
	//jQuery( document).ready(function(){
	//	  $("#submit").click(function(){
	//	// var num=0;
	//     var str="";
	//     $("input[type$='password']").each(function(n){
	//          if($(this).val()=="")
	//          {
	//              // num++;
	//			   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
	//                title: '提示框',				
	//				icon:0,				
	//          }); 
	//             // layer.msg(str+=""+$(this).attr("name")+"不能为空！\r\n");
	//             layer.close(index);
	//          }		  
	//     });    
	//})		
	//	});
	/*********************点击事件*********************/
	$(document).ready(function() {
		$('#nav_list,.link_cz').find('li.home').on('click', function() {
			$('#nav_list,.link_cz').find('li.home').removeClass('active');
			$(this).addClass('active');
		});
		//时间设置
		function currentTime() {
			var d = new Date(), str = '';
			str += d.getFullYear() + '年';
			str += d.getMonth() + 1 + '月';
			str += d.getDate() + '日';
			str += d.getHours() + '时';
			str += d.getMinutes() + '分';
			str += d.getSeconds() + '秒';
			return str;
		}

		setInterval(function() {
			$('#time').html(currentTime)
		}, 1000);
		$('#Exit_system').on('click', function() {
			layer.confirm('是否确定退出系统？', {
				btn : [ '是', '否' ],//按钮
				icon : 2,
			}, function() {
				location.href = "/winner/itemweb/logout";
			});
		});
	});
	function link_operating(name, title) {
		var cid = $(this).name;
		var cname = $(this).title;
		$("#iframe").attr("src", cid).ready();
		$("#Bcrumbs").attr("href", cid).ready();
		$(".Current_page a").attr('href', cid).ready();
		$(".Current_page").attr('name', cid);
		$(".Current_page").html(cname).css({
			"color" : "#333333",
			"cursor" : "default"
		}).ready();
		$("#parentIframe")
				.html('<span class="parentIframe iframeurl"> </span>').css(
						"display", "none").ready();
		$("#parentIfour").html('').css("display", "none").ready();

	}
</script>
</head>
<body>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>
		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="http://www.erdangjiade.com/" class="navbar-brand"> <small>
						<img src="/winner/backstage/show/logo.png" width="210px">
				</small>
				</a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->
			<div class="navbar-header operating pull-left"></div>
			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue"><a data-toggle="dropdown"
						href="http://www.erdangjiade.com/" class="dropdown-toggle"> <span
							class="time"><em id="time">2017年9月11日9时27分39秒</em></span><span
							class="user-info"><small>欢迎光临,</small>超级管理员</span> <i
							class="icon-caret-down"></i>
					</a>
						<ul
							class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="javascript:void(0" name="Systems.html"
								title="系统设置" class="iframeurl"><i class="icon-cog"></i>网站设置</a></li>
							<li><a href="javascript:void(0)" name="admin_info.html"
								title="个人信息" class="iframeurl"><i class="icon-user"></i>个人资料</a></li>
							<li class="divider"></li>
							<li><a href="javascript:ovid(0)" id="Exit_system"><i
									class="icon-off"></i>退出</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="main-container" id="main-container" style="height: 533px;">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler"
				href="http://www.erdangjiade.com/"> <span class="menu-text"></span>
			</a>
			<div class="sidebar" id="sidebar" style="height: 510px;">
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'fixed')
					} catch (e) {
					}
				</script>
				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<a class="btn btn-success"> <i class="icon-signal"></i>
						</a> <a class="btn btn-info"> <i class="icon-pencil"></i>
						</a> <a class="btn btn-warning"> <i class="icon-group"></i>
						</a> <a class="btn btn-danger"> <i class="icon-cogs"></i>
						</a>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span> <span class="btn btn-info"></span>

						<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
					</div>
				</div>
				<!-- #sidebar-shortcuts -->
				<div id="menu_style" class="menu_style" tabindex="5000"
					style="overflow: hidden; outline: none;">
					<ul class="nav nav-list" id="nav_list" style="height: 436px;">
						<li class="home"><a href="javascript:void(0)"
							name="home.html" class="iframeurl" title=""><i
								class="icon-home"></i><span class="menu-text"> 系统首页 </span></a></li>
						<li><a href="#" class="dropdown-toggle"><i
								class="icon-desktop"></i><span class="menu-text"> 理财管理 </span><b
								class="arrow icon-angle-down"></b></a>
							<ul class="submenu" id="Sort_link_0">
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/yx/list" title="固收类"
									class="iframeurl"><i class="icon-double-angle-right"></i>固收类</a></li>
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/yx2/list2"
									title="私募/股权类" class="iframeurl"><i
										class="icon-double-angle-right"></i>私募/股权类</a></li>
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/yx3/list3" title="海外配置"
									class="iframeurl"><i class="icon-double-angle-right"></i>海外配置</a></li>


						</ul>
					</li>
					<li>
						<li><a href="http://www.erdangjiade.com/"
							class="dropdown-toggle"><i class="icon-list"></i><span
								class="menu-text"> 学院管理 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu" id="Sort_link_2">
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/listNewsType" title="资讯分类"
									class="iframeurl"><i class="icon-double-angle-right"></i>资讯分类</a></li>
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/listNews" title="资讯管理"
									class="iframeurl"><i class="icon-double-angle-right"></i>资讯管理</a></li>
							</ul></li>
						<li><a href="http://www.erdangjiade.com/"
							class="dropdown-toggle"><i class="icon-credit-card"></i><span
								class="menu-text"> 会员管理 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu" id="Sort_link_3">
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/sushuang1/list1"
									title="账户管理" class="iframeurl"><i
										class="icon-double-angle-right"></i>账户管理</a></li>
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/sushuang3/list3"
									title="绑卡管理" class="iframeurl"><i
										class="icon-double-angle-right"></i>绑卡管理</a></li>
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/sushuang8/list8"
									title="付息计划" class="iframeurl"><i
										class="icon-double-angle-right"></i>付息计划</a></li>
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/sushuang4/list4"
									title="充值管理" class="iframeurl"><i
										class="icon-double-angle-right"></i>充值管理</a></li>
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/sushuang5/list5"
									title="提现管理" class="iframeurl"><i
										class="icon-double-angle-right"></i>提现管理</a></li>
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/sushuang6/list6"
									title="邀请奖励" class="iframeurl"><i
										class="icon-double-angle-right"></i>邀请奖励</a></li>
							</ul></li>
						<li><a href="http://www.erdangjiade.com/"
							class="dropdown-toggle"><i class="icon-user"></i><span
								class="menu-text"> 赢+统计 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu" id="Sort_link_4">
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="user_list.html" title="财务统计"
									class="iframeurl"><i class="icon-double-angle-right"></i>财务统计</a></li>
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="member-Grading.html"
									title="用户综合统计" class="iframeurl"><i
										class="icon-double-angle-right"></i>用户综合统计</a></li>
								<!--                     <li class="home" style="height: 36px;"><a href="javascript:void(0)" name="integration.html" title="会员记录管理" class="iframeurl"><i class="icon-double-angle-right"></i>会员记录管理</a></li> -->


							</ul></li>
						<li><a href="http://www.erdangjiade.com/"
							class="dropdown-toggle"><i class="icon-laptop"></i><span
								class="menu-text"> 赢+设置 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu" id="Sort_link_5">
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/listPushNotice" title="公告管理"
									class="iframeurl"><i class="icon-double-angle-right"></i>公告管理</a></li>
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/listFeedback" title="意见反馈"
									class="iframeurl"><i class="icon-double-angle-right"></i>意见反馈<span
										class="badge badge-danger">5</span></a></li>
							</ul></li>
						<li><a href="http://www.erdangjiade.com/"
							class="dropdown-toggle"><i class="icon-comments-alt"></i><span
								class="menu-text"> 系统设置 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu" id="Sort_link_6">
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/system/users"
									id="usersid" title="账户设置" class="iframeurl"><i
										class="icon-double-angle-right"></i>账户设置</a></li>
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/system/roles"
									id="userRole" title="角色设置" class="iframeurl"><i
										class="icon-double-angle-right"></i>角色设置</a></li>
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/system/toActivitiReply"
									id="tk" title="角色设置" class="iframeurl"><i
										class="icon-double-angle-right"></i>提款审批</a></li>
								<li class="home" style="height: 36px;"><a
									href="javascript:void(0)" name="/winner/system/toPasswords"
									title="密码设置" class="iframeurl"><i
										class="icon-double-angle-right"></i>密码设置</a></li>
							</ul></li>
					</ul>
				</div>
				<script type="text/javascript">
					$("#menu_style").niceScroll({
						cursorcolor : "#888888",
						cursoropacitymax : 1,
						touchbehavior : false,
						cursorwidth : "5px",
						cursorborder : "0",
						cursorborderradius : "5px"
					});
				</script>
				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'collapsed')
					} catch (e) {
					}
				</script>
			</div>

			<div class="main-content">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="#">首页</a></li>
						<li class="active"><span class="Current_page iframeurl"></span></li>
						<li class="active" id="parentIframe"><span
							class="parentIframe iframeurl"></span></li>
						<li class="active" id="parentIfour"><span
							class="parentIfour iframeurl"></span></li>
					</ul>
				</div>

				<iframe id="iframe"
					style="border: 0px; width: 100%; background-color: rgb(255, 255, 255); height: 469px;"
					name="iframe" frameborder="0"
					src="/winner/backstage/show/home.html"> </iframe>


				<!-- /.page-content -->
			</div>
			<!-- /.main-content -->

			<div class="ace-settings-container" id="ace-settings-container">
				<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
					id="ace-settings-btn">
					<i class="icon-cog bigger-150"></i>
				</div>

				<div class="ace-settings-box" id="ace-settings-box">
					<div>
						<div class="pull-left">
							<select id="skin-colorpicker" class="hide" style="display: none;">
								<option data-skin="default" value="#438EB9">#438EB9</option>
								<option data-skin="skin-1" value="#222A2D">#222A2D</option>
								<option data-skin="skin-2" value="#C6487E">#C6487E</option>
								<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
							</select>
							<div class="dropdown dropdown-colorpicker">
								<a data-toggle="dropdown" class="dropdown-toggle"
									href="http://www.erdangjiade.com/"><span
									class="btn-colorpicker" style="background-color: #438EB9"></span></a>
								<ul class="dropdown-menu dropdown-caret">
									<li><a class="colorpick-btn selected"
										href="http://www.erdangjiade.com/"
										style="background-color: #438EB9;" data-color="#438EB9"></a></li>
									<li><a class="colorpick-btn"
										href="http://www.erdangjiade.com/"
										style="background-color: #222A2D;" data-color="#222A2D"></a></li>
									<li><a class="colorpick-btn"
										href="http://www.erdangjiade.com/"
										style="background-color: #C6487E;" data-color="#C6487E"></a></li>
									<li><a class="colorpick-btn"
										href="http://www.erdangjiade.com/"
										style="background-color: #D0D0D0;" data-color="#D0D0D0"></a></li>
								</ul>
							</div>
						</div>
						<span>&nbsp; 选择皮肤</span>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-sidebar"> <label class="lbl"
							for="ace-settings-sidebar"> 固定滑动条</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-rtl"> <label class="lbl"
							for="ace-settings-rtl">切换到左边</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-add-container"> <label class="lbl"
							for="ace-settings-add-container"> 切换窄屏 <b></b>
						</label>
					</div>
				</div>
			</div>
			<!-- /#ace-settings-container -->
		</div>
		<!-- /.main-container-inner -->

	</div>
	<div id="ascrail2000" class="nicescroll-rails"
		style="width: 5px; z-index: auto; cursor: default; position: absolute; top: 116px; left: 184px; height: 436px; opacity: 0;">
		<div
			style="position: relative; top: 0px; float: right; width: 5px; height: 433px; background-color: rgb(136, 136, 136); border: 0px; background-clip: padding-box; border-radius: 5px;"></div>
	</div>
	<div id="ascrail2000-hr" class="nicescroll-rails"
		style="height: 5px; z-index: auto; top: 547px; left: 0px; position: absolute; cursor: default; display: none; width: 184px; opacity: 0;">
		<div
			style="position: relative; top: 0px; height: 5px; width: 189px; background-color: rgb(136, 136, 136); border: 0px; background-clip: padding-box; border-radius: 5px;"></div>
	</div>
	<!--底部样式-->

	<div class="footer_style" id="footerstyle">
		<script type="text/javascript">
			try {
				ace.settings.check('footerstyle', 'fixed')
			} catch (e) {
			}
		</script>
		<p class="l_f">版权所有：赢+ 豫ICP备14018001号-1</p>
		<p class="r_f">地址：上海松江区泽悦路211弄17号1104室 邮编：210011 技术支持：XXXX</p>
	</div>

</body>
</html>
