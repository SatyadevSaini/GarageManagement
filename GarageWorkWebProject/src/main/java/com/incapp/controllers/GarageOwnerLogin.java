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

import com.incapp.dao.GarageDao;


@WebServlet("/GarageOwnerLogin")
public class GarageOwnerLogin extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get data from form here 
		try {
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			//invoked method 
			GarageDao db=new GarageDao();
			HashMap garageDetails=db.getGarageOwnerLogin(email,password);
			db.disconnect();
			
			// it will gave hashmap with all data 
			HttpSession session=request.getSession();
			
			// if data exits means email password correct will gone on the GarageOwnerHome.jsp   page ....
			if(garageDetails!=null) {
				session.setAttribute("garageDetails", garageDetails);
				response.sendRedirect("GarageOwnerHome.jsp");
				
				// else it will gone on the GarageOwner.jsp .... 
			}else {
				session.setAttribute("msg", "invalid");
				response.sendRedirect("GarageOwner.jsp");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("ExpPage.jsp");
			rd.forward(request, response);
		}
	}

}
