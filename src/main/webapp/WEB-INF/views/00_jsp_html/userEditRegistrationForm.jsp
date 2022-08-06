<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>User Edit</title>
<style>  
</style>
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
				action="${pageContext.request.contextPath}/tutorial/springmvc/userRegister">
				<%-- <form:form action="editsave" method="POST" modelAttribute="user"> --%>
				<form:errors path = "*" cssClass = "errorblock" element = "div" />
				<table>
					<tr>
						<td></td>
						<td><form:hidden path="userId" /></td>
					</tr>
					<tr>
						<td>First Name :</td>
						<td><form:input type="text" path="firstname" /></td>
					</tr>
					<tr>
						<td>Last Name :</td>
						<td><form:input type="text" path="lastname" /></td>
					</tr>
					<tr>
						<td>Email :</td>
						<td><form:input type="text" path="emailId" /></td>
					</tr>
					<tr>
						<td>Age :</td>
						<td><form:input type="number" path="age" /></td>
					</tr>
					<tr>
						<td>DOB (dd/mm/yyyy):</td>
						<td><form:input type="text" path="dob" /></td>
						<td><form:errors path="dob" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td>Mobile Nos:</td>
						<td><form:input type="text" path="mobileNos" /></td>
						<td><form:errors path="mobileNos" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td>Hubbies:</td>
						<td><form:input type="text" path="hubbies" /></td>
						<td><form:errors path="hubbies" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td>Gender :</td>
						<td><form:input type="text" path="gender" /></td>
						<td><form:errors path="gender" cssClass="errormsg" /></td>
					</tr>
					<%-- <tr>
						<td>Skills :</td>
						<td><form:select name="skills" multiple/>
						<option value="corejava">corejava</option>
						<option value="spring">spring</option>
						<option value="hb">Hb</option>
						</form:select>
						</td>
						<td><form:errors path="skills" cssClass="errormsg" /></td>
					</tr> --%>
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
