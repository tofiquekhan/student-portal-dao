package myproject.studentportal.service;

import myproject.studentportal.dto.Student;

public interface StudentService {

	public String addStudent(Student student);
	public Student searchStudent(String sid);
	public String deleteStudent(String sid);
	
	
}
