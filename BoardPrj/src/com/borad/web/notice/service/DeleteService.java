package com.borad.web.notice.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteService extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String id = (String)session.getAttribute("id");
		int num = 0;
		if(request.getParameter("num") == null) {
			num = 0;
		} else {
			num = Integer.parseInt(request.getParameter("num"));
		}
		
		NoticeService service = new NoticeService();
		int result = 0;
		
		result = service.DeleteList(id, num);
		
		if(result == 0) {
			out.println("<script language='javascript'>");
			out.println("alert('글삭제에 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('글을 삭제했습니다.')");
			out.println("location.href='/update'");
			out.println("</script>");
		}
		
	}
}
