package com.example.services;

import java.util.List;

import com.example.entities.Student;

public interface IStudentServices {
	public Student saveStudent(Student student);
  
	 public List<Student> getAllStudents();
	 
	 public Student getStudentById(Integer id);
	 
	 public void deleteStudent(Integer id);
	 
	 public Student updateStudent(Integer id,Student updateStudent);
	 
	 
	 
}
