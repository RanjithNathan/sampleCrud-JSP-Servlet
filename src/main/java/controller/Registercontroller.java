package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registercontroller")
public class Registercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Registercontroller() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		response.setContentType("text/html");

		try(PrintWriter  out=response.getWriter()) {
			
			String uname=request.getParameter("username");
			String pass=request.getParameter("password");
			String mail=request.getParameter("email");
			String mob=request.getParameter("mobile");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","Rk@mysql09");
			PreparedStatement prestate=connect.prepareStatement("insert into userdetails (name,password,email,mobile)values(?,?,?,?)");
			//Statement state=connect.createStatement();
		//int s=	state.executeUpdate("insert into userdetails (name,password,email,mobile) values('"+uname+"','"+pass+"','"+mail+"','"+mob+"')");
			prestate.setString(1, uname);
			prestate.setString(2, pass);
			prestate.setString(3, mail);
			prestate.setString(4, mob);
			
			int s=prestate.executeUpdate();
			if(s>0)
			{
				out.println("<h1>your record submitted succesfully</h1>");
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
