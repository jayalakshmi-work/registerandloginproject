package com.techpalle.dao;

import java.sql.*;

import com.tecpalle.model.Customer;

public class DataAcesss
{
  private static final String dburl = "jdbc:mysql://localhost:3306/jayalakshmi";
  private static final String dbusername = "root";
  private static final String dbpassword = "Ja19ya97";
	
	private static Connection con = null;
	private static Statement s = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private static final String insertQry = "insert into customer(name, email, mobile, password, state) values(?,?,?,?,?)";
	
	private static final String validateqry = "select email, password from customer where email = ? and password = ?";

	public static boolean validateCustomer(String email, String password)
	{
		boolean b = false;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dburl,dbusername, dbpassword);
			
			ps = con.prepareStatement(validateqry);
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			 rs = ps.executeQuery();
			
	
			b = rs.next();
			 
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(rs != null)
			{
				try {
					rs.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(ps != null || con !=null)
			{
			try {
				ps.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			}
		}
		return b;
		
		
		
		
	}
public static void insertCustomer(Customer customer)
{
	
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(dburl,dbusername, dbpassword);
		
		ps = con.prepareStatement(insertQry);
		
		ps.setString(1,customer.getName());
		ps.setString(2, customer.getEmail());
		ps.setLong(3, customer.getMobile());
		ps.setString(4, customer.getPassword());
		ps.setString(5, customer.getState());
		
		ps.executeUpdate();
		
		
		
	} 
	catch (ClassNotFoundException e) 
	{
		e.printStackTrace();
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally
	{
		if(ps != null)
		{
		try {
			ps.close();
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		}
	}
	
	
	
	
	
}



}
