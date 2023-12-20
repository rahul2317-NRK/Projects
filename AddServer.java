package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.ServerBean;
import com.dao.DBConnection;

/**
 * Servlet implementation class AddServer
 */
@WebServlet("/AddServer")
public class AddServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		String sname = request.getParameter("sname");
		String sid = request.getParameter("sid");
		String spwd = request.getParameter("spwd");
		ServerBean sb = new ServerBean();
		sb.setSname(sname);
		sb.setSid(sid);
		sb.setSpwd(spwd);
		String sql = "insert into server values(?,?,?)";
		int i = DBConnection.setServer(sql, sb);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Cloud Server Added Successfully...');");
			o.println("window.location='AddServer.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Please enter valid Details/Already Exist');");
			o.println("window.location='AddServer.jsp';</script>");
		}
	}

}
