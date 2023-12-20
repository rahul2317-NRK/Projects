package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.UserBean;
import com.dao.DBConnection;

/**
 * Servlet implementation class UserReg
 */
@WebServlet("/UserReg")
public class UserReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReg() {
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
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String cserver = request.getParameter("cserver");
		UserBean ub = new UserBean();
		ub.setName(name);
		ub.setEmail(email);
		ub.setAge(age);
		ub.setGender(gender);
		ub.setPassword(password);
		ub.setMobile(mobile);
		ub.setCserver(cserver);
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
		int i = DBConnection.setUser(sql, ub);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Register Successfully...');");
			o.println("window.location='MobileUser.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Please enter valid Details/Already Exist');");
			o.println("window.location='MobileUserReg.jsp';</script>");
		}}}
