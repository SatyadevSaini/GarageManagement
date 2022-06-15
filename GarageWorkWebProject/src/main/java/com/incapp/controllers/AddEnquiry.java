package com.incapp.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.incapp.dao.UserDao;


// it is AddEnqry Controller ...
@WebServlet("/AddEnquiry")  // action in form ... got it ..action="AddEnquiry"   
public class AddEnquiry extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get the values from the Form ....
		try {
			String name=request.getParameter("Name");
			String phone=request.getParameter("Phone");
			String email=request.getParameter("Email");
			
			// create object here of user Dao ..// it makes the Connection ...
			
			UserDao db=new UserDao();
			
			// set Enquires here ..
			db.setEnquiry(name, phone, email);
			db.disconnect();// Disconnect  Connection Close 
			
			//Send Message on Index.jsp with Session object Creation ...
			//we will send here with Session ...
			HttpSession session=request.getSession();
			session.setAttribute("msg", "Enquiry Submitted Successfully For Call!"); // msg goes on Index.jsp ...
			response.sendRedirect("index.jsp");
			
			
			// it is our Exception Page here ...when Exception Occurred it will run 
		}catch (Exception e) {
			
			
			e.printStackTrace();  // for console print error 
			//Here we use Request Dispatcher  because No Url Change here in  RequestDispatcher we can known which page is giving the Exception
			
			RequestDispatcher rd=request.getRequestDispatcher("ExpPage.jsp");
			rd.forward(request, response);
		}
	}

}
