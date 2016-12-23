<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>List Contacts</h1>
	<h3>
		<a href="addcontact1.html">Add More Contact</a>
	</h3>

	<c:if test="${!empty contacts}">
		<table align="left" border="1">
			<tr>
				<th>Contact ID</th>
				<th>User Name</th>
				<th>Password</th>
				<th>Name</th>
			</tr>

			<c:forEach items="${contacts}" var="contact">
				<tr>
					<td><c:out value="${contact.id}" /></td>
					<td><c:out value="${contact.username}" /></td>
					<td><c:out value="${contact.password}" /></td>
					<td><c:out value="${contact.name}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
