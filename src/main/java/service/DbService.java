package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.PrimaryBean;
import model.SecondaryBean;
import java.util.*;

public class DbService 
{
 
	public static List<PrimaryBean> getPrimaryData()
	{
		List<PrimaryBean> primarylist=new ArrayList<PrimaryBean>();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDetails","root","Rk@mysql09");
		PreparedStatement prestate=connect.prepareStatement("select * from primarydata");
		
		
		ResultSet rs=prestate.executeQuery();
		while(rs.next())
		{
			PrimaryBean bean=new PrimaryBean();
			String name=rs.getString("stname");
			String mob=rs.getString("mobilenumber");
			
			bean.setMobilenumber(mob);
			bean.setStname(name);
			
			primarylist.add(bean);
		}
		
		
		
	}catch(SQLException e)
	{
		System.out.println(e);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
		return primarylist;
}
	
	
	public static List<SecondaryBean> getSecondaryData()
		{
		List<SecondaryBean> secondarylist=new ArrayList<SecondaryBean>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDetails","root","Rk@mysql09");
				PreparedStatement prestate=connect.prepareStatement("select * from Secondarydata");
				
				
				
				ResultSet rs=prestate.executeQuery();
				while(rs.next())
				{
					SecondaryBean bean=new SecondaryBean();
					String address=rs.getString("address");
					String mob=rs.getString("mobilenumber");
					
					bean.setMobilenumber(mob);
					bean.setAddress(address);
					secondarylist.add(bean);
				}
				
			}catch(SQLException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return secondarylist;

}
}
