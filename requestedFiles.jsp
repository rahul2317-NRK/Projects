<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : Assembly 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20140330

-->
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page import="com.dao.DBConnection"%>
<%@page import="java.sql.Connection"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="main.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->
<style type="text/css">
p {
	font-size: 20px;
	font-family: verdana;
}
a
{
color: black;
font-style: italic;
font-size: 24px;
}

</style>
</head>
<body style="background-image:url('h.jpg');">
		<br><br><br><br><br><br><br><br><br>
		<center>	
		<div>
				<a href="uhome.jsp" accesskey="1" title="">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="search.jsp" accesskey="2" title="">Search</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="requestedFiles.jsp" accesskey="3" title="">Requested Files</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="requestedFiles.jsp" accesskey="3" title="">Accept Request</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				<a href="logout.jsp" accesskey="4" title="">Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			
		</div>
	</center>
	<br><br><br><br>
	<center>
	<div id="banner" class="container" >
		<div class="title">
		
		<table border="1" style="color: green; ">
		<tr>
		<td>Requested User</td>
		<td>Status</td>
		<td>Fileid</td>
		<td>Accept</td>
		<td>Reject</td>
		</tr>
		<%
		session = request.getSession(false);
					String name = (String) session.getAttribute("name");%>
					<h2 >Welcome to <%=name %></h2>
					<% String email=(String) session.getAttribute("email");
					String sql = "select * from requestfile where owneremail='"+email+"' and status='pending'";
					Connection con = DBConnection.connect();
					List files=new ArrayList();
					PreparedStatement ps=con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){%>
						<tr>
						<td><%=rs.getString(2) %></td>
						<td><%=rs.getString(3) %></td>
						<td><%=rs.getString(4) %></td>
						<td><a href="approve.jsp?fileid=<%=rs.getString(4)%>&&status=accept">Accept</a></td>
						<td><a href="approve.jsp?fileid=<%=rs.getString(4)%>&&status=reject">Reject</a></td>
						
						</tr>
		
		<% }%>
		</table>
			
		</div>
	</div>
</center>
</body>
</html>
