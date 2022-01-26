package myproject.studentportal.dao;

import myproject.studentportal.dto.Student;

public interface StudentDao {

	public String add(Student student);
	public Student search(String sid);
	public String delete(String sid);
}
