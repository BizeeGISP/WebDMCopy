<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang='en'>
<head>
    <meta charset="UTF-8" /> 
    <title>
        WebDM CRM
    </title>
    <link rel="stylesheet" type="text/css" href="/webdm/styles/style.css" />
</head>
<body>

<form method="POST" action="/webdm/loginsuccess.html">
  <h1> Log in</h1>
  <div class="inset">
  
  <p>
    <label for="id">ID</label>
    <input type="hidden" name="id" id="id">
  </p>
  <p>
    <label for="username">USER NAME</label>
    <input type="text" name="username" id="username">
  </p>
  <p>
    <label for="password">PASSWORD</label>
    <input type="password" name="password" id="password">
  </p>
  <p>
    <input type="checkbox" name="remember" id="remember">
    <label for="remember">Remember me?</label>
  </p>
  </div>
  <p class="p-container">
    <span><a href="javascript:void(0)" src="">Forgot password?</a></span>
    <input type="submit" name="login" id="login" value="log in">
  </p>
</form>

</body>
</html>
