package edu.mum.cs.cs425.srs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.srs.model.Student;
import edu.mum.cs.cs425.srs.repository.IStudentRepository;
import edu.mum.cs.cs425.srs.service.IStudentService;

@Service("studentService")
public class StudentService implements IStudentService {
	
	@Autowired
	IStudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student findById(Long studentId) {
		Optional<Student> os = studentRepository.findById(studentId);
		return os.orElse(null);
	}

	@Override
	public void delete(Long studentId) {
		studentRepository.deleteById(studentId);
	}
	
}
