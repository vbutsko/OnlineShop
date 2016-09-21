<%--
  Created by IntelliJ IDEA.
  User: wladek
  Date: 21.09.16
  Time: 1:46
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true"%>
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<div class="container" style="width: 300px;"  id="login-box">

    <div class="container" style="width: 300px;" onload='document.f.j_username.focus();'>
        <c:url value="/j_spring_security_check" var="loginUrl" />
        <form action="${loginUrl}" method='POST'>
            <h2 class="form-signin-heading">Please sign in</h2>
            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>
            <input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus value="">
            <input type="password" class="form-control" name="j_password" placeholder="Password" required value="">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
        </form>
    </div>

</div>
