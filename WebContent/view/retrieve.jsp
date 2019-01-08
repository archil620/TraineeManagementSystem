<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center"> Retrieve Operation</h2>
<c:set var="dList" value="${retTrain }"></c:set>

<form:form action="retrieveTrainee.obj" modelAttribute="retrieve" method="post">
	<table align="center">
		<tr> 
			<td> Please Enter Trainee ID: </td>
			<td> <form:input path="traineeId"/> </td>
			<td> <form:errors path="traineeId" cssStyle="color:red"/></td> 
		</tr>
		
		<tr>
			<td colspan="3" align="center"> <input type="submit" value="retrieve"></td>
			
		</tr>
	</table>
</form:form>

<c:if test="${dList ne null}"> 
<h2 align="center"> Trainee Info</h2>

	<table border="1" align="center">
	 <tr>
	 	<th> TraineeID </th>
	 	<th> Trainee Name </th>
	 	<th> Trainee Domain</th>
	 	<th> Trainee Location</th>
	 </tr>
	 
	 
		<tr>
			<td>${retTrain.traineeId} </td>
			<td>${retTrain.traineeName} </td>
			<td>${retTrain.traineeDomain} </td>
			<td>${retTrain.traineeLocation} </td>
			
		</tr>
		
	</table>

</c:if>


</body>
</html>