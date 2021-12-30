package com.project.marksheet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JdbcDataSource {
	
	public static void main(String[] args) {
		getConnection();
		getConnection();
		getConnection();
		getConnection();
	} 
	                                   
	// JDBC Datasource static object
	private static JdbcDataSource jds = null;
	
	//C3P0 database connection pool
	private ComboPooledDataSource ds  = null;
	
	//make default constructor private
	private JdbcDataSource() {
		try {
			// create data source 
			ds = new ComboPooledDataSource();
			//set ds properties
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setUser("root");
			ds.setPassword("root");
			ds.setInitialPoolSize(1);
			ds.setAcquireIncrement(1);
			ds.setMaxPoolSize(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//get singleton class instance
	public static JdbcDataSource getInstance() {
		if (jds == null) {
			jds = new JdbcDataSource();
		}
		return jds;
	}
	
	//get connection from DCP
	public static Connection getConnection() {
		try {
			return getInstance().ds.getConnection();
		} catch (SQLException e) {
			return null;
		}
	}
	
	//close connection
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	//close connection
	public static void closeConnection(Connection conn) {
		closeConnection(conn, null, null);
	}
	
	
}
