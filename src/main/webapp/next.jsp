<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Next Page</title>
<style>
body{
background-color:lightblue;}
</style>
</head>
<body>
<%
				String value=(String)session.getAttribute("name");
		out.println(value);
//session.invalidate();
%>	<h1><%=value %></h1>
<a href="Addprimary.jsp">Add Users-primary</a>
<a href="AddSecondary.jsp">Add Users-Secondary</a>

</body>
</html>