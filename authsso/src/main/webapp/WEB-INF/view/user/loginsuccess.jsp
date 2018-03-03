<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登录中心 </title>
<script language="javascript">
var secs = 3; //倒计时的秒数 
var URL ;
function Load(url){
URL = url;
for(var i=secs;i>=0;i--) 
{ 
   window.setTimeout('doUpdate(' + i + ')', (secs-i) * 1000); 
} 
}
function doUpdate(num) 
{ 
document.getElementById('ShowDiv').innerHTML = '将在'+num+'秒后自动跳转到主页' ;
if(num == 0) { window.location = URL; }
}
</script>
</head>
<body onload="Load('${completeurl}')"> 
<div>登录成功，即将跳转</div>
<div id="ShowDiv"></div>
<div><a href="${completeurl}">点我立即跳转</a></div>
</body>
</html>