package edu.mum.cs.cs425.srs.service;

import java.util.List;

import edu.mum.cs.cs425.srs.model.Student;

public interface IStudentService {
	public abstract List<Student> findAll();
	public abstract Student save(Student student);
	public abstract Student findById(Long studentId);
	public abstract void delete(Long studentId);
}
