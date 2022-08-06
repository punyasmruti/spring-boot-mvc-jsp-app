<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<style>  
.errormsg{color:red}  
.errorblock {
         color: #000;
         background-color: #ffEEEE;
         border: 3px solid #ff0000;
         padding: 8px;
         margin: 16px;
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
				<li><a href="users">All Registered Users</a></li>
				<li><a href="home">Home</a></li>
			</ul>
		</nav>
	</header>
	<!-- ######################################## main or body  content  ################################## -->
	<main>
		<section>
			<h1>User Registration</h1>
			<form:form action="userRegister3" method="post" modelAttribute="userDetailsWithAddress">
			<!-- Error block -->
			<%-- <form:errors path = "*" cssClass = "errorblock" element = "div" /> --%>
				<table>
					<tr>
						<td>First Name :</td>
						<td><form:input type="text" path="firstname" /></td>
						<td><form:errors path="firstname" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td>Last Name :</td>
						<td><form:input type="text" path="lastname" /></td>
						<td><form:errors path="lastname" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td>Email :</td>
						<td><form:input type="text" path="emailId" /></td>
						<td><form:errors path="emailId" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td>Age :</td>
						<td><form:input type="number" path="age" /></td>
						<td><form:errors path="age" cssClass="errormsg" /></td>
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
						<%-- <td><form:input type="text" path="hubbies" /></td> --%>
						<!-- OR -->
						<td><select type="text" name="hubbies" path="hubbies" multiple>
						<option value="study">study</option>
						<option value="music">music</option>
						<option value="cricket">cricket</option>
						</select>
						</td>
						<td><form:errors path="hubbies" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td>Gender :</td>
						<td><form:input type="text" path="gender" /></td>
						<td><form:errors path="gender" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td>Skills :</td>
						<%-- <td><form:input type="text" path="skills" /></td> --%>
						<!-- OR -->
						<td><select type="text" name="skills" path="skills" multiple>
						<option value="corejava">corejava</option>
						<option value="spring">spring</option>
						<option value="hb">Hb</option>
						</select>
						</td>
						<td><form:errors path="skills" cssClass="errormsg" /></td>
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
						<td>City :</td>
						<td><form:input type="text" path="address.city" /></td>
						<td><form:errors path="address.city" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td>State :</td>
						<td><form:input type="text" path="address.state" /></td>
						<td><form:errors path="address.state" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td>Country :</td>
						<td><form:input type="text" path="address.country" /></td>
						<td><form:errors path="address.country" cssClass="errormsg" /></td>
					</tr>
					<tr>
						<td></td>
						<td colspan="3" align="center"><input type="reset" value="Reset" />
						<input type="submit" value="Save" /></td>
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
