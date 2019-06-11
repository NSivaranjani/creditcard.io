
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,com.cts.creditcard.Bo.*,com.cts.creditcard.model.*" %>
 <%--    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accepted User</title>
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
</head>
<body>
<div class="topnav">
  
  
  <div class="topnav-right">
    <a href="adminheader.jsp">Previous Page</a>
  </div>
</div>
<%  
MemberStatusBo msb=new MemberStatusBo();
List<MemberStatus> list=msb.getAllMembersStatus(); 
request.setAttribute("list",list);  
%>  
<br>
<br>
 <center>Application of Accepted Users</center>
 <br>
 <center>
<table border="1" width="90%">  
<tr><th>UID</th><th>Application Id</th><th>Application Date</th><th>Status</th>  
</tr> 
<%for(MemberStatus ms:list) {
if(ms.getStatus().equals("Accepted")){
	
%> 
<tr><td><%=ms.getUid() %></td><td><%=ms.getApplicationId() %></td><td><%=ms.getApplicationDate()%></td>  
 
<td><%=ms.getStatus() %></td> 

<%}}%> 
 
<!-- </c:forEach>   -->
</table> 
</center>
</body>
</html>