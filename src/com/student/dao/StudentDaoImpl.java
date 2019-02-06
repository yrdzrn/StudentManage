package com.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.student.entity.Student;
import com.student.util.DBUtil;

public class StudentDaoImpl implements IStudentDao{
	//查询学生是否存在
	public boolean isExit(int sno) {
		return queryStudentBySno(sno)==null? false:true;
	}
	//根据学号查询学生
	public Student queryStudentBySno (int sno) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student student = null;
		try {
			String sql = "select * from studentinfo where sno = ?";
			Object[] params = {sno};
			rs = DBUtil.executeQuery(sql, params);
			if (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
			}
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rs, (Statement) pstmt, connection);
		}
	}
	
	//查询全部学生
	public List<Student> queryAllStudents () {
		Student student = null;
		List<Student> students = new ArrayList<Student>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from studentinfo";
			rs = DBUtil.executeQuery(sql, null);
			while (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
				students.add(student);
			}
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rs, (Statement) pstmt, DBUtil.connection);
		}
	}
	//根据年龄查询学生
	
	//根据姓名查询学生
	
	//增加学生
	public boolean addStudent(Student student) {
		String sql = "insert into studentinfo (sno, sname, sage, saddress) values (?, ?, ?, ?)";
		Object[] params = {student.getSno(), student.getSname(), student.getSage(), student.getSaddress()};
		return DBUtil.executeUpdate(sql, params);
	}
	//根据学号删除学生
	public boolean deleteStudentBySno (int sno) {
		String sql = "delete from studentinfo where sno = ?";
		Object[] params = {sno};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//根据学号修改学生信息
	public boolean UpdateStudentBySno (int sno, Student student) {
		String sql = "update studentinfo set sname=?, sage=?, saddress=? where sno=?";
		Object[] params = {student.getSname(), student.getSage(), student.getSaddress(), sno};
		return DBUtil.executeUpdate(sql, params);
	}
}
