<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String value=(String)session.getAttribute("name");
out.println("welcome "+value); %>

	<form action="PrimaryDataController" method="post">
<table align="center">
<tr><td>Name</td><td><input type="text" id="uname" name="name"></td></tr>

<tr><td>Mobile</td><td><input type="text" id="mobile" name="mobile"></td></tr>

<tr><td></td><td><input type="submit" name=""></td></tr>
</table>

</form>
</body>
</html>