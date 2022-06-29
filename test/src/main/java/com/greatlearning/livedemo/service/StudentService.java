	package com.greatlearning.livedemo.service;
	
	import java.util.List;
	
	import com.greatlearning.livedemo.entity.Student;
	
	public interface StudentService 
	{
		
		public List<Student> findAll();
	
		public  Student findbyId(int Studentid);
		
		public void save(Student student);
		
		public void delete (int Studentid);
	
		
	
		
		
	}
