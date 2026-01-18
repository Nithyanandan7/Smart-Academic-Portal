package com.spidy;

import jakarta.servlet.RequestDispatcher;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "fetch", urlPatterns = { "/fetch" })
public class Fetch extends HttpServlet 
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String url = "jdbc:mysql://localhost:3306/student_db";
		String uname = "root";
		String pass = "Itsme7";
		int i = Integer.parseInt(request.getParameter("id"));
		String query = "SELECT * FROM student WHERE student_id = " + i;
		
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, uname, pass);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);  
				rs.next();
				String id = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String depart = rs.getString(4);
				request.setAttribute("id", id);
				request.setAttribute("name", name);
				request.setAttribute("email", email);
				request.setAttribute("depart", depart);
				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				rd.forward(request, response);
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
					e.printStackTrace();
				}

	}

}
