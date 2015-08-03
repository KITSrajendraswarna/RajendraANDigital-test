<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="${pageContext.request.contextPath}/resources/css/venuefinder.css"
	rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Welcome to Venue Finder Home Page</title>
</head>
<body>

	<form method="POST" name="venueFinderHome"
		action="${pageContext.request.contextPath}/results">

		<input id="searchTerms" name="searchTerms" type="text" value="">
		<p>
			<input type="submit" value="Find Venues"/>
		</p>

		<div class="hrl">
			<hr />
		</div>
		<h3>Matching Results</h3>
		<div class="hrl">
			<hr />
		</div>

		<p>Click on the button to load result.html file:</p>

		<div id="stage" style="background-color: #cc0;">STAGE</div>

	</form>
</body>
</html>