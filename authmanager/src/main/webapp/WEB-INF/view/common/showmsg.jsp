<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提示消息</title>
<title>系统权限管理中心-提示消息</title>
<script>
	//var timer = setInterval('tourl()', 1000);
	function tourl() {
		var t = document.getElementById("intervalnum");
		time = t;
		if (time > 0) {
			t.innerHTML = time;
			time--;
		} else {
			clearInterval(timer);
			location.href = document.getElementById("tourl").getAttribute(
					"href");
		}
	}
</script>
</head>
<body>
	<div>
		<h3>提示</h3>
		<h2>${viewdata.msg}</h2>
		<font id="intervalnum" size="7"><%=request.getParameter("intervalnum")%></font>秒钟跳转<a
			id="tourl" href="<%=request.getParameter("tourl")%>">或点击我直接跳转</a>
	</div>
</body>
</html>