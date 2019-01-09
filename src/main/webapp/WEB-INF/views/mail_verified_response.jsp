<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Verified</title>
</head>

<%
	String color = "", data = "";
	String verify = request.getParameter("verify");
	
	if(verify.equalsIgnoreCase("true")){
		data = "Verified Sucessful";
		color = "green";
	} else {
		data = "Verified Failed !";
		color = "red";
	}
%>

<body>

<center> 
	<h2 style="color:<%= color %> ;"> <%= data %> </h2>
</center>

</body>
</html>