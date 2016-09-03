<%--
  Created by IntelliJ IDEA.
  User: wladek
  Date: 12.08.16
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container-fluid">
    <table class="table table-striped table-bordered">
        <caption align="center">Characteristics</caption>
        <tr>
            <td>Name   </td>
            <td>${productDetails.name}</td>
        </tr>
        <tr>
            <td>Producer  </td>
            <td>${productDetails.manufacturer.name}</td>
        </tr>
        <tr>
            <td>Price   </td>
            <td>${productDetails.price}</td>
        </tr>
    </table>
    <div class="pull-right mobile_shop">
        <!--<sf:form class="mobile_shop" method="post" modelAttribute="cartItem">-->
            <input name="amount" value="1" size="10" placeholder="amount" type="number" min="1">
            <sf:errors path="amount" cssClass="error" />
            <button class="add_shop">add to cart</button>
            <input type="hidden" name="productId" value="${productDetails.id}">
            <div name="info"></div>
        <!--</sf:form>-->
    </div>
</div>