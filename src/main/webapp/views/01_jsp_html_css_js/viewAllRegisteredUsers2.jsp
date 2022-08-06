<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Hi ${name}</title>
</head>
<body>
	<H1>All Users</H1>
	<div>
		<table>
			<caption>Users are</caption>
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
	<a class="button" href="/register">Add</a>
</body>
</html>