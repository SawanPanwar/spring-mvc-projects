<%@page import="com.rays.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		UserDTO user = (UserDTO) session.getAttribute("user");
	%>
	<table width="100%" border="0">
		<tr>
			<td width="90%"><a href="<c:url value="/Welcome"/>"><b>Welcome</b></a>
				| <%
				if (user != null) {
			%> <a href="<c:url value="/Login"/>"><b>Logout</b></a> <%
 	} else {
 %><a href="<c:url value="/Login" />"><b>Login</b></a> <%
 	}
 %></td>
			<td rowspan="2">
				<%-- <h1 align="Right">
					<img
						src='<c:url  value="/SpringMVC/resources/image/customLogo.jpg"></c:url>'
						width="318" height="90">
				</h1> --%>
			</td>
		</tr>
		<tr>
			<td>
				<%
					if (user != null) {
				%>
				<h3>
					Hii,
					<%=user.getFirstName()%></h3> <a href="<c:url value="/ctl/User"/>"><b>Add
						User</b></a> | <a href="<c:url value="/ctl/User/search"/>"><b>User
						List</b></a> <%
 	} else {
 %>
				<h3>Hi, Guest</h3> <a href="?lang=en"><b>English</b></a> | <a
				href="?lang=hi"> <b><s:message code="lable.hindi"></s:message></b>
			</a> <%
 	}
 %>
			</td>
		</tr>
	</table>
	<hr>
</body>
</html>