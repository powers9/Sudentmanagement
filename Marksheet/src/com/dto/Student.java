package com.dto;

/**
 * @author powers9
 *
 */

public class Student {
	private String fname;
	private int rollno;
	private int marks;
	private int phy;
	private int chem;
	private int math;


	/**
	 * @return STUDENT NAME
	 */
	

	/**return roll number of student
	 * @return
	 */
	public int getRollno() {
		return rollno;
	}

	/**
	 * @param rollno
	 */
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	/**
	 * @return marks of marksheet
	 */
	public int getMarks() {
		return marks;
	}

	/**
	 * @param marks
	 */
	public void setMarks(int marks) {
		this.marks = marks;
	}

	/**
	 * @return physics mark
	 */
	public int getPhy() {
		return phy;
	}

	public void setPhy(int phy) {
		this.phy = phy;
	}

	/**
	 * @return chemistry mark
	 */
	public int getChem() {
		return chem;
	}

	public void setChem(int chem) {
		this.chem = chem;
	}

	/**
	 * @return math mark
	 */
	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	
}
