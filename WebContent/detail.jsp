<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>${product.name}</title>
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
    <div class="wrapper">
        <div class="section_container">
            <!-- 产品详情 -->
            <div id="product_detail">
                <!--详情左侧-->
                <div class="product_leftcol fl">
                    <div id="jingdong">
                        <div class="datu">
                            <img src="image/product/${product.pic}" />
                            <div id="fangdajing"></div>
                        </div>
                    </div>
                </div>
                <!--详情左侧结束-->
                <!--详情右侧-->
                <div class="product_rightcol fr">
                    <div id="name">
                        <h1>${product.name}</h1>
                    </div>
                    <ul id="summary">
                        <li id="summary-price">
                            <div class="dt">价&nbsp;格：</div>
                            <div class="dd"> <strong class="p-price" id="jd-price">￥${product.price}</strong><br>
                            <span>
                            	<c:if test="${product.category.id=='1'}">
                       				<strong></strong><font color="red">双十一促销：
                       				￥<fmt:formatNumber value="${product.price*0.8}" pattern="##.##" minFractionDigits="2"/></font> </
                      			</c:if>
		                        <c:if test="${product.category.id=='2'}">
		                       		<strong><font color="red">双十一促销：满199-20</font></strong>
		                        </c:if>
		                        <c:if test="${product.category.id=='3'}">
		                       		<strong><font color="red">双十一促销：
		                       		￥<fmt:formatNumber value="${product.price*0.9}" pattern="##.##" minFractionDigits="2"/> ,满100元返5元优惠卷</font></strong>
		                        </c:if>
		                        <c:if test="${product.category.id=='4'}">
		                       		<strong><font color="red">双十一促销：满1000元返20元优惠卷</font></strong>
		                        </c:if>
		                    </span>
                            </div>
                        </li>
                    </ul>
                    <form action="addSorder.do?id=${product.id}" method="post">
	                    <ul id="choose">
	                        <li id="choose-amount">
	                            <div class="dt">购买数量：</div>
	                            <div class="dd">
									 <input name="number" value="1" size="2" >&nbsp;&nbsp;&nbsp;库存：${product.stock }
	                            </div>
	                        </li>
	                    </ul>
	                    <div class="add_to_buttons">
	                        <button type="submit" class="add_cart">加入购物车</button>
	                    </div>
                    </form>
                </div>
                <!--详情右侧结束--> 
                </div>
            <!--产品详情结束-->
           </div>
        </div>
	</body>
</html>
