<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <%@ include file="Header.jsp"%> --%>
	<div align="center">
		<h1 align="center" style="margin-bottom: -15; color: navy;">User
			List</h1>

		<sf:form method="post" modelAttribute="form">
			<table style="width: 30%">
				<tr>
					<td><sf:input path="firstName"
							placeholder="Enter First Name Here" style="margin-right: 5px;" /></td>
					<td><sf:input path="dob"
							placeholder="Enter Date Of Birth Here" style="margin-right: 5px;" /></td>
					<td><sf:select path="userId">
							<sf:option value="0">-----------select------------</sf:option>
							<sf:options items="${userList}" itemValue="id"
								itemLabel="firstName" />
						</sf:select></td>
					<td><input type="submit" name="operation" value="search">
					</td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
			</table>
			<table border="1" style="width: 100%; border: groove;">
				<tr style="background-color: #e1e6f1e3;">
					<th width="5%">Select</th>
					<th width="5%">S.No.</th>
					<th width="13%">FirstName</th>
					<th width="13%">LastName</th>
					<th width="13%">LoginId</th>
					<th width="8%">Password</th>
					<th width="13%">DOB</th>
					<th width="8%">Address</th>
					<th width="5%">Edit</th>
				</tr>

				<c:forEach items="${list}" var="user">

					<tr>
						<td style="text-align: center;"><sf:checkbox path="ids"
								value="${user.id}" /></td>
						<td style="text-align: center;">1</td>
						<td style="text-align: center;"><c:out
								value="${user.firstName }"></c:out></td>
						<td style="text-align: center;"><c:out
								value="${user.lastName }"></c:out></td>
						<td style="text-align: center;"><c:out value="${user.login }"></c:out></td>
						<td style="text-align: center;"><c:out
								value="${user.password }"></c:out></td>
						<td style="text-align: center;"><c:out value="${user.dob }"></c:out></td>
						<td style="text-align: center;"><c:out
								value="${user.address }"></c:out></td>
						<td style="text-align: center;"><a
							href="<c:url value="/ctl/User?id=${user.id}"/>">edit</a></td>
					</tr>

				</c:forEach>
			</table>
			<table style="width: 100%">
				<tr>
					<td style="width: 25%"><input type="submit" name="operation"
						value="previous"></td>
					<td align="center" style="width: 25%"><input type="submit"
						name="operation" value="add"></td>
					<td align="center" style="width: 25%"><input type="submit"
						name="operation" value="delete"></td>
					<td style="width: 25%" align="right"><input type="submit"
						name="operation" value="next"></td>
				</tr>
			</table>
		</sf:form>
	</div>
</body>
</html>