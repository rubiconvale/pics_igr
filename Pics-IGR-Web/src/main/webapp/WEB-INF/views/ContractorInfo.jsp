<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
	<title>forms | mvc-showcase</title>
	<link href="<c:url value="/resources/styles/redmond/jquery-ui-1.8.23.custom.css" />" rel="stylesheet"  type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-1.8.0.min.js" />"></script>
</head>
<body>

	<div id="formsContent">
        <fieldset>
            <legend>Contractor Info</legend>
            <h3>BillingContact: ${billingContact}</h3>
            <h3>Phone: ${billingPhone}</h3>
            <h3>Description : ${description}</h3>
            </fieldset>
		</div>

</body>
</html>
