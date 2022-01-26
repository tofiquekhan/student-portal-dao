package myproject.studentportal.factory;

import myproject.studentportal.dao.StudentDao;
import myproject.studentportal.dao.StudentDaoImpl;

public class StudentDaoFactory {

	private static StudentDao studentDao;
	
	static {
		studentDao = new StudentDaoImpl();
	}
	
	public static StudentDao getStudentDao() {
		return studentDao;
	}
	
}
