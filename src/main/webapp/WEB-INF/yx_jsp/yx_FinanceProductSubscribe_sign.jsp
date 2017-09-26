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
<script type="text/javascript">
 function fun(obj){
   var money=obj.value;
   var year_rate=${fe3.financeProductFunds.yearRate};
   var period=${fe3.financeProductFunds.period};
   var num=((money*year_rate)/365)*period;
   $("#interest").val(parseFloat(num).toFixed(2));
} 
</script>${fe3.name}
<p><p><p><h4>▶&nbsp;签署合同</h4>
<form action="/winner/yx2/savesign/${id2}" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${fe3.id}">
<%-- <input type="hidden" name="" value="${fe3.member.id}"> --%>
<input type="hidden" name="name" value="${fe3.name}">
<input type="hidden" name="phone" value="${fe3.phone}">
<input type="hidden" name="addr" value="${fe3.addr}">
<input type="hidden" name="signedPhotos" value="${fe3.signedPhotos}">
<input type="hidden" name="comment" value="${fe3.comment}">
<input type="hidden"  name="startDate" value="${fe3.startDate}">
<input type="hidden"  name="member.id" value="${fe3.member.id}">
<input type="hidden" name="financeProductFunds.id" value="${fe3.financeProductFunds.id}">

<table border="0" width="100%">
<tr>
<td width="35%" align="right">真实姓名:&nbsp;&nbsp;&nbsp;&nbsp;</td><td width="45%"><input type="text" value="${fe3.member.name}" class="form-control" readonly="readonly"></td><td></td>
</tr>
<tr>
<td width="35%" align="right">身份证:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="text" value="${fe3.member.identity}"class="form-control" readonly="readonly"></td><td></td>
</tr>
<tr>
<td width="35%" align="right">购买金额:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="text"  name="amount" value="${fe3.amount}" onblur="fun(this)"   class="form-control"></td><td></td>
</tr>
<tr>
<td width="35%" align="right">利息收益:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="text"  id="interest" class="form-control" readonly="readonly"></td><td></td>
</tr>
<tr>
<td width="35%" align="right">开始时间:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="date" name="createDate" class="form-control"></td><td></td>
</tr>
<tr>
<td width="35%" align="right">截止时间:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="text" value="${endTime}"class="form-control" readonly="readonly"></td><td></td>
</tr>
<tr>
<td width="35%" align="right">私募合同:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="file" name="file_name" class="form-control"></td><td></td>
</tr>
<tr>
<td width="35%" align="right">风险提示书:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="file" name="file_name2" class="form-control"></td><td></td>
</tr>
<tr>
<td width="35%" align="right"></td><td colspan="2"><input type="submit" class="btn btn-primary" value="签署合同"></td>
</tr>
</table>
</form>

</body>
</html>