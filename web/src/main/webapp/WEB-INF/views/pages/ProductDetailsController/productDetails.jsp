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
                var phone = $(this).parent('.mobile_shop');

                var amount = phone.find("[name=amount]").val();
                var productId = phone.find("[name=productId]").val();
                var name = phone.find("[name=name]").val();

                $.ajax({
                    type: "POST",
                    url: "/web/cart",
                    data: "amount=" + amount + "&productId=" + productId + "&name=" + name,
                    success: function (response) {
                        // we have the response
                        var message = response.result;
                        if(response.status == "SUCCESS")
                            message = "<p style=\"color:green\">" + message + "</p>";
                        else
                            message = "<p style=\"color:red\">" + message + "</p>";
                        phone.find("[name=info]").html(message);
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
                    <td>${productDetails.name}</td>
                </tr>
                <tr>
                    <td>Producer  </td>
                    <td>${productDetails.manufacturer.name}</td>
                </tr>
                <tr>
                    <td>Cost   </td>
                    <td>${productDetails.price}</td>
                </tr>
            </table>
            <div class="pull-right mobile_shop">
                <!--<sf:form class="mobile_shop" method="post" modelAttribute="cartItem">-->
                    <input name="amount" size="10" placeholder="amount" type="number" min="1">
                    <sf:errors path="amount" cssClass="error" />
                    <button class="add_shop">add to cart</button>
                    <input type="hidden" name="productId" value="${productDetails.id}">
                    <input type="hidden" name="name" value="${productDetails.name}">
                    <div name="info"></div>
                <!--</sf:form>-->
            </div>
        </div>
    </body>
</html>
