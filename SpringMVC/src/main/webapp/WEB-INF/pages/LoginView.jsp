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
	<br>
	<br>
	<%-- <%@ include file="Header.jsp"%> --%>
	<sf:form method="post" modelAttribute="form">
		<div align="center">
			<h1 style="color: navy">Login</h1>
			<div style="height: 15px; margin-bottom: 12px">
				<H3 align="center" class="success">
					<c:if test="${not empty success}">${success}</c:if>
				</H3>
				<H3 align="center" class="error">
					<c:if test="${not empty error}">${error}</c:if>
				</H3>
			</div>
			<table>
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
					<th></th>
					<td><input type="submit" name="operation" value="signIn"
						style="margin-right: 5px;"><input type="submit"
						name="operation" value="signUp"></td>
				</tr>
			</table>
		</div>
	</sf:form>
</body>
</html>