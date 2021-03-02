/**
 * 
 */
package com.ss.assignment.weekone;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SampleSingleton {
	private static Connection conn = null;
	private static volatile SampleSingleton instance = null;

	public static SampleSingleton getInstance() {
		if (instance == null) {
			synchronized(SampleSingleton.class) {
				if (instance == null) {
					instance = new SampleSingleton();
				}
			}
		}
		
		return instance;
	}

	public static void databaseQuery(BigDecimal input) throws SQLException {
		conn = DriverManager.getConnection("url of database");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id from table");
		BigDecimal x;
		while (rs.next()) {
			x = new BigDecimal(rs.getInt(1)).multiply(input);
		}
	}
}