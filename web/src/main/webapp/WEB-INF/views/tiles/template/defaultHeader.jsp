<%--
  Created by IntelliJ IDEA.
  User: wladek
  Date: 11.08.16
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div class="container-fluid">
    <h1>Online Shop. Choose your mobilephone.</h1>
    <p class="pull-right" id="headerTotal" onload="updateTotalBar()"></p>
    <br/>
    <security:authorize url="/admin/">
        <a href='<c:url value="/j_spring_security_logout" />' ><button class="button, pull-right"> Logout</button></a>
    </security:authorize>
</div>
