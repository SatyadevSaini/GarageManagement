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


@WebServlet("/UserPasswordChange")
@MultipartConfig
public class UserPasswordChange extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			 // get 4 values 3 from form 1 from hidden from field 
			String email=request.getParameter("email");
			String op=request.getParameter("o_password");
			String np=request.getParameter("n_password");
			String cp=request.getParameter("c_password");
			
			HttpSession session=request.getSession();
			
			// if confirm & new Password is same the Dao object create method invoked .. 
			if(np.equals(cp)) {
				UserDao db=new UserDao();
				int result=db.updateUserPassword(email,op,np);
				db.disconnect();
				
				// if  result is not 0 then password updated!
				if(result!=0) {
					session.setAttribute("msg", "Password Updated Successfully!");
					
					// result value is 0  means cp & np are same ..so old password is wrong !!
				}else {
					session.setAttribute("msg", "Old Password is Wrong!");
				}
				
				//password mismatch !! 
			}else {
				session.setAttribute("msg", "Password Mismatch!");
			}
			response.sendRedirect("UserProfile.jsp");
			
			
		}catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("ExpPage.jsp");
			rd.forward(request, response);
		}
	}

}
