package com.jdbc.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCPractice1 {

	public static void main(String[] args) throws Exception{
		testresult();
	}

	public static void testresult() throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");
		Statement stmt= conn.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from marksheet");
		
		while (rs.next()) {
			System.out.print("\t"+rs.getString(2)+"\t");
			System.out.print("\t"+rs.getString(3)+"\t");
			System.out.print("\t"+rs.getString(4)+"\t");
			System.out.print("\t"+rs.getString(5)+"\t");
			System.out.print("\t"+rs.getString(6)+"\t");
			System.out.println("\t"+rs.getString(7));
			
		}
		conn.close();
		stmt.close();
	}
	
}
