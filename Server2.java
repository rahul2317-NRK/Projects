package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DBConnection;

/**
 * Servlet implementation class Server2
 */
@WebServlet("/Server2")
public class Server2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Server2() {
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
		String uid = request.getParameter("sid");
		String pwd = request.getParameter("spwd");
		HttpSession session = request.getSession();
		System.out.println("username and password"+uid+pwd);
		String sql = "select * from server2 where sid='"+uid+"' and spwd='"+pwd+"'";
		boolean b = DBConnection.getData(sql);
		if(b == true){
			session.setAttribute("sid", uid);
			sql = "select sname from server2 where sid='"+uid+"'";
			String name = DBConnection.getName(sql);
			session.setAttribute("sname", name);
			response.sendRedirect("CloudServerHome2.jsp");
		}else{
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Please enter valid Details');");
			pw.println("window.location='CloudServer2.jsp';</script>");
		}
			}
	}
