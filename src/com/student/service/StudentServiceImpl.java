package com.student.service;

import java.util.List;

import com.student.dao.IStudentDao;
import com.student.dao.StudentDaoImpl;
import com.student.entity.Student;

public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao = new StudentDaoImpl();
	//增加学生
	public boolean addStudent (Student student) {
		if (!studentDao.isExit(student.getSno())) {
			studentDao.addStudent(student);
			return true;
		} else {
			return false;
		}
	}
	//删除学生
	public boolean deleteStudentBySno (int sno) {
		if (studentDao.isExit(sno)) {
			return studentDao.deleteStudentBySno(sno);
		}
		return false;
	}
	//修改学生信息
	public boolean updateStudentBysno (int sno, Student student) {
		if (studentDao.isExit(sno)) {
			return studentDao.UpdateStudentBySno(sno, student);
		}
		return false;
	}
	//查询全部学生
	public List<Student> queryAllStudents() {
		return studentDao.queryAllStudents();
	}
	//根据学号查询学生
	public Student queryStudentBySno (int sno) {
		return studentDao.queryStudentBySno(sno);
	}
}
