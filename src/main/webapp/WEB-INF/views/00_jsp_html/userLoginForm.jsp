<html>
<head>
<title>User Login Page</title>
</head>
<body>
	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<form action="login" method="POST">
		UserName : <input type="text" name="loginUsername"  /> 
		Password : <input type="password" name="loginPassword"  /> 
		<input type="submit" />
	</form>
</body>
</html>