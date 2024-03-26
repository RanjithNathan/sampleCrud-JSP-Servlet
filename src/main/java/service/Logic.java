package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;

public class Logic {
	public static PrimaryBean getElementByMobile(String mobile)
	{
		PrimaryBean pbean=new PrimaryBean();
		SecondaryBean sbean=new SecondaryBean();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDetails","root","Rk@mysql09");
			//PreparedStatement pps=connect.prepareStatement("select *  primarydata.*,secondarydata.* from primarydata leftjoin secondarydata on primarydata.mobilenumber=secondarydata.mobilenumber ");
			PreparedStatement pps=connect.prepareStatement("select * from Primarydata where mobilenumber=?");
			PreparedStatement sps=connect.prepareStatement("select * from Secondarydata where mobilenumber=?");
			pps.setString(1, mobile);
			sps.setString(1, mobile);
			ResultSet rs1=pps.executeQuery();
			ResultSet rs2=sps.executeQuery();
			
			while(rs1.next())
			{
				pbean.setMobilenumber(rs1.getString(2));
				pbean.setStname(rs1.getString(1));
				
			
			}
			while(rs2.next())
			{
				sbean.setMobilenumber(rs2.getString(2));
				sbean.setAddress(rs2.getString(1));
			}
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return pbean;
	}

}
