<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Contact Data</h2>
	<form:form method="POST" action="/webdm/savecontact.html">
		<table>
			<tr>
				<td><form:label path="id">Contact ID:</form:label></td>
				<td><form:input path="id" value="${contact.id}" readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="username">User Name:</form:label></td>
				<td><form:input path="username" value="${contact.name}" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:input path="password" value="${contact.password}" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:input path="name" value="${contact.name}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${!empty contacts}">
		<h2>List Contacts</h2>
		<table align="left" border="1">
			<tr>
				<th>Contact ID</th>
				<th>User Name</th>
				<th>Password</th>
				<th>Name</th>
				<th>Actions on Row</th>
			</tr>

			<c:forEach items="${contacts}" var="contact">
				<tr>
					<td><c:out value="${contact.id}" /></td>
					<td><c:out value="${contact.username}" /></td>
					<td><c:out value="${contact.password}" /></td>
					<td><c:out value="${contact.name}" /></td>
					<td align="center"><a href="editcontact.html?id=${contact.id}">Edit</a>
						| <a href="deletecontact.html?id=${contact.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
