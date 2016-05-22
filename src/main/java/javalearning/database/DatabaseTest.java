package javalearning.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import org.apache.commons.dbcp.BasicDataSource;

public class DatabaseTest {

	public static void main(String[] args) {
		
		/*Driver  --> DriverManager --> Connection*/
		
		
		// test DriverManager
//		test001();
		
		// use traditional jdbc
//		test002();
		
		// test batch operate
//		test003();
		
		// test jdbc CRUD
//		test004();

		// use dbcp
		test005();
		
		// use jdbc template
		
		// use support
		
		// test dbcp properties
		
		// timeout
		
		// rebuild connections
		
		// test sqllite

	}
	
	private static void test001() {
		
		/*You need to include the driver to classpath*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Enumeration<java.sql.Driver> d1 = DriverManager.getDrivers();
		while (d1.hasMoreElements()) {
			System.out.println(d1.nextElement().getClass());
		}

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/iinet", "root", "admin");
			
			//Test Statement
			Statement statement = conn.createStatement();
			// select
			ResultSet rs = statement.executeQuery("select * from sms limit 5");
			int count = 0;
			while (rs.next()) {
				//get field by name or position(start from 1), non case sensitive
				System.out.println("Record " + count++);
				System.out.println(rs.getString("additional_notify_address") + rs.getString("entered"));
				System.out.println(rs.getString("ADDITIONAL_notify_address") + rs.getTimestamp("Entered"));
				System.out.println(rs.getString(2) + rs.getTimestamp(10));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void test002() {
		
		/*You need to include the driver to classpath*/
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Enumeration<java.sql.Driver> d1 = DriverManager.getDrivers();
		while (d1.hasMoreElements()) {
			System.out.println(d1.nextElement().getClass());
		}

		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/iinet", "root", "admin");
			
			//Test PreparedStatement
			PreparedStatement stmt = conn.prepareStatement("select * from sms limit ?");
			stmt.setInt(1, 10);
			ResultSet rs2 = stmt.executeQuery();
			int count = 0;
			while (rs2.next()) {
				//get field by name or position(start from 1), non case sensitive
				System.out.println("Record2 " + count++);
				System.out.println(rs2.getString("additional_notify_address") + rs2.getString("entered"));
				System.out.println(rs2.getString("ADDITIONAL_notify_address") + rs2.getTimestamp("Entered"));
				System.out.println(rs2.getString(2) + rs2.getTimestamp(10));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	private static void test003() {
		
		/*You need to include the driver to classpath*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Enumeration<java.sql.Driver> d1 = DriverManager.getDrivers();
		while (d1.hasMoreElements()) {
			System.out.println(d1.nextElement().getClass());
		}

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/iinet", "root", "admin");
			PreparedStatement stmt = conn.prepareStatement("insert into sms (additional_notify_address, entered) values ('test@163.com', '2016-05-20 15:04:51')");
			//Test batch
			stmt.addBatch();
			stmt.addBatch();
			stmt.addBatch();
			int[] counts = stmt.executeBatch();
			for (int i = 0; i < counts.length; i++) {
				System.out.println(counts[i]);
			}
			
			ResultSet rs2 = stmt.executeQuery("select * from sms order by entered desc limit 3 ");
			while (rs2.next()) {
				System.out.println(rs2.getString(2) + rs2.getTimestamp(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void test004() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/iinet", "root", "admin");
				Statement stmt = conn.createStatement();
				
				int count = 0;
				boolean result = false;
				
				// create table
				System.out.println("\r\nTest case : create table");
				System.out.println("==========================================");
				result = stmt.execute("create table IF NOT EXISTS COUNTRIES "
						+ "(NAME varchar(256) not null primary key, POPULATION varchar(256) not null);");
				System.out.println("Create table result: " + result);
				
				// delete all
				System.out.println("\r\nTest case : delete all");
				System.out.println("==========================================");
				count = stmt.executeUpdate("delete from countries");
				System.out.println("Delete all result: " + count);
				
				// insert
				System.out.println("\r\nTest case : insert");
				System.out.println("==========================================");
				count = stmt.executeUpdate("insert into countries (name, population) values ('China', '1 billion')");
				count += stmt.executeUpdate("insert into countries (name, population) values ('Japan', '200 Million')");
				System.out.println("Insert table result: " + count);
				
				// select
				System.out.println("\r\nTest case : select");
				System.out.println("==========================================");
				ResultSet rs = stmt.executeQuery("select * from countries");
				while (rs.next()) {
					System.out.println("Name:" + rs.getString("name") + "; Population:" + rs.getString("population"));
				}
				
				// update
				System.out.println("\r\nTest case : update");
				System.out.println("==========================================");
				count = stmt.executeUpdate("update countries set population = '1.3 billion' where name = 'China'");
				System.out.println("Update table result: " + count);
				rs = stmt.executeQuery("select * from countries");
				while (rs.next()) {
					System.out.println("Name:" + rs.getString("name") + "; Population:" + rs.getString("population"));
				}
				
				// delete
				System.out.println("\r\nTest case : delete");
				System.out.println("==========================================");
				count = stmt.executeUpdate("delete from countries where name = 'China'");
				System.out.println("Delete table result: " + count);
				rs = stmt.executeQuery("select * from countries");
				while (rs.next()) {
					System.out.println("Name:" + rs.getString("name") + "; Population:" + rs.getString("population"));
				}
				
				// batch
				System.out.println("\r\nTest case : batch");
				System.out.println("==========================================");
				PreparedStatement pstmt = conn.prepareStatement("insert into countries (name, population) values (?, ?)");
				pstmt.setString(1, "USA");
				pstmt.setString(2, "0.2 billion");
				pstmt.addBatch();
				pstmt.setString(1, "Canada");
				pstmt.setString(2, "50 Million");
				pstmt.addBatch();
				pstmt.executeBatch();
				rs = pstmt.executeQuery("select * from countries");
				while (rs.next()) {
					System.out.println("Name:" + rs.getString("name") + "; Population:" + rs.getString("population"));
				}
				
				// transaction roll back
				System.out.println("\r\nTest case : transaction roll back");
				System.out.println("==========================================");
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement("insert into countries (name, population) values (?, ?)");
				pstmt.setString(1, "AU");
				pstmt.setString(2, "20 Million");
				pstmt.addBatch();
				pstmt.setString(1, "India");
				pstmt.setString(2, "1.5 Billion");
				pstmt.addBatch();
				pstmt.executeBatch();
				conn.rollback();
				rs = pstmt.executeQuery("select * from countries");
				while (rs.next()) {
					System.out.println("Name:" + rs.getString("name") + "; Population:" + rs.getString("population"));
				}

				// transaction commit
				System.out.println("\r\nTest case : transaction commit");
				System.out.println("==========================================");
				pstmt = conn.prepareStatement("insert into countries (name, population) values (?, ?)");
				pstmt.setString(1, "AU");
				pstmt.setString(2, "20 Million");
				pstmt.addBatch();
				pstmt.setString(1, "India");
				pstmt.setString(2, "1.5 Billion");
				pstmt.addBatch();
				pstmt.executeBatch();
				conn.commit();
				rs = pstmt.executeQuery("select * from countries");
				while (rs.next()) {
					System.out.println("Name:" + rs.getString("name") + "; Population:" + rs.getString("population"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void test005() {
		
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:33060/wallet");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("mppg");
		ds.setPassword("mppg");
		ds.setMinIdle(10);
		ds.setMaxIdle(20);
		ds.setTestOnBorrow(false);
		ds.setValidationQuery("SELECT 1"); // important because in case that 
		                                   // the connection is broken but ds doesn't check
		
		for (int i = 0; i < 100; i++) {
			
			try {
				Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from call_back_queue order by id desc limit 1");
				while (rs.next()) {
					System.out.println("Request_DateTime:" + rs.getString("Request_DateTime") + "; Client_ID:" + rs.getString("Client_ID"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	

}
