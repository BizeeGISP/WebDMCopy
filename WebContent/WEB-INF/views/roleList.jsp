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
<h1>List Roles</h1>
	<h3>
		<a href="add.html">Add More Roles</a>
	</h3>

	<c:if test="${!empty roles}">
		<table align="left" border="1">
			<tr>
				<th>Role ID</th>
				<th>Role Name</th>
		    </tr>

			<c:forEach items="${roles}" var="role">
				<tr>
					<td><c:out value="${role.roleid}" /></td>
					<td><c:out value="${role.rolename}" /></td>
			   </tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
