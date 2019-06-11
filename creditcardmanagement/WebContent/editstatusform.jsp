<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cts.creditcard.model.*,com.cts.creditcard.Bo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update user details</title>
</head>
<style>
body
{
background-color:lightyellow;
font-size:25px;
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

</style>

<body>
<%

String uid=request.getParameter("id");
MemberFormBo mfb=new MemberFormBo();
MemberStatusBo msb=new MemberStatusBo();
MemberForm mf=mfb.getMemberForm(uid);
MemberStatus ms=msb.getMemberStatus(uid);

%>
<div class="topnav">
  
  
  <div class="topnav-right">
    <a href="adminheader.jsp">Previous Page</a>
  </div>
</div>
<br>
<br>
<center><form action="./EditAllServlet" method="post">
<table>
<tr><td>First name : <input style="font-size:20px" type="text" name="fname" value="<%=mf.getFirstName()%>"><br><br></td></tr>
<tr><td>Last name : <input style="font-size:20px" type="text" name="lname" value="<%=mf.getLastName()%>"><br><br></td></tr>
<tr><td>Age : <input style="font-size:20px" type="text" name="age" value="<%=mf.getAge()%>"><br><br></td></tr>
<tr><td>Gender : <input style="font-size:20px" type="text" name="gender" value="<%=mf.getGender()%>"><br><br></td></tr>
<tr><td>Contact Number : <input style="font-size:20px" type="text" name="cnum" value="<%=mf.getContactNumber()%>"><br><br></td></tr>
<tr><td>UID Number : <input style="font-size:20px" type="text" name="uid" value="<%=uid%>"><br><br></td></tr>
<tr><td>Password : <input style="font-size:20px" type="text" name="psw" value="<%=mf.getPassword()%>"><br><br></td></tr>

<tr><td>Application Id : <input style="font-size:20px" type="text" name="appid" value="<%=ms.getApplicationId()%>"><br><br></td></tr>
<tr><td>Date of Submission : <input style="font-size:20px" type="text" name="dos" value="<%=ms.getApplicationDate()%>" ><br><br></td></tr>
<tr><td>Status : <select style="font-size:20px" name="status">
  <option value="Submitted">Submitted</option>
  <option value="Accepted">Accepted</option>
  <option value="Rejected">Rejected</option></td></tr>
  

</select><br>
<br>
<tr><td style="padding:30px;"><center> <input style="font-size:20px" type="submit" name="submit" ></center> </center></td></tr>
</table>
</form>
</body>
</html>