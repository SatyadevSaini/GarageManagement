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

import com.incapp.dao.AdminDao;


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			// get the values ...
			String id=request.getParameter("id");
			String password=request.getParameter("password");
			AdminDao db=new AdminDao();
			// invoked method ..
			boolean r=db.getAdminLogin(id, password);
			db.disconnect();
			
			// session object created 
			HttpSession session=request.getSession();
			// r = true means ... admin has enter right id password & it will gone on 2 Admin Home 
			if(r==true) {
				session.setAttribute("aname", "Satyadev Saini Dharwal");
				response.sendRedirect("AdminHome.jsp");
				
				// else message on Admin.jsp with message invalid 
			}else {
				session.setAttribute("msg", "invalid");
				response.sendRedirect("Admin.jsp");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("ExpPage.jsp");
			rd.forward(request, response);
		}
	}

}
