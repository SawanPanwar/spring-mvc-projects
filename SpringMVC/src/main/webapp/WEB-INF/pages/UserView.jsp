<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
	color: red;
	font-weight: bold;
}

.success {
	color: green;
	font-weight: bold;
}
</style>
</head>
<body>
	<%-- <%@ include file="Header.jsp"%> --%>
	<sf:form method="post" modelAttribute="form">
		<div align="center">
			<h1 style="color: navy">Add User</h1>
			<table>
				<tr>
					<th align="left">First Name :</th>
					<td><sf:input path="firstName" /></td>
					<td class="error" style="position: fixed;"><sf:errors
							path="firstName"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Last Name :</th>
					<td><sf:input path="lastName" /></td>
					<td class="error" style="position: fixed;"><sf:errors
							path="lastName"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Login ID :</th>
					<td><sf:input path="login" /></td>
					<td class="error" style="position: fixed;"><sf:errors
							path="login"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Password :</th>
					<td><sf:input path="password" /></td>
					<td class="error" style="position: fixed;"><sf:errors
							path="password"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Date Of Birth :</th>
					<td><sf:input path="dob" /></td>
					<td class="error" style="position: fixed;"><sf:errors
							path="dob"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Address :</th>
					<td><sf:input path="address" /></td>
					<td class="error" style="position: fixed;"><sf:errors
							path="address"></sf:errors></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit"></td>
				</tr>
			</table>
		</div>
	</sf:form>
</body>
</html>