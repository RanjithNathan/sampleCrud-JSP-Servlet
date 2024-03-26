4<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*,javax.servlet.*,javax.servlet.http.*,model.*,service.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Data</title>
</head>
<body>
		<%
	
		String sname=(String)session.getAttribute("uname");
		out.println("welcome "+sname);
		
		
		
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");

		
		
		

		%>

		
		<form  method="post">
			<table align="center">
				<tr><td>Name</td><td><input type="text" id="uname" name="name1" value="<%=name%>"></td></tr>
				
				<tr><td>Mobile</td><td><input type="text" id="mobile" name="mobile1" value="<%=mobile%>" readonly="readonly"></td></tr>
				<tr><td>Address</td><td><input type="text" id="address" name="address1" value="<%=address%>"></td></tr>
				<tr><td></td><td><input type="submit" name=""></td></tr>
			</table>

</form>
<%
		PrimaryBean pbean=new PrimaryBean();
		SecondaryBean sbean=new SecondaryBean();
		
		pbean.setStname(request.getParameter("name1"));
		pbean.setMobilenumber(request.getParameter("mobile1"));
		sbean.setAddress(request.getParameter("address1"));
		
		String name1=pbean.getStname();
		String mobile1=pbean.getMobilenumber();
		String address1=sbean.getAddress();




try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDetails","root","Rk@mysql09");
	
	PreparedStatement pps=connect.prepareStatement("update  Primarydata set stname=? where mobilenumber=?");
	PreparedStatement sps=connect.prepareStatement("update Secondarydata set address=? where mobilenumber=?");
	pps.setString(1,name1);
	pps.setString(2,mobile1);
	
	sps.setString(1, address1);
	sps.setString(2, mobile1);
	
	int  rs1=pps.executeUpdate();
	int rs2=sps.executeUpdate();
 
	if(rs1>0 && rs2>0)
	{
	request.getRequestDispatcher("/ViewUsers.jsp").forward(request, response);

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