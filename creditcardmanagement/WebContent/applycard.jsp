<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.http.*,java.text.*,java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply Card</title>
</head>
<body>
<%@ include file="userheader.jsp" %>
<% session=request.getSession(false);
String s=(String)session.getAttribute("id");
Date date = new Date();
SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
String dat=formatter.format(date);%>
<center>
<form action="./ApplyCardServlet" method="post">
<br><br><br>
<br>
<table>
<tr><td style="font-size:30px;"> UID  Number   : </td><td> <input style="font-size:30px;" type="text" name="uid" value="<%=s%>" ><br><td></tr>
<tr><td style="font-size:30px;">Application Id : </td><td><input style="font-size:30px;" type="text" name="appid"><br><td></tr>
<tr><td style="font-size:30px;">Date of Apply : </td><td> <input style="font-size:30px;" type="text" name="doa" value="<%=dat%>" ><br><td></tr>
<tr>
   <td></td><td style="padding:30px;"><input style="font-size:30px;" type="submit" value="Apply card">
      </tr>
</table>
</center>
</form>
</body>
</html>