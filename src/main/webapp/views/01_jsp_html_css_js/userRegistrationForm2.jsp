<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
	<!-- ######################################## Header  content  ################################## -->
	<header>
		<img src="images/pasta.jpg" alt="photo">
		<h1>Welcome To My Blog</h1>
		<nav class="navbar">
			<ul>
				<!--  
                <li><a href="contactMe.html">Contact Me</a></li>
                <li><a href="aboutMe.html">About Me</a></li>
                <li><a href="courses.html">Courses</a></li> -->
				<li><a href="#">Login</a></li>
				<li><a href="users">All Users</a></li>
				<li><a href="home">Home</a></li>
			</ul>
		</nav>
	</header>
	<!-- ######################################## main or body  content  ################################## -->
	<main>
		<section>
			<h1>User Registration</h1>
			<form:form action="register" method="post" modelAttribute="user">
				<table>
					<tr>
						<td>Full Name :</td>
						<td><form:input path="name" /></td>
						<td><form:errors path="name" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td>Email :</td>
						<td><form:input path="email" /></td>
						<td><form:errors path="email" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td>Age :</td>
						<td><form:input path="age" /></td>
						<td><form:errors path="age" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td>DOB :</td>
						<td><form:input path="dob" /></td>
						<td><form:errors path="dob" cssClass="errormsg" /></td>
					</tr>
					<%-- <tr>
						<td>Login Username :</td>
						<td><form:input path="username" /></td>
						 <td><form:errors path = "username" cssClass = "errormsg" /></td>
					</tr>
					<tr>
						<td>Login Password :</td>
						<td><form:password path="password" /></td>
						 <td><form:errors path = "password" cssClass = "errormsg" /></td>
					</tr> --%>
					<tr>
						<td></td>
						<td colspan="3" align="center"><input type="reset"
							value="Reset" /><input type="submit" value="Save" /></td>
					</tr>
				</table>
			</form:form>
		</section>
	</main>
	<footer>
		<a href="#">copy_write@punya_blog_spot</a>
	</footer>
</body>
</html>
