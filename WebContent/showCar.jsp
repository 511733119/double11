<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
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
			<!-- 购物车 -->
			<div id="shopping_cart">
				<div class="message success">我的购物车</div>
				<c:choose>
				<c:when test="${empty sessionScope.forder}">
					你的购物车空空的~&nbsp;&nbsp;&nbsp;<a href="index.jsp"><font color="red">开始购物</font></a>
				</c:when>
				<c:otherwise>
				<table class="data-table cart-table" cellpadding="0" cellspacing="0">
					<tr>
						<th class="align_center" width="35%" colspan="2">&nbsp;商品名称</th>
						<th class="align_center" width="10%">销售价格</th>
						<th class="align_center" width="20%">数量</th>
						<th class="align_center" width="15%">小计</th>
					</tr>
					<c:forEach items="${sessionScope.forder.sorderSet}" var="sorder">
						<tr id="tr" lang="${sorder.product.id }">
							<td width="80px" class="align_center"><img src="image/product/${sorder.product.pic}" width="80px"
								height="80px" />
							</td>
							<td class="align_center"><a class="pr_name" href="#">${sorder.name }</a>
							</td>
							<td class="align_center vline">
								￥${sorder.price }
							</td>
							<td class="align_center vline">
								<input class="text" style="height: 20px;" value="${sorder.number}" lang="${sorder.number}">		
							</td>
							<td class="align_center vline">
								￥${sorder.price*sorder.number }
							</td>
						</tr>
					</c:forEach>
				</table>
				</c:otherwise>
				</c:choose>
				
				<!-- 结算 -->
				<div class="totals">
					<table id="totals-table">
						<tbody>
							<tr>
								<td width="60%" colspan="1" class="align_left total"><strong>总计</strong>
								</td>
								<td>￥
									<span id="total" class="total">
									<c:choose>
										<c:when test="${empty sessionScope.forder.total}">0.00</c:when>
										<c:otherwise>${sessionScope.forder.total}</c:otherwise>
									</c:choose>
									</span>
								</td>
							</tr>
						</tbody>
					</table>
					</div>
					<div>
						<form action="Toconfirm.do">
							<h3>使用优惠券</h3>
							<c:choose>
								<c:when test="${empty packList}">无</c:when>
								<c:otherwise>
									<c:forEach items="${packList}" var="list">
										<div style="margin:10px; float:left;">
											<input type="radio" name="privilege" value="${list.price}"/><font color="red">&nbsp;${list.price}元</font>
										</div>
									</c:forEach>
								</c:otherwise>
							</c:choose>
							<div class="action_buttonbar">
								<button type="submit" class="checkout fr" style="background-color: #f38256;">订单确认</button>
							</form>
							<a href="index.jsp">
								<button type="button"  class="continue fr">继续购物
								</button>
							</a>
						<div style="clear:both"></div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	
</body>
</html>
