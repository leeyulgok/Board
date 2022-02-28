package com.borad.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.borad.web.notice.model.NoticeModel;
import com.borad.web.notice.service.NoticeService;

@WebServlet("/main")
public class MainController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		NoticeService service = new NoticeService();
		List<NoticeModel> list = service.NoticeList(id);
		
		request.setAttribute("list", list);
		
		
		request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
	}
}
