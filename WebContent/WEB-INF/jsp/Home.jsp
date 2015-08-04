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

		<div>
		<table>
			<tr>
			<td colspan="2">
			<label id="searchInput"></label> Search Term:  <input id="searchTerms" name="searchTerms" type="text" value="">
			</td>
			<td colspan="2"> &nbsp; &nbsp;</td>
			<td colspan="2">
			<label id="searchPlace"></label> Search Place: <input id="searchPlace" name="searchPlace" type="text" value="">
			</td>
			</tr>
			<tr> <td> &nbsp; </td> <tr>
			<tr>
			<td colspan="2">
			<div>
			<input id="button" type="submit" value="Search For Venues"/>
			</div>
			</td>
			</tr>
		</table>
		</div>

		<div class="hrl"> <hr/></div>


	</form>
</body>
</html>