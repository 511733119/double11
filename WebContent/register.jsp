<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="User"  class="com.hjc.double11.model.User" scope="request"/>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link rel="stylesheet" href="css/style.css" />
	<style type="text/css">
		#dd div{
			padding: 5px;
		}
		#head a{
			text-decoration: underline;
		}
		#head{
			font-size: 16px;
		}
	</style>
</head>
<body>
	<div id="head" style="display:block;float:right;width:40%;margin:30px 20% 50px 30%">
     	<a href="index.jsp">首页</a>
     	<a href="showCar.jsp">我的购物车</a>
     	<a href="ToMyPack.do">我的优惠券</a>
     	<a href="login.jsp">Login</a>
     </div>
	<div class="wrapper">
		<div class="section_container">
			<div id="dd" class="action_buttonbar" style="text-align:center;">
				<form:form modelAttribute="User" method="post" action="register.do">
					<div>
							<label for="name">会员名:&nbsp;</label> 
							<input type="text" name="name" /><br>
							<font color="red"><form:errors path="name" /> </font>
					</div>
					<div>
							<label for="pass">密码:&nbsp;&nbsp;</label> 
							<input type="password" name="pass" />
					</div>
					<div>
							<label for="phone">电话号码:</label> 
							<input type="text" name="phone" />
					</div>
					<div>
							<label for="address">收货地址:</label> 
							<input type="text"  name="address"/><br>
							<font color="red"><form:errors path="address" /> </font>
					</div>
					<div>
							<label for="age">年龄:&nbsp;&nbsp;</label> 
							<input type="text" name="age" value="0" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
							<br><font color="red"><form:errors path="age" /> </font>
					</div>
					<div>
						<input type="submit" value="注册" style="width:60px;height:30px" />
					</div>
			   </form:form>
			   <div style="clear:both"></div>
			</div>
		</div>
	</div>
</body>
</html>
