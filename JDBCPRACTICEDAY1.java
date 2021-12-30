package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

public class JDBCPRACTICEDAY1 {

	public static void main(String[] args) throws Exception {
		// testjdbc();
		inserttestjdbc();
		// updatestjdbc();
		// deletetestjdbc();

	}

	public static void inserttestjdbc() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/d", "root", "root");
		Statement stmt = conn.createStatement();
		stmt.addBatch("insert into t values(10,'Aniket','Jain')");
		stmt.addBatch("insert into t values(11,'Nishant','Sharma')");
		stmt.addBatch("insert into t values(12,'Hemant','Verma')");
		int[] i = stmt.executeBatch();
		System.out.println(i+"Inserted");
		stmt.close();
		conn.close();
	}

	public static void deletetestjdbc() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/d", "root", "root");
		Statement stmt = conn.createStatement();
		int rs = stmt.executeUpdate("delete from t where id=7");
		System.out.println(rs + "updated!!!!");

		stmt.close();
		conn.close();
	}

	public static void updatestjdbc() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/D", "root", "root");
		Statement stmt = conn.createStatement();
		int rs = stmt.executeUpdate("update t set fname='Vinit' where id=6");
		System.out.println(rs + "updated");
		stmt.close();
		conn.close();

	}

	public static void testjdbc() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/d", "root", "root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from T");

		while (rs.next()) {
			System.out.print(rs.getString(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.println(rs.getString(3));

		}
		stmt.close();
		conn.close();

	}

}
