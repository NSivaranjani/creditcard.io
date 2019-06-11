<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
  background-color:lightyellow;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: mediumblue;
  color: white;
}

.topnav a.active {
  background-color: blue;
  color: white;
}

.topnav-right {
  float: right;
}
p
{
font-size:25px;
}
</style>
</head>
<body >
<div class="topnav">
  <a href="submitteduser.jsp">Submitted User</a>
  <a href="ApprovedUser.jsp">Approved User</a>
  <a href="RejectedUser.jsp">Rejected User</a>
  <div class="topnav-right">
    <a href="homepage.html">Logout</a>
  </div>
</div>
<header align="right">
<p>Welcome <%=session.getAttribute("user") %><p>
<img src="admin2.jpg" style="width:1900px;">
</header>
</body>
</html>

