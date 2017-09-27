<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" rel="stylesheet" href="winner/webapp/sscss/sushuang.css">

<link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss"> 
 <link rel="stylesheet" href="/winner/backstage/show/bootstrap.min.css">  
 
<title>提现管理</title>
<script type="text/javascript" src=/winner/sushuangjs/jquery.min.js></script>


 <script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
 
 
</head>


<script type="text/javascript">
	$(function(){
		$("#btn5").click(function(){
			document.forms[0].action="/winner/sushuang5/list5";
			document.forms[0].submit();
		});
		
		$("#cz").click(function(){
			document.forms[0].action="/winner/sushuang5/listcz5";
			document.forms[0].submit();
	})
	
	});
</script>

<body>
<form action="" method="post"  id="formId">
姓名：<input   type="text"  name="aname" value="${aname }">&nbsp;&nbsp;
手机号：<input  type="text"  name="aphone" value="${aphone }">&nbsp;&nbsp;
绑卡卡号：<input type="text"  name="anumber" value="${anumber }">&nbsp;&nbsp;
状态：<select  name="astatu" id="astatu">
<!--  <option value="${astatu }">${astatu }</option>  -->
<option value="" selected="selected">全部状态</option>
<option value="0">待审核</option>
<option value="1">已打款</option>
<option value="2">打款中</option>
<option value="3">打款失败</option>
</select><br><br>
提现时间：<input   type="date" name="adate" value="${adate }">&nbsp;&nbsp;
<input class="btn btn-primary" type="button" value="查询" id="btn5">

<input  class="btn btn-primary"  type="reset"   id="cz" value="重置">
<br><br>
<table width="1100" bgcolor="blue" cellspacing="1" border="0"  
class="table table-striped table-condensed table-condensed table-hover table-bordered">
<tr align="center" bgcolor="white">
<td>序号</td>
<td>手机号</td>
<td>姓名</td>
<td>身份证</td>
<td>提现金额</td>
<td>提现银行</td>
<td>提现卡号</td>
<td>提现开户行地址</td>
<td>提现状态</td>
<td>提现时间</td>
<td>账号详情</td>
<td>操作</td>
</tr>

<c:forEach items="${listwithdrawrecord}" var="listwith" varStatus="stat">
<tr align="center" bgcolor="white">
<td>${stat.index+1 }</td>
<td>${listwith.member.mobile_Phone }</td>   <!-- 手机号 -->
<td>${listwith.member.memberName }</td> <!-- 姓名 -->
<td>${listwith.member.identity }</td>  <!-- 身份证 -->
<td>${listwith.amount}</td>       <!-- 提现金额 -->
<td>${listwith.bankName }</td>    <!-- 提现银行 -->
<td>${listwith.bankCard }</td>    <!-- 提现卡号 -->
<td>${listwith.cardaddress }</td>   <!-- 体现开户行所在地 -->
<!-- 提现状态 -->   
<td><c:if test="${listwith.status == '0' }"><font color="red">待审核</font></c:if>
	<c:if test="${listwith.status == '1' }"><font color="green">已打款</font></c:if>
	<c:if test="${listwith.status == '2' }"><font color="blue">打款中</font></c:if>
	<c:if test="${listwith.status == '3' }"><font color="red">打款失败</font></c:if>
	</td>
<td>${listwith.createDate }</td>  <!-- 提现时间 -->
<td><a a href="/winner/sushuang1/getmemberId/${listwith.member.id }"  class="btn btn-primary" type="button">账号详情</a></td>
<!-- <td><a a href="/winner/sushuang7//getmemberaccountId/${listwith.id }"  class="btn btn-primary" type="button">账号详情</a></td> -->
<!-- /winner/sushuang1/getmemberId/${li.id } -->
<!-- <a href="WEB-INF/ssjsp/details"></a> -->
<td> <!-- 操作 -->
	<c:if test="${listwith.status == '1' }"><font color="green">已打款</font></c:if>
	<c:if test="${listwith.status == '2' }"><font color="blue">打款中</font></c:if>
	<c:if test="${listwith.status == '3' }"><font color="red">打款失败</font></c:if>
	<!-- 说明   点击审核按钮  弹出模态窗口    提交更改     审核按钮变成打款中       待审核也要变成打款中 -->
	<c:if test="${listwith.status == '0' }" >
	<button class="btn btn-primary" data-toggle="modal" onclick="mymodal(${listwith.id})">审核</button>
	 </c:if>
	</td>
</tr>
</c:forEach>
</table>
</form>

<!-- bootstrap模态窗口显示 -->
   <div class="modal fade " id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"  aria-hidden="true">×</button>
          
         </div>
          <h4 class="modal-title" id="myModalLabel">审核 </h4>
         <div class="modal-body">
         <select  >
     <option value="" selected="selected">全部</option>
     <option value="FUIOU">富友</option>
     <option value="BEIFU">贝付</option>
   
     </select>  </div>
     
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭  </button>
           <!--  <button type="submit" class="btn btn-primary"> 提交更改</button> --> 
         <button  class="btn btn-primary"  type="button"  id="btn" >提交更改</button>
       
         </div>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
   </div><!-- /.modal -->
    <script type="text/javascript">
 		function mymodal(id){ 			
 		//	alert("11111111111");
 			$("#myModal").modal("show");
 			//alert("222222");
 			$("#btn").click(function(){
 			//	alert("333333");
 				location="/winner/sushuang5/updatememberwithdraw5/"+id;
 			});
 			
 		}
	
</script>
 
  
</body>
</html>