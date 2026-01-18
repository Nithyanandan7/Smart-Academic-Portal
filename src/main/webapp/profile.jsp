<%@page import="com.spidy.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <title>Student Profile</title>
  <link rel="stylesheet" href="profile.css">
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
	<%
	if(session.getAttribute("username") == null) 
	{
		response.sendRedirect("student-login.jsp");
		return;
	}
	Student s1 = (Student)session.getAttribute("student");
	%>
<header>

  <form action="logout">
    <button type="submit" style="background:none;border:none;">
     	<svg width="28" height="28" viewBox="0 0 28 28" fill="none" xmlns="http://www.w3.org/2000/svg">
			<g clip-path="url(#clip0_28_2)">
				<path fill-rule="evenodd" clip-rule="evenodd" d="M22.36 24.808C18.7185 25.0639 15.0635 25.0639 11.422 24.808C10.832 24.766 10.316 24.56 9.91399 24.254C9.64949 24.0631 9.32082 23.9831 8.99817 24.0312C8.67552 24.0792 8.38444 24.2515 8.18709 24.5113C7.98974 24.771 7.90174 25.0976 7.94189 25.4214C7.98205 25.7451 8.14716 26.0403 8.40199 26.244C9.19399 26.844 10.174 27.224 11.244 27.302C15.0033 27.568 18.7767 27.568 22.536 27.302C25.08 27.12 27.162 25.196 27.288 22.694C27.4303 19.7982 27.5009 16.8993 27.5 14C27.5 11.018 27.426 8.10798 27.288 5.30598C27.162 2.80398 25.08 0.879983 22.536 0.697983C18.7767 0.432007 15.0033 0.432007 11.244 0.697983C10.2141 0.76746 9.22662 1.13506 8.40199 1.75598C8.2668 1.85357 8.1525 1.97721 8.06581 2.11964C7.97913 2.26206 7.92181 2.42039 7.89724 2.5853C7.87267 2.75021 7.88134 2.91837 7.92273 3.07988C7.96413 3.24139 8.03742 3.39299 8.13829 3.52575C8.23916 3.65851 8.36557 3.76974 8.51008 3.85291C8.65459 3.93608 8.81427 3.9895 8.97974 4.01002C9.1452 4.03054 9.3131 4.01775 9.47355 3.97241C9.63399 3.92706 9.78374 3.85008 9.91399 3.74598C10.316 3.44198 10.834 3.23398 11.422 3.19198C15.0628 2.93612 18.7171 2.93612 22.358 3.19198C23.784 3.29198 24.736 4.32798 24.79 5.42998C24.9312 8.28446 25.0012 11.142 25 14C25 16.94 24.928 19.81 24.79 22.57C24.736 23.672 23.784 24.706 22.358 24.808M18.878 15.25H8.49399V19.574C8.49373 19.7874 8.43883 19.9972 8.33453 20.1834C8.23023 20.3696 8.07999 20.526 7.89813 20.6376C7.71627 20.7493 7.50885 20.8126 7.29561 20.8214C7.08238 20.8302 6.87045 20.7843 6.67999 20.688C4.24399 19.454 1.85999 17.038 0.63999 14.576C0.546444 14.398 0.497566 14.2 0.497566 13.999C0.497566 13.7979 0.546444 13.5999 0.63999 13.422C1.85999 10.962 4.24599 8.54598 6.67999 7.31198C6.87045 7.21569 7.08238 7.16976 7.29561 7.17858C7.50885 7.18739 7.71627 7.25065 7.89813 7.36233C8.07999 7.47402 8.23023 7.6304 8.33453 7.81659C8.43883 8.00278 8.49373 8.21257 8.49399 8.42598V12.75H18.88C19.2115 12.75 19.5295 12.8817 19.7639 13.1161C19.9983 13.3505 20.13 13.6685 20.13 14C20.13 14.3315 19.9983 14.6494 19.7639 14.8839C19.5295 15.1183 19.2095 15.25 18.878 15.25Z" fill="white"/>
			</g>
			<defs>
				<clipPath id="clip0_28_2">
			<rect width="28" height="28" fill="white" transform="matrix(-1 0 0 -1 28 28)"/>
			</clipPath>
			</defs>
		</svg>
    </button>
  </form>

  <div class="username"><%= s1.getName() %></div>

</header>


<div class="container">

  <!-- Left table -->
  <table class="profile-table">
    <tr>
      <td>Register Number</td>
      <td><%out.print(s1.getRegnumber());%></td>
    </tr>
    <tr>
      <td>Name</td>
      <td><%out.print(s1.getName()); %></td>
    </tr>
    <tr>
      <td>Department</td>
      <td><%out.print(s1.getDepartment()); %></td>
    </tr>
    <tr>
      <td>Year</td>
      <td><%out.print(s1.getYear()); %></td>
    </tr>
    <tr>
      <td>Semester</td>
      <td><%out.print(s1.getSemester()); %></td>
    </tr>
    <tr>
      <td>Attendance</td>
      <td><%out.print(s1.getAttendance()); %></td>
    </tr>
    <tr>
      <td>Grade</td>
      <td><%out.print(s1.getGrade()); %></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><%out.print(s1.getEmail()); %></td>
    </tr>
    <tr>
      <td>Phone Number</td>
      <td><%out.print(s1.getPhone()); %></td>
    </tr>
    <tr>
      <td>Parent Number</td>
      <td><%out.print(s1.getParentsphone()); %></td>
    </tr>
  </table>

  <!-- Right photo box -->
  <div class="photo-box">
    <span>Photo</span>
  </div>

</div>

</body>
</html>


