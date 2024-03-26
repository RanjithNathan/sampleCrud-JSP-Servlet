<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.sql.*,javax.servlet.*,javax.servlet.http.*,model.*,service.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete data</title>
</head>
<body>
	
		<%String sname=(String)session.getAttribute("uname");
		out.println("welcome "+sname);

		
		String mobile=request.getParameter("mobile");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDetails","root","Rk@mysql09");
			PreparedStatement prestate1=connect.prepareStatement("delete from primarydata where mobilenumber=? ");
			PreparedStatement prestate2=connect.prepareStatement("delete  from secondarydata where mobilenumber=?");
					prestate1.setString(1, mobile);
					prestate2.setString(1, mobile);
			
			 int status1=prestate1.executeUpdate();
			 int status2=prestate2.executeUpdate();
			 if(status1>0 && status2>0)
			 {
				 out.println("<h1 style='color:green'>your data deleted successfully</h1>");
				 request.getRequestDispatcher("/ViewUsers.jsp").include(request, response);
			 }
			
		}catch(SQLException e)
		{
			out.println(e);
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
		%>
</body>
</html>