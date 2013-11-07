package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.datasource.DataSource;
import com.dto.User;

public class UserAuthentication {
	static Connection con;

	public static int Authenticate(User user) throws SQLException {
		con = DataSource.getDataSource();
		PreparedStatement ps = con
				.prepareStatement("select * from user where user=? and password=?");
		ps.setString(1, user.getUser());
		ps.setString(2, user.getPass());
		ResultSet rs = ps.executeQuery();
		con.setAutoCommit(false);
		int i = 0;
		if (rs.next()) {
			System.out.println("user authenticated");
			i = 1;
		}
		return i;

	}

}
