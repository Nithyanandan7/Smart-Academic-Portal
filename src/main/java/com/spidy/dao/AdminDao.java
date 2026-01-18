package com.spidy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.spidy.Admin;
import com.spidy.model.Student;

public class AdminDao 
{
	String url = "jdbc:mysql://localhost:3306/student_db";
	String uname = "root";
	String pass = "Itsme7";
	
	public Admin verifyAdmin(String username, String password) 
	{
		Admin verify = new Admin();
		String query = "SELECT * FROM admin WHERE name = '" +username+ "' AND password = '"+password+"'";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next())
				verify.setVerify(true);
			else
				verify.setVerify(false);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return verify;
	}
	
	public List<Student> sortDepartment(String department) {
		List<Student> allStudents = new ArrayList<>();
		String query = "SELECT name, regnumber, department, attendance, grade, fees, year, semester, batch, phone, "
						+ "email, parentsphone FROM student WHERE department = '"+ department+"'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setName(rs.getString("name"));
				student.setRegnumber(rs.getString("regnumber"));
				student.setDepartment(rs.getString("department"));
				student.setAttendance(rs.getString("attendance"));
				student.setGrade(rs.getString("grade"));
				student.setFees(rs.getString("fees"));
				student.setYear(rs.getString("year"));
				student.setSemester(rs.getString("semester"));
				student.setBatch(rs.getString("batch"));
				student.setPhone(rs.getString("phone"));
				student.setEmail(rs.getString("email"));
				student.setParentsphone(rs.getString("parentsphone"));

				allStudents.add(student);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return allStudents;
	}
	
	public List<Student> sortYear(String year) {
		List<Student> allStudents = new ArrayList<>();
		String query = "SELECT name, regnumber, department, attendance, grade, fees, year, semester, batch, phone, "
						+ "email, parentsphone FROM student WHERE year = '"+ year+"'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setName(rs.getString("name"));
				student.setRegnumber(rs.getString("regnumber"));
				student.setDepartment(rs.getString("department"));
				student.setAttendance(rs.getString("attendance"));
				student.setGrade(rs.getString("grade"));
				student.setFees(rs.getString("fees"));
				student.setYear(rs.getString("year"));
				student.setSemester(rs.getString("semester"));
				student.setBatch(rs.getString("batch"));
				student.setPhone(rs.getString("phone"));
				student.setEmail(rs.getString("email"));
				student.setParentsphone(rs.getString("parentsphone"));

				allStudents.add(student);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return allStudents;
	}
	
	public List<Student> sortFees(String fees) {
		List<Student> allStudents = new ArrayList<>();
		String query = "SELECT name, regnumber, department, attendance, grade, fees, year, semester, batch, phone, "
						+ "email, parentsphone FROM student WHERE fees = '"+ fees+"'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setName(rs.getString("name"));
				student.setRegnumber(rs.getString("regnumber"));
				student.setDepartment(rs.getString("department"));
				student.setAttendance(rs.getString("attendance"));
				student.setGrade(rs.getString("grade"));
				student.setFees(rs.getString("fees"));
				student.setYear(rs.getString("year"));
				student.setSemester(rs.getString("semester"));
				student.setBatch(rs.getString("batch"));
				student.setPhone(rs.getString("phone"));
				student.setEmail(rs.getString("email"));
				student.setParentsphone(rs.getString("parentsphone"));

				allStudents.add(student);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return allStudents;
	}
	
	public List<Student> sortSemester(String semester) {
		List<Student> allStudents = new ArrayList<>();
		String query = "SELECT name, regnumber, department, attendance, grade, fees, year, semester, batch, phone, "
						+ "email, parentsphone FROM student WHERE semester = '"+ semester+"'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setName(rs.getString("name"));
				student.setRegnumber(rs.getString("regnumber"));
				student.setDepartment(rs.getString("department"));
				student.setAttendance(rs.getString("attendance"));
				student.setGrade(rs.getString("grade"));
				student.setFees(rs.getString("fees"));
				student.setYear(rs.getString("year"));
				student.setSemester(rs.getString("semester"));
				student.setBatch(rs.getString("batch"));
				student.setPhone(rs.getString("phone"));
				student.setEmail(rs.getString("email"));
				student.setParentsphone(rs.getString("parentsphone"));

				allStudents.add(student);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return allStudents;
	}
	
	public List<Student> sort(String sort) {
		List<Student> allStudents = new ArrayList<>();
		String query = "SELECT name, regnumber, department, attendance, grade, fees, year, semester, batch, phone, "
						+ "email, parentsphone FROM student ORDER BY "+ sort;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setName(rs.getString("name"));
				student.setRegnumber(rs.getString("regnumber"));
				student.setDepartment(rs.getString("department"));
				student.setAttendance(rs.getString("attendance"));
				student.setGrade(rs.getString("grade"));
				student.setFees(rs.getString("fees"));
				student.setYear(rs.getString("year"));
				student.setSemester(rs.getString("semester"));
				student.setBatch(rs.getString("batch"));
				student.setPhone(rs.getString("phone"));
				student.setEmail(rs.getString("email"));
				student.setParentsphone(rs.getString("parentsphone"));

				allStudents.add(student);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return allStudents;
	}
}