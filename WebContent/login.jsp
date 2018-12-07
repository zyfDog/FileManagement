<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录界面</title>
<link rel="stylesheet" type="text/css" href="css/login.css" />
</head>
<body>
	<div class="all">
		<div class="top">
			<span>文件管理系统-管理员登录界面</span>
		</div>
		<div class="login-page">
			<div class="title">
				<span>LOGIN</span>
			</div>
			<form action="login" method="post" class="information">
				<li><label>用户名</label> <input class="input" type="text"
					name="user.account" placeholder="请输入用户名 " required="required">
				</li>
				<li><label>密&nbsp&nbsp&nbsp码</label> <input class="input"
					type="password" name="user.password" placeholder="请输入密码"
					required="required"></li> <input class="login_button"
					type="submit" value="登录" />
			</form>
		</div>
	</div>
</body>
</html>