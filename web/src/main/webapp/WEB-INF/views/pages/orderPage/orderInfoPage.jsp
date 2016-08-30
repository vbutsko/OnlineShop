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
    <caption style="text-align: center; font-size: large">Your order</caption>
    <table class="table table-striped table-bordered list-group-item">
        <tr>
            <th>Name</th>
            <th>Amount</th>
        </tr>
        <c:forEach var="product" items="${cartSession.cartItemList}" varStatus="count">
                <tr>
                    <td><c:out value="${count.index + 1} : ${cartItemNames[count.index]}"/></td>
                    <td><c:out value="${product.amount}"/></td>
                </tr>
        </c:forEach>
        <tr/><td/><td/>
        <tr>
            <th>Total Amount</th>
            <td><c:out value="${cartSession.getTotalAmount()}"/></td>
        </tr>
        <tr>
            <th>Delivery  Price</th>
            <td><c:out value="${personalInfo.deliveryPrice}"/></td>
        </tr>
        <tr>
            <th>Total Cost</th>
            <%
               // BigDecimal totalCost = ((PersonalInfo)request.getAttribute("personalInfo")).getDeliveryPrice().add(((Cart)pageContext.getSession().getAttribute("cart")).getTotalCost());
               // out.println("<td>"+totalCost+"</td>");
            %>
        </tr>
    </table>
    <br/>
    <p align="center" style="font-size: large">buyer information</p>
    <sf:form method="post" action="order" modelAttribute="personalInfo">
        <table class="table table-striped table-bordered list-group-item">
            <tr>
                <td><sf:label path="firstName">fist name</sf:label></td>
                <td><sf:input path="firstName" value="${personalInfo.firstName}"/></td>
            </tr>
            <tr>
                <td><sf:label path="lastName">last name</sf:label></td>
                <td><sf:input path="lastName" value="${personalInfo.lastName}"/></td>
            </tr>
            <tr>
                <td><sf:label path="number">number</sf:label></td>
                <td><sf:input path="number" value="${personalInfo.number}"/></td>
            </tr>
        </table>
        <div class="pull-right">
            <button type="submit">Next</button>
        </div>
    </sf:form>
</div>