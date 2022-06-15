package com.incapp.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.incapp.dao.UserDao;

@WebServlet("/UserLogin")
//user Login 
public class UserLogin extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// get the Data 
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			//object created Connection  making
			UserDao db=new UserDao();
			
			// invoked the method of DAOUser values get here  from the form pass in the Dao Class method 
			// & after that Controller Decide which page will be Run ... 
			HashMap userDetails=db.getUserLogin(email,password);
			db.disconnect();
			
			// after invoked the method  check the values 
			// if values came then it will go on the ("UserHome.jsp")
			// else it will gone on "User.jsp" 
			
			HttpSession session=request.getSession();
			if(userDetails!=null) {
				session.setAttribute("userDetails", userDetails);
				response.sendRedirect("UserHome.jsp");
				
			}else {
				session.setAttribute("msg", "invalid");
				response.sendRedirect("User.jsp");
			}
			
			// if Exception Occurred  it will invoked..   
		}catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("ExpPage.jsp");
			rd.forward(request, response);
		}
	}

}
