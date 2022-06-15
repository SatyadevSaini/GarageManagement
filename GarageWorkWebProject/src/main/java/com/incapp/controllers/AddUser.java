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
@WebServlet("/AddUser")
@MultipartConfig
public class AddUser extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			InputStream photo=null;
			Part p=request.getPart("photo");
			if(p!=null) {
				photo=p.getInputStream();
			}
			HashMap user=new HashMap();
			user.put("name", name);
			user.put("phone", phone);
			user.put("email", email);
			user.put("password", password);
			user.put("photo", photo);
			
			UserDao db=new UserDao();
			String result=db.setUser(user);
			db.disconnect();
			
			HttpSession session=request.getSession();
			session.setAttribute("msg", result);
			response.sendRedirect("User.jsp");
			
		}catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("ExpPage.jsp");
			rd.forward(request, response);
		}
	}

}
