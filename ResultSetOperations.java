// Question 3
package com.accolite.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetOperations {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		String sql;
		
		try {
			// Load driver
			Class.forName("com.mysql.jdbc.Driver");

			// Open DB connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcAssign?useSSL=false", "root", "root");

			// Create statement
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		               ResultSet.CONCUR_UPDATABLE);
			
			sql = "select * from Employee";
			rs = stmt.executeQuery(sql);
			
			//insertion			
			for(int i=0;i<2;i++) {
				rs.moveToInsertRow();
				rs.updateInt("id", 100 + i);
				rs.updateString("name", ""+(char)('Y' + i));
				rs.updateInt("age", 26 + i);
				rs.insertRow();
				rs.moveToCurrentRow();
			}
			
			System.out.println("Database after entry");
			while (rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
			
			//update
			int i=0;
			while(rs.previous()) {
				i++;
				if(i>2) break;
				String name = rs.getString("name");
				rs.updateString("name", name+"_updated");
				rs.updateRow();
			}
			
			System.out.println("Database after update");
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
