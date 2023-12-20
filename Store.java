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

import com.beans.StoreBean;
import com.dao.DBConnection;
import com.dao.RandomeString;

/**
 * Servlet implementation class Store
 */
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/Store")
public class Store extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Store() {
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
		String name = request.getParameter("name");
		String sql = "select cserver from user where email='"+uid+"'";
		String cserver = DBConnection.getName(sql);
		Part img = request.getPart("photo");
		InputStream photo = null;
		if(img != null){
			photo = img.getInputStream();
		}
		String content = img.getContentType();
		double size = img.getSize();
		Date d = new Date();
		String da = "" + d;
		StoreBean sb = new StoreBean();
		sb.setId(id);
		sb.setUid(uid);
		sb.setName(name);
		sb.setPhoto(photo);
		sb.setCserver(cserver);
		sb.setDa(da);
		sb.setContent(content);
		sb.setSize(size);
		sql = "insert into store values(?,?,?,?,?,?,?,?)";
		int i = DBConnection.store(sql, sb);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('File Stored Successfully..');");
			o.println("window.location='StoreData.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Failed to store the file');");
			o.println("window.location='StoreData.jsp';</script>");
		}
	}
	}
