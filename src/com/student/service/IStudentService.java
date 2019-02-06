package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface IStudentService {
		//增加学生
		public boolean addStudent (Student student);
		
		//删除学生
		public boolean deleteStudentBySno (int sno);
		
		//修改学生信息
		public boolean updateStudentBysno (int sno, Student student);
		
		//查询全部学生
		public List<Student> queryAllStudents();
		
		//根据学号查询学生
		public Student queryStudentBySno (int sno);

}
