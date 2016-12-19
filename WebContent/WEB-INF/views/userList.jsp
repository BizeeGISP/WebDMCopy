<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<h2>Add Student Data</h2>
	<form:form method="POST" action="/bizee/save.do">
		<table>
			<tr>
				<td><form:label path="userid">User ID:</form:label></td>
				<td><form:input path="userid" value="${user.userid}" readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="username">User Name:</form:label></td>
				<td><form:input path="username" value="${user.username}" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Student Password:</form:label></td>
				<td><form:input path="password" value="${user.password}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${!empty user}">
		<h2>List Users</h2>
		<table align="left" border="1">
			<tr>
				<th>User ID</th>
				<th>User Name</th>
				<th>Password</th>
			    <th>Actions on Row</th>
			</tr>

			<c:forEach items="${user}" var="user">
				<tr>
					<td><c:out value="${user.userid}" /></td>
					<td><c:out value="${user.usernamename}" /></td>
					<td><c:out value="${user.password}" /></td>
			         <td align="center"><a href="edit.do?id=${user.userid}">Edit</a>
						| <a href="delete.do?userid=${user.userid}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html> --%>