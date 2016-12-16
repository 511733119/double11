<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*,com.hjc.double11.model.Forder" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <jsp:useBean id="Forder"  class="com.hjc.double11.model.Forder" scope="request"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" href="/css/detail.css" />
	<link rel="stylesheet" href="/css/style.css" />
	<link rel="stylesheet" href="/css/public.css" />
  </head>
  <body>
  	<c:if test="${empty sessionScope.forder.sorderSet}">
  		<c:redirect url="/index.jsp"/>
  	</c:if>
  	 <div class="wrapper">
        <div class="section_container">
            <!-- 确认订单信息 -->
            <div class="check-stup">
            	<!-- 商品确认 -->
                <div class="pro-check check ">
                    <h1>确认订单信息</h1>
	                <table class="data-table cart-table" >
						<tr>
							<th class="align_left" width="35%" colspan="2">商品名称</th>
							<th class="align_center" width="10%">销售价格</th>
							<th class="align_center" width="20%">数量</th>
							<th class="align_center" width="15%">小计</th>
						</tr>
						<c:forEach items="${sessionScope.forder.sorderSet}" var="sorder">
						<tr lang="${sorder.product.id}">
							<td  width="80px"><img src="/double11/image/product/${sorder.product.pic}" width="80"
								height="80" />
							</td>
							<td class="align_left"><a class="pr_name" href="#">${sorder.name}</a>
							</td>
							<td class="align_center">￥${sorder.price}</td>
							<td class="align_center vline">
								${sorder.number}	
							</td>
							<td class="align_center vline">￥${sorder.price*sorder.number}</td>
						</tr>
						</c:forEach>
					</table>
					
                    <div class="sum"> 
                        <div class="fr">
                        	<span>总计：</span><b>￥
                        	<c:choose>
                        		<c:when test="${privilege != 0.00}"><%=((Forder)session.getAttribute("forder")).getTotal().subtract(new BigDecimal(request.getParameter("privilege"))) %></c:when>
                        		<c:otherwise>${forder.total}</c:otherwise>
                        	</c:choose>
                        	</b><br>
                        </div>
                    </div>
                   
                </div>
                <!-- 订购确认 -->
                <form:form modelAttribute="Forder" action="/double11/saveForder.do" method="post" >
	                <div class="person-check check">
	                    <h1>订购人信息</h1>
	                    <div class="person-checkinner">
	                        <div>
	                        	<label>配送姓名:</label>
	                        	<input type="text" name="name" value="${sessionScope.user.name }"/>
	                        </div>
	                        <br>
	                        <div>
	                        	<label>联系方式:</label>
	                        	<input type="text" name="phone" value="${sessionScope.user.phone }" />
	                        </div>
	                        <br>
	                        <div>
	                        	<label>区域邮编:</label>
	                        	<input type="text" name="post"/>
	                        </div>
	                        <br>
	                        <div>
	                        	<label>配送地址:</label>
	                        	<input type="text" name="address" value="${sessionScope.user.address }"/>
	                       		<font color="red"><form:errors path="address" /> </font>
	                        </div>
	                        <br>
	                        <c:choose>
                        		<c:when test="${privilege != 0.00}">
                        			<input type="hidden" name = "privilege" value="${privilege}">
                        		</c:when>
                        	</c:choose>
	                    </div>
	                </div>
	                <div class="person-check check">
		                <div class="submit">
		                   	<input type="submit" class="sub-logo fr" value="确认购买" />
		                </div>
	                </div>
                </form:form>
           	 </div>
       	   </div>
       <!-- 确认订单信息结束 -->
      </div>
  </body>
</html>
