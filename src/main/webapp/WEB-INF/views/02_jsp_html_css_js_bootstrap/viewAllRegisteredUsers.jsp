<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>All Users</title>
<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<nav role="navigation" class="navbar navbar-default">
	<div class="navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="/login">Login</a></li>
			<li class="active"><a href="/users/users">Users</a></li>
		</ul>
	</div>
</nav>
	<div class="container">
		<table class="table table-striped">
			<caption>All Users</caption>
			<thead>
				<tr>
					<th>User ID</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email ID</th>
					<th>Age</th>
					<th>Gender</th>
					<th>MobileNo</th>
					<th>Hobby</th>
					<th>Date Of Birth</th>
					<th>Edit/Delete</th>
				</tr>
			</thead>
			<tbody>
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
			</tbody>
		</table>
	</div>
	<div>
		<a class="button" href="/users/register">Add</a>
	</div>
	<!-- <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
</body>
</html>