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

import com.dao.DBConnection;
import com.dao.RandomeString;

/**
 * Servlet implementation class SharePrivateKey
 */
@WebServlet("/SharePrivateKey")
public class SharePrivateKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SharePrivateKey() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw=response.getWriter();
		String rid=RandomeString.getRID();
		String name=(String)request.getSession().getAttribute("name");
		String uid=(String)request.getSession().getAttribute("email");
		String sql = "select cserver from user where email='"+uid+"'";
		String cserver = DBConnection.getName(sql);
	//	String sname=(String)request.getSession().getAttribute("sname");
		String key=DBConnection.getkey(uid);
		Connection con=DBConnection.connect();
		try {
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into sharepk values('"+rid+"','"+name+"','"+uid+"','CloudServer1','CloudServer2','"+key+"')");
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('PK Shared Successfully...');");
			 pw.println("location='SharePrivateKey.jsp';");
			 pw.println("</script>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 pw.println("<script type=\"text/javascript\">");
			 pw.println("alert('Already Shared PK...');");
			 pw.println("location='SharePrivateKey.jsp';");
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
