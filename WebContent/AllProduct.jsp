<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${productList[0].category.type}</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<style type="text/css">

#first-carousel, #first-carousel li {
	list-style:none; 
	float:left;
	margin:10px;
}
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
	<!-- 产品列表 -->
     <div>
     	<h2 class="sub_title">${productList[0].category.type}</h2>
     	<!--  循环开始 -->
     	<c:forEach items="${productList}" var="list">
     		<ul id="first-carousel">
              <li> 
             	 <a href="getDetail.do?id=${list.id}&typeid=${list.category.id}" class="product_image"><img src="image/product/${list.pic}" style="width:170px;height:170px;"/></a>
                 <div class="product_info">
                   <span style="color:red;font-size:17px;">￥${list.price }</span>
                   <h3><a href="#">商品名称:${list.name }</a></h3>
                 </div>
              </li>
            </ul>
         </c:forEach>
          <!--结束  -->
     </div>
    
</body>
</html>