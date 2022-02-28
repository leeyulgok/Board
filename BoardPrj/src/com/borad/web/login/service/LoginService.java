package com.borad.web.login.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.borad.web.login.controller.Log;

@WebServlet("/loginService")
public class LoginService extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		int result = 0;
		Log log = new Log();
		result = log.Login(id, pw);
		
		if(result == 1) {
			out.println("<script language='javascript'>");
			out.println("alert('로그인에 성공했습니다!')");
			out.println("location.href='/main'");
			out.println("</script>");
		} else if(result == -1) {
			out.println("<script language='javascript'>");
			out.println("alert('비밀번호가 틀립니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('데이터베이스 오류입니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
	}
}
