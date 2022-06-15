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

/**
 * Servlet implementation class AddEnquiry
 */
@WebServlet("/UserPhotoUpload")
@MultipartConfig  // it is Anotation to work with images 

public class UserPhotoUpload extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email=request.getParameter("email"); // get values  from Hidden From fields ...
			
			InputStream photo=null;
			Part p=request.getPart("photo"); // get photo from the form ...
			
			// if it is not null photo goes 
			if(p!=null) {
				photo=p.getInputStream();
			}
			
			//invoked the method ...
			UserDao db=new UserDao();
			String result=db.updateUserPhoto(email,photo);
			db.disconnect();
			
			// value send in the Session ... 
			HttpSession session=request.getSession();
			
//			condition 
			if(result.equalsIgnoreCase("success")) {
				session.setAttribute("msg", "Photo Updated Successfully!");
			}else {
				session.setAttribute("msg", "Photo Updation Failed!");
			}
			response.sendRedirect("UserProfile.jsp");
			
		}catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("ExpPage.jsp");
			rd.forward(request, response);
		}
	}

}
