package com.example.entities;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Student {

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name",nullable = false ,length = 40)
	private String firstName;
	
	@Column(name = "last_name",nullable = false)
	private String lastName;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birth_of_date",nullable = true)
	private Date birthOfDate;

	@ManyToMany
	@JoinTable(name = "student_course",
	joinColumns = @JoinColumn(name = "student_id"),//burası ait oldugu tabloyu temsil ediyoır
	inverseJoinColumns = @JoinColumn(name = "course_id"))//burası ıse baglı oldugu tabloyu temsil ediyor

	private List<Course> courses;

}
