<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.dao.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%

String fileid=request.getParameter("fileid");
String status=request.getParameter("status");
System.out.println(fileid+status);

if(status.equalsIgnoreCase("accept")){
	
	String sql="update requestfile set status='approved' where fileid=?";
	Connection con = DBConnection.connect();
	
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1,Integer.parseInt(fileid));
	int i=ps.executeUpdate();
	if(i==-1){
		System.out.println("failed to update");
	}else{
		System.out.println("updated");
	}
}else{
	
}

%>
</body>
</html>