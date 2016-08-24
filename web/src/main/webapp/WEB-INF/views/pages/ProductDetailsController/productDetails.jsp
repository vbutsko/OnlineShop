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
                        $('#info_shop').html(response);
                        $('#headerTotal').html("${sessionScope.cart.getTotalAmount()} :Amount; ${sessionScope.cart.getTotal()}: Total");
                    },
                    error: function (e) {
                        alert('Error: ' + e);
                    }
                });
            });
        });
    </script>
        <div class="container-fluid">
            <table class="table table-striped table-bordered">
                <caption align="center">Characteristics</caption>
                <tr>
                    <td>Name   </td>
                    <td>${productDetails.getName()}</td>
                </tr>
                <tr>
                    <td>Producer  </td>
                    <td>${productDetails.getProducer().getProducer_name()}</td>
                </tr>
                <tr>
                    <td>Cost   </td>
                    <td>${productDetails.getCost()}</td>
                </tr>
            </table>
            <div class="pull-right">
                <div class="mobile_shop">
                    <input class="amount_shop" size="10" placeholder="amount" type="number" min="1">
                    <sf:errors path="amount" cssClass="error" />
                    <button class="add_shop">add to cart</button>
                    <input type="hidden" class="productId_shop" value="${productDetails.getId()}">
                    <input type="hidden" class="name_shop" value="${productDetails.getName()}">
                    <input type="hidden" class="cost_shop" value="${productDetails.getCost()}">
                    <div id="info_shop" style="color: green;"></div>
                </div>
            </div>
        </div>
    </body>
</html>
