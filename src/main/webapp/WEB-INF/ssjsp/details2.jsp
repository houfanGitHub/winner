<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="sscss/bootstrap.min.css" rel="stylesheet"/>

<script type="text/javascript" src="sushuangjs/bootstrap.min.js"></script>
<script type="text/javascript" src="sushuangjs/jquery.min.js"></script>


<script type="text/javascript" src="sushuangjs/bootstrap.min.js"></script>
<script type="text/javascript" src="sushuangjs/jquery.min.js"></script>
<title>账号详情</title>
<script type="text/javascript" src=/winner/sushuangjs/jquery.min.js></script>

<script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
</head>

<body>
			<!-- class="table table-striped table-hover" -->
	<table  border="0" width="600px"  style="text-align: center;font-size: 6">
	<thead>
		<tr>
			<td><font color="black">
			<strong>姓名:${member.memberName }</strong></font></td>
		</tr>
		<br><br>
		<tr>
			<td>用户名:${member.name }</td>
		</tr>
		<br><br>
		<tr>
			<td>电话:${member.mobile_Phone }</td>
		</tr>
		<br><br>
		<tr>
			<td>身份证:${member.identity }</td>
		</tr>
		<br><br>
		<tr>
			<td>创建时间:${member.createDate }</td>
		</tr>
		<br><br>
		<tr>
			<td>邀请码:${member.invitationCode }</td>
		</tr>
		<br><br>
		<tr>
			<td>被邀请码:${member.invitedCode }</td>
		</tr>
	</thead>	
	</table>
		
</body>
</html>