package com.example.controller.impl;

import java.util.List;

import com.example.dto.DtoStudent;
import com.example.dto.DtoStudentIU;
import jakarta.validation.Valid;
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

	//ISUDENTCONTROLLER DE I İLE BAŞLAYIP O SINIFIN BİR INTERFACE SINIF OLDUGUNU BELİRTTİK
	//STUDENTCONTROLLERIMPL DERKEN İSE YUKARDA BELİRTTİGİMİZ İNTERFACE SINIFLARINI İMPLEMENT EDEN SINIFLARI BULUNDURUR .

	@Autowired
	private IStudentServices studentServices;

	
	@Override
	@PostMapping(path = "/save")
	public DtoStudent saveStudent(@RequestBody DtoStudentIU dtoStudentIU) {
		//REQUESTBODY=HTTP isteğinin body kısmındaki JSON verisini al, Student nesnesine dönüştür
		return studentServices.saveStudent(dtoStudentIU);
	}

     @GetMapping(path = "/list")
	@Override
	public List<DtoStudent> getAllStudents() {
		return studentServices.getAllStudents();
	}

     @GetMapping(path = "/list/{id}")
	@Override
	public DtoStudent getStudentById(@PathVariable(name = "id") Integer id) {
         
		return studentServices.getStudentById(id);
	}
     @DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteStudent(@PathVariable(name = "id")Integer id) {
studentServices.deleteStudent(id);
	}

     @PutMapping(path = "/update/{id}")
	@Override
	public DtoStudent updateStudent(@PathVariable(name = "id")Integer id,@RequestBody   DtoStudentIU dtoStudentIU) {
		return studentServices.updateStudent(id, dtoStudentIU);
	}
}
