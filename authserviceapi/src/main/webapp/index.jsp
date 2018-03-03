<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>系统权限管理中心</title>
	<link rel="stylesheet" href="common/bootstrap/css/bootstrap.css">
	<script src="content/jquery-3.2.1.min.js"></script>
	<script src="content/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div>
获取授权中心
<a target="_blank" href="${pageContext.request.contextPath }/user/getuserauthmenu?userid=1&projectid=2">获取用户菜单权限</a>
<a target="_blank" href="${pageContext.request.contextPath }/user/getuserauthaction?userid=1&projectid=2">获取用户功能权限</a>

<a target="_blank" href="${pageContext.request.contextPath }/user/gettokenauthmenu?token=1&projectid=2">获取token用户菜单权限</a>
<a target="_blank" href="${pageContext.request.contextPath }/user/gettokenauthaction?token=1&projectid=2">获取token用户功能权限</a>

</div>
</body>
</html>