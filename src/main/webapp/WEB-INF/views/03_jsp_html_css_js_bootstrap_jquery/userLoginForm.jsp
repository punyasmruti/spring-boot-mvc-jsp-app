<html>
<head>
<title>User Login Page</title>
</head>
<body>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/login" method="POST">
        UserName : <input name="name" type="text" /> 
        Password : <input name="password" type="password" /> 
        <input type="submit" />
    </form>
</body>
</html>