package com.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.beans.StoreBean2;
import com.dao.DBConnection;
import com.dao.RandomeString;

/**
 * Servlet implementation class Store2
 */
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/Store2")
public class Store2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Store2() {
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
		HttpSession session = request.getSession(false);
		String id=RandomeString.getID();
		String uid = (String) session.getAttribute("email");
		String name = request.getParameter("name1");
		String sql = "select cserver from user where email='"+uid+"' and ";
	//	String cserver = DBConnection.getName(sql);
		Part img = request.getPart("photo1");
		InputStream photo = null;
		if(img != null){
			photo = img.getInputStream();
		}
		String content1 = img.getContentType();
		double size = img.getSize();
		Date d = new Date();
		String da = "" + d;
		StoreBean2 sb1 = new StoreBean2();
		sb1.setId1(id);
		sb1.setUid1(uid);
		sb1.setName1(name);
		sb1.setPhoto1(photo);
	//	sb1.setCserver1(cserver);
		sb1.setDa1(da);
		sb1.setContent1(content1);
		sb1.setSize1(size);
		sql = "insert into recovery values(?,?,?,?,?,?,?,?)";
		int i = DBConnection.store2(sql, sb1);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('File Stored Successfully..');");
			o.println("window.location='StoreData2.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Failed to store the file');");
			o.println("window.location='StoreData2.jsp';</script>");
		}
	}
	}

