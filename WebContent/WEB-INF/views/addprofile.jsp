<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add profile Page</title>
</head>
<body>
	<h2>Add profile Data</h2>
	<form:form method="POST" action="/webdm/save.html">
		<table>
			<tr>
				<td><form:label path="id"> ID:</form:label></td>
				<td><form:input path="id" value="${profile.id}" readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="name"> Name:</form:label></td>
				<td><form:input path="name" value="${profile.name}" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${!empty profiles}">
		<h2> profiles List</h2>
		<table align="left" border="1">
			<tr>
				<th> ID</th>
				<th> Name</th>
				<th>Actions on Row</th>
			</tr>

			<c:forEach items="${profiles}" var="profile">
				<tr>
					<td><c:out value="${profile.id}" /></td>
					<td><c:out value="${profile.name}" /></td>
					
					<td align="center"><a href="edit.html?id=${profile.id}">Edit</a>
						| <a href="delete.html?id=${profile.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>