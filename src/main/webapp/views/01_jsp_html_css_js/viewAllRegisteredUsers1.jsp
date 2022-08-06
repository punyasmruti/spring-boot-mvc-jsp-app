<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" href="webjars/bootstrap/4.2.1/css/bootstrap.min.css"> -->
<style type="text/css">
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
	margin-top: 0px;
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
	background-image: linear-gradient(rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.4)),
		url('images/showcase.jpg');
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
	margin: 5px 0 10px 0;
	font-size: 45px;
	font-weight: 700;
	text-shadow: 2px 1px 5px black;
	text-transform: uppercase;
	text-decoration: underline;
}

section p {
	font-size: 15px;
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
				<li><a href="#">Login</a></li>
				<li><a href="register">Sign Up</a></li>
				<li><a href="home">Home</a></li>
			</ul>
		</nav>
	</header>
	<!-- ######################################## main or body  content  ################################## -->
	<main>
	<section>
		<div class="container">
			<h1 align="center">All Registered Users</h1>
			<!-- <h1 align="center"><a href="register">New User ? Register Here</a></h1> -->
			<table border="1" width="100%">
				<tr>
					<th>User ID</th>
					<th>Name</th>
					<th>Email ID</th>
					<th>Age</th>
					<th>Date Of Birth</th>
					<th>Edit/Delete</th>
					<!-- <th>Delete</th> -->
				</tr>
				<c:forEach var="user" items="${usersList}">
					<tr>
						<td align="center">${user.userId}</td>
						<td align="center">${user.name}</td>
						<td align="center">${user.email}</td>
						<td align="center">${user.age}</td>
						<td align="center"><fmt:formatDate value="${user.dob}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
						<%-- <td align="center"><a href="edituser?id=${user.id}" type="button" class="btn btn-warning">Edit</a>/<a href="deleteuser?id=${user.id}" type="button" class="btn btn-warning">Delete</a></td> --%>
						<td align="center"><a href="edituser/${user.userId}">Edit</a> / <a href="deleteuser/${user.userId}">Delete</a></td>
						<%-- <td><a href="deleteuser/${user.id}">Delete</a></td> --%>
					</tr>
				</c:forEach>
			</table>
	<!-- 
	<script src="webjars/jquery/4.2.1/js/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.2.1/js/bootstrap.min.js"> </script> -->
	</div>
	</section>
	</main>
	<footer>
		<a href="#">copy_write @ punyasmruti</a>
	</footer>
</body>
</html>


