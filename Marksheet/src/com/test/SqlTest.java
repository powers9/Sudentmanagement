package com.test;


import java.sql.SQLException;

import com.dto.Student;
import com.service.Service;

public class SqlTest {
	

	
		public static void main(String[] args) throws SQLException {
			Student student =new Student();
			System.out.println("Test run");
			student.setFname("shalll");
			student.setMarks(780);
			student.setMath(89);
			student.setChem(89);
			student.setPhy(89);
			student.setRollno(21);
			//int m=Service.add(student);//tik he na the the problem still persist eclipsre jar ko class path mein read ni kar raha tha isliye maine
			//webinf/lib folder mein patak diya so it dosent matter here see so ab bata
			
			
		//	System.out.println(m);

		}

	}


