<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>

<script>
	var stateObject = {
		"India" : {
			"West Bengal" : [ "Howrah", "Asansol" ],
			"Bihar" : [ "Patna", "Muzzafferpur" ],
			"Utter Pradesh" : [ "Banaras", "Haridwar" ],
		},
		"Australia" : {
			"South Australia" : [ "Dunstan", "Mitchell" ],
			"Victoria" : [ "Altona", "Euroa" ]
		},
		"Canada" : {
			"Alberta" : [ "Acadia", "Bighorn" ],
			"Columbia" : [ "Washington", "" ]
		},
	}

	window.onload = function() {
		var countySel = document.getElementById("countySel"), stateSel = document
				.getElementById("stateSel"), districtSel = document
				.getElementById("districtSel");
		for ( var country in stateObject) {
			countySel.options[countySel.options.length] = new Option(country,
					country);
		}
		countySel.onchange = function() {
			stateSel.length = 1; // remove all options bar first
			districtSel.length = 1; // remove all options bar first
			if (this.selectedIndex < 1)
				return; // done
			for ( var state in stateObject[this.value]) {
				stateSel.options[stateSel.options.length] = new Option(state,
						state);
			}
		}
		countySel.onchange(); // reset in case page is reloaded
		stateSel.onchange = function() {
			districtSel.length = 1; // remove all options bar first
			if (this.selectedIndex < 1)
				return; // done
			var district = stateObject[countySel.value][this.value];
			for (var i = 0; i < district.length; i++) {
				districtSel.options[districtSel.options.length] = new Option(
						district[i], district[i]);
			}
		}
	}
</script>

</head>
<body bgcolor="lavender">

	<center>
		<h1>Registration Page</h1>


		<sf:form action="addRegistration" modelAttribute="registration"
			method="get" id="myForm" name="myForm">

			<table>
				<tr>
					<td>Name</td>
					<td><sf:input path="name" /></td>
				</tr>

				<tr>
					<td>Company Name</td>
					<td><sf:input path="companyName" /></td>
				</tr>

				<tr>
					<td>Contact Number</td>
					<td><sf:input path="contactNumber" /></td>
				</tr>

				<tr>
					<td>Gender</td>
					<td><sf:radiobutton path="gender" value="true" />Male <sf:radiobutton
							path="gender" value="false" />Female</td>
				</tr>

				<tr>
					<td>Country</td>
					<td><sf:select path="country" name="state" id="countySel"
							size="1">
							<sf:option value="" selected="selected">Select Country</sf:option>

						</sf:select></td>
				</tr>

				<tr>
					<td>State</td>
					<td><sf:select path="state" name="countrya" id="stateSel"
							size="1">
							<sf:option value="" selected="selected">Please Select Country first</sf:option>

						</sf:select></td>
				</tr>

				<tr>
					<td>City</td>
					<td><sf:select path="city" name="district" id="districtSel"
							size="1">
							<sf:option value="" selected="selected">Please Select State first</sf:option>

						</sf:select></td>
				</tr>

				<tr>
					<td><button type="submit">Login</button></td>
					<td><button type="reset">Cancel</button></td>

				</tr>


			</table>

		</sf:form>
</body>
</html>