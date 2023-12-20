package com.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.DBConnection;
import com.beans.StoreBean;
import com.beans.ServerBean;
import com.beans.StoreBean2;
import com.beans.UserBean;


public class DBConnection {

	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mjbc03-2023", "root", "root");
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return con;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return con;
		}

	}
	// Method for user Registration
	public static int setServer(String sql, ServerBean sb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sb.getSname());
			ps.setString(2, sb.getSid());
			ps.setString(3, sb.getSpwd());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}public static boolean getData(String sql) {
		// TODO Auto-generated method stub
		boolean b = false;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			b = rs.next();
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public static ResultSet getData1(String sql) {
		// TODO Auto-generated method stub
			Connection con = connect();
			ResultSet rs = null;
			try{
				PreparedStatement ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return rs;
		}
	 public static ResultSet getServer() throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from server ";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static String getName(String sql) {
			// TODO Auto-generated method stub
			String name ="";
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					name = rs.getString(1);
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return name;

		}
	public static int setUser(String sql, UserBean ub) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ub.getName());
			ps.setString(2, ub.getEmail());
			ps.setString(3, ub.getAge());
			ps.setString(4, ub.getGender());
			ps.setString(5, ub.getPassword());
			ps.setString(6, ub.getMobile());
			ps.setString(7, ub.getCserver());
			ps.setString(8, "pending");
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static List<String> getCSName(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static List<String> getUserRequest(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
				lt.add(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static int update(String sql) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	 public static ResultSet getUserDetails(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from user where cserver='CloudServer1' and status1='Approved'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getUserDetails2(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from user where cserver='CloudServer2' and status1='Approved'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static int store(String sql, StoreBean sb) {
			// TODO Auto-generated method stub
			int i = 0;
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, sb.getId());
				ps.setString(2, sb.getUid());
				ps.setString(3, sb.getName());
				InputStream photo = sb.getPhoto();
				if(photo != null){
					ps.setBinaryStream(4, photo);
				}
				ps.setString(5, sb.getCserver());
				ps.setString(6, sb.getDa());
				ps.setString(7, sb.getContent());
				ps.setDouble(8, sb.getSize());
				i = ps.executeUpdate();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
	 public static ResultSet getUserDataDetails(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from store where cserver='CloudServer1'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getSetup1(String uid) throws SQLException
	 {
	 	Connection con =DBConnection.connect();
	 	String sql="select * from user where email='"+uid+"' and cserver='CloudServer1'";
	 	Statement s=con.createStatement();
	 	ResultSet r=s.executeQuery(sql);
	 	return r;
	 }
	 public static ResultSet getSendPK(String uid) throws SQLException
	 {
	 	Connection con =DBConnection.connect();
	 	String sql="select * from privatekeys where email='"+uid+"' and cserver='CloudServer1'";
	 	Statement s=con.createStatement();
	 	ResultSet r=s.executeQuery(sql);
	 	return r;
	 }
	 public static List<String> getCServer(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
	 public static String getkey(String uid)
	 {
	 String key="";
	 	Connection con =DBConnection.connect();
	 	String sql="select pk from privatekeys where email='"+uid+"' ";
	 	Statement s;
	 try {
	 	s = con.createStatement();
	 	ResultSet r=s.executeQuery(sql);
	 	r.next();
	 	key=r.getString(1);
	 	r.close();
	 } catch (SQLException e) {
	 	// TODO Auto-generated catch block
	 	e.printStackTrace();
	 }finally{
	 	try {
	 		con.close();
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	 }
	 	return key;
	 }
	 public static List<String> getFile(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			String sql1= "select fileid from requestfile where fileid=?";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					String fileid="not";
					PreparedStatement ps1=con.prepareStatement(sql1);
					ps1.setInt(1, rs.getInt(1));
					ResultSet rs1=ps1.executeQuery();
					if(rs1.next()){
						fileid=String.valueOf(rs1.getInt(1));
					}
					if(fileid.equalsIgnoreCase("not")){
					lt.add(String.valueOf(rs.getInt(1)));
					lt.add(rs.getString(2));
					lt.add(rs.getString(3));
					lt.add(rs.getString(5));
					lt.add(rs.getString(6));
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
	 
	 
	 public static List<String> getFileapprove(String sql,String email) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			
			
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, email);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					
					
					lt.add(rs.getString(2));
					lt.add(rs.getString(3));
					lt.add(rs.getString(4));
					
				}
					
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
	 public static ResultSet getUserPKDetails( ) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from sharepk ";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getUserDataDetails2(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from recovery where cserver='CloudServer2'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static ResultSet getAuthenticationRequest(String uid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from sharepk where email='"+uid+"'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static String getRID1(String sid)
	 {
	 String key="";
	 	Connection con =DBConnection.connect();
	 	String sql="select rid from sharepk where tocserver2='"+sid+"'";
	 	Statement s;
	 try {
	 	s = con.createStatement();
	 	ResultSet r=s.executeQuery(sql);
	 	r.next();
	 	key=r.getString(1);
	 	r.close();
	 } catch (SQLException e) {
	 	// TODO Auto-generated catch block
	 	e.printStackTrace();
	 }finally{
	 	try {
	 		con.close();
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	 }
	 	return key;
	 }
	 public static List<String> getRID(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(1));
				//	lt.add(rs.getString(2));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
	 public static List<String> getOName(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(1));
					//lt.add(rs.getString(2));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
	 public static String getOName1(String uid)
	 {
	 String key="";
	 	Connection con =DBConnection.connect();
	 	String sql="select name from user where email='"+uid+"'";
	 	Statement s;
	 try {
	 	s = con.createStatement();
	 	ResultSet r=s.executeQuery(sql);
	 	r.next();
	 	key=r.getString(1);
	 	r.close();
	 } catch (SQLException e) {
	 	// TODO Auto-generated catch block
	 	e.printStackTrace();
	 }finally{
	 	try {
	 		con.close();
	 	} catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	 }
	 	return key;
	 }
	 public static ResultSet getVerifyRequest(String sid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from verify where tocserver1='CloudServer1' and status1='Pending'";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static List<String> getRecoverFile(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(1));
					lt.add(rs.getString(2));
					lt.add(rs.getString(3));
				//	lt.add(rs.getString(4));
					lt.add(rs.getString(5));
					lt.add(rs.getString(6));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
	 public static int store2(String sql, StoreBean2 sb1) {
			// TODO Auto-generated method stub
			int i = 0;
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, sb1.getId1());
				ps.setString(2, sb1.getUid1());
				ps.setString(3, sb1.getName1());
				InputStream photo1 = sb1.getPhoto1();
				if(photo1 != null){
					ps.setBinaryStream(4, photo1);
				}
				ps.setString(5, "CloudServer2");
				ps.setString(6, sb1.getDa1());
				ps.setString(7, sb1.getContent1());
				ps.setDouble(8, sb1.getSize1());
				i = ps.executeUpdate();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
	 public static ResultSet getUsersPK() throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from privatekeys ";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 public static List<String> getViewFile(String sql) {
			// TODO Auto-generated method stub
			List<String> lt = new ArrayList<String>();
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					lt.add(rs.getString(2));
					lt.add(rs.getString(3));
					lt.add(rs.getString(5));
					lt.add(rs.getString(6));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lt;
		}
	 public static ResultSet getUserD( String uid) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from user where email='"+uid+"' and cserver='CloudServer2' and status1='Approved' ";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	 
	 public static String getUserCloud(String sql,String name1) throws SQLException{
		 Connection con =DBConnection.connect();
		 PreparedStatement ps=con.prepareStatement(sql);
		 ps.setString(1, name1);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next()){
			 return rs.getString(1);
		 }else{
		 
		 
		 return null;
		 }
	 }
	 public static ResultSet getUserRecoveryReq( ) throws SQLException
		{
			Connection con =DBConnection.connect();
			String sql="select * from recoveryrequest";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(sql);
			return r;
		}
	public static int saveRequest(String ownername, String userid, String status,String fileid) throws SQLException {
		Connection con =DBConnection.connect();
		String sql="insert into requestfile values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, ownername);
		ps.setString(2,userid);
		ps.setString(3,status);
		ps.setInt(4,Integer.parseInt(fileid));
		int i=ps.executeUpdate();
		return i;
	}
	 }
