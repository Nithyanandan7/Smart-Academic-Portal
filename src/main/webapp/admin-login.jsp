<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Login</title>
  <link rel="stylesheet" href="admin-login.css">
</head>
<body>

  <!-- Header -->
  <div class="header"></div>

  <!-- Login Card -->
  <div class="login-container">

    <h2 class="title">Admin Login</h2>

    <form action="AdminLoginServlet" method="post">

      <label>Username</label>
      <input type="text" name="username" value = "${username != null? username: ''}" required>

      <label>Password</label>
      <input type="password" name="password" required>
      
      	<%
			String error = (String)request.getAttribute("error");
			if (error != null) {
		%>
			<p style = "color : red"><%= error %></p>
		<%
			}
		%>

      <button type="submit">Submit</button>

    </form>

    <a href="#" class="forgot">Forgot Password</a>

  </div>

</body>
</html>