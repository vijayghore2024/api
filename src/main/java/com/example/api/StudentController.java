package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	StudentService ss;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Springboot";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/allstudents")
	public List<Student> getAllStudents(){
		List<Student> ls = ss.getAllStudents();
		return ls;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/student/{rno}")
	public Student getStudent(@PathVariable("rno") int rno) {
        return ss.getStudent(rno);
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/insert/stud") // Add new Record into the database.
    public String addStudent(@RequestBody Student stud) {
        return ss.addStudent(stud);
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/delete/{rno}") // Delete the record from the database.
    public String deleteStudent(@PathVariable("rno") int rno) {
        return ss.deleteStudent(rno);
    }
}
