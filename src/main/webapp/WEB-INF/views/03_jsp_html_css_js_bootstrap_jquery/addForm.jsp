<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Form</title>
<script>
	function validateForm() {
		var x = document.forms["myForm"]["num1"].value;
		var y = document.forms["myForm"]["num2"].value;
		if (x == "") {
			alert("Num1 must be filled out");
			return false;
		}
		if (y == "") {
			alert("Num2 must be filled out");
			return false;
		}
	}
</script>
</head>
<body>
	<form name="myForm" action="add1" method="post" onsubmit="return validateForm()">
		Num1:<input type="text" name="num1"> 
		Num2:<input type="text" name="num2"> 
		<input type="submit" value="Add">
	</form>
</body>
</html>