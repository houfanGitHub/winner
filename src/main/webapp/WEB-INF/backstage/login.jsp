<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>赢+官网网站后台登陆平台</title>
<script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
}
.STYLE3 {font-size: 12px; color: #adc9d9; }
-->
</style></head>

<body>
<table width="100%"  height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td bgcolor="#1075b1">&nbsp;</td>
  </tr>
  <tr>
    <td height="608" background="/winner/backstage/images/login_03.gif"><table width="847" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="318" background="/winner/backstage/images/login_04.gif">&nbsp;</td>
      </tr>
      <tr>
        <td height="84"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="381" height="84" background="/winner/backstage/images/login_06.gif" align="right">
            <span id="uspa" style="display:none">
            ${errorMsg }<br>
            <font color="#CC3333" size="-2">账号或密码不能为空</font>
            </span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td width="162" valign="middle" background="/winner/backstage/images/login_07.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              
              <form action="/winner/itemweb/backstageUserLogin" method="post">
            
              	<tr>
	                <td width="44" height="24" valign="bottom"><div align="right"><span class="STYLE3">用户</span></div></td>
	                <td width="10" valign="bottom">&nbsp;</td>
	                <td height="24" colspan="2" valign="bottom">
	                  <div align="left">
	                    <input type="text" name="name" id="name" style="width:100px; height:17px; background-color:#87adbf; border:solid 1px #153966; font-size:12px; color:#283439; ">
	                  </div></td>
	              </tr>
	              <tr>
	                <td height="24" valign="bottom"><div align="right"><span class="STYLE3">密码</span></div></td>
	                <td width="10" valign="bottom">&nbsp;</td>
	                <td height="24" colspan="2" valign="bottom"><input type="password" name="password" id="password" style="width:100px; height:17px; background-color:#87adbf; border:solid 1px #153966; font-size:12px; color:#283439; "></td>
	              </tr>
	              <tr>
	                <td height="24" valign="bottom"><div align="right"><span class="STYLE3">验证码</span></div></td>
	                <td width="10" valign="bottom">&nbsp;</td>
	                <td width="52" height="24" valign="bottom"><input type="text" name="textfield3" id="textfield3" style="width:50px; height:17px; background-color:#87adbf; border:solid 1px #153966; font-size:12px; color:#283439; "></td>
	                <td width="62" valign="bottom"><div align="left"><img src="/winner/backstage/images/yzm.gif" width="38" height="15"></div></td>
	              </tr>
              </form>
             
              <tr></tr>
            </table></td>
            <td width="26"><img src="/winner/backstage/images/login_08.gif" width="26" height="84"></td>
            <td width="67" background="/winner/backstage/images/login_09.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="25"><div align="center"><img id="dl" src="/winner/backstage/images/dl.gif" width="57" height="20" onclick="toSubmit();"></div></td>
              </tr>
              <tr>
                <td height="25"><div align="center"><img id="cz" src="/winner/backstage/images/cz.gif" width="57" height="20" oncick="toCline();"></div></td>
              </tr>
            </table></td>
            <td width="211" background="/winner/backstage/images/login_10.gif">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="206" background="/winner/backstage/images/login_11.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="#152753">&nbsp;</td>
  </tr>
</table>
<script type="text/javascript">
	function toSubmit(){
		var name = $("#name").val();
		var password = $("#password").val();
		if(name==""||password==""){
			$("#uspa").show();
			return;
		}
		document.forms[0].submit();
	}
	function toCline(){
		document.forms[0].reset();
	}
</script>
</body>
</html>