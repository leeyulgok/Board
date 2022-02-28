package com.borad.web.notice.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.borad.web.register.controller.Register;

@WebServlet("/noticeWriteService")
public class NoticeWriteService extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int pub = 1;
		
		if(request.getParameter("pub") == null) {
			pub = 1;
		} else {
			pub = 0;
		}
		
		NoticeService service = new NoticeService();
		int result = service.InputList(id, title, content, pub);
		
		if(result == 0) {
			out.println("<script language='javascript'>");
			out.println("alert('글쓰기에 실패하셨습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('글쓰기에 성공하셨습니다.')");
			out.println("location.href='/main'");
			out.println("</script>");
		}
		
	}
}
