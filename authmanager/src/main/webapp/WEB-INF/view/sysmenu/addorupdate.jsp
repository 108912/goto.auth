<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统权限管理中心-菜单管理</title>
</head>
<body>

	<div class="container">
		<div>
			<%@include file="../../../section/baseboostrap.jsp"%>
			<%@include file="../../../section/menu.jsp"%>
			<script
				src="${pageContext.request.contextPath }/content/loadselect.js"></script>
		</div>
		<div>
			<ol class="breadcrumb">
				<li><a>系统管理</a></li>
				<li><a>菜单管理</a></li>
				<li class="active">编辑</li>
			</ol>
		</div>
		<div class="panel panel-default">
		<div class="text-center page-header text-primary">
			<h3>菜单信息维护</h3>
		</div>
			<div id="error" class="text-center" style="color:red">
					<c:forEach var="error" items="${errors}">
					<span>${error}</span>
					</c:forEach>
			</div>
			<form class="form-horizontal" role="form" method="post"
				action="addorupdate.do">
				<input type="hidden" name="id" value="${record.id}">
				<div class="form-group">
					<label for="parentid" class="col-sm-2 control-label">所属应用系统</label>
					<div class="col-sm-10">
						<input type="hidden" class="form-control" id="projectid"
							name="projectid" value="${record.projectid}"> <label id="projectname"></label>
						<div id="selectmedal">
							<input type="button" class="btn btn-primary" value="选择列表"
								onclick="selectload('loadselectdataproject','sysproject','radio','projectid','projectname');" />
							<div id="loadselectdataproject"></div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="parentid" class="col-sm-2 control-label">所属菜单</label>
					<div class="col-sm-10">
						<input type="hidden" class="form-control" id="parentid"
							name="parentid" value="${record.parentid}"> <label id="parentname"></label>
						<div id="selectmedal">
							<input type="button" class="btn btn-primary" value="选择列表"
								onclick="selectload('loadselectdatamenu','sysmenu','radio','parentid','parentname');" />
							<div id="loadselectdatamenu"></div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">名称</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="name" name="name"
							value="${record.name}">
					</div>
				</div>
				<div class="form-group">
					<label for="url" class="col-sm-2 control-label">url地址</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="url" name="url"
							value="${record.url}">
					</div>
				</div>
				<div class="form-group">
					<label for="icostyle" class="col-sm-2 control-label">icostyle</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="icostyle" name="icostyle"
							value="${record.icostyle}">
					</div>
				</div>
				<div class="form-group">
					<label for="note" class="col-sm-2 control-label">描述</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="note" name="note"
							value="${record.note}">
					</div>
				</div>
				<div class="text-center">
						<button type="button" class="btn btn-default" onclick="returnurl();">返回</button>
						<button type="submit" class="btn btn-primary">提交</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>