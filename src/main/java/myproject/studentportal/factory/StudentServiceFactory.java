package myproject.studentportal.factory;

import myproject.studentportal.service.StudentService;
import myproject.studentportal.service.StudentServiceImpl;

public class StudentServiceFactory {

	private static StudentService studentService;
	
	static {
		studentService = new StudentServiceImpl();
		
	}
	
	public static StudentService getStudentService() {
		return studentService;
	}
}
