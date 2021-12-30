package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class TransactionHandling {

	public static void main(String[] args) throws Exception {
		testTransactionHandling();
		//testInsert();
	}

	public static void testTransactionHandling() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/d", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("Insert into t values(7,'Vinay','Jain')");
		PreparedStatement ps1 = conn.prepareStatement("Insert into t values(7,'Vinay','Jain')");
		PreparedStatement ps2 = conn.prepareStatement("Insert into t values(7,'Vinay','Jain')");
		PreparedStatement ps3 = conn.prepareStatement("Insert into t values(7,'Vinay','Jain')");
		
		conn.commit();
		ps.executeUpdate();
		ps1.executeUpdate();
		ps2.executeUpdate();
		ps3.executeUpdate();
		
		}
	public static void testInsert() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/d", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("Insert into t values(7,'Vinay','Jain')");
		PreparedStatement ps1 = conn.prepareStatement("Insert into t values(8,'Vinay','Jain')");
		PreparedStatement ps2 = conn.prepareStatement("Insert into t values(7,'Vinay','Jain')");
		PreparedStatement ps3 = conn.prepareStatement("Insert into t values(8,'Vinay','Jain')");
		
		
		ps.executeUpdate();
		ps1.executeUpdate();
		ps2.executeUpdate();
		ps3.executeUpdate();
		
		}

}
