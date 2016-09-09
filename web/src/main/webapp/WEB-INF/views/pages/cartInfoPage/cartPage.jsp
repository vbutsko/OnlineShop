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
<div class="container-fluid">
    <sf:form method="post" action="/web/cart" modelAttribute="cartForm" methodParam="update">
        <fieldset>
            <c:forEach var="product" items="${cart.cartItemList}" varStatus="count">
                <div class="list-group-item">
                    <div class="row">
                        <div class="col-lg-5 col-md-5">
                            <p >${count.index+1} : ${cartItemNames[count.index]}</p>
                        </div>
                        <div class="col-lg-4 col-lg-offset-3 col-md-5 col-md-offset-2">
                            <sf:input placeholder=" amount" path="cartItemFormList[${count.index}].amount" value="${product.amount}"/>
                            <sf:input type="hidden" path="cartItemFormList[${count.index}].productId" value="${product.productId}"/>
                            <button formaction="cart?cartItemProductId=${product.productId}" type="submit" name="delete" onclick="return confirm('Are you sure you want to delete ${cartItemNames[count.index]} x${product.amount} from cart?')">delete</button>
                            <br/>
                            <sf:errors path="cartItemFormList[${count.index}].amount" cssClass="error" cssStyle="color:red"/>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <c:if test="${cart.cartSize > 0}">
                <div class="pull-right">
                    <input class="pull-right" type="submit" name="update" value="Update"/>
                    <button formaction="/web/order" formmethod="get" type="submit">fill order information</button>
                </div>
                <div class="row">
                    <c:out value="Total: ${cart.totalCost}"/>
                </div>
            </c:if>
        </fieldset>
    </sf:form>
</div>