package com.incapp.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.incapp.dao.UserDao;


@WebServlet("/GetUserPhoto") // get user photo on UserHome ...

public class GetUserPhoto extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//get here email ..
			String email=request.getParameter("email");
			// object creation 
			
			UserDao db=new UserDao();
			
			//photo get  the photo here ... 
			byte photo[]=db.getUserPhoto(email);
			db.disconnect();
			
			// it its length is 0 ...
			if(photo.length==0) {
				
				//get servlet context to upload the photo because it range over the Application 
				ServletContext ctx=getServletContext();
				
				// photo travels in Stream so get it in Stream  tell location  to get the photo ..  here stream is coming so get it in InputStream ..
				InputStream i=ctx.getResourceAsStream("resource/user.png");
				
				// create array according to photo size .. 
				photo=new byte[300000];
				
				//  here photo came & stored in the  InputStream ... 
				i.read(photo);
			}
			// it will gone if photo has length means photo exits ...
			response.getOutputStream().write(photo);
			
		}catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("ExpPage.jsp");
			rd.forward(request, response);
		}
	}
}
