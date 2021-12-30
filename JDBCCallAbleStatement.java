package com.jdbc.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class JDBCCallAbleStatement {

	public static void main(String[] args) throws Exception {
		testStoreProcs();
		//testFunctionProc();
	}

	public static void testFunctionProc() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		CallableStatement cal = conn.prepareCall("{? = CALL PERSONCOUNTFUNCTION()}");
		cal.registerOutParameter(1, Types.INTEGER);
		cal.execute();
		int count = cal.getInt(1);
		System.out.println("count is = " + count);

	}

	public static void testStoreProcs() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		CallableStatement cal = conn.prepareCall("{CALL select(?)}");
		cal.registerOutParameter(1, Types.INTEGER);
		cal.execute();
		int count = cal.getInt(1);
		System.out.println("count is = " + count);

	}

}
