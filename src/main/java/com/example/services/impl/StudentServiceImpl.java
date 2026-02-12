package com.example.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.dto.DtoStudent;
import com.example.dto.DtoStudentIU;
import org.hibernate.sql.Update;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Student;
import com.example.repository.StudentRepository;
import com.example.services.IStudentServices;


@Service
public class StudentServiceImpl implements IStudentServices{

	   @Autowired
		private StudentRepository studentRepository;

		@Override
		public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		DtoStudent response =new DtoStudent();
		Student student =new Student();
			BeanUtils.copyProperties(dtoStudentIU,student); //dtoStudentIU içindeki aynı isimli alanları👉 student nesnesine kopyalar.
		 Student dbStudent=studentRepository.save(student);
		 BeanUtils.copyProperties(dbStudent,response);
		 //database sadece entity tipinde veri tipini kabul ettigi için dto olarak aldıgımız veriyi entity e cevirip kaydediyoruz .
		return  response;
		}

		@Override
		public List<DtoStudent> getAllStudents() {
			List<DtoStudent> dtoList=new ArrayList<>();

          List<Student> studentList =  studentRepository.findAll();
		  for (Student student:studentList){
			  DtoStudent dto=new DtoStudent();
			  BeanUtils.copyProperties(student,dto);
			  dtoList.add(dto);
		  }
			return dtoList;
		}
		 @Override
		public DtoStudent getStudentById(Integer id) {
			DtoStudent dto=new DtoStudent();
		Optional<Student> optional= studentRepository.findById(id);
		//optional bu deger oladabilir olmayadabilir için kullanılır 
		if (optional.isPresent()) {
			//ispresent içinde deger varmı true dönerse var  
			Student dbStudent=optional.get();
			BeanUtils.copyProperties(dbStudent,dto);
		}
		return null;
		}

		@Override
		public void deleteStudent(Integer id) {
		Optional<Student> optional=	studentRepository.findById(id);
		if (optional.isPresent()) {
			studentRepository.delete(optional.get());
		}
			
		}

		@Override
		public DtoStudent updateStudent(Integer id,DtoStudentIU dtoStudentIU) {
         DtoStudent dto=new DtoStudent();
		Optional<Student> optinal=studentRepository.findById(id);
		if (optinal.isPresent()){
			Student dbStudent=optinal.get();

			dbStudent.setFirstName(dtoStudentIU.getFirstName());
			dbStudent.setLastName(dtoStudentIU.getLastName());
			dbStudent.setBirthOfDate(Date.valueOf(dtoStudentIU.getBirthOfDate()));

			Student updated=studentRepository.save(dbStudent);
			BeanUtils.copyProperties(updated,dto);
             return dto;
		}
		return null;


	/*DtoStudent dtoStudent=getStudentById(id);
	if (dtoStudent!=null) {
		dtoStudent.setFirstName(updateStudent.getFirstName());
		dtoStudent.setLastName(updateStudent.getLastName());
		dtoStudent.setBirthOfDate(updateStudent.getBirthOfDate());

	   return  studentRepository.save(dbStudent);

		}*/





}
}
