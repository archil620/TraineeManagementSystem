<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2 align="center"> User Details Submitted Succesfully!</h2>

	Trainee ID  : ${idcount}<br>
	Trainee Name: ${trainee.traineeName}<br>
	Trainee Domain: ${trainee.traineeDomain }<br>
	Trainee Location:${trainee.traineeLocation }<br>
	
	<a href="home.obj"><p align="center"> Go Back to homepage </p></a>
</body>
</html>