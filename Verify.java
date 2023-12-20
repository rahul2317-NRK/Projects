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


/**
 * Servlet implementation class Verify
 */
@WebServlet("/Verify")
public class Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		/*int fid = Integer.parseInt(request.getParameter("id"));*/
		String rid=request.getParameter("rid");
		//String uid=(String)request.getSession().getAttribute("email");
		String uid=request.getParameter("email");
	//	String sql = "update verify set status1='Verified' where rid='"+rid+"' and oname='"+uid+"'";
		//String sql2="update verify set status1='Verified' where rid='"+rid+"' and oname='"+uid+"' and pk == key1";
	//	String sql2=	"select COUNT(*) AS rows_checked, SUM(pk = key1) AS rows_matching,SUM(pk != key1) AS rows_different FROM verify WHERE rid='"+rid+"' and oname='"+uid+"'";
	//	System.out.println(sql2);
		Connection con=DBConnection.connect();
		Statement st;
		try {
			st = con.createStatement();
			String	sql = "select * from  verify  where rid='"+rid+"' and oname='"+uid+"' and verify.pk!=verify.key1";
			
			if (DBConnection.getData(sql) == true) {
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Key Are Not Matched');");
				o.println("window.location='CSReq.jsp';</script>");
			}else {
			int i=st.executeUpdate("update verify set status1='Verified' where rid='"+rid+"' and oname='"+uid+"' and verify.pk=verify.key1");
			if(i==1){	
		    	o.println("<script type=\"text/javascript\">");
				o.println("alert('Keys Verified Successfully...');");
				o.println("window.location='CSReq.jsp';</script>");
		} else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Keys Are Not Matched');");
			o.println("window.location='CSReq.jsp';</script>");
		}
			}
		}catch (SQLException e) {
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
