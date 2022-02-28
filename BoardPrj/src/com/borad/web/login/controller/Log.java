package com.borad.web.login.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.borad.web.register.model.RegisterModel;

public class Log {
	
	public int Login(String id, String pw) {
		int result = 0;
		
		try {			
			final String url = "jdbc:mysql://localhost:3306/NOTICE";
			final String dbid = "root";
			final String dbpw = "1234";
			final String driver = "com.mysql.jdbc.Driver";
			
			String sql = String.format("SELECT PW FROM REGISTER WHERE ID='%s'", id);
			
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbid, dbpw);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				if(!rs.getString(1).equals(pw)) {
					result = -1;
				} else {
					result = 1;
				}
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
