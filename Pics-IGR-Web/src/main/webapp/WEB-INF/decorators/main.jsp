<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title><decorator:title default="PICS IGR" /></title>

<link type="text/css" href="<s:url value='/resources/styles/redmond/jquery-ui-1.8.23.custom.css'/>" rel="stylesheet" />


<script language="JavaScript" src="${pageContext.request.contextPath}/struts/utils.js" type="text/javascript"></script>
<script language="JavaScript" src="${pageContext.request.contextPath}/struts/xhtml/validation.js" type="text/javascript"></script>

<%-- <script language="JavaScript" src="${pageContext.request.contextPath}/js/main.js" type="text/javascript"></script> --%>
<decorator:head />
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>

</head>
<body>
	<div id="page-wrap">

		<div id="top-bar">
			<div id="right-side">

				<div class="floatright">

					&nbsp;&nbsp;
					<security:authorize access="isAuthenticated()">
						<a href="<s:url value="/j_spring_security_logout" />"> Logout</a>
					</security:authorize>
				</div>
			</div>
		</div>
		
		<div id="zone-bar">
			<ul>

					<security:authorize access="isAuthenticated()">

					</security:authorize>			
			</ul>
		</div>
		
		<div id="main-content">
			<div id="feature-content">
				
				<div id="feature-left">
				<div id="feature-left-bar"></div>
					
					<p id="ad" class="ui-widget" style="padding: 10px;clip: auto;height: 100%;">

					</p>
				</div>
				
				<div id="feature-right" style="padding: 5px;height: 100%;z-index:0;">
					<div id="errorblock" class="ui-state-error ui-corner-all" style="display: none;padding:5px; ">

					<decorator:body />
	
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		
		<div id="footer">Diabetes Proctor - Trade Mark</div>
		
	</div>
</body>
</html>