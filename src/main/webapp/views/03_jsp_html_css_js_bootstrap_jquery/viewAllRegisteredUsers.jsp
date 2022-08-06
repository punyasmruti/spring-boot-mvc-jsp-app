<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Hi ${name}</title>
<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
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
	<div class="container">
		<table class="table table-striped">
			<caption>All Users</caption>
			<thead>
				<tr>
					<th>User ID</th>
					<th>Name</th>
					<th>Email ID</th>
					<th>Age</th>
					<th>Date Of Birth</th>
					<th>Edit/Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usersList}" var="user">
					<tr>
						<td align="center">${user.userId}</td>
						<td align="center">${user.name}</td>
						<td align="center">${user.email}</td>
						<td align="center">${user.age}</td>
						<td align="center"><fmt:formatDate value="${user.dob}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
						<%-- <td align="center"><a href="edituser?id=${user.id}" type="button" class="btn btn-warning">Edit</a>/<a href="deleteuser?id=${user.id}" type="button" class="btn btn-warning">Delete</a></td> --%>
						<td align="center"><a href="edituser/${user.userId}">Edit</a>/<a href="deleteuser/${user.userId}">Delete</a></td>
						<%-- <td><a href="deleteuser/${user.id}">Delete</a></td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<a class="button" href="/register">Add</a>
	</div>
	<!-- <script src="webjars/jquery/1.9.1/jquery.min.js"></script> -->
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>