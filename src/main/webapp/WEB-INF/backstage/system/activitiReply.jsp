<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程审批</title>
   <link href="/winner/css/bootstrap.min.css" rel="stylesheet">
   <script src="/winner/js/jquery.min.js"></script>
   <script src="/winner/js/bootstrap.min.js"></script>
</head>
<br>
<body class="container">
	<table class="table table-hover table-condensed table-responsive">
		 <thead>
	      <tr>
	         <th>流程实例ID</th>
	         <th>提款银行账号</th>
	         <th>提款金额</th>
	         <th>申请人</th>
	         <th>操作</th>
	      </tr>
	   </thead>
	   <tbody>
	   		<c:forEach items="${listMaps }" var="list">
	   			<tr>
	   				<th>${list.processInstanceId }</th>
	   				<th>${list.bankCard }</th>
	   				<th>${list.withdrawAmount }</th>
	   				<th>${list.memberID }</th>
	   				<th>
	   					<button id="tg" class="btn btn-success" click="javascript:getThrough(${list.processInstanceId },${list.bankCard },${list.withdrawAmount },${list.memberID })">通过申请</button>
	   					<button id="bh" class="btn btn-link" click="javascript:reject(${list.processInstanceId })">驳回申请</button>
	   				</th>
	   			</tr>
	   		</c:forEach>
	   </tbody>
	</table>
	<script type="text/javascript">
		function getThrough(id,bankCard,withdrawAmount,memberID){
			$.post("/winner/system/getThrough/",
					{
					'id':id,
					'bankCard':bankCard,
					'withdrawAmount':withdrawAmount,
					'memberID':memberID
					},
					function(falg){
						if(falg){
							alert("操作成功");
						}else{
							alert("额，出现了点小问题");
						}
			});
		}
		function reject(id){
			$.post("/winner/system/reject/"+id,function(falg){
				if(falg){
					alert("操作成功");
				}else{
					alert("额，出现了点小问题");
				}
			});
		}
	</script>
</body>
</html>