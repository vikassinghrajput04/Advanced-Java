package com.jdbc.connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class TestJdbcConnection {

	public static void main(String[] args) throws Exception {
		testJdbc();
		// updateTableJdbc();
		// insertTableJdbc();
		//deleteTableJdbc();
	}

	public static void deleteTableJdbc() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");
		Statement stmt = conn.createStatement();
		int rs = stmt.executeUpdate("delete from marksheet where id=17");

		System.out.println(rs + "record inserted");

	}

	public static void insertTableJdbc() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");
		Statement stmt = conn.createStatement();
		int rs = stmt.executeUpdate("Insert into Marksheet Values(17,1217,'Karthik','Sharma',70,80,75)");

		System.out.println(rs + "record inserted");

	}

	public static void updateTableJdbc() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");
		Statement stmt = conn.createStatement();
		int rs = stmt.executeUpdate("Update marksheet set first_name = 'Vinay' where id =16");

		System.out.println(rs + "record inserted");

	}

	public static void testJdbc() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from marksheet");

		while (rs.next()) {

			System.out.print(rs.getString(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getString(3) + "\t" + "\t");
			System.out.print(rs.getString(4) + "\t" + "\t");
			System.out.print(rs.getString(5) + "\t");
			System.out.print(rs.getString(6) + "\t");
			System.out.println(rs.getString(7) + "\t");

		}

	}

}
