package com.example.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.IStudentController;
import com.example.entities.Student;
import com.example.services.IStudentServices;


@RestController
@RequestMapping(path = "/rest/api/student")
public class StudentControllerImpl implements IStudentController{
	
	@Autowired
	private IStudentServices studentServices;

	
	@Override
	@PostMapping(path = "/save")
	public Student saveStudent(@RequestBody Student student) {
		//REQUESTBODY=HTTP isteğinin body kısmındaki JSON verisini al, Student nesnesine dönüştür
		
		return studentServices.saveStudent(student);
	}

     @GetMapping(path = "/list")
	@Override
	public List<Student> getAllStudents() {
		return studentServices.getAllStudents();
	}

     @GetMapping(path = "/list/{id}")
	@Override
	public Student getStudentById(@PathVariable(name = "id") Integer id) {
         
		return studentServices.getStudentById(id);
	}
     @DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteStudent(@PathVariable(name = "id")Integer id) {
studentServices.deleteStudent(id);
	}

     @PutMapping(path = "/update/{id}")
	@Override
	public Student updateStudent(@PathVariable(name = "id")Integer id,@RequestBody   Student updateStudent) {
		return studentServices.updateStudent(id, updateStudent);
	}
}
