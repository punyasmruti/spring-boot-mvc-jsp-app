<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/static/css/custom.css" rel="stylesheet">
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
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email ID</th>
					<th>Age</th>
					<th>Gendere</th>
					<th>Mobile No</th>
					<th>Hubbies</th>
					<th>Date Of Birth</th>
					<th>Edit/Delete</th>
					<!-- <th>Delete</th> -->
				</tr>
				<c:forEach items="${usersList}" var="user">
					<tr>
						<td align="center">${user.userId}</td>
						<td align="center">${user.firstname}</td>
						<td align="center">${user.lastname}</td>
						<td align="center">${user.emailId}</td>
						<td align="center">${user.age}</td>
						<td align="center">${user.gender}</td>
						<td align="center">${user.mobileNos}</td>
						<td align="center">${user.hubbies}</td>
						<%-- <td align="center"><fmt:formatDate value="${user.dob}" pattern="dd/MM/yyyy"></fmt:formatDate></td> --%>
						<td align="center"><fmt:formatDate value="${user.dob}" pattern="dd MMM yyyy"></fmt:formatDate></td>
						<%-- <td align="center"><a href="edituser?id=${user.id}" type="button" class="btn btn-warning">Edit</a>/<a href="deleteuser?id=${user.id}" type="button" class="btn btn-warning">Delete</a></td> --%>
						<td align="center"><a href="edituser/${user.userId}">Edit</a>/<a href="deleteuser/${user.userId}">Delete</a></td>
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
		<a href="#">copy_write@punya_blog_spot</a>
	</footer>
</body>
</html>


