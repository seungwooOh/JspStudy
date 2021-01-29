package com.koreait.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtils {
	
	public static Connection getCon() throws Exception {
		
		final String URL = "jdbc:mysql://localhost/javaboard?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
		final String USER = "root";
		final String PW = "koreait2020";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PW);
		System.out.println("getCon()");
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement ps) {
		if(ps != null) {
			try {ps.close();} catch(Exception e) {}
		}
		if(con != null) {
			try {con.close();} catch(Exception e) {}
		}
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {rs.close();} catch(Exception e) {}
		}
		close(con, ps);
	}
	
}
