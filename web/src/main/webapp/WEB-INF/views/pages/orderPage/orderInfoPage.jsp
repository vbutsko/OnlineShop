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
<div class="container-fluid">
    <caption style="text-align: center; font-size: large">Your order</caption>
    <table class="table table-striped table-bordered list-group-item">
        <tr>
            <th>Name</th>
            <th>Amount</th>
        </tr>
        <c:forEach var="product" items="${cart.cartItemList}" varStatus="count">
                <tr>
                    <td><c:out value="${count.index + 1} : ${cartItemNames[count.index]}"/></td>
                    <td><c:out value="${product.amount}"/></td>
                </tr>
        </c:forEach>
        <tr/><td/><td/>
        <tr>
            <th>Total Amount</th>
            <td><c:out value="${cart.totalAmount}"/></td>
        </tr>
        <tr>
            <th>Delivery  Price</th>
            <td><c:out value="${deliveryPrice}"/></td>
        </tr>
        <tr>
            <th>Total Cost</th>
            <td>${cart.totalCost + deliveryPrice}</td>
        </tr>
    </table>
    <br/>
    <p align="center" style="font-size: large">buyer information</p>
    <sf:form method="post" action="order" modelAttribute="personalInfo">
        <table class="table table-striped table-bordered list-group-item">
            <tr>
                <td><sf:label path="firstName">fist name</sf:label></td>
                <td>
                    <sf:input path="firstName" value="${personalInfo.firstName}"/><br/>
                    <sf:errors path="firstName" cssClass="error" cssStyle="color:red"/>
                </td>
            </tr>
            <tr>
                <td><sf:label path="lastName">last name</sf:label></td>
                <td>
                    <sf:input path="lastName" value="${personalInfo.lastName}"/><br/>
                    <sf:errors path="lastName" cssClass="error" cssStyle="color:red"/>
                </td>
            </tr>
            <tr>
                <td><sf:label path="phoneNumber">phoneNumber</sf:label></td>
                <td>
                    <sf:input path="phoneNumber" value="${personalInfo.phoneNumber}"/><br/>
                    <sf:errors path="phoneNumber" cssClass="error" cssStyle="color:red"/>
                </td>
            </tr>
        </table>
        <div class="pull-right">
            <button type="submit">Next</button>
        </div>
    </sf:form>
</div>