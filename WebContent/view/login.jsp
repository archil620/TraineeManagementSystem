<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
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
<h2 align="center"> Login Page </h2>
</div>

<div id="companyWrapper">
	<c:url var="myAction" value="/validateform.obj"></c:url>
	<form:form action="${myAction}" modelAttribute="user" method="post">
		<table align="center">
			<tr>
				<td> Username: </td>
				<td> <form:input path="username" name="user"/> </td>
			</tr>
			
			<tr>
				<td> Password: </td>
				<td> <form:input path="password" type="password" name="pwd"/> </td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"> <input type="submit" value="Login"> </td>
			</tr>
		</table>
	</form:form>
</div>
</body>
</html>