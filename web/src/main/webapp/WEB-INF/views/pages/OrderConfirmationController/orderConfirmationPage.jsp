<%@ page import="java.math.BigDecimal" %>
<%@ page import="by.expertsoft.butko.phone.PersonalInfo" %>
<%@ page import="by.expertsoft.butko.phone.Cart" %><%--
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
    <p align="center" style="font-size: large">Total order information</p>
    <table class="table table-striped table-bordered list-group-item">
        <tr>
            <th>Name</th>
            <th>Amount</th>
        </tr>
        <c:forEach var="product" items="${sessionScope.cart.cartItemList}" varStatus="count">
            <tr>
                <td><c:out value="${count.index + 1} : ${product.name}"/></td>
                <td><c:out value="${product.amount}"/></td>
            </tr>
        </c:forEach>
        <tr/><td/><td/>
        <tr>
            <th>Total Amount</th>
            <td>${sessionScope.cart.getTotalAmount()}</td>
        </tr>
        <tr>
            <th>Delivery  Price</th>
            <td><c:out value="${sessionScope.personalInfo.deliveryPrice}"/></td>
        </tr>
        <tr>
            <th>Total Cost</th>
            <%
                BigDecimal totalCost = ((PersonalInfo)pageContext.getSession().getAttribute("personalInfo")).getDeliveryPrice().add(((Cart)pageContext.getSession().getAttribute("cart")).getTotal());
                out.println("<td>"+totalCost+"</td>");
            %>
        </tr>
        <tr>
            <td>fist name</td>
            <td>${sessionScope.personalInfo.firstName}</td>
        </tr>
        <tr>
            <td>last name</td>
            <td>${sessionScope.personalInfo.lastName}</td>
        </tr>
        <tr>
            <td>number</td>
            <td>${sessionScope.personalInfo.number}</td>
        </tr>
    </table>
    <button class="pull-right">finish</button>
</div>