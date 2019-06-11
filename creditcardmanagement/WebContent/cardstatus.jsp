<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,com.cts.creditcard.Bo.*,com.cts.creditcard.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Card Status</title>
</head>
<style>
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
marquee
{
font-size:25px;
font-family:lucida calligraphy;
color:blue;

}
</style>
<body style= "background-color:lightyellow" >
<div class="topnav">
  <div class="topnav-right">
  <a href="userheader.jsp">Previous</a>
    <a href="homepage.html">Logout</a>
  </div>
</div>

<% 
MemberStatusBo msb=new MemberStatusBo();
MemberFormBo mfb=new MemberFormBo();
List<MemberStatus> list=msb.getAllMembersStatus(); 
List<MemberForm> mflist=mfb.getAllMembers();
//request.setAttribute("list",list); 
//HttpSession session=request.getSession(false);
session=request.getSession(false);
String uid=(String)session.getAttribute("id");

%>
<%
for(MemberForm mf: mflist){
	
	if(mf.getUid().equals(uid)){
	%>
	<br>
	<br>
	<br>
	<center>
	<table>
	<tr><td style="font-size:30px;">User Name : <%=mf.getFirstName() + mf.getLastName() %> <br><br></td></tr>
	<tr><td style="font-size:30px;">UID Number : <%=mf.getUid() %> <br><br></td></tr>
	<tr><td style="font-size:30px;">Contact Number : <%=mf.getContactNumber() %> <br><br></td></tr>
	
	
<%}} %>
<%
 for(MemberStatus ms:list){
	 if(ms.getUid().equals(uid)){
	 %>

	<% if(ms.getStatus().equals("Accepted"))
	{%> 
	<header>
<marquee>Congratulations!!! Your card has been accepted and will be dispatched soon...</marquee>
</header>
<br>
<br>
	<tr><td style="font-size:30px;"><p style="color:green" font-size="20px;"> Status : <%=ms.getStatus()%></p></td></tr>
	<% }else if(ms.getStatus().equals("Rejected")){%>
	<header>
<marquee>Sorry!!! You have provided the Incorrect information...</marquee>
</header>
<br>
<br>
	 <tr><td style="font-size:30px;"><p style="color:red" font-size="20px;"> Status : <%=ms.getStatus()%></p></td></tr>
	 
	<%} else
	{%>
	<header>
<marquee>Thank You!!! You card has been sent for further verification process....</marquee>
</header>
<br>
<br>
	  <tr><td style="font-size:30px;"><p style="color:orange" font-size="20px;"> Status : <%=ms.getStatus()%></p></td></tr>
<%}}} %>
</table>
</center>
</body>
</html>