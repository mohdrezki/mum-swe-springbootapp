package edu.mum.cs.cs425.srs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.srs.model.Student;

@Repository("studentRepository")
public interface IStudentRepository extends JpaRepository<Student, Long> {
	// Relies on the default public abstract methods defined in the super interface, JpaRepository<T, ID>
	// We may override or add more methods here, if needed
}
