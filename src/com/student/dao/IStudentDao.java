package com.student.dao;

import java.util.List;

import com.student.entity.Student;

public interface IStudentDao {
		//查询学生是否存在
		public boolean isExit(int sno);
		
		//根据学号查询学生
		public Student queryStudentBySno (int sno);
		
		//查询全部学生
		public List<Student> queryAllStudents ();
		
		//根据年龄查询学生
		
		//根据姓名查询学生
		
		//增加学生
		public boolean addStudent(Student student) ;
		
		//根据学号删除学生
		public boolean deleteStudentBySno (int sno) ;
		
		//根据学号修改学生信息
		public boolean UpdateStudentBySno (int sno, Student student);

}
