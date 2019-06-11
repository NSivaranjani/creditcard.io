<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
</head>
body
{
background-color:lightyellow;
}
p
{
font-size:40px;
}
#a1:link, #a1:visited {
  background-color: dodgerblue;
  color: white;
  padding: 20px 80px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
font-size:18px;
align:"center";
}

#a1:hover,#a1:active {
  background-color: skyblue;
}
</style>
<body style="background-color:lightyellow;">
<%-- <%=request.getParameter("value") %> --%>
<p>You have Successfully Applied.... </p>
<p>Please click the link below to get directed to User home page..</p>
<a id="a1" href="userheader.jsp">User Home</a>