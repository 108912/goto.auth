<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统权限管理中心-功能管理</title>
</head>
<body>
	<div class="container">
		<div>
			<%@include file="../../../section/baseboostrap.jsp"%>
			<%@include file="../../../section/menu.jsp"%>
		</div>
		<div>
			<ol class="breadcrumb">
				<li><a>系统管理</a></li>
				<li><a>功能管理</a></li>
				<li class="active">列表</li>
			</ol>
		</div>
		<div class="panel panel-default">
			<form class="form-horizontal" role="form" method="get" action="index">
				<div class="row top">
					<div class="col-sm-6 form-group">
						<label for="id" class="col-sm-2 control-label">ID</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="id" name="id"
								value="${queryparam.id}">
						</div>
					</div>
					<div class="col-sm-6 form-group">
						<label for="name" class="col-sm-2 control-label">名称</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name"
								value="${queryparam.name}">
						</div>
					</div>
				</div>
				<div class="text-right">
					<button type="submit" class="btn btn-info">查询</button>
					<a class="btn btn-info"
						href="${pageContext.request.contextPath }/sysaction/addorupdate?id=0">添加</a>
				</div>
			</form>
			<table class="table table-striped tablefixed">
				<caption>列表</caption>
				<thead>
					<tr>
						<th style="width: 5%">ID</th>
						<th style="width: 20%">编码</th>
						<th style="width: 20%">名称</th>
						<th style="width: 30%">描述</th>
						<th style="width: 25%">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${datalist}">
						<tr>
							<td>${item.id}</td>
							<td>${item.code}</td>
							<td>${item.name}</td>
							<td>${item.note}</td>
							<td><a class="btn btn-default"
								href="${pageContext.request.contextPath }/sysaction/addorupdate?id=${item.id}">编辑</a>
								<a class="btn btn-danger"
								href="${pageContext.request.contextPath }/sysaction/del?id=${item.id}">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="text-right" id="paginationtools">
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
var paramstr='${paramstr}';
var totalcount=${querycount}; 
var pagesize=${queryparam.pagesize};
var pageindex=${queryparam.pageindex};
    $(document).ready(function(){  
	loadpagination("paginationtools",totalcount,pagesize,pageindex,paramstr);
    });
</script>