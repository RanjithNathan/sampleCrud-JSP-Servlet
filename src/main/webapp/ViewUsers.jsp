<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.util.*,model.*,service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Details</title>
</head>
<body>
<a href="index.jsp">Log in</a>

<%
		String name=(String)session.getAttribute("uname");
		out.println("welcome "+name);
%>
<table border="2px" align="center">
		<tr>
			<th>NAME</th>
			<th>MOBILE NUMBER</th>
			<th>ADDRESS</th>
			<th>EDIT</th>
			<th>DELETE</th>
			
		</tr>
		<%
		List<PrimaryBean> primaryResponse=DbService.getPrimaryData();
		List<SecondaryBean> secondaryResponse=DbService.getSecondaryData();
		
		Map<String,PrimaryBean> primarymap=new HashMap<String,PrimaryBean>();
		
		if(!primaryResponse.isEmpty())
		{
			for(PrimaryBean primarydata:primaryResponse)
			{
				primarymap.put(primarydata.getMobilenumber(), primarydata);
				
			}
			
		}
		if(!secondaryResponse.isEmpty())
		{
			for(SecondaryBean secondarydata:secondaryResponse)
			{
				PrimaryBean primarydata=primarymap.get(secondarydata.getMobilenumber());
				//out.print(primarydata.getMobilenumber()+""+primarydata.getStname()+""+secondarydata.getAddress());
				
		%>

		<tr>
		<td><%=primarydata.getStname() %></td>
		<td><%=primarydata.getMobilenumber()%></td>
		<td><%=secondarydata.getAddress() %></td>
		<td><a href="EditData.jsp?mobile=<%=primarydata.getMobilenumber()%>&name=<%=primarydata.getStname()%>&address=<%=secondarydata.getAddress()%>">Edit</a></td>
		<td><a href="DeleteData.jsp?mobile=<%=primarydata.getMobilenumber()%>">Delete</a></td>
		
		</tr>
		
		<%
			}
			}
			
		%>

</table>

</body>
</html>