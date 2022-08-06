<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>All Users</title>
</head>
<body>
	<a class="button" href="/register">Add User</a>
	<H1><u>All Users</u></H1>
	<div>
		<table border="1">
			<caption></caption>
			<thead>
				<tr>
					<th>User ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email ID</th>
					<th>Age</th>
					<th>Gender</th>
					<th>Mobile Nos</th>
					<th>Hubbies</th>
					<th>Date Of Birth</th>
					<th>Actions</th>
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
</body>
</html>