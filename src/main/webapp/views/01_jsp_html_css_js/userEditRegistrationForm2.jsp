<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>My Title</title>
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
				<li><a href="${pageContext.request.contextPath}/users">All Users</a></li>
				<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
			</ul>
		</nav>
	</header>
	<!-- ######################################## main or body  content  ################################## -->
	<main>
		<section>
			<h1>Edit User Details</h1>
			<form:form method="POST"
				action="${pageContext.request.contextPath}/editsave"
				modelAttribute="user">
				<%-- <form:form action="editsave" method="POST" modelAttribute="user"> --%>
				<table>
					<tr>
						<td></td>
						<td><form:hidden path="userId" /></td>
					</tr>
					<tr>
						<td>Name :</td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td>Email :</td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td>Age :</td>
						<td><form:input path="age" /></td>
					</tr>
					<tr>
						<td>DOB :</td>
						<td><form:input path="dob" /></td>
						<td><form:errors path="dob" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Update" /></td>
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
