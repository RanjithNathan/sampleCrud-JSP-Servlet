<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in page</title>
<style>
body{
background-color:lightblue;}

</style>


<script type="text/javascript">
function myFunction()
	{
	//alert("please enter username and password");
	let username=document.getElementById("uname").value;
	let pass=document.getElementById("pwd").value;
	
	if(username=="")
		{
		alert("please enter username");
		return false;
		}
	if(pass=="")
		{
		alert("please enter  password");
		return false;
		}
	
	
	}
				

</script>


</head>
<body>
<form action="LoginController" method="post" onsubmit="return myFunction()">
<table align="center">
<tr><td>Username</td><td><input type="text" id="uname" name="username"></td></tr>
<tr><td>Password</td><td><input type="password" id="pwd" name="password"></td></tr>
<tr><td><a href="signup.jsp"> signup</a></td><td><input type="submit" name=""></td></tr>


</table>
</form>
</body>
</html>