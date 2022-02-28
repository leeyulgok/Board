package com.borad.web.register.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Register {
	
	public int InputRegister(String name, String id, String pw){
		int result = 0;
		
		try {			
			final String url = "jdbc:mysql://localhost:3306/NOTICE";
			final String dbid = "root";
			final String dbpw = "1234";
			final String driver = "com.mysql.jdbc.Driver";
			
			String sql = String.format("INSERT IGNORE INTO REGISTER VALUES ('%s', '%s', '%s')", name, id, pw);
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbid, dbpw);
			PreparedStatement st = con.prepareStatement(sql);
			result = st.executeUpdate();
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
