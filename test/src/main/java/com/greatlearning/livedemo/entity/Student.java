package com.greatlearning.livedemo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_live")
public class Student 
{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "Studentid")
	private int Studentid;
	@Column(name="fname")
	private String fname;
	@Column(name="lname")
	private String lname;
	@Column(name="course")
	private String course;
	@Column(name="country")
	private String country;	

	public Student()
	{
		super();	
	}
	
	public Student(String fname, String lname, String department, String country) {
		super();
		
		this.fname = fname;
		this.lname = lname;
		this.course = department;
		this.country = country;
	
	}
	
	public int getStudentid() {
		return Studentid;
	}

	
	public void setStudentid(int studentid) {
		Studentid = studentid;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [Studentid=" + Studentid + ", fname=" + fname + ", lname=" + lname + ", course=" + course
				+ ", country=" + country + "]";
	}
	
	
	
}
