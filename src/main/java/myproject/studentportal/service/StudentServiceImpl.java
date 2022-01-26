package myproject.studentportal.service;

import myproject.studentportal.dao.StudentDao;
import myproject.studentportal.dto.Student;
import myproject.studentportal.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService{

	@Override
	public String addStudent(Student student) {
		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		String status =studentDao.add(student);
		return status;
	}

	@Override
	public Student searchStudent(String sid) {
		
		return null;
	}

	@Override
	public String deleteStudent(String sid) {
		
		return null;
	}

}