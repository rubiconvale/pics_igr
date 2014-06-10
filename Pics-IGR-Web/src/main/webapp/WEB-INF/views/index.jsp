<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>spring-mvc-showcase</title>
    <link href="<c:url value="/resources/styles/form.css" />" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/resources/js/jquery/jquery-1.8.0.min.js" />" rel="stylesheet" type="text/css"/>

    <!--
        Used for including CSRF token in JSON requests
        Also see bottom of this file for adding CSRF token to JQuery AJAX requests
    -->
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body>
<h1><a href="<c:url value="/" />">PICS IGR</a></h1>
<div id="simple">
    <h2>Simple</h2>
    <p>
        See the <code>org.springframework.samples.mvc.simple</code> package for the @Controller code
    </p>
    <ul>
        <li>
            <a id="simpleLink" class="textLink" href="<c:url value="/contractorInfo" />">GET /simple</a>
        </li>

    </ul>
</div>
</body>
</html>