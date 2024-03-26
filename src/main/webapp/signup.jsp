<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up page</title>
<style>
body{
background-color:lightblue;}
</style>
</head>
<body>
<form action="Registercontroller" method="post">
<table align="center">
<tr><td>Username</td><td><input type="text" id="uname" name="username" required></td></tr>
<tr><td>Password</td><td><input type="password" id="pwd" name="password" required></td></tr>
<tr><td>E-mail</td><td><input type="email" id="email" name="email" required></td></tr>
<tr><td>Mobile</td><td><input type="text" id="mobile" name="mobile" required></td></tr>
<tr><td><a href="index.jsp">Login </a></td><td><input type="submit" name="" required></td></tr>
</table>

</form>
</body>
</html>