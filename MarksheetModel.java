package com.project.marksheet;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ResourceBundle;

public class MarksheetModel {

	public void ADD(MarksheetBean bean) throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.project.marksheet.app");

		Class.forName(rb.getString("Driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("password"));
		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("Insert into marksheet values(?,?,?,?,?,?,?)");
		ps.setInt(1, autoId() + 1);
		ps.setString(2, bean.getRollno());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhysics());
		ps.setInt(6, bean.getMaths());
		ps.setInt(7, bean.getChemistry());

		ps.executeUpdate();
		conn.commit();
		System.out.println("Inserted");

		ps.close();
		conn.close();

	}

	private static int autoId() throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.project.marksheet.app");

		Class.forName(rb.getString("Driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("password"));
		CallableStatement cal = conn.prepareCall("{CALL IDCOUNT(?)}");
		cal.registerOutParameter(1, Types.INTEGER);
		cal.execute();
		int count = cal.getInt(1);
		return count;

	}

	public void update(MarksheetBean bean) throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.project.marksheet.app");

		Class.forName(rb.getString("Driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("password"));
		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("Update Marksheet set First_Name = ?  where id= ? ");
		ps.setString(1, bean.getFname());
		ps.setInt(2, bean.getId());

		ps.executeUpdate();
		conn.commit();
		System.out.println("updated");

		ps.close();
		conn.close();

	}

	public void deleteMarksheet(MarksheetBean bean) throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.project.marksheet.app");

		Class.forName(rb.getString("Driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("password"));
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("delete from Marksheet where Roll_No = ?");
		ps.setString(1, bean.getRollno());

		ps.executeUpdate();
		conn.commit();
		System.out.println("deleted");
		ps.close();
		conn.close();

	}

	public void getRollno(MarksheetBean bean) throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.project.marksheet.app");

		Class.forName(rb.getString("Driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("password"));
		PreparedStatement ps = conn.prepareStatement("Select * from Marksheet where Roll_no = ?");
		ps.setString(1, bean.getRollno());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getString(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getString(3) + "\t");
			System.out.print(rs.getString(4) + "\t");
			System.out.print(rs.getString(5) + "\t");
			System.out.print(rs.getString(6) + "\t");
			System.out.println(rs.getString(7) + "\t");
		}

		ps.close();
		conn.close();

	}

	public void getMeritList() throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.project.marksheet.app");

		Class.forName(rb.getString("Driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("password"));
		PreparedStatement ps = conn.prepareStatement(
				"SELECT *,(physics + maths + chemistry) AS Total_Marks, ((physics + maths + chemistry)/3) AS Percentage  FROM Marksheet  WHERE physics>40 AND maths>40 AND chemistry>40 ORDER BY Total_Marks DESC LIMIT 3;");
		ResultSet rs = ps.executeQuery();
		System.out.println("Id" + "\t" + "Roll_no." + "\t" + "First_Name" + "\t" + "Last_Name" + "\t" + "Physics" + "\t"
				+ "\t" + "Chemistry" + "\t" + "Maths" + "\t" + "\t" + "Total_Marks" + "\t" + "Percentage" + "\t");
		while (rs.next()) {
			System.out.print(rs.getString(1) + "\t");
			System.out.print(rs.getString(2) + "\t" + "\t");
			System.out.print(rs.getString(3) + "\t" + "\t");
			System.out.print(rs.getString(4) + "\t" + "\t");
			System.out.print(rs.getString(5) + "\t" + "\t");
			System.out.print(rs.getString(6) + "\t" + "\t");
			System.out.print(rs.getString(7) + "\t" + "\t");
			System.out.print(rs.getString(8) + "\t" + "\t");
			System.out.println(rs.getString(9) + "\t" + "\t");
		}
		ps.close();
		conn.close();
	}

	public void search() throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.project.marksheet.app");

		Class.forName(rb.getString("Driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("password"));
		PreparedStatement ps = conn.prepareStatement("Select * from Marksheet");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getString(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getString(3) + "\t");
			System.out.print(rs.getString(4) + "\t");
			System.out.print(rs.getString(5) + "\t");
			System.out.print(rs.getString(6) + "\t");
			System.out.println(rs.getString(7) + "\t");
		}

		ps.close();
		conn.close();

	}
}
