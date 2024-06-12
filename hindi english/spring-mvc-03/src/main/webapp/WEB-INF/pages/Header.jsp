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
	<c:if test="${not empty sessionScope.user}">
		<h3>
			Hii,
			<c:out value="${sessionScope.user.firstName}"></c:out>
			<a href="<c:url value="/ctl/User"/>">Add User</a> | <a
				href="<c:url value="/ctl/User/search"/>">User List</a> | <a
				href="<c:url value="/Login?operation=logout"/>">Logout</a>
		</h3>
	</c:if>
	<c:if test="${empty sessionScope.user}">
		<h3>
			<s:message code="header.Hi"></s:message>
			, Guest
		</h3>
		<a href="<c:url value="?lang=en"/>"><b>English</b></a> | <a
			href="<c:url value="?lang=hi"/>"><b><s:message
					code="lable.hindi" /></b> </a>
	</c:if>
	<hr>
</body>
</html>