<%--
  Created by IntelliJ IDEA.
  User: wladek
  Date: 15.09.16
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container-fluid">
    <c:forEach var="order" items="${orders}" varStatus="count">
            <div class="list-group-item">
                <div class="row" >
                    <div class="col-lg-10 col-md-9">
                        <c:out value="${count.index+1}  " />
                        <a href="<s:url value="orderlist/order?order_id=${order.orderId}"/>"> ${order.orderId} </a>
                        <c:out  value="   Total cost: ${order.totalCost}"/>
                    </div>
                    <div class="col-lg-1 col-lg-offset-1 col-md-2 col-md-offset-1">
                        <c:if test="${!order.deliveredStatus}">
                            <form method="post" action="/web/admin/orderlist" >
                                <input type="hidden" name="orderId" value="${order.orderId}"/>
                                <input type="submit" value="confirm"/>
                            </form>
                        </c:if>
                    </div>
                </div>
            </div>
    </c:forEach>
</div>