package edu.mum.cs.cs425.srs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.srs.model.Student;
import edu.mum.cs.cs425.srs.service.IStudentService;

@Controller
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value="/srs/students/browse", method=RequestMethod.GET)
	public ModelAndView students() {
		ModelAndView mav = new ModelAndView();
		List<Student> students = studentService.findAll();
		mav.addObject("students", students);
		mav.setViewName("students/browse");
		return mav;
	}
	
	@RequestMapping(value="/srs/students/new", method = RequestMethod.GET)
	public String studentRegistrationForm(Model model){			
		model.addAttribute("student", new Student());
		return "students/new";
	}
	
	@RequestMapping(value = "/srs/students/new", method = RequestMethod.POST)
	public String registerNewStudent(@Valid @ModelAttribute("student") Student student, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "students/new";
		}
		student = studentService.save(student);
		return "redirect:/srs/students/browse";
	}
	
	@RequestMapping(value="/srs/students/edit/{id}", method = RequestMethod.GET)
	public String editStudent(@PathVariable Long id, Model model){	
		Student s = studentService.findById(id);
		if (s != null) {
			model.addAttribute("student", s);
			return "students/edit";
		}
		return "students/browse";
	}
	
	@RequestMapping(value = "/srs/students/edit", method = RequestMethod.POST)
	public String updateStudent(@Valid @ModelAttribute("student") Student student, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "students/edit";
		}
		student = studentService.save(student);
		return "redirect:/srs/students/browse";
	}
}
