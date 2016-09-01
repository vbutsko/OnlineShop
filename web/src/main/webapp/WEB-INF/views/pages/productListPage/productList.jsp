<%@ page import="by.expertsoft.butko.phone.Phone" %><%--
  Created by IntelliJ IDEA.
  User: wladek
  Date: 12.08.16
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<div class="container-fluid">
    <c:forEach var="product" items="${productList}" varStatus="count">
        <div class="list-group-item">
            <div class="row">
                <div class="col-lg-5 col-md-5">
                    <c:out value="${count.index+1}  " />
                    <a href="<s:url value="/mobilephones/model?id=${product.id}"/>"> ${product.name} </a>
                </div>
                <div class="col-lg-4 col-lg-offset-3 col-md-5 col-md-offset-2 mobile_shop">
                    <input name="amount" value="1" size="10" placeholder="amount" type="number" min="1">
                    <button class="add_shop" >add to cart</button>
                    <input type="hidden" name="productId" value="${product.id}">
                    <div name="info"></div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<script src="<c:url value="/resources/js/addToCartScript.js"/>"></script>