package com.incapp.dao;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

public class UserDao {
	//it is User Dao file ....
	private Connection c;  // it is here Connection here because it can be Accessable for every methos in Dao
	
	// it is Constructor here Makes for Making Connection here ..when object created Connection will be Done ..
	public UserDao() throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/garageworks","root","Satya@123");
	}
	
	//DisConnected method here ... 
	public void disconnect()throws SQLException {
		c.close();
	}
	
	// setEnquies here ... it will take name , phone , email   to set the Enquires ...
	
	public void setEnquiry(String name,String phone,String email) throws SQLException{// it will gave SQL Exception 
		// prepared statement will be used here ..
		PreparedStatement p=c.prepareStatement("insert into enquries (name,phone,email) values(?,?,?)");
		
		//here we are setting the values of the ? here 
		p.setString(1, name); // 1 ?  value set here 
		p.setString(2, phone);
		p.setString(3, email);
		p.executeUpdate();  // execute the query here 
	}
	
	
	// set User means we are Adding the user SignUp for users here ..
	// it will take 5 values so for this we use here Hashmap to input values 
	public String setUser(HashMap user) throws SQLException{
		
		// try catch because if user already exits it will gave SQLIntegrityConstraintViolationException if user already exits ..
		try {
			PreparedStatement p=c.prepareStatement("insert into users (email,name,phone,password,photo) values(?,?,?,?,?)");
			
			// setting the values here of ? here ...
			p.setString(1, (String)user.get("email")); // 1 question mark value  get value here from collection ..
			p.setString(2, (String)user.get("name"));
			p.setString(3, (String)user.get("phone"));
			p.setString(4, (String)user.get("password"));
			p.setBinaryStream(5, (InputStream)user.get("photo"));  // BinaryStream ... It travel here Input Stream ..
			p.executeUpdate();
			// if Everything Will be Fine it will gave Success 
			return "success";
			
			//if user Already Exits it will gave this Exception ...
		}catch (SQLIntegrityConstraintViolationException e) {
			return "failed";
		}
	}
	
	
	//User Login .....SignIn here....  
	//here will gave email  & password to Login 
	// if it will be right  it will gave values in the collection & goes on (UserHome.jsp) else it will be on (User.jsp) with message incorrect PassWord 
	public HashMap getUserLogin(String email,String password)throws SQLException {
		PreparedStatement p=c.prepareStatement("select * from users where email=? and password=?");
		p.setString(1, email);
		p.setString(2, password);
		ResultSet rs=p.executeQuery();
		
		// email & password Match it will on next page with Data ...
		//else on (User.jsp) with message incorrect PassWord
		if(rs.next()) {
			HashMap<String, String> userDetails=new HashMap<>();
			userDetails.put("name", rs.getString("name"));
			userDetails.put("email", rs.getString("email"));
			userDetails.put("phone", rs.getString("phone"));
			return userDetails;
		}else {
			return null;
		}
	}
	
	
	// getUserPhoto here .......
	// photo always in byte ...only email goes it comes to urlRewriting ...
	
	public byte[] getUserPhoto(String email) throws SQLException{
		
		//query fire here ...
		PreparedStatement p=c.prepareStatement("select photo from users where email=?");
		p.setString(1, email); // set ? value here 
		ResultSet rs=p.executeQuery();
		
		//get the photo here 
		
		rs.next();
		// get photo here in byte[] array here ..
		byte photo[]=rs.getBytes("photo");
		return photo;
			}
	
	
	
	
	//on update the photo by user on its profile tells email .... & update photo ..
	// email & photo will be travel in the inputStream ...
	public String updateUserPhoto(String email,InputStream photo) throws SQLException{
		
		// prepared statement ...
			PreparedStatement p=c.prepareStatement("update users set photo=? where email=?");
			
			p.setBinaryStream(1, photo);// set ? value 
			p.setString(2, email);
			p.executeUpdate();
			return "success"; // msg here .. 
	}

	// user Password change ... int return type uses here .. 
	public int updateUserPassword(String email,String op,String np) throws SQLException{
		// query ... 
			PreparedStatement p=c.prepareStatement("update users set password=? where email=? and password=?");
			
			p.setString(1, np); // new Password ? value set 
			p.setString(2, email);// email ..
			p.setString(3, op); // password .. 
			 
			int result= p.executeUpdate();  // value will goes in Int... 
			return result; 
	}
	
	
	public ArrayList<HashMap> getGarages(String state,String city) throws SQLException{
		PreparedStatement p=c.prepareStatement("select * from garage where state=? and city=? and status='accepted'");
		p.setString(1, state);
		p.setString(2, city);
		ResultSet rs=p.executeQuery();
		ArrayList<HashMap> allGarageDetails=new ArrayList<HashMap>();
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
			allGarageDetails.add(garageDetails);
		}
		return allGarageDetails;
	}
}
