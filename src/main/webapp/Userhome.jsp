<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home Page</title>
<style>
body{
background-color:lightblue;}
</style>
</head>
<body>
<%
		String name=(String)session.getAttribute("uname");
		out.println("welcome "+name);
%>
<h1>Welcome Mr.<%=name %></h1>

<a href="ViewUsers.jsp">View Users 
</body>
</html>