<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Page </title>
<script>
	function validateForm() {
		var x = document.forms["myForm"]["loginUsername"].value;
		var y = document.forms["myForm"]["loginPassword"].value;
		if (x == "") {
			alert("loginUsername must be filled out");
			return false;
		}
		if (y == "") {
			alert("loginPassword must be filled out");
			return false;
		}
	}
</script>
</head>
<body>
<form name="myForm" action="login" method="post" modelAttribute="userRegistration" onsubmit="return validateForm()">
		Username:<input type="text" name="loginUsername">
		Password:<input type="text" name="loginPassword">
		<input type="submit" value="Submit">ss
	</form>
</body>
</html>