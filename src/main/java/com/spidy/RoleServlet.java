package com.spidy;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String role = request.getParameter("role");
		
		if (role.equals("admin")) 
		{
			response.sendRedirect("admin-login.jsp");
		}
		else if (role.equals("student"))
		{
			response.sendRedirect("student-login.jsp");
		}
	}

}
