package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DBConnection;

/**
 * Servlet implementation class SendData
 */
@WebServlet("/SendData")
public class SendData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String fid=request.getParameter("fid");
		String userid=request.getParameter("userid");
		String file=request.getParameter("file");
		ServletInputStream image=request.getInputStream();
		String cserver=request.getParameter("cserver");
		String date1=request.getParameter("date1");
		String sql2="select * from recoveryrequest where email='"+userid+"' and  status2='Approved'";
		String sql="select * from verify where  status1='Verified'";
		Connection con=DBConnection.connect();
		if(DBConnection.getData(sql2))
		{
		if(DBConnection.getData(sql)){
		try {
			Statement st=con.createStatement();
		//	int i=st.executeUpdate("insert into recovery values('"+fid+"','"+userid+"','"+file+"','"+image+"','"+cserver+"','"+date1+"')");
			 int i=st.executeUpdate("insert into recovery select * from store where fid='"+fid+"'");
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('Requested Data Sent Successfully...');");
			 pw.println("location='MobileUsersData.jsp';");
			 pw.println("</script>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else{
		 pw.println("<script type=\"text/javascript\">");
		 pw.println("alert('Keys Are Not Yet Verified...');");
		 pw.println("location='MobileUsersData.jsp';");
		 pw.println("</script>");
	}
		}else{
		 pw.println("<script type=\"text/javascript\">");
		 pw.println("alert('Recovery Request Did'nt Recieved...');");
		 pw.println("location='MobileUsersData.jsp';");
		 pw.println("</script>");
	}
		pw.println("<script type=\"text/javascript\">");
		 pw.println("alert('Recovery Request Did'nt Recieved...');");
		 pw.println("location='MobileUsersData.jsp';");
		 pw.println("</script>");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
