<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link rel="stylesheet" href="css/style.css"/>
	<style type="text/css">
		#dd div{
			padding: 5px;
		}
	</style>
<body>
			<div id="dd" class="action_buttonbar" style="text-align:center;display:block;width:40%;float:left;
			margin-left:30%;margin-top:10%;">
				<form method="post" action="login.do">
					<div>
						<label for="login">账号:&nbsp;</label> 
						<input type="text" name="name" value="${name}"/>
					</div>
					<div>
						<label for="pass">密码:&nbsp;</label> 
						<input type="password" name="pass" />
					</div>
					<div>
						${sessionScope.error}  
					</div>
					<div>
						<input type="submit" value="登陆" style="width:60px;height:30px" />
					</div>
			   </form>
			   	   <a href="register.jsp">注册</a>
			   <div style="clear:both"></div>
			</div>
</body>
</html>
