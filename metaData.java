//Question 2

package com.accolite.au.jdbc;

import java.sql.*;

public class metaData {
	public static void main(String[] args) throws SQLException{
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		String sql;
		try {
			// Load driver
			Class.forName("com.mysql.jdbc.Driver");

			// Open DB connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "root");
			DatabaseMetaData dbmd=con.getMetaData();  
			String table[]={"TABLE"};  
			rs=dbmd.getTables(null,null,null,table);  

			while(rs.next())
			{
			    //Print
				String tableName = rs.getString("TABLE_NAME");
			    System.out.println("\nTable name: "+ tableName);
			    
			    ResultSet columns = dbmd.getColumns(null,null, tableName, null);
			    System.out.println("\tColumn Name\t\tData Type\tSize\tDecimal Degits\tIs Nullable\tIs auto-increment");
			    while(columns.next())
			    {
			    	String columnName = columns.getString("COLUMN_NAME");
			        String datatype = columns.getString("DATA_TYPE");
			        String columnsize = columns.getString("COLUMN_SIZE");
			        String decimaldigits = columns.getString("DECIMAL_DIGITS");
			        String isNullable = columns.getString("IS_NULLABLE");
			        String is_autoIncrment = columns.getString("IS_AUTOINCREMENT");
			        //Printing results
			        System.out.println("\t"+columnName + "\t\t" + datatype + "\t" + columnsize + "\t" + decimaldigits + "\t" + isNullable + "\t" + is_autoIncrment);
			    }
			}
		}
		catch (Exception e) {
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
