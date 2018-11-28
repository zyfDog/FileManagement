<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="">
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
	</form>
</body>
</html>