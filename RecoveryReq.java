package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DBConnection;

/**
 * Servlet implementation class RecoveryReq
 */
@WebServlet("/RecoveryReq")
public class RecoveryReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecoveryReq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
	    PrintWriter pw=response.getWriter();
	    String name=request.getParameter("name");
	    String email=request.getParameter("email");
	    String cserver=request.getParameter("cserver");
	    String sql="select * from user where cserver='CloudServer2' and status1='Approved'";
	    Connection con=DBConnection.connect();
	    Statement st;
	    if(DBConnection.getData(sql)){
		try {
			String sql4="select * from recoveryrequest where email='" + email + "' and name='"+name+"'";
			if(DBConnection.getData(sql4)==true){
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Already Sent Data Recovery Request');");
			pw.println("window.location='ReqForRecovery.jsp';</script>");
		}else{
			st = con.createStatement();
			 int i=st.executeUpdate("insert into recoveryrequest values('"+name+"','"+email+"','CloudServer1','"+cserver+"','Pending')");
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('Data Recovery Request Sent Successfully...');");
			 pw.println("location='ReqForRecovery.jsp';");
			 pw.println("</script>");
		} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
