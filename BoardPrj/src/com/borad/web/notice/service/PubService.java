package com.borad.web.notice.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pubService")
public class PubService extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String[] open = request.getParameterValues("onums");
		String[] close = request.getParameterValues("cnums");
		
		int result = 0;
		
		for(int i = 0; i < open.length; i++) {
			System.out.print(open[i] + ",");
		}
		for(int i = 0; i < close.length; i++) {
			System.out.print(close[i] + ",");
		}
		
		String onums = "";
		String cnums = "";
		
		for(int i = 0; i < open.length; i++) {
			if(i+1 == open.length) {
				onums += open[i];
			} else {				
				onums += open[i] + ",";				
			}
		}
		
		for(int i = 0; i < close.length; i++) {
			if(i+1 == close.length) {
				cnums += close[i];
			} else {				
				cnums += close[i] + ",";				
			}
		}
		
		NoticeService service = new NoticeService();
		result = service.PubSetting(onums, cnums);
		
		if(result == 0) {
			out.println("<script language='javascript'>");
			out.println("alert('공개에 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('공개에 성공했습니다.')");
			out.println("location.href='/allnotice'");
			out.println("</script>");
		}
		
	}
}
