<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Profiles</title>
</head>
<body>
	<h1>Profile List</h1>
	<h3>
		<a href="addprofile1.html">Add More profiles</a>
	</h3>

	<c:if test="${!empty profiles}">
		<table align="left" border="1">
			<tr>
				<th> ID</th>
				<th> Name</th>
			</tr>

			<c:forEach items="${profiles}" var="profile">
				<tr>
					<td><c:out value="${profile.id}" /></td>
					<td><c:out value="${profile.name}" /></td>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>