<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.spidy.model.Student"%>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="admin-dashboard.css">
</head>
<body>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    if (session.getAttribute("username") == null) {
        response.sendRedirect("admin-login.jsp");
        return;
    }
%>

<!-- HEADER -->
<header>
    <div>
        <form action="AdminLogout">
            <button class="logout-btn">Logout</button>
        </form>
    </div>
    <div class="username">
        <%= session.getAttribute("username") %>
    </div>
</header>

<!-- MAIN -->
<div class="main-container">

    <!-- FILTER -->
<div class="filter-container">

    <input type="checkbox" id="filter-toggle" hidden>

    <label for="filter-toggle" class="filter-btn">
        Filter ▾
    </label>

    <div class="filter-dropdown">

        <!-- Sorting -->
        <a href="AdminDashboardServlet?sort=regnumber">Reg Number</a>
        <a href="AdminDashboardServlet?sort=name">Name</a>
        <a href="AdminDashboardServlet?sort=grade">Grade</a>
        <a href="AdminDashboardServlet?sort=attendance">Attendance</a>

        <div class="divider"></div>

        <!-- Department -->
        <div class="filter-group">
            <span>Department ▸</span>
            <div class="sub-filter">
                <a href="AdminDashboardServlet?department=CSE">CSE</a>
                <a href="AdminDashboardServlet?department=IT">IT</a>
                <a href="AdminDashboardServlet?department=ECE">ECE</a>
            </div>
        </div>

        <!-- Fees -->
        <div class="filter-group">
            <span>Fees ▸</span>
            <div class="sub-filter">
                <a href="AdminDashboardServlet?fees=paid">Paid</a>
                <a href="AdminDashboardServlet?fees=pennding">Pending</a>
            </div>
        </div>

        <!-- Year -->
        <div class="filter-group">
            <span>Year ▸</span>
            <div class="sub-filter">
                <a href="AdminDashboardServlet?year=1">1</a>
                <a href="AdminDashboardServlet?year=2">2</a>
                <a href="AdminDashboardServlet?year=3">3</a>
                <a href="AdminDashboardServlet?year=4">4</a>
            </div>
        </div>

        <!-- Semester -->
        <div class="filter-group">
            <span>Semester ▸</span>
            <div class="sub-filter">
                <a href="AdminDashboardServlet?semester=1">1</a>
                <a href="AdminDashboardServlet?semester=2">2</a>
                <a href="AdminDashboardServlet?semester=3">3</a>
                <a href="AdminDashboardServlet?semester=4">4</a>
                <a href="AdminDashboardServlet?semester=5">5</a>
                <a href="AdminDashboardServlet?semester=6">6</a>
                <a href="AdminDashboardServlet?semester=7">7</a>
                <a href="AdminDashboardServlet?semester=8">8</a>
            </div>
        </div>

    </div>
</div>




    <!-- TABLE -->
    <div class="table-wrapper">
        <%
            List<Student> students =
                (List<Student>) session.getAttribute("students");

            if (students != null && !students.isEmpty()) {
        %>

        <table>
            <thead>
                <tr>
                    <th>Reg No</th>
                    <th>Name</th>
                    <th>Department</th>
                    <th>Year</th>
                    <th>Semester</th>
                    <th>Attendance</th>
                    <th>Grade</th>
                    <th>Fees</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Student s : students) {
                %>
                <tr>
                    <td><%= s.getRegnumber() %></td>
                    <td><%= s.getName() %></td>
                    <td><%= s.getDepartment() %></td>
                    <td><%= s.getYear() %></td>
                    <td><%= s.getSemester() %></td>
                    <td><%= s.getAttendance() %></td>
                    <td><%= s.getGrade() %></td>
                    <td><%= s.getFees() %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <%
            } else {
        %>
            <p class="no-data">No students found</p>
        <%
            }
        %>
    </div>

</div>

</body>
</html>
