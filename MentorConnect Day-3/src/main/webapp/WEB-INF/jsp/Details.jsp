<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Details</title>
</head>
<body>

	<h1></h1>

	<div align="center">
		<table cellpadding="5">

			<caption>
				<h2>List of Registration Details</h2>
			</caption>
			<thead>
				<tr>
					<th>Name</th>
					<th>Company Name</th>
					<th>Contact Number</th>
					<th>Gender</th>
					<th>City</th>
					<th>State</th>
					<th>Country</th>

				</tr>

			</thead>

			<c:forEach items="${registrationDetails }" var="detail">

				<tr>
					<td>${detail.name }</td>
					<td>${detail.companyName }</td>
					<td>${detail.contactNumber }</td>
					<td><c:choose>
							<c:when test="${detail.gender }">Male</c:when>
							<c:otherwise>Female</c:otherwise>
						</c:choose></td>
					<td>${detail.city}</td>
					<td>${detail.state }</td>
					<td>${detail.country }</td>

					<td><a href="">Edit</a></td>
					<td><a href="">Delete</a></td>
				</tr>
			</c:forEach>


		</table>
	</div>

</body>
</html>