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
<h2 align="center"> Modify Operation</h2>
<c:set var="dList" value="${modifyTrain}"></c:set>
<form:form action="modifybyID.obj" modelAttribute="trainee" method="post">
	<table align="center">
		<tr> 
			<td> Please Enter Trainee ID: </td>
			<td> <form:input path="traineeId"/> </td>
			<td> <form:errors path="traineeId" cssStyle="color:red"/></td> 
		</tr>
		
		<tr>
			<td colspan="3" align="center"> <input type="submit" value="delete"></td>
			
		</tr>
	</table>
</form:form>

<c:if test="${dList ne null}"> 
<h2 align="center"> Trainee Info</h2>
<form:form action="modTrain.obj?del=${modifyTrain.traineeId}" modelAttribute="trainee" method="post">
	<table border="1" align="center">
	 <tr>
	 	<th> TraineeID </th>
	 	<td>${modifyTrain.traineeId}</td>
	 </tr>
	 
	 <tr>
	 	<th> Trainee Name </th>
	 	<td> <input type="text" name="traineeName" value="${modifyTrain.traineeName}"> </td>
	 </tr>
	 
	 <tr>
	 	<th> Trainee Domain</th>
	 	<td> <input type="text" name="tdomain" value="${modifyTrain.traineeDomain}"> </td>
	 </tr>
	 
	 <tr>
	 	<th> Trainee Location</th>
	 	<td> <input type="text" name="tloc" value="${modifyTrain.traineeLocation}"> </td>
	 </tr>
		
		<tr>
			<td colspan="4" align="right"> <input type="submit" value="Update"> </td>
		</tr>
		
	</table>
</form:form> 
 </c:if> 
</body>
</html>