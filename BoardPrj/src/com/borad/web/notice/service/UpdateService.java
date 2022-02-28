package com.borad.web.notice.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updateService")
public class UpdateService extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		NoticeService service = new NoticeService();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = (String)session.getAttribute("id");
		
		int num = 0;
		if(request.getParameter("num") == null) {
			num = 0;
		} else {
			num = Integer.parseInt(request.getParameter("num"));
		}
		System.out.println(num);
		int pub = 1;
		
		if(request.getParameter("pub") == null) {
			pub = 1;
		} else {
			pub = 0;
		}
		System.out.println(pub);
		
		int result = 0;
		
		result = service.UpdateList(title, content, pub, id, num);
		
		if(result == 0) {
			out.println("<script language='javascript'>");
			out.println("alert('글수정에 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('글을 수정했습니다.')");
			out.println("location.href='/update'");
			out.println("</script>");
		}
		
	}
}
