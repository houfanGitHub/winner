<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单配置</title>
 <link href="/winner/css/bootstrap.min.css" rel="stylesheet">
   <script src="/winner/js/jquery.min.js"></script>
   <script src="/winner/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<input type="hidden" id="roleId" value="${roleId }">
	<table class="table table-bordered">
	   <thead>
	      <tr>
	         <th>主菜单</th>
	         <th>子菜单名称</th>
	      </tr>
	   </thead>
	   <tbody>
	      <tr>
	         <td><input type="checkbox" id="licai_mangere" name="permission_name" value="licai_mangere">理财管理</td>
	         <td><ul style="list-style-type:none">
	         	<li><input type="checkbox" id="licai_gsl_p2p_manager" name="permission_name" value="licai_gsl_p2p_manager">固收类/P2P</li>
	         	<li><input type="checkbox" id="licai_sml_p2p_manager" name="permission_name" value="licai_sml_p2p_manager">私募类</li>
	         	<li><input type="checkbox" id="licai_gql_p2p_manager" name="permission_name" value="licai_gql_p2p_manager">股权类</li>
	         </ul></td>
	      </tr>
	      <tr>
	         <td><input type="checkbox" id="qianbao_mangere" name="permission_name" value="qianbao_mangere">钱包管理</td>
	         <td><ul style="list-style-type:none">
	         <li><input type="checkbox" id="qianbao_sjczjl_manager" name="permission_name" value="qianbao_sjczjl_manager">钱包缴费记录</li>
	         </ul></td>
	      </tr>
	      <tr>
	         <td><input type="checkbox" id="xueyuan_mangere" name="permission_name" value="xueyuan_mangere">学院管理</td>
	         <td><ul style="list-style-type:none">
	         	<li><input type="checkbox" id="xueyuan_zxfl_manager" name="permission_name" value="xueyuan_zxfl_manager">资讯分类</li>
	         	<li><input type="checkbox" id="xueyuan_zxgl_manager" name="permission_name" value="xueyuan_zxgl_manager">资讯管理</li>
	         </ul></td>
	      </tr>
	      <tr>
	         <td><input type="checkbox" id="huiyuan_mangere" name="permission_name" value="huiyuan_mangere">会员管理</td>
	         <td><ul style="list-style-type:none">
	         	<li><input type="checkbox" id="huiyuan_zhgl_manager" name="permission_name" value="huiyuan_zhgl_manager">账户管理</li>
	         	<li><input type="checkbox" id="huiyuan_lcssh_manager" name="permission_name" value="huiyuan_lcssh_manager">理财师审核</li>
	         	<li><input type="checkbox" id="huiyuan_bkgl_manager" name="permission_name" value="huiyuan_bkgl_manager">绑卡管理</li>
	         	<li><input type="checkbox" id="huiyuan_fxjh_manager" name="permission_name" value="huiyuan_fxjh_manager">付息计划</li>
	         	<li><input type="checkbox" id="huiyuan_czgl_manager" name="permission_name" value="huiyuan_czgl_manager">充值管理</li>
	         	<li><input type="checkbox" id="huiyuan_txgl_manager" name="permission_name" value="huiyuan_txgl_manager">提现管理</li>
	         	<li><input type="checkbox" id="huiyuan_yqjl_manager" name="permission_name" value="huiyuan_yqjl_manager">邀请奖励</li>
	         </ul></td>
	      </tr>
	      <tr>
	         <td><input type="checkbox" id="yingjia_statistics" name="permission_name" value="yingjia_statistics">赢+统计</td>
	         <td><ul style="list-style-type:none">
	         	<li><input type="checkbox" id="yingjia_statistics_finance" name="permission_name" value="yingjia_statistics_finance">财务统计</li>
	         	<li><input type="checkbox" id="yingjia_statistics_user" name="permission_name" value="yingjia_statistics_user">用户综合统计</li>
	         </ul></td>
	      </tr>
	      <tr>
	         <td><input type="checkbox" id="yingjia_mangere" name="permission_name" value="yingjia_mangere">赢+设置</td>
	         <td><ul style="list-style-type:none">
	         	<li><input type="checkbox" id="yingjia_notice_manager" name="permission_name" value="yingjia_notice_manager">公告管理</li>
	         	<li><input type="checkbox" id="yingjia_yjfk_manager" name="permission_name" value="yingjia_yjfk_manager">意见反馈</li>
	         </ul></td>
	      </tr>
	      <tr>
	         <td><input type="checkbox" id="xitong_mangere" name="permission_name" value="xitong_mangere">系统设置</td>
	         <td><ul style="list-style-type:none">
	         	<li><input type="checkbox" id="xitong_userlist_manager" name="permission_name" value="xitong_userlist_manager">账户管理</li>
	         	<li><input type="checkbox" id="xitong_rolelist_manager" name="permission_name" value="xitong_rolelist_manager">角色设置</li>
	         	<li><input type="checkbox" id="xitong_psw_manager" name="permission_name" value="xitong_psw_manager">密码管理</li>
	         </ul></td>
	      </tr>
	   </tbody>
   </table>
   	<div class="row">
   		<div class="col-md-4"></div>
	   	<div class="col-md-8">
	   		<button class="btn btn-danger" onclick="updatePermission();">确定</button>
	   	</div>
   	</div>
   </div>
   
   <script type="text/javascript">
   		$(function(){
			var string = ${setPermission};
// 			alert(string);
			for (var i= 0; i< string.length; i++) {
					$("#"+string[i]).attr("checked",true);
			}
			
			$("#xitong_mangere").click(
					function(){
						if($("#xitong_mangere").is(":checked")){//如果不是选中状态
			 				$("#xitong_userlist_manager").attr("disabled",false);
			 				$("#xitong_rolelist_manager").attr("disabled",false);
			 				$("#xitong_psw_manager").attr("disabled",false);
			 			}else{
			 				$("#xitong_userlist_manager").attr("checked",false);
			 				$("#xitong_rolelist_manager").attr("checked",false);
			 				$("#xitong_psw_manager").attr("checked",false);
			 				
			 				$("#xitong_userlist_manager").attr("disabled",true);
							$("#xitong_rolelist_manager").attr("disabled",true);
							$("#xitong_psw_manager").attr("disabled",true);
			 			}
				});
			$("#yingjia_mangere").click(
					function(){
						if($("#yingjia_mangere").is(":checked")){//如果不是选中状态
			 				$("#yingjia_notice_manager").attr("disabled",false);
			 				$("#yingjia_yjfk_manager").attr("disabled",false);
			 			}else{
			 				$("#yingjia_notice_manager").attr("checked",false);
			 				$("#yingjia_yjfk_manager").attr("checked",false);
			 				
			 				$("#yingjia_notice_manager").attr("disabled",true);
							$("#yingjia_yjfk_manager").attr("disabled",true);
			 			}
				});
			$("#yingjia_statistics").click(
					function(){
						if($("#yingjia_statistics").is(":checked")){//如果不是选中状态
			 				$("#yingjia_statistics_finance").attr("disabled",false);
			 				$("#yingjia_statistics_user").attr("disabled",false);
			 			}else{
			 				$("#yingjia_statistics_finance").attr("checked",false);
			 				$("#yingjia_statistics_user").attr("checked",false);
			 				
			 				$("#yingjia_statistics_finance").attr("disabled",true);
							$("#yingjia_statistics_user").attr("disabled",true);
			 			}
				});
			$("#licai_mangere").click(
					function(){
						if($("#licai_mangere").is(":checked")){//如果不是选中状态
			 				$("#licai_gsl_p2p_manager").attr("disabled",false);
			 				$("#licai_sml_p2p_manager").attr("disabled",false);
			 				$("#licai_gql_p2p_manager").attr("disabled",false);
			 			}else{
			 				$("#licai_gsl_p2p_manager").attr("checked",false);
			 				$("#licai_sml_p2p_manager").attr("checked",false);
			 				$("#licai_gql_p2p_manager").attr("checked",false);
			 				
			 				$("#licai_gsl_p2p_manager").attr("disabled",true);
							$("#licai_sml_p2p_manager").attr("disabled",true);
							$("#licai_gql_p2p_manager").attr("disabled",true);
			 			}
				});
			$("#qianbao_mangere").click(
					function(){
						if($("#qianbao_mangere").is(":checked")){//如果不是选中状态
			 				$("#qianbao_sjczjl_manager").attr("disabled",false);
			 			}else{
			 				$("#qianbao_sjczjl_manager").attr("checked",false);
			 				
			 				$("#qianbao_sjczjl_manager").attr("disabled",true);
			 			}
				});
			$("#xueyuan_mangere").click(
					function(){
						if($("#xueyuan_mangere").is(":checked")){//如果不是选中状态
			 				$("#xueyuan_zxfl_manager").attr("disabled",false);
			 				$("#xueyuan_zxgl_manager").attr("disabled",false);
			 			}else{
			 				$("#xueyuan_zxfl_manager").attr("checked",false);
			 				$("#xueyuan_zxgl_manager").attr("checked",false);
			 				
			 				$("#xueyuan_zxfl_manager").attr("disabled",true);
							$("#xueyuan_zxgl_manager").attr("disabled",true);
			 			}
				});
			$("#huiyuan_mangere").click(
					function(){
						if($("#huiyuan_mangere").is(":checked")){//如果不是选中状态
			 				$("#huiyuan_zhgl_manager").attr("disabled",false);
			 				$("#huiyuan_bkgl_manager").attr("disabled",false);
			 				$("#huiyuan_fxjh_manager").attr("disabled",false);
			 				$("#huiyuan_lcssh_manager").attr("disabled",false);
			 				$("#huiyuan_txgl_manager").attr("disabled",false);
			 				$("#huiyuan_yqjl_manager").attr("disabled",false);
			 				$("#huiyuan_czgl_manager").attr("disabled",false);
			 				
			 			}else{
			 				$("#huiyuan_zhgl_manager").attr("checked",false);
			 				$("#huiyuan_bkgl_manager").attr("checked",false);
			 				$("#huiyuan_fxjh_manager").attr("checked",false);
			 				$("#huiyuan_lcssh_manager").attr("checked",false);
			 				$("#huiyuan_txgl_manager").attr("checked",false);
			 				$("#huiyuan_yqjl_manager").attr("checked",false);
			 				$("#huiyuan_czgl_manager").attr("checked",false);
			 				
			 				
			 				$("#huiyuan_zhgl_manager").attr("disabled",true);
			 				$("#huiyuan_bkgl_manager").attr("disabled",true);
			 				$("#huiyuan_fxjh_manager").attr("disabled",true);
			 				$("#huiyuan_lcssh_manager").attr("disabled",true);
			 				$("#huiyuan_txgl_manager").attr("disabled",true);
			 				$("#huiyuan_yqjl_manager").attr("disabled",true);
			 				$("#huiyuan_czgl_manager").attr("disabled",true);
							
			 			}
				});
		});
   </script>
   <script type="text/javascript" language="javascript">
   		function updatePermission(){
   			obj = document.getElementsByName("permission_name");
   		    check_val = [];
   		    for(k in obj){
   		        if(obj[k].checked)
   		            check_val.push(obj[k].value);
   		    }
//    		    alert(check_val);
   		    $.post("/winner/system/updatePermission/"+check_val,
   		    		{roleId:$("#roleId").val()},
   		    		function(falg){
   		    		if(falg){
   		    			alert("权限修改成功");
   		    			window.parent.document.getElementById("userRole").click();
   		    		}else{
   		    			alert("权限修改失败");
   		    		}
   		    });
   		}
   </script>
</body>
</html>