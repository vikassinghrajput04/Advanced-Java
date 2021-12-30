package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class JDBCDay1 {
	public static void main(String[] args) throws Exception {
		testjdbc();
		//Updatetestjdbc();
		
	}
	public static void Updatetestjdbc() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		Statement stmt=conn.createStatement();
		int rs= stmt.executeUpdate("Insert into emp values(6,'Raju','Verma',10000)");
		System.out.println(rs+"record inserted");
		stmt.close();
		conn.close();
			
		
		
	}
	public static void testjdbc() throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	Statement stmt=conn.createStatement();
	ResultSet rs= stmt.executeQuery("Select * from emp ");
	System.out.println("ID"+"\t"+"First_Name"+"\t"+"Last_Name"+"\t"+"Salary");
	while (rs.next()) {
		System.out.print(rs.getString(1));
		System.out.print("\t"+rs.getString(2)+"\t");
		System.out.print("\t"+rs.getString(3)+"\t");
		System.out.println("\t"+rs.getString(4)+"\t");
		
		
	}
	stmt.close();
	conn.close();
		
	}

}
