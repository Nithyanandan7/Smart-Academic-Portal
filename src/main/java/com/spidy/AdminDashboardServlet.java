package com.spidy;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.spidy.dao.AdminDao;
import com.spidy.dao.StudentDao;
import com.spidy.model.Student;


@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String department = request.getParameter("department");
		String year = request.getParameter("year");
		String semester = request.getParameter("semester");
		String fees = request.getParameter("fees");
		String sort = request.getParameter("sort");

		
		AdminDao dao = new AdminDao();
		List<Student> students = new ArrayList<>();
		
		if (department != null)
		{
			students = dao.sortDepartment(department);
			department = "";
		}
		
		if (year != null)
		{
			students = dao.sortYear(year);
			year = "";
		}
		
		if (fees != null)
		{
			students = dao.sortFees(fees);
			fees = "";
		}
		
		if (semester != null)
		{
			students = dao.sortSemester(semester);
			semester = "";
		}
		if (sort != null)
		{
			students = dao.sort(sort);
			sort = "";
		}
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("username") == null)
			System.out.print("i am out");
		session.setAttribute("students", students);
		response.sendRedirect("admin-dashboard.jsp");
	}

}


