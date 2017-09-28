<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>签署合同</title>
<link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss"> 
 <link rel="stylesheet" href="/winner/backstage/show/bootstrap.min.css">  
</head>
<script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
<body>
<p><p><p><h4>▶&nbsp;签署合同</h4>
<table border="1" width="100%">
<tr>
<td width="35%" align="right">真实姓名:&nbsp;&nbsp;&nbsp;&nbsp;</td><td width="45%"><input type="text" value="${fe3.member.name}" class="form-control" readonly="readonly"></td><td></td>
</tr>
<tr>
<td width="35%" align="right">身份证:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="text" value="${fe3.member.identity}"class="form-control" readonly="readonly"></td><td></td>
</tr>
<tr>
<td width="35%" align="right">购买金额:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="text" value="${fe3.member.identity}"class="form-control" readonly="readonly"></td><td></td>
</tr>
<tr>
<td width="35%" align="right">利息收益:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="text" value="${fe3.member.identity}"class="form-control" readonly="readonly"></td><td></td>
</tr>
<tr>
<td width="35%" align="right">开始时间:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="text" value="${fe3.financeProductFunds.startDate}"class="form-control" readonly="readonly"></td><td></td>
</tr>
<tr>
<td width="35%" align="right">截止时间:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="text" value="${str}"class="form-control" readonly="readonly"></td><td></td>
</tr>
<tr>
<td width="35%" align="right">私募合同:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="text" value="${fe3.member.identity}"class="form-control" readonly="readonly"></td><td></td>
</tr>
<tr>
<td width="35%" align="right">风险提示书:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="text" value="${fe3.member.identity}"class="form-control" readonly="readonly"></td><td></td>
</tr>
</table>


</body>
</html>