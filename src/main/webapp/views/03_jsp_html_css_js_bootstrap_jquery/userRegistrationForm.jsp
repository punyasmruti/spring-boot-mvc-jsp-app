<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->
<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
     <!-- ######################################## main or body  content  ################################## -->
	<h1>User Registration Form</h1>
		<div class="container">
			<form:form action="/register" method="post" modelAttribute="user" >
				<fieldset class="form-group">
					<label>Full Name :</label>
					<form:input path="name" class="form-control" required="required" />
					 <form:errors path = "name" cssClass = "errormsg" />
					<label>Email :</label>
					<form:input path="email" class="form-control" required="required"/>
					 <form:errors path = "email" cssClass = "errormsg" />
					<label>Age :</label>
					<form:input path="age" class="form-control" required="required"/>
					 <form:errors path = "age" cssClass = "errormsg" />
					<label>DOB :</label>
					<form:input path="dob" class="form-control" required="required"/>
					 <form:errors path = "dob" cssClass = "errormsg" />
					<input type="reset" value="Reset" /><input type="submit" value="Save" />
				</fieldset>
		</form:form>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
    <script>
        $('#dob').datepicker({
            format : 'dd/mm/yyyy'
        });
    </script>
    
</body>
</html>
