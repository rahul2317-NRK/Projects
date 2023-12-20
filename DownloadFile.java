package com.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DBConnection;

@WebServlet("/downloadfile")
public class DownloadFile  extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	PrintWriter out=response.getWriter();
				String da = request.getParameter("fileid");
				
			
					
					HttpSession session = request.getSession(false);
					//	String email = (String) session.getAttribute("email");
						String sql = "select * from store where Fid='"+da+"'";
						Connection con = DBConnection.connect();
						try {
							PreparedStatement ps = con.prepareStatement(sql);
							ResultSet rs = ps.executeQuery();
							OutputStream o = response.getOutputStream();
							if(rs.next()){
								response.setContentType(rs.getString(7));
								o.write(rs.getBytes(4));
							}
							o.flush();
							o.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					
				
				
	}
}
