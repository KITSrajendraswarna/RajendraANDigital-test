<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="${pageContext.request.contextPath}/resources/css/venuefinder.css"
	rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Venue Results</title>
</head>
<body>

	<form method="POST" name="venueFinder"
		action="${pageContext.request.contextPath}/results">

	<input id="searchTerms" name="searchTerms" type="text" value="">
	<p>
	<input type="submit" value="Find Venues""/>
	</p>
	<div class="hrl"> <hr /> </div>
	<h3>Matching Results</h3>
	<div class="hrl"> <hr /> </div>


    <div id="stage" style="background-color:#cc0;">

	<c:forEach var="item" items="${results}">
		<div id="product">${item}</div>
	</c:forEach>
	<p></p>

	<p></p>
	<p></p>
	</div>
	<div class="hrl"> <hr /> </div>
</form>
</body>
</html>