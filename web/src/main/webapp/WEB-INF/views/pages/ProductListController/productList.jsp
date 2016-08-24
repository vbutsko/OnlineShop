<%@ page import="by.expertsoft.butko.model.Mobile" %><%--
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
<html>
    <body>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script type="text/javascript">
        $(function() {
            $(".add_shop").on('click', function () {
                var mobile = $(this).parent('.mobile_shop');

                var amount = parseInt(mobile.find('.amount_shop').eq(0).val(), 10);
                var productId = parseInt(mobile.find('.productId_shop').eq(0).val(), 10);
                var cost = mobile.find('.cost_shop').eq(0).val();
                var name = mobile.find('.name_shop').eq(0).val();

                $.ajax({
                    type: "POST",
                    url: "/web/cart",
                    data: "amount=" + amount + "&productId=" + productId + "&cost=" + cost + "&name=" + name,
                    success: function (response) {
                        // we have the response
                        //$('#info_shop').html(response);
                        //$('.amount_shop').val('');
                        //$('#headerTotal').html("${cart.getTotal()}: Total");
                        $(this).parent('.info_shop').html(response);
                    },
                    error: function (e) {
                        alert('Error: ' + e);
                    }
                });
            });
        });
    </script>
        <div class="container-fluid">
            <c:forEach var="product" items="${productList}" varStatus="count">
                <div class="list-group-item">
                    <div class="row">
                        <div class="col-lg-5 col-md-5">
                            <c:out value="${count.index+1}  " />
                            <a href="<s:url value="/mobilephones/model?id=${product.getId()}"/>"> ${product.getName()} </a>
                        </div>
                        <div class="col-lg-4 col-lg-offset-3 col-md-5 col-md-offset-2">
                            <div class="mobile_shop">
                                <input class="amount_shop" size="10" placeholder="amount" type="number" min="1">
                                <button class="add_shop">add to cart</button>
                                <input type="hidden" class="productId_shop" value="${product.getId()}">
                                <input type="hidden" class="name_shop" value="${product.getName()}">
                                <input type="hidden" class="cost_shop" value="${product.getCost()}">
                                <div class="info_shop" style="color: green;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </body>
</html>
