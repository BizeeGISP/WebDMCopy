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
<h2>Add Role Data</h2>
	<form:form method="POST" action="/webdm/saverole.html">
		<table>
			<tr>
				<td><form:label path="roleid">Role ID:</form:label></td>
				<td><form:input path="roleid" value="${role.roleid}" readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="rolename">Role Name:</form:label></td>
				<td><form:input path="rolename" value="${role.rolename}" /></td>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${!empty roles}">
		<h2>List Roles</h2>
		<table align="left" border="1">
			<tr>
				<th>Role ID</th>
				<th>Role Name</th>
				<th>Actions on Row</th>
			</tr>

			<c:forEach items="${roles}" var="role">
				<tr>
					<td><c:out value="${role.roleid}" /></td>
					<td><c:out value="${role.rolename}" /></td>
					<td align="center"><a href="editrole.html?roleid=${role.roleid}">Edit</a>
						| <a href="deleterole.html?roleid=${role.roleid}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
