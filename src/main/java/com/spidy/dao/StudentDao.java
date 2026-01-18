package com.spidy.dao;

import java.sql.*;
import java.util.ArrayList;

import com.spidy.model.Student;
import java.util.List;

public class StudentDao {

	String url = "jdbc:mysql://localhost:3306/student_db";
	String uname = "root";
	String pass = "Itsme7";

	public Student getStudent(String username) {
		Student student = new Student();
		String query = "SELECT * FROM student WHERE username =" + username;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				student.setId(rs.getString("student_id"));
				student.setUsername(rs.getString("username"));
				student.setName(rs.getString("name"));
				student.setRegnumber(rs.getString("regnumber"));
				student.setEmail(rs.getString("email"));
				student.setPhone(rs.getString("phone"));
				student.setDepartment(rs.getString("department"));
				student.setYear(rs.getString("year"));
				student.setSemester(rs.getString("semester"));
				student.setBatch(rs.getString("batch"));
				student.setParentsphone(rs.getString("parentsphone"));
				student.setAttendance(rs.getString("attendance"));
				student.setFees(rs.getString("fees"));
				student.setGrade(rs.getString("grade"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return student;
	}

	public Student verifyStudent(String username, String password) {
		Student verify = new Student();
		String query = "SELECT * FROM student WHERE username = " + username + " AND password = '" + password + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			if (rs.next())
				verify.setVerify(true);
			else
				verify.setVerify(false);
		} catch (Exception e) {
			System.out.println(e);
		}

		return verify;
	}

	public List<Student> getAllStudents() {
		List<Student> allStudents = new ArrayList<>();
		String query = "SELECT name, regnumber, department, attendance, grade, fees, year, "
				+ "semester, batch, phone, email, parentsphone FROM student";
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
