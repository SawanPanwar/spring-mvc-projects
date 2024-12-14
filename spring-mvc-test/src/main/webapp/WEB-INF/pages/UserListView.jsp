<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<sf:form method="post" modelAttribute="form">
		<table style="width: 100%" border="1">
			<tr>
				<th>Select</th>
				<th>ID</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Login</th>
				<th>Password</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Edit</th>
			</tr>
			<c:forEach items="${list}" var="user">
				<tr>
					<td align="center"><sf:checkbox path="id" value="${user.id}" /></td>
					<td align="center"><c:out value="${user.id }"></c:out></td>
					<td align="center"><c:out value="${user.firstName }"></c:out></td>
					<td align="center"><c:out value="${user.lastName }"></c:out></td>
					<td align="center"><c:out value="${user.login }"></c:out></td>
					<td align="center"><c:out value="${user.password }"></c:out></td>
					<td align="center"><c:out value="${user.dob }"></c:out></td>
					<td align="center"><c:out value="${user.address }"></c:out></td>
					<td align="center"><a href="<c:url value="/User" />">edit</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
	</sf:form>
</body>
</html>