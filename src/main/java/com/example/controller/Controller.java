package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.repository.Repository;
import com.example.student.Student;
@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	Repository repo;
	@RequestMapping("/")
	private String home() {
		System.out.println("welcome home");
		return "home";
	}

	@RequestMapping("/addStudent")
	private String addStudent(Student student) {
		repo.save(student);
		System.out.println("student saved");
		return "home";
	}
	
	@RequestMapping("/viewStudent")
	public String viewStudent(){
		repo.findAll();
		return "show";
		
	}
	
	@RequestMapping("/viewAll")
	public ModelAndView viewAll(){
		ModelAndView mv = new ModelAndView("show.jsp");
		List<Student> student=repo.findAll();
		mv.addObject(student);
		return mv;
		
	}
	
	@RequestMapping("/view/{id}")
	public List<Student> view(@PathVariable int id){
		return repo.findById(id);
	
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
	repo.deleteById(id);
	return "deleted";
	
	}
}
