// Question 1
package com.accolite.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Batch {

	public static void main(String[] args) throws SQLException {
		
		HashMap<Integer, Employee> empHashMap = new HashMap<Integer, Employee>();
		empHashMap.put(1, new Employee(1, "A", 30));
		empHashMap.put(2, new Employee(2, "B",35));
		empHashMap.put(3, new Employee(3, "C", 40));
		empHashMap.put(4, new Employee(4, "D", 45));
		empHashMap.put(5, new Employee(5, "E", 50));
		
		System.out.println(empHashMap);
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			// Load driver
			Class.forName("com.mysql.jdbc.Driver");

			// Open DB connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcAssign?useSSL=false", "root", "root");

			// Create statement
			stmt = con.createStatement();
			
			String SQL = "insert into Employee values(?,?,?)";
			
			// Create PrepareStatement object
			pstmt = con.prepareStatement(SQL);
			
			for(Map.Entry<Integer, Employee> entry: empHashMap.entrySet()) {
				// Set the variables
				pstmt.setInt(1, entry.getValue().getId());
				pstmt.setString(2, entry.getValue().getName());
				pstmt.setInt(3, entry.getValue().getAge());
				// Add it to the batch
				pstmt.addBatch();
			}

			pstmt.executeBatch();
			
			String sql = "select * from Employee;";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("Database after entry");
			while (rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
			
			
			//update
			SQL = "update Employee set name = ? where id = ?";
			pstmt = con.prepareStatement(SQL);
			
			for(Map.Entry<Integer, Employee> entry: empHashMap.entrySet()) {
				// Set the variables
				pstmt.setString(1, entry.getValue().getName()+ "_updated");
				pstmt.setInt(2, entry.getValue().getId());
				// Add it to the batch
				pstmt.addBatch();
			}

			pstmt.executeBatch();
			
			sql = "select * from Employee;";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("\nDatabase after updating");
			while (rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
			
			//delete
			SQL = "delete from Employee where id = ?";
			pstmt = con.prepareStatement(SQL);
			int i =0 ;
			
			for(Map.Entry<Integer, Employee> entry: empHashMap.entrySet()) {
				i++;
				if(i>=3) break;
				// Set the variables
				pstmt.setInt(1, entry.getValue().getId());
				// Add it to the batch
				pstmt.addBatch();
			}

			pstmt.executeBatch();
			
			sql = "select * from Employee;";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("\nDatabase after deleting");
			while (rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}
	}

}
