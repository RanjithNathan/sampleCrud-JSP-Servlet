package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		try(PrintWriter  out=response.getWriter()) {
			
			String uname=request.getParameter("username");
			String pass=request.getParameter("password");
			
			int flag=0;
			if(uname.equals("admin") && pass.equals("admin123"))
			{
				out.println("Login Successfull");

				HttpSession session =request.getSession();
				session.setAttribute("name",uname);
				
				request.getRequestDispatcher("/Adminhome.jsp").forward(request, response);
				flag=1;
			}
			else
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","Rk@mysql09");
				PreparedStatement prestate=connect.prepareStatement("select * from userdetails ");
				ResultSet result=prestate.executeQuery();
				//int f=0;
			while(result.next())
			{
				String dbuser=result.getString("name");
				String dbpass=result.getString("password");
				
				if(dbuser.equals(uname)&& dbpass.equals(pass))
				{
					out.print("Login successfully");
					HttpSession session =request.getSession();
					session.setAttribute("uname",dbuser);
					request.getRequestDispatcher("/Userhome.jsp").forward(request, response);
					//f=1;
				}
				
			
			}
			}if(flag==0)
			{
				out.print("<h1 style='color:red'>Sorry,Please enter valid username / password<h1>");
				request.getRequestDispatcher("/index.jsp").include(request, response);
				
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
