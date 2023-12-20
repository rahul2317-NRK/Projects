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
 * Servlet implementation class Server1
 */
@WebServlet("/Server1")
public class Server1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Server1() {
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
/*PrintWriter pw = response.getWriter();
String uid = request.getParameter("sid");
String pwd = request.getParameter("spwd");
HttpSession session = request.getSession();
System.out.println("username and password"+uid+pwd);
String sql = "select * from server where sid='"+uid+"' and spwd='"+pwd+"'";
boolean b = DBConnection.getData(sql);
if(b == true){
	session.setAttribute("sid", uid);
	sql = "select sname from server where sid='"+uid+"'";
	String name = DBConnection.getName(sql);
	session.setAttribute("sname", name);
	response.sendRedirect("CloudServerHome.jsp");
}else{
	pw.println("<script type=\"text/javascript\">");
	pw.println("alert('Please enter valid Details');");
	pw.println("window.location='CloudServer1.jsp';</script>");
}
	}*/
PrintWriter out=response.getWriter();

		HttpSession session=request.getSession();
		String uname=request.getParameter("sid");
		String pass=request.getParameter("spwd");
	
			 try {
				if(uname.equalsIgnoreCase("Cloud")&&pass.equalsIgnoreCase("Cloud"))
				{
					session.setAttribute("CloudServer1", uname);
					response.sendRedirect("CloudServerHome.jsp");
				}else if(uname.equalsIgnoreCase("CloudServer2")&&pass.equalsIgnoreCase("CloudServer2")){
					session.setAttribute("CloudServer2", uname);
					response.sendRedirect("CloudServerHome2.jsp");
				}
				else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('failed to login');");
					out.println("window.location='index.html'</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
}
	
