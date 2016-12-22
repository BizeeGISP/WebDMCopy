<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
    function goToNewPage()
    {
        var url = document.getElementById('list').value;
        if(url != 'none') {
            window.location = url;
        }
    }
</script>
</head>
<body>
	<form method="POST" action="/webdm/form.html">
		<select name="list" id="list" >
			<option value='none' selected>Dropdown</option>
			<option value="form1.html">url 1</option>
			<option value="index2.html">url 2</option>
			<option value="index3.html">url 3</option>
        </select>
		<input type=button value="Go" onclick="goToNewPage()" />
	</form>
</body>
</html>