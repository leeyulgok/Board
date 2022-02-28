package com.borad.web.register.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.borad.web.register.controller.Register;

@WebServlet("/registerService")
public class RegisterService extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		
		Register register = new Register();
		int result = register.InputRegister(name, id, pw);
		
		if(result == 0) {
			out.println("<script language='javascript'>");
			out.println("alert('회원가입에 실패하셨습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('회원가입에 성공하셨습니다!')");
			out.println("location.href='/index'");
			out.println("</script>");
		}
		
	}
}