<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>赢+官网网站后台登陆平台</title>
<script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
<script type='text/javascript'>  
        var code ; //在全局定义验证码    
        $(function(){
        	createCode();
        });
        function createCode(){  
            code = "";     
            var codeLength = 4;//验证码的长度    
            var checkCode = document.getElementById("code");     
            var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',    
            'S','T','U','V','W','X','Y','Z');//随机数    
            for(var i = 0; i < codeLength; i++) {//循环操作    
               var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35）    
               code += random[index];//根据索引取得随机数加到code上    
           }    
           checkCode.value = code;//把code值赋给验证码    
       }
        $(function(){
        	if("${name}"!=""&&"${password}"!=""){
        		$("#name").val("${name}");
        		$("#password").val("${password}");
        	}
        });
        //校验验证码    
        function validate(){  
            var inputCode = document.getElementById("input").value.toUpperCase(); //取得输入的验证码并转化为大写          
            if(inputCode.length <= 0) { //若输入的验证码长度为0 
            	$("#uspa").hide();
            	$("#errorMsg").hide();
            	$("#yzmError").hide();
            	$("#yzmNull").show();
                return false;
            }else if(inputCode != code ) { //若输入的验证码与产生的验证码不一致时  
            	$("#uspa").hide();
            	$("#errorMsg").hide();
            	$("#yzmNull").hide();
            	$("#yzmError").show();
                createCode();//刷新验证码    
                document.getElementById("input").value = "";//清空文本框 
                return false;
            } 
            return true;
        }  
        function toSubmit(){
    		var name = $("#name").val();
    		var password = $("#password").val();
    		if(name==""||password==""){
    			$("#errorMsg").hide();
    			$("#uspa").show();
    			return;
    		}
    		if(!validate()){
    			return;
    		}
    		document.forms[0].submit();
    	}
    	function toCline(){
    		document.forms[0].reset();
    	}
        </script>  
        <style type='text/css'>  
        #code{  
            font-family:Arial,宋体;  
            font-style:italic;  
            color:green;  
            border:0;  
            padding:2px 3px;  
            letter-spacing:3px;  
            font-weight:bolder;  
        }  
        </style> 
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
        <td height="318" background="/winner/backstage/images/login_02.gif">&nbsp;</td>
      </tr>
      <tr>
        <td height="84"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="381" height="84" background="/winner/backstage/images/login_06.gif" align="right">
            <span id="yzmError" style="display:none">
            	<font color="#CC3333" size="-2">验证码错误</font>
            </span>
            <span id="yzmNull" style="display:none">
            	<font color="#CC3333" size="-2">验证码不能为空</font>
            </span>
            <span id="errorMsg">
           	 	<font color="#CC3333" size="-2">${errorMsg }</font>
            </span>
            <span id="uspa" style="display:none">
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
	                <td width="52" height="24" valign="bottom"><input type="text" name="textfield3" id="input" style="width:53px; height:17px; background-color:#87adbf; border:solid 1px #153966; font-size:12px; color:#283439; "></td>
	                <td width="62" valign="bottom"><div align="left"><input type="button" id="code" onclick="createCode()" style="width:50px;height:20px" title='点击更换验证码' /></div></td>
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
</body>
</html>