package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.datasource.DataSource;
import com.dto.Student;

public class Service {

	static Connection con;

	/**
	 * for adding student data
	 * 
	 * @param student
	 * @return resultset of student data
	 * @throws SQLException
	 */
	public static int add(Student student) throws SQLException {
		con = DataSource.getDataSource();
		con.setAutoCommit(false);
		PreparedStatement ps = con
				.prepareStatement("insert into student values (?,?,?,?,?,?)");
		System.out.println(" service name ---"+student.getFname());
		ps.setString(1, student.getFname());
		ps.setInt(2, student.getRollno());
		ps.setInt(3, student.getMarks());
		ps.setInt(4, student.getPhy());
		ps.setInt(5, student.getChem());
		ps.setInt(6, student.getMath());
		int i = 0;
		i = ps.executeUpdate();
		if (i > 0) {
			System.out.println("user added successfully");
			con.commit();
			con.close();
		}
		return i;
	}

	/**
	 * @param student
	 * @return row no. of deleted student by rollno.
	 * @throws SQLException
	 */
	public static int delete(Student student) throws SQLException {
		con = DataSource.getDataSource();
		con.setAutoCommit(false);
		PreparedStatement ps = con
				.prepareStatement("delete from student where rollno=(?)");
		ps.setInt(1, student.getRollno());

		int i = 0;
		i = ps.executeUpdate();
		if (i > 0) {
			con.commit();
			con.close();
		}
		return i;
	}

	/**
	 * @param student
	 * @return resultset of student by name
	 * @throws SQLException
	 */
	public static ResultSet getByName(Student student) throws SQLException {
		con = DataSource.getDataSource();
		con.setAutoCommit(false);
		PreparedStatement ps = con
				.prepareStatement("select from student where name=(?)");
		ps.setString(1, student.getFname());

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			con.commit();
			con.close();
		}
		return rs;
	}

	/**
	 * @param student
	 * @return resultset of student by rollno
	 * @throws SQLException
	 */
	public static ResultSet getByRollNo(Student student) throws SQLException {
		con = DataSource.getDataSource();
		con.setAutoCommit(false);
		PreparedStatement ps = con
				.prepareStatement("delete from student where rollno=(?)");
		ps.setInt(1, student.getRollno());

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			con.commit();
			con.close();
		}
		return rs;
	}

	/**
	 * @param student
	 * @return no of row updted in student
	 * @throws SQLException
	 */
	public static int update(Student student) throws SQLException {
		con = DataSource.getDataSource();
		con.setAutoCommit(false);
		PreparedStatement ps = con
				.prepareStatement("update student set name=?,marks=?,phy=?,chem=?,math=? where rollno=(?)");
		ps.setString(1, student.getFname());
		ps.setInt(2, student.getMarks());
		ps.setInt(3, student.getPhy());
		ps.setInt(4, student.getChem());
		ps.setInt(5, student.getMath());
		ps.setInt(6, student.getRollno());
		int i = 0;
		i = ps.executeUpdate();
		if (i > 0) {
			con.commit();
			con.close();
		}
		return i;
	}

	/**
	 * @return list of students
	 * @throws SQLException
	 */
	public static ArrayList<Student> getList() throws SQLException {
		con = DataSource.getDataSource();
		PreparedStatement ps = con.prepareStatement("select * from student");
		ResultSet rs;
		rs = ps.executeQuery();
		ArrayList<Student> li = new ArrayList<Student>();
		while (rs.next()) {
			Student student = new Student();

			student.setFname(rs.getString("name"));
			student.setRollno(rs.getInt("rollno"));
			student.setMarks(rs.getInt("marks"));
			student.setPhy(rs.getInt("phy"));
			student.setChem(rs.getInt("chem"));
			student.setMath(rs.getInt("math"));
			li.add(student);
		}
		return li;

	}

}
