package com.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class User2
 */
@WebServlet("/User2")
public class User2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User2() {
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
		PrintWriter pw = response.getWriter();
		String uid = request.getParameter("email");
		String pwd = request.getParameter("password");
		String cserver = request.getParameter("cserver");
		HttpSession session = request.getSession();
	    System.out.println("username and password"+uid+pwd);
		String sql = "select * from user where email='"+uid+"' and password='"+pwd+"' and status1='Approved' and cserver='CloudServer2'";
		boolean b = DBConnection.getData(sql);
		if(b == true){
			session.setAttribute("email", uid);
			sql = "select name from user where email='"+uid+"'";
			String name = DBConnection.getName(sql);
			session.setAttribute("name", name);
			response.sendRedirect("MobileUserHome2.jsp");
		}else{
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Please takes permission from a cloud server');");
			pw.println("window.location='MobileUser2.jsp';</script>");
		}
	}
	}
