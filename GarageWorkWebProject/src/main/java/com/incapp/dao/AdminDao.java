package com.incapp.dao;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

public class AdminDao {
	private Connection c;
	//constructor ...for making Connection ..
	public AdminDao() throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/garageworks","root","Satya@123");
	}
	//close the Coonection 
	public void disconnect()throws SQLException {
		c.close();
	}
	
	// Admin Login method .. 
	public boolean getAdminLogin(String id,String password)throws SQLException {
		// query ... 
		PreparedStatement p=c.prepareStatement("select * from admin where id=? and password=?");
		p.setString(1, id); // 1 question mark value set ..
		p.setString(2, password);
		ResultSet rs=p.executeQuery();
		// if value exits it will gave true else gave false .. 
		if(rs.next()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	// get Garrage By Status here 
	// only tells the status  query fired ...
	// Collection Of Collection... & get all data of every garage ...
	public ArrayList<HashMap> getGarageByStatus(String status) throws SQLException{
		PreparedStatement p=c.prepareStatement("select * from garage where status=?");
		p.setString(1, status);
		ResultSet rs=p.executeQuery();
		
		// collection of collection use here to send the data .. 
		ArrayList<HashMap> allGarage=new ArrayList<HashMap>();
		while(rs.next()) {
			HashMap garageDetails=new HashMap();
			garageDetails.put("name", rs.getString("name"));
			garageDetails.put("gname", rs.getString("gname"));
			garageDetails.put("email", rs.getString("email"));
			garageDetails.put("phone", rs.getString("phone"));
			garageDetails.put("state", rs.getString("state"));
			garageDetails.put("city", rs.getString("city"));
			garageDetails.put("sec_vill", rs.getString("sec_vill"));
			garageDetails.put("shop_no", rs.getString("shop_no"));
			garageDetails.put("status", rs.getString("status"));
			allGarage.add(garageDetails);
		}
		return allGarage;
	}
	
	
	
	public HashMap getGarageByEmail(String email) throws SQLException{
		PreparedStatement p=c.prepareStatement("select * from garage where email=?");
		p.setString(1, email);
		ResultSet rs=p.executeQuery();
		if(rs.next()) {
			HashMap garageDetails=new HashMap();
			garageDetails.put("name", rs.getString("name"));
			garageDetails.put("gname", rs.getString("gname"));
			garageDetails.put("email", rs.getString("email"));
			garageDetails.put("phone", rs.getString("phone"));
			garageDetails.put("state", rs.getString("state"));
			garageDetails.put("city", rs.getString("city"));
			garageDetails.put("sec_vill", rs.getString("sec_vill"));
			garageDetails.put("shop_no", rs.getString("shop_no"));
			garageDetails.put("status", rs.getString("status"));
			return garageDetails;
		}else {
			return null;
		}
	}
	
	
	//update garage status method here    the value came from hyperlink in controller & controller will gave this value to this 
	// let's understand  the story ....
	// if value came email & status = activated ... it will be activate & gaves 1 not null and value will be updated 
	// if values came pending we click on reject hyperlink ... status = pending then no change in data base value will be remain same .. 
	public int updateGarageStatus(String email,String status) throws SQLException{
		PreparedStatement p=c.prepareStatement("update garage set status=? where email=?");
		p.setString(1, status);
		p.setString(2, email);
		int result= p.executeUpdate();
		return result;
		
		// done this one .. 
		
	}
	public String[] getAdminDetails() throws SQLException{
		PreparedStatement p=c.prepareStatement("select * from admin");
		ResultSet rs=p.executeQuery();
		String adminDetails[]=new String[2];
		if(rs.next()) {
			adminDetails[0]=rs.getString("id");
			adminDetails[1]=rs.getString("password");
		}
		return adminDetails;
	}
}
