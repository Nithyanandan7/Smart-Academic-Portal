package com.spidy.model;

public class Student 
{
	private boolean verify;
	public boolean getVerify() {
		return verify;
	}
	public void setVerify(boolean verify) {
		this.verify = verify;
	}

	private String id;
	private String username;
	private String name;
	private String regnumber;
	private String email;
	private String phone;
	private String department;
	private String year;
	private String semester;
	private String batch;
	private String parentsphone;
	private String attendance;
	private String fees;
	private String grade;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegnumber() {
		return regnumber;
	}
	public void setRegnumber(String regnumber) {
		this.regnumber = regnumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getParentsphone() {
		return parentsphone;
	}
	public void setParentsphone(String parentsphone) {
		this.parentsphone = parentsphone;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public String getFees() {
		return fees;
	}
	public void setFees(String fees) {
		this.fees = fees;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", name=" + name + ", regnumber=" + regnumber
				+ ", email=" + email + ", phone=" + phone + ", department=" + department + ", year=" + year
				+ ", semester=" + semester + ", batch=" + batch + ", parentsphone=" + parentsphone + ", attendance="
				+ attendance + ", fees=" + fees + ", grade=" + grade + "]";
	}
	
}
