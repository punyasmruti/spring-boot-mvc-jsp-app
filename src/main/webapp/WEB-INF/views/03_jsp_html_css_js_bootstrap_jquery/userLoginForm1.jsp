<html>
<head>
<title>User Login Page</title>
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
	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<form name="myForm" action="login01" method="POST" onsubmit="return validateForm()" >
		UserName : <input name="loginUsername" type="text" /> 
		Password : <input name="loginPassword" type="password" /> 
		<input type="submit" />
	</form>
</body>
</html>