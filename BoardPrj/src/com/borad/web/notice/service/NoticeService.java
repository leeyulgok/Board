package com.borad.web.notice.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.borad.web.notice.model.NoticeModel;

public class NoticeService {
	
	public List<NoticeModel> NoticeList(String ID) {
		List<NoticeModel> list = new ArrayList<>();
		
		try {			
			final String url = "jdbc:mysql://localhost:3306/NOTICE";
			final String dbid = "root";
			final String dbpw = "1234";
			final String driver = "com.mysql.jdbc.Driver";
			
			String sql = String.format("SELECT * FROM NOTICE WHERE ID='%s' ORDER BY REGDATE DESC", ID);
			
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbid, dbpw);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String id = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String regdate = rs.getString(5);
				int hit = rs.getInt(6);
				int pub = rs.getInt(7);
				
				NoticeModel notice = new NoticeModel(num, id, title, content, regdate, hit, pub);
				list.add(notice);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int InputList(String id, String title, String content, int pub){
		int result = 0;
		
		try {			
			final String url = "jdbc:mysql://localhost:3306/NOTICE";
			final String dbid = "root";
			final String dbpw = "1234";
			final String driver = "com.mysql.jdbc.Driver";
			
			String sql = String.format("INSERT NOTICE (ID, TITLE, CONTENT, PUB) VALUES('%s', '%s', '%s', %d)", id, title, content, pub);
			
			
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
	
	public List<NoticeModel> DetailList(int NUM){

		List<NoticeModel> list = new ArrayList<>();
		
		try {			
			final String url = "jdbc:mysql://localhost:3306/NOTICE";
			final String dbid = "root";
			final String dbpw = "1234";
			final String driver = "com.mysql.jdbc.Driver";
			
			String sql = String.format("SELECT * FROM NOTICE WHERE NUMBER=%d", NUM);
			
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbid, dbpw);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String id = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String regdate = rs.getString(5);
				int hit = rs.getInt(6);
				int pub = rs.getInt(7);
				
				NoticeModel notice = new NoticeModel(num, id, title, content, regdate, hit, pub);
				list.add(notice);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int DeleteList(String id, int num) {
		int result = 0;
		
		try {			
			final String url = "jdbc:mysql://localhost:3306/NOTICE";
			final String dbid = "root";
			final String dbpw = "1234";
			final String driver = "com.mysql.jdbc.Driver";
			
			String sql = String.format("DELETE FROM NOTICE WHERE ID='%s' AND NUMBER=%d", id, num);
			
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
	
	public int UpdateList(String title, String content, int pub, String id, int num) {
		int result = 0;
		
		try {			
			final String url = "jdbc:mysql://localhost:3306/NOTICE";
			final String dbid = "root";
			final String dbpw = "1234";
			final String driver = "com.mysql.jdbc.Driver";
			
			String sql = String.format("UPDATE NOTICE SET TITLE='%s', CONTENT='%s', PUB=%d WHERE ID='%s' AND NUMBER=%d", title, content, pub, id, num);
			
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

	public List<NoticeModel> AllNoticeList() {
		List<NoticeModel> list = new ArrayList<>();
		
		try {			
			final String url = "jdbc:mysql://localhost:3306/NOTICE";
			final String dbid = "root";
			final String dbpw = "1234";
			final String driver = "com.mysql.jdbc.Driver";
			
			String sql = "SELECT * FROM NOTICE WHERE PUB=1 ORDER BY REGDATE DESC";
			
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbid, dbpw);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String id = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String regdate = rs.getString(5);
				int hit = rs.getInt(6);
				int pub = rs.getInt(7);
				
				NoticeModel notice = new NoticeModel(num, id, title, content, regdate, hit, pub);
				list.add(notice);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int PubSetting(String onums, String cnums) {
		int result = 0;
		
		String opensql = String.format("UPDATE NOTICE SET PUB=1 WHERE NUMBER IN ('%s');", onums);
		String closesql = String.format("UPDATE NOTICE SET PUB=0 WHERE NUMBER IN ('%s');", cnums);
		
		try {			
			final String url = "jdbc:mysql://localhost:3306/NOTICE";
			final String dbid = "root";
			final String dbpw = "1234";
			final String driver = "com.mysql.jdbc.Driver";
			
			String sql = opensql + closesql;
			System.out.println(sql);
			
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

	public int HitService(int num) {
		int result = 0;
		
		try {			
			final String url = "jdbc:mysql://localhost:3306/NOTICE";
			final String dbid = "root";
			final String dbpw = "1234";
			final String driver = "com.mysql.jdbc.Driver";
			
			String sql = String.format("UPDATE NOTICE SET HIT=HIT+1 WHERE NUMBER=%d", num);
			
			
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
