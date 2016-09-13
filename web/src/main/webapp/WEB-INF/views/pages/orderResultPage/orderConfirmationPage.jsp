<%@ page import="java.math.BigDecimal" %>
<%@ page import="by.expertsoft.butko.cart.PersonalInfo" %>
<%@ page import="by.expertsoft.butko.cart.Cart" %><%--
  Created by IntelliJ IDEA.
  User: wladek
  Date: 15.08.16
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/tagLib.tld" prefix="tt" %>
<div class="container-fluid">
    <tt:thank order_id="${order.orderId}"> <c:out value="${message}"/></tt:thank>
    <p align="center" style="font-size: large">Total order information</p>
    <table class="table table-striped table-bordered list-group-item">
        <tr>
            <th>Name</th>
            <th>Amount</th>
        </tr>
        <c:forEach var="product" items="${order.cartItemList}" varStatus="count">
            <tr>
                <td><c:out value="${count.index + 1} : ${cartItemNames[count.index]}"/></td>
                <td><c:out value="${product.amount}"/></td>
            </tr>
        </c:forEach>
        <tr/><td/><td/>
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
            <td>${personalInfo.firstName}</td>
        </tr>
        <tr>
            <td>last name</td>
            <td>${personalInfo.lastName}</td>
        </tr>
        <tr>
            <td>phoneNumber</td>
            <td>${personalInfo.phoneNumber}</td>
        </tr>
    </table>
</div>
