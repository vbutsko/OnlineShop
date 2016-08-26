<%--
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
<html>
    <body>
        <div class="container-fluid">
            <sf:form method="post" action="/web/cart" modelAttribute="cart" methodParam="update">
                <fieldset>
                    <c:forEach var="product" items="${sessionScope.cart.cartItemList}" varStatus="count">
                        <div class="list-group-item">
                            <div class="row">
                                <div class="col-lg-5 col-md-5">
                                    <p >${count.index+1} : ${product.name}</p>
                                </div>
                                <div class="col-lg-4 col-lg-offset-3 col-md-5 col-md-offset-2">
                                    <sf:input placeholder=" amount" path="cartItemList[${count.index}].amount" value="${product.amount}"/>
                                    <button formaction="cart?cartItemId=${count.index}" type="submit" name="delete" onclick="return confirm('Are you sure you want to delete ${product.getName()} x${product.getAmount()} from cart?')">delete</button>
                                    <br/>
                                    <sf:errors path="cartItemList[${count.index}].amount" cssClass="error" cssStyle="color:red"/>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <c:if test="${sessionScope.cart.getCartSize() > 0}">
                        <input class="pull-right" type="submit" name="update" value="Update"/>
                    </c:if>
                </fieldset>
            </sf:form>
            <div class="row">
                <c:out value="Total: ${sessionScope.cart.getTotal()}"/>
            </div>
        </div>
    </body>
</html>