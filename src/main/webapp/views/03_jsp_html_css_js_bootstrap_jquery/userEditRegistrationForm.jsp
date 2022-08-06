<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"> -->
</head>
<body>
<nav role="navigation" class="navbar navbar-default">
	<!-- <div class="">
		<a href="http://www.in28minutes.com" class="navbar-brand">in28Minutes</a>
	</div> -->
	<div class="navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="/login">Login</a></li>
			<li class="active"><a href="/users">Users</a></li>
		</ul>
	</div>
</nav>
<main>
   <section>
	<h1>Edit User Details</h1>
	<%-- <form:form action="editsave" method="POST" modelAttribute="user"> --%>
	<form:form method="POST" action="${pageContext.request.contextPath}/editsave" modelAttribute="user">
		<fieldset class="form-group">
			<form:hidden path="userId" />
				<label>Name :</label>
				<form:input path="name" class="form-control" required="required"/>
				<label>Email :</label>
				<form:input path="email" class="form-control" required="required"/>
				<label>Age :</label>
				<form:input path="age" class="form-control" required="required"/>
				<label>DOB :</label>
				<form:input path="dob" class="form-control" required="required" />
				 <form:errors path = "dob" cssClass = "errormsg" />
				<input type="submit" value="Update" />
		</fieldset>
	</form:form>
	</section>
	</main>
</body>
</html>
