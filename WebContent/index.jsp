<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页--双十一</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<style type="text/css">

#first-carousel, #first-carousel li {
	list-style:none; 
	float:left;
	margin-right:25px;
}
</style>
<body>
	
     <div style="display:block;float:right;width:400px;margin-right:400px">
     	<a href="index.jsp">首页</a>
     	<a href="showCar.jsp">我的购物车</a>
     	<a href="ToMyPack.do">我的优惠券</a>
     	<a href="login.jsp">登录</a>
     	<a href="register.jsp">注册</a>
     </div>
     <!-- 产品列表 -->
     	<!--  大循环开始 -->
     	<div  class="products_list">
     	<c:forEach items="${applicationScope.bigList}" var="list">
     		<ul id="first-carousel">
	          <h2 class="sub_title">${list[0].category.type}</h2>
	          <h4 style="font-weight: normal"><a href="getAllProduct.do?id=${list[0].category.id}">查看全部 >></a></h4>
        		
              <!--  小循环开始 -->
    		  <c:forEach items="${list}" var="product">
              <li> 
             	 <a href="getDetail.do?id=${product.id}&typeid=${list[0].category.id}" class="product_image"><img src="image/product/${product.pic}" style="width:220px;height:220px;"/></a>
                 <div class="product_info">
                   <span style="color:red;font-size:19px;"><strong>￥${product.price} </strong></span>
                   <br>
                   <span style="font-size:15px;display:block;width:200px;margin:10px 0px 10px 0px">
                       <c:if test="${list[0].category.type=='家用电器'}">
                       		双十一促销：<font color="red">￥<fmt:formatNumber value="${product.price*0.8}" pattern="##.##" minFractionDigits="2"/></font> 
                       </c:if>
                       <c:if test="${list[0].category.type=='日用生活品'}">
                       		双十一促销：<font color="red">满199-20</font>
                       </c:if>
                       <c:if test="${list[0].category.type=='食品'}">
                       		双十一促销：<font color="red">￥<fmt:formatNumber value="${product.price*0.9}" pattern="##.##" minFractionDigits="2"/></font> ,满100元返5元优惠卷
                       </c:if>
                       <c:if test="${list[0].category.type=='手机、数码产品'}">
                       		双十一促销：满1000元返20元优惠卷
                       </c:if>
                   <font color="blue"><h3>商品名称:${product.name }</h3></font>
                   </span>
                 </div>
              </li>
              </c:forEach>
              </ul>
         </c:forEach>
     </div>
     <!--产品列表结束  -->
</body>
</html>