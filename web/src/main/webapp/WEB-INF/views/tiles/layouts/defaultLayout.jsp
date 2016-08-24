<%--
  Created by IntelliJ IDEA.
  User: wladek
  Date: 11.08.16
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<link href="<c:url value='/resources/css/bootstrap.css' />"  rel="stylesheet"/>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><tiles:getAsString name="title" /></title>
    </head>

    <body>

        <div id="wrap">
            <div class="container-fluid">
                <div class="page-header">
                    <tiles:insertAttribute name="header" />
                </div>
                <div class="row">
                    <div class="col-xs-3 col-md-2 sidebar">
                        <tiles:insertAttribute name="menu" />
                    </div>
                    <div class="col-sx-9 col-md-10 main">
                        <tiles:insertAttribute name="body" />
                    </div>
                </div>
            </div>
        </div>
        <div id="footer">
            <div class="container-fluid">
                <tiles:insertAttribute name="footer" />
            </div>
        </div>
    </body>
</html>
