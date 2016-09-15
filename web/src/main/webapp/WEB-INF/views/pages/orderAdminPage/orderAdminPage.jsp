<%--
  Created by IntelliJ IDEA.
  User: wladek
  Date: 15.09.16
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/tagLib.tld" prefix="tt" %>
<div class="container-fluid">
    <p align="center" style="font-size: large">Total order information</p>
    <table class="table table-striped table-bordered list-group-item">
        <tr>
            <th>Name</th>
            <th>Amount</th>
        </tr>
        <c:forEach var="product" items="${order.cartItemList}" varStatus="count">
            <tr>
                <td><c:out value="${count.index + 1} : ${orderItemNames[count.index]}"/></td>
                <td><c:out value="${product.amount}"/></td>
            </tr>
        </c:forEach>
        <tr/><td/><td/>
        <tr>
            <th>Order ID</th>
            <td>${order.orderId}</td>
        </tr>
        <tr>
            <th>Total Amount</th>
            <td>${order.totalAmount}</td>
        </tr>
        <tr>
            <th>Delivery  Price</th>
            <td><c:out value="${order.deliveryPrice}"/></td>
        </tr>
        <tr>
            <th>Total Cost</th>
            <td>${order.totalCost + order.deliveryPrice}</td>
        </tr>
        <tr>
            <td>fist name</td>
            <td>${order.personalInfo.firstName}</td>
        </tr>
        <tr>
            <td>last name</td>
            <td>${order.personalInfo.lastName}</td>
        </tr>
        <tr>
            <td>phone number</td>
            <td>${order.personalInfo.phoneNumber}</td>
        </tr>
        <tr>
            <td>delivered status</td>
            <td>${order.deliveredStatus}</td>
        </tr>
    </table>
    <c:if test="${!order.deliveredStatus}">
        <form method="post" action="/web/admin/orderlist/order" >
            <input type="hidden" name="orderId" value="${order.orderId}"/>
            <input type="submit" value="confirm"/>
        </form>
    </c:if>
</div>
