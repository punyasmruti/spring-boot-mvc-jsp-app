<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>User Reg Page</title>
<style type="text/css">
/*.errormsg{color:red}  
.errorblock {
         color: #000;
         background-color: #ffEEEE;
         border: 3px solid #ff0000;
         padding: 8px;
         margin: 16px;
      }*/
      


* {
	margin: 0px;
	padding: 0px;
}

/*####################################################################################################
	header section
    ####################################################################################################*/
header {
	margin: auto;
	/* border: 2px solid red; */
	background-color: #5d2e2e;
	height: 118px;
	/* border-radius: 10px; */
}

img {
	margin: auto;
	padding: 5px;
	display: block;
	width: 70px;
	border-radius: 40px;
}

h1 {
	text-align: center;
	margin: 0px;
	color: white;
}

.navbar {
	background-color: black;
	/* border-radius: 10px; */
	/* border: 2px solid red; */
}

.navbar ul {
	overflow: auto;
	margin-top: 40px;
}

.navbar li {
	float: right;
	list-style: none;
	margin: 10px 20px;
}

.navbar li a {
	color: white;
	padding: 3px 30px;
	text-decoration: none;
}

.navbar li a:hover {
	color: orange
}

/*######################################################################################################
main or body content
######################################################################################################*/
main {
	width: 100%;
	height: 76.3vh;
	background-image: linear-gradient(rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.4)), url('images/showcase.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: center;
	color: white;
}

span {
	background-color: blue;
}

section h3 {
	font-size: 35px;
	font-weight: 200;
	letter-spacing: 3px;
}

section h1 {
	margin: 30px 0 20px 0;
	font-size: 45px;
	font-weight: 700;
	text-shadow: 2px 1px 5px black;
	text-transform: uppercase;
}

section p {
	font-size: 25px;
	word-spacing: 2px;
	margin-bottom: 25px;
	text-shadow: 1px 1px 1px black;
}

section a {
	padding: 12px 30px;
	border-radius: 4px;
	outline: none;
	/*text-transform: uppercase;*/
	font-size: 13px;
	font-weight: 500;
	text-decoration: none;
	letter-spacing: 1px;
	color: white;
}

section .btn_login {
	background: orange;
}

section .btn_signup {
	background: orange;
}
/*main or body section endened */

/*####################################################################################################
	footer section
####################################################################################################*/
footer {
	width: 100%;
	height: 5vh;
	/*background-image: linear-gradient(rgba(0,0,0,0.3),rgba(0,0,0,0.1)), url('../images/showcase.jpg');*/
	/*background-repeat: no-repeat;*/
	/*background-size: cover;*/
	background-color: #5d2e2e;
	text-align: center;
	padding-top: 5px;
}

footer a {
	font-size: 15px;
	font-weight: 500;
	text-decoration: none;
	letter-spacing: 1px;
	color: white;
}
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
				action="${pageContext.request.contextPath}/tutorial/springmvc/userRegister" modelAttribute="userRegistration">
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
