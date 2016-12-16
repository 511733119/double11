<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>我的优惠券</title>
	<link rel="stylesheet" href="css/detail.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/public.css" />
</head>
<style type="text/css">
	#head a{
		text-decoration: underline;
	}
	#head{
		font-size: 16px;
	}
</style>
<body>
	<div id="head" style="display:block;float:right;width:40%;margin:30px 20% 50px 30%">
     	<a href="index.jsp">首页</a>
     	<a href="showCar.jsp">我的购物车</a>
     	<a href="ToMyPack.do">我的优惠券</a>
     	<a href="login.jsp">Login</a>
     </div>
     <div class="section_container">
         <!-- 产品详情 -->
         <div id="product_detail">
             <div class="product_rightcol fr">
                 <div id="name">
                     <h1>我的优惠券</h1>
                 </div>
                 <ul>
                     <li id="summary-price">
                         <div class="dt">
                         	<c:forEach items="${packList}" var="list">
                         		<div><font color="red"><h2>￥${list.price}元</h2></font></div><hr>
                         	</c:forEach>
                         </div>
                     </li>
                 </ul>
            	  </div>
             </div>
        </div>
	</body>
</html>
