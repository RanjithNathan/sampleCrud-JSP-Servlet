<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin page</title>
<style>
body{
background-color:lightblue;}
</style>
</head>
<body>

<% 
			//String uname=request.getParameter("username");
		//	String pass=request.getParameter("password");
			//out.println("welcome mr."+uname);
			
			
			String name=(String)session.getAttribute("name");
			//out.println("welcome, "+name);
			%>
			<h1>welcome<%=" Mr."+name%></h1>
			<table>
			<tr>
			<td></td>
			<td><a href="index.jsp">Log in</a></td>
			
				<td></td><td><a href="Addprimary.jsp">Add primary</a></td>
				<td></td><td><a href="AddSecondary.jsp">Add Secondary</a></td>
			</tr>
			</table>
			
			
</body>
</html>