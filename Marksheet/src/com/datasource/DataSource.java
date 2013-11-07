package com.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	static Connection con;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static Connection getDataSource() throws SQLException {
		if (con.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/test", "root", "root");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
}
