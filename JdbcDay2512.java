package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDay2512 {

	public static void main(String[] args) throws Exception {
		//testJdbc();
		//updateJdbc();
		//insertJdbc();
		//deleteJdbc();
		testjdbc(3);
	}	
	public static void testjdbc(int pk) throws Exception {
		int id = pk;
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/d", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from t where id = ?");
		ps.setInt(1, id); 
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getString(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.println(rs.getString(3));
		}
		ps.close();
		conn.close();
		
	}
	public static void deleteJdbc() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/d", "root", "root");
		PreparedStatement ps = conn.prepareStatement("delete From t where id= ?");
		ps.setInt(1, 7);
		int i =ps.executeUpdate();
		System.out.println(i+"record deleted");
		ps.close();
		conn.close();
		
	}
	public static void insertJdbc() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/d", "root", "root");
		String fname="AKSHAT";
		String lname="MALI";
		int id=6;
		
		
		PreparedStatement ps = conn.prepareStatement("insert into t values(?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, fname);
		ps.setString(3, lname);
		
		int i =ps.executeUpdate();
		System.out.println(i + "record updated");
		ps.close();
		conn.close();
	}

	public static void updateJdbc() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/d", "root", "root");
		int id=4;
		String fname="Aniket";
		String lname="Sharma";
		
		
		PreparedStatement ps = conn.prepareStatement("update t set fname=?,lname=? Where id =?");
		ps.setString(1, fname);
		ps.setString(2, lname);
		ps.setInt(3, id);
		int i =ps.executeUpdate();
		System.out.println(i + "record updated");
		ps.close();
		conn.close();

	}

	public static void testJdbc() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/d", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from t");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getString(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.println(rs.getString(3));
		}
		ps.close();
		conn.close();
	}
	

}
