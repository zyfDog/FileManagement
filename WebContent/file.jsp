<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/file.css" type="text/css" />
</head>
<body>
	<%-- <form action="">
		<table>
			<tr>
				<th>名称</th>
				<th>大小</th>
				<th>点击</th>
				<th>最后更新</th>
				<th>操作</th>
			</tr>
			<s:iterator value="files" status="status">
				<tr>
					<td>${name}</td>
					<td>${size}</td>
					<td>${hits}</td>
					<td>${updateTime}</td>
					<td>操作</td>
				</tr>
			</s:iterator>
		</table>
	</form> --%>
	<div id="top">
		<div id="topfunction">
			<span>知识管理</span>
			<div id="topfunctionright">
				<ul>
					<li>列表显示</li>
					<li>新建文件夹</li>
					<li>新建文件</li>
					<li>新建文件</li>
					<li>上传文件</li>
					<li>zip批量文件</li>
					<li>查询</li>
				</ul>
			</div>
		</div>
	</div>
	<div id="body">
		<div id="left">
		</div>
		<div id="right">
		</div>
	</div>
</body>
</html>