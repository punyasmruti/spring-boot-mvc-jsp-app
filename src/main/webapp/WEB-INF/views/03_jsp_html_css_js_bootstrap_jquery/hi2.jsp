<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hi2</title>
</head>
<body>

	<%
		out.println(request.getAttribute("msg"));	
	%>
	
	<%= request.getAttribute("msg") %>

	${msg}

</body>
</html>