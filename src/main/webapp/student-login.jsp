<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Student Login</title>
  <link rel="stylesheet" href="student-login.css">
</head>
<body>
	<header></header>

<div class="page">
  <form class="login-box" action="StudentLoginServlet" method="post">
    <h2>Student Login</h2>

    <div class="form-group">
      <label>Username</label>
      <input type="text" name="username" value = "${username != null? username: ''}"required>
    </div>

    <div class="form-group">
      <label>Password</label>
      <input type="password" name="password" required>
    </div>
	<%
		String error = (String)request.getAttribute("error");
		if (error != null) {
	%>
	<p style = "color : red"><%= error %></p>
	<%
		}
	%>
    <button class="submit-btn" type="submit">Submit</button>

    <div class="forgot">Forgot Password</div>
  </form>
</div>
</body>
</html>