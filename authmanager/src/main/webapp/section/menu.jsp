<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="nav nav-pills showhigh">
	<li><a class="btn-primary" href="${pageContext.request.contextPath }/sysdic/index">系统字典管理</a></li>
	<li><a class="btn-primary" href="${pageContext.request.contextPath }/sysorg/index">组织管理</a></li>
	<li><a class="btn-primary" href="${pageContext.request.contextPath }/sysuser/index">用户管理</a></li>
	<li><a class="btn-primary" href="${pageContext.request.contextPath }/sysproject/index">应用系统管理</a></li>
	<li><a class="btn-primary" href="${pageContext.request.contextPath }/sysrole/index">角色管理</a></li>
	<li><a class="btn-primary" href="${pageContext.request.contextPath }/syspermission/index">权限管理</a></li>
	<li><a class="btn-primary" href="${pageContext.request.contextPath }/sysmenu/index">菜单管理</a></li>
	<li><a class="btn-primary" href="${pageContext.request.contextPath }/sysaction/index">功能管理</a></li>
	<li><a class="btn-warning" href="${pageContext.request.contextPath }/logout">退出</a></li>
</ul>
<style>
.showhigh a:hover{color:black;}
</style>