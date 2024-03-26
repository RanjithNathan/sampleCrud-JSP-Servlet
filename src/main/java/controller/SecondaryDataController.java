package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondaryDataController")
public class SecondaryDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SecondaryDataController() {
        super();
      
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			response.setContentType("text/html");
		
		try(PrintWriter out=response.getWriter())
		{
			String address=request.getParameter("address");
			String mobile=request.getParameter("mobile");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDetails","root","Rk@mysql09");
			PreparedStatement prestate=connect.prepareStatement("insert into secondarydata(address,mobilenumber)values(?,?)");
				prestate.setString(1, address);
				prestate.setString(2,mobile);
				
				int state=prestate.executeUpdate();
			
				if(state>0)
				{
					out.print("<h1 style='color:green'>your record saved successfully</h1>");
					request.getRequestDispatcher("/Adminhome.jsp").include(request, response);
				
				}
				else{
					
					out.print("<h1 style='color:green'>sorry, unable to save your record <h1>");
				}
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	}


