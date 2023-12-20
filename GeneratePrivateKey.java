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
import com.dao.PortNumber;

/**
 * Servlet implementation class GeneratePrivateKey
 */
@WebServlet("/GeneratePrivateKey")
public class GeneratePrivateKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneratePrivateKey() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");
		String mname=(String)session.getAttribute("name");
		String name=(String)session.getAttribute("sname");
		//String uid=request.getParameter("email");
		//String name=request.getParameter("name");
		String pk = PortNumber.getTrapdoorKeys();
		System.out.println("kkkkkkkkk"+email);
		Connection con=DBConnection.connect();
	try {
		String	sql = "select * from privatekeys where email='" + email + "' and name='"+mname+"' and cserver='CloudServer1'";
		
			if (DBConnection.getData(sql) == true) {
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Already Private Keys Generated ');");
				pw.println("window.location='GeneratePrivateKey.jsp';</script>");
			}else {
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into privatekeys values('"+mname+"','"+email+"','CloudServer1','"+pk+"') ");
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('Private Keys For Mobile User("+email+") are Generated Successfully');");
			 pw.println("location='GeneratePrivateKey.jsp';");
			 pw.println("</script>");
			} }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
