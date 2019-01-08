 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="view/companyLogin.css" type="css/text">
</head>
<body bgcolor="lightgray">

<div id="headerWrapper">
<h2 align="center">Enter Trainee details</h2>
</div>
<div id="companyWrapper">
<form:form action="addtraining.obj" modelAttribute="trainee" method="get">
	<table align="center">
	
		<tr>
			<td>Trainee Name:</td>
			<td><form:input path="traineeName"/></td>
			<td> <form:errors path="traineeName" cssStyle="color:red"/> </td>  
		</tr>
		<tr>
			<td>Training Location:</td>
			
			
			<td>
				<form:select path="traineeLocation"> 
					<form:option value="" label="Please Select"/>
					<form:options items="${traineeLoc}" />
  				</form:select>
			
			<%-- <form:radiobutton path="traineeLocation" value="chennai" label="Chennai"/>
				<form:radiobutton path="traineeLocation" value="bangalore" label="Bangalore"/>
				<form:radiobutton path="traineeLocation" value="pune" label="Pune"/>
				<form:radiobutton path="traineeLocation" value="mumbai" label="Mumbai"/> --%>
			</td>
		 <td> <form:errors path="traineeLocation" cssStyle="color:red"/> </td> 
		</tr>
		<tr>
			<td>Domain:</td>
 		 	<td><form:select path="traineeDomain">
 		 			<form:option value="" label="Please Select"/>
    				<form:option value="jee" label="JEE"/>
   					<form:option value="mf" label="Mainframe"/>
  				  	<form:option value="sys" label="Systems"/>
  				</form:select>
			</td>
			<td> <form:errors path="traineeDomain" cssStyle="color:red"/> </td>
		</tr>
		
		<tr>
				<td> Location preference </td>
				<td><form:checkboxes items="${traineeLoc}" path="location"/> </td>
				<!-- <td> <input type="checkbox" name="location" value="Chennai"/> Chennai 
					<input type="checkbox" name="location" value="Pune"/> Pune
					<input type="checkbox" name="location" value="Mumbai"/> Mumbai
					<input type="checkbox" name="location" value="Banglore"/> Bengaluru
				</td> -->
		</tr>
		
		
		
		<tr>
			<td colspan="3" align="center"><input type="submit" value="Add Trainee"/></td>
		</tr>	
	</table>



</form:form>
</div>
</body>
</html>