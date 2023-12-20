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
 * Servlet implementation class SendForAthentication
 */
@WebServlet("/SendForAthentication")
public class SendForAthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendForAthentication() {
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
	//	String rid=request.getParameter("rid");
		String tocserver2=(String)session.getAttribute("CloudServer2");
		//String name=(String)session.getAttribute("name");
     	String name=request.getParameter("name");
	//	String oname=DBConnection.getOName1(name);
	//	System.out.println("ddd"+name);
		System.out.println("ddd"+tocserver2);
		System.out.println("ddd"+name);
		String key=request.getParameter("pkey");
		String rid=DBConnection.getRID1(tocserver2);
		String pk=request.getParameter("pk");
	//	String pk=DBConnection.getkey(name);
	//	String sql="insert into verify values('"+rid+"','"+name+"','"+tocserver2+"','"+pk+"','"+key+"')";
		System.out.println("ddd"+key);
		Connection con=DBConnection.connect();
		try {
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into verify values('"+rid+"','"+name+"','CloudServer1','"+tocserver2+"','"+pk+"','"+key+"','Pending')");
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('PK Shared For Authentication Successfully...');");
			 pw.println("location='SendForAthentication.jsp';");
			 pw.println("</script>");
			System.out.println("kkk:"+pk);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('Already Shared PK For Authentication...');");
			 pw.println("location='SendForAthentication.jsp';");
			 pw.println("</script>");
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
