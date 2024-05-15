package com.blacky.cruddemo;

import com.blacky.cruddemo.dao.StudentDAO;
import com.blacky.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting All Students...");
		int row=studentDAO.deleteAll();
		System.out.println("Deleted row count: "+row);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("Deleting student id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId=1;
		Student myStudent=studentDAO.findById(studentId);
		System.out.println("Updating student...");
		myStudent.setFirstName("Rohit");
		studentDAO.update(myStudent);
		System.out.println("Updated student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
//		get list of students
		List<Student> theStudents=studentDAO.findByLastName("Gupta");
//		display list of students
		for(Student tempStd:theStudents){
			System.out.println(tempStd);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents=studentDAO.findAll();
		for(Student tempStd:theStudents){
			System.out.println(tempStd);
		}
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
//		create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("Rahul", "Gupta", "guptarohit@gmail.com");
		Student tempStudent2 = new Student("Shivam", "Gupta", "guptashivam@gmail.com");
		Student tempStudent3 = new Student("Anubhav", "Tiwari", "anubhavtiwari@gmail.com");
//		save the student objects
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		System.out.println("Saved student. Generated id: "+tempStudent1.getId());
		System.out.println("Saved student. Generated id: "+tempStudent2.getId());
		System.out.println("Saved student. Generated id: "+tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
//		create the student object
		System.out.println("Creation new student object...");
		Student tempStudent = new Student("Rohit", "Gupta", "guptarohit.12072@gmail.com");
//		save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
//		display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
	private void readStudent(StudentDAO studentDAO){
		Student tempStudent1 = new Student("Rahul", "Gupta", "guptarohit@gmail.com");
		Student tempStudent2 = new Student("Shivam", "Gupta", "guptashivam@gmail.com");
		Student tempStudent3 = new Student("Anubhav", "Tiwari", "anubhavtiwari@gmail.com");
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		System.out.println("Retrieving student by id: "+tempStudent1.getId());
		System.out.println("Retrieving student by id: "+tempStudent2.getId());
		System.out.println("Retrieving student by id: "+tempStudent3.getId());
		Student std1=studentDAO.findById(tempStudent1.getId());
		Student std2=studentDAO.findById(tempStudent1.getId());
		Student std3=studentDAO.findById(tempStudent1.getId());
		System.out.println("Found the student: "+std1);
		System.out.println("Found the student: "+std2);
		System.out.println("Found the student: "+std3);
	}
}
