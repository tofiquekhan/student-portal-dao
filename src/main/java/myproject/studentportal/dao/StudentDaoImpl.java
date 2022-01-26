package myproject.studentportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import myproject.studentportal.dto.Student;
import myproject.studentportal.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao{

	@Override
	public String add(Student student) {
		String status;
		try {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from student where sid=?");
		ps.setString(1, student.getSid());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			status="existed";
		}else {
			ps = con.prepareStatement("insert into student values(?,?,?)");
			ps.setString(1, student.getSid());
			ps.setString(2, student.getSname());
			ps.setString(3, student.getSaddr());
			int row = ps.executeUpdate();
			if(row==1) {
				status = "success";
			}else {
				status = "failure";
			}
		}
		}
		catch (Exception e) {
			status = "failure"; 
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		
		return null;
	}

	@Override
	public String delete(String sid) {

		return null;
	}

}
