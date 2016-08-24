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
            <sf:form method="post" action="/web/cart" modelAttribute="orderList">
                <c:forEach var="product" items="${orderList.cartItemList}" varStatus="count">
                    <div class="list-group-item">
                        <div class="row">
                            <div class="col-lg-5 col-md-5">
                                <p >${count.index+1} : ${cart.cartItemList[count.index].getName()}</p>
                            </div>
                            <div class="col-lg-4 col-lg-offset-3 col-md-5 col-md-offset-2">
                                <input type="number" min="1" name="cartItemList[${count.index}].amount" value="${cart.cartItemList[count.index].getAmount()}"/>
                                <button formaction="cart?orderId=${count.index}" type="submit" name="delete" onclick="return confirm('Are you sure you want to delete ${product.getName()} x${product.getAmount()} from cart?')">delete</button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <c:if test="${cart.getOrdersSize() > 0}">
                    <input class="pull-right" type="submit" name="update" value="Update"/>
                </c:if>
            </sf:form>
            <div class="row">
                <c:out value="Total: ${cart.getTotal()}"/>
            </div>
        </div>
    </body>
</html>