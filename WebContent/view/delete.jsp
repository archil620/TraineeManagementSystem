<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="view/companyLogin.css" type="css/text">
</head>
<body bgcolor="lightgray">

<div id="headerWrapper">

<h2 align="center"> Delete Operation</h2>
</div>
<c:set var="dList" value="${delTrainee }"></c:set>

<div id="companyWrapper">
<form:form action="showDelTrainee.obj" modelAttribute="trainee" method="post">
	<table align="center">
		<tr> 
			<td> Please Enter Trainee ID: </td>
			<td> <form:input path="traineeId"/> </td>
			<td> <form:errors path="traineeId" cssStyle="color:red"/></td> 
		</tr>
		
		<tr>
			<td> <input type="submit" value="delete"></td>
			
		</tr>
	</table>
</form:form>


<c:if test="${dList ne null}"> 


<h2 align="center"> Trainee Info</h2>


<form:form action="delTrain.obj?del=${delTrainee.traineeId}" modelAttribute="trainee" method="post">
	<table border="1" align="center" id="table">
	 <tr>
	 	<th> TraineeID </th>
	 	<th> Trainee Name </th>
	 	<th> Trainee Domain</th>
	 	<th> Trainee Location</th>
	 </tr>
	 
	  
		<tr>
			<td>${delTrainee.traineeId} </td>
			<td>${delTrainee.traineeName} </td>
			<td>${delTrainee.traineeDomain} </td>
			<td>${delTrainee.traineeLocation} </td>
			
		</tr>
		
		<tr>
			<td colspan="4" align="right"> <input type="submit" value="delete"> </td>
		</tr>
		
	</table>
</form:form> 

 </c:if> 
 </div>
</body>
</html>