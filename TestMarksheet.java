package com.project.marksheet;


import java.util.Locale;
import java.util.ResourceBundle;

public class TestMarksheet {
	
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testUpdate();
		//testDelete();.
		//testGet("A-04");
		//testGetMeritList();
		//testSearch();
		
		ResourceBundle rb = ResourceBundle.getBundle("com.project.marksheet.app",new Locale("hi"));
		System.out.println(rb.getString("greeting"));
		 
	}
	
	
	
	public static void testAdd() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		bean.setRollno("A-09");
		bean.setFname("Chetan");
		bean.setLname("Jain");
		bean.setPhysics(75);
		bean.setMaths(85);
		bean.setChemistry(60);
		
		MarksheetModel m = new MarksheetModel();
		m.ADD(bean);
		
		
	}
	
	public static void testUpdate() throws Exception{
		MarksheetBean bean = new MarksheetBean();
		bean.setFname("Vikas");
		bean.setId(3);
		
		
		MarksheetModel m = new MarksheetModel();
		m.update(bean);
	}
	
	public static void testDelete() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setRollno("A-03");
		
		MarksheetModel m = new MarksheetModel();
		m.deleteMarksheet(bean);
	}
	public static void testGet(String s) throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setRollno(s);
		
		MarksheetModel m = new MarksheetModel();
		m.getRollno(bean);
		}
	public static void testGetMeritList() throws Exception {
		MarksheetModel m = new MarksheetModel();
		m.getMeritList();
	}
	public static void testSearch() throws Exception {
		
		MarksheetModel m = new MarksheetModel();
		m.search();
	}
}
