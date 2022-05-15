package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


public class Unit {
	
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unitmanage?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertUnit(String uAccNo, String uEmail, String uTotalUnit, String uAmount)  
	{   
		String output = ""; 	 
		try   
		{    
			Connection con = connect(); 
	 
			if (con == null)    
			{return "Error while connecting to the database for inserting."; } 
	 
			// create a prepared statement 
			String query = " insert into unit1(`uID`,`uAccNo`,`uEmail`,`uTotalUnit`,`uAmount`)" + " values (?, ?, ?, ?, ?)"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
			// binding values    
			 preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, uAccNo);
			 preparedStmt.setString(3, uEmail);
			 preparedStmt.setString(4, uTotalUnit);
			 preparedStmt.setString(5, uAmount);
			
			// execute the statement    
			preparedStmt.execute();    
			con.close(); 
	   
			String newUnit = readUnit(); 
			output =  "{\"status\":\"success\", \"data\": \"" + newUnit + "\"}";    
		}   
		catch (Exception e)   
		{    
			output =  "{\"status\":\"error\", \"data\": \"Error while inserting the Unit.\"}";  
			System.err.println(e.getMessage());   
		} 		
	  return output;  
	} 	
	
	public String readUnit()  
	{   
		String output = ""; 
		try   
		{    
			Connection con = connect(); 
		
			if (con == null)    
			{
				return "Error while connecting to the database for reading."; 
			} 
	 
			// Prepare the html table to be displayed    
			output = "<table class='table table-bordered table-hover'><thead class='thead-dark'><tr><th>Account No</th><th>Email</th><th>Unit Total</th><th>Total Amount</th><th>Update</th><th>Remove</th></tr></th>";
	 
			String query = "select * from unit1";    
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
	 
			// iterate through the rows in the result set    
			while (rs.next())    
			{     
				String uID = Integer.toString(rs.getInt("uID"));
				 String uAccNo = rs.getString("uAccNo");
				 String uEmail = rs.getString("uEmail");
				 String uTotalUnit = rs.getString("uTotalUnit");
				 String uAmount = rs.getString("uAmount");
				 
				// Add into the html table 
				output += "<tbody><tr><td><input id=\'hidUnitIDUpdate\' name=\'hidUnitIDUpdate\' type=\'hidden\' value=\'" + uID + "'>" 
							+ uAccNo + "</td>"; 
				output += "<td>" + uEmail + "</td>";
				output += "<td>" + uTotalUnit + "</td>";
				output += "<td>" + uAmount + "</td>";
	 
				// buttons     
				output +="<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-success'></td>"       
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-unitid='" + uID + "'>" + "</td></tr></tbody>"; 
			
			}
			con.close(); 
	   
			output += "</table>";   
		}   
		catch (Exception e)   
		{    
			output = "Error while reading the Unit.";    
			System.err.println(e.getMessage());   
		} 	 
		return output;  
	}
	
	public String updateUnit(String uID, String uAccNo, String uEmail, String uTotalUnit, String uAmount)  
	{   
		String output = "";  
		try   
		{    
			Connection con = connect(); 
	 
			if (con == null)    
			{return "Error while connecting to the database for updating."; } 
	 
			// create a prepared statement    
			String query = "UPDATE unit1 SET uAccNo=?,uEmail=?,uTotalUnit=?,uAmount=?"  + "WHERE uID=?";  	 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
			// binding values    
			preparedStmt.setString(1, uAccNo);
			 preparedStmt.setString(2, uEmail);
			 preparedStmt.setString(3, uTotalUnit);
			 preparedStmt.setString(4, uAmount);
			 preparedStmt.setInt(5, Integer.parseInt(uID)); 
	 
			// execute the statement    
			preparedStmt.execute();    
			con.close();  
			String newUnit = readUnit();    
			output = "{\"status\":\"success\", \"data\": \"" + newUnit + "\"}";    
		}   
		catch (Exception e)   
		{    
			output =  "{\"status\":\"error\", \"data\": \"Error while updating the Unit.\"}";   
			System.err.println(e.getMessage());   
		} 	 
	  return output;  
	} 
	
	public String deleteUnit(String uID)   
	{   
		String output = ""; 
	 
		try   
		{    
			Connection con = connect(); 
	 
			if (con == null)    
			{
				return "Error while connecting to the database for deleting."; 			
			} 
	 
			// create a prepared statement    
			String query = "delete from unit1 where uID=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
			// binding values    
			preparedStmt.setInt(1, Integer.parseInt(uID)); 
	 
			// execute the statement    
			preparedStmt.execute();    
			con.close(); 
	 
			String newUnit = readUnit();    
			output = "{\"status\":\"success\", \"data\": \"" +  newUnit + "\"}";    
		}   
		catch (Exception e)   
		{    
			output = "Error while deleting the Unit.";    
			System.err.println(e.getMessage());   
		} 
	 
		return output;  
	}
	
}
