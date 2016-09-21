<%--
  Created by IntelliJ IDEA.
  User: wladek
  Date: 11.08.16
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div class="well sidebar-nav">
    <ul class="nav nav-pills nav-stacked">
        <li class="menu nav-header" style="text-align: center; font-size: large; color: black">Menu</li>
        <security:authorize url="/admin/">
            <li class="orderlist"><a href="<s:url value="/admin/orderlist"/>">Order List</a></li>
        </security:authorize>
        <li class="home"><a href="<s:url value="/home"/>">HomePage</a></li>
        <li class="mobilephones"><a href="<s:url value="/mobilephones"/>">Product List</a></li>
        <li class="cart"><a href="<s:url value="/cart"/>">Your Cart</a></li>
    </ul>
</div>
<script type="text/javascript">
    var currentUrl = window.location.href;
    var className = currentUrl.split('/').pop() || "home";
    var classArr = className.split(';')[0].split("?");
    document.getElementsByClassName(classArr[0])[0].classList.add("active");
</script>
