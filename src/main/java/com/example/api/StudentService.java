package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentDAO sdao;
	
	public List<Student> getAllStudents(){
		return sdao.getAllStudents();
	}
	
	public Student getStudent(int rno){
		return sdao.getStudent(rno);
	}
	
	String addStudent(Student std) {
        return sdao.addStudent(std);
    }
	
	String deleteStudent(int rno) {
        return sdao.deleteStudent(rno);
    }
}
