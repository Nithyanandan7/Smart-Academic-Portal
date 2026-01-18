package com.spidy;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.spidy.dao.StudentDao;
import com.spidy.model.Student;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
			
		StudentDao dao = new StudentDao();
		List<Student> students = dao.getAllStudents();
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("students", students);
		response.sendRedirect("admin-dashboard.jsp");
	}

}
