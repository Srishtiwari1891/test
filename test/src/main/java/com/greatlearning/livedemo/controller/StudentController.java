package com.greatlearning.livedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.livedemo.entity.Student;
import com.greatlearning.livedemo.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/list")
	public String listStudents(Model theModel) {
		List<Student> studentlist = studentService.findAll();
		theModel.addAttribute("students", studentlist);
		return "list-students";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("students", student);
		theModel.addAttribute("mode", "Add");
		return "student-form";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentid") int Studentid, Model theModel) {
		Student student = studentService.findbyId(Studentid);
		theModel.addAttribute("students", student);
		theModel.addAttribute("mode", "Update");
		return "student-form";

	}

	@PostMapping("/save")
	public String saveStudent(
			@RequestParam("studentid") int Studentid,
			@RequestParam("fname") String fname,
			@RequestParam("lname") String lname,
			@RequestParam("department") String department,
			@RequestParam("country") String country) {
		
		Student student=null;
		
		if(Studentid==0) {
			 student=new Student(fname,lname,department,country);	
		}
		else {
			student=studentService.findbyId(Studentid);
			student.setFname(fname);
			student.setLname(lname);
			student.setCourse(department);
			student.setCountry(country);
		}
		studentService.save(student);
		return "redirect:list";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentid") int Studentid) {
		studentService.delete(Studentid);
		return "redirect:list";
	}
}

	






