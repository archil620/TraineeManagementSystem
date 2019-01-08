<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2 align="center"> Trainees Details </h2>
	<table align="center" border="1">
		<tr>
			<th> Trainee ID </th>
			<th> Trainee Name</th>
			<th> Trainee Location</th>
			<th> Trainee Domain</th>
		</tr>
	<%-- <c:set var="dList" value="${tList }"></c:set> --%>
		<c:forEach var="list" items="${tList}">
			<tr>
				<td> ${list.traineeId } </td>
				<td> ${list.traineeName } </td>
				<td> ${list.traineeDomain } </td>
				<td> ${list.traineeLocation } </td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>