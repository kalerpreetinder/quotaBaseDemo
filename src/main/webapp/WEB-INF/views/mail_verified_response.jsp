<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Verified</title>
</head>


<%
	String color = "red", data = "Verified Failed !";
	//String verify = request.getParameter("verify");

	/* if (verify.equalsIgnoreCase("true")) {
		data = "Verified Sucessful";
		color = "green";
	} else {
		data = "Verified Failed !";
		color = "red";
	} */
%>

<c:if test="${verify == 'true'}">
	<%
		data = "Verified Sucessful";
			color = "green";
	%>
</c:if>
<body>

	<center>
		<h2 style="color:<%=color%> ;">
			<%=data%>
		</h2>
	</center>

</body>
</html>