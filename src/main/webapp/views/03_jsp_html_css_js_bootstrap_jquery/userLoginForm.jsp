<html>
<head>
<title>Login Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form action="/login" method="post">
		<fieldset class="form-group">
				<p>
					<font color="red">${errorMessage}</font>
				</p>
				<label>Username</label> 
				<input name="name" type="text" class="form-control" required="required"/> 
				<label>Password</label>
				<input name="password" type="password" class="form-control" required="required"/>
				<button type="submit" class="btn btn-success">Login</button>
				</fieldset>
		</form>
	</div>
</body>
</html>