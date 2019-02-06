package com.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.student.entity.Student;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/student?useSSL=false&useUnicode=true&characterEncoding=utf-8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";
	public static Connection connection = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	//获取连接对象
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
	}
	
	public static PreparedStatement prepareStatement(String sql, Object[] params) throws ClassNotFoundException, SQLException {
		pstmt = getConnection().prepareStatement(sql);
		if(params!=null) {
			for (int i=0; i<params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
		return pstmt;
	}
	//通用增删改
	public static boolean executeUpdate(String sql, Object[] params) {
		try {
			pstmt = prepareStatement(sql, params);
			int count = pstmt.executeUpdate();
			if (count>0) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeAll(null, (Statement) pstmt, connection);
		}
	}
	//通用查
	public static ResultSet executeQuery (String sql, Object[] params) {
		try {
			pstmt = prepareStatement(sql, params);
			rs = pstmt.executeQuery();
			return rs;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//关闭操作对象
	public static void closeAll(ResultSet rs, Statement stmt, Connection connection) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if (connection!=null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
