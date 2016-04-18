<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile: <c:out value="${user.userName}" /></title>
</head>
<body>
	<div class="profileView">
		<h1>
			<c:out value="${user.userName}" />
		</h1>
		<c:out value="${user.firstName}" />
		<c:out value="${user.lastName}" />
	</div>
</body>
</html>