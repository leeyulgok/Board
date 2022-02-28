package com.borad.web.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.borad.web.notice.model.NoticeModel;
import com.borad.web.notice.service.NoticeService;

@WebServlet("/updatepage")
public class UpdatePageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService service = new NoticeService();
		int num = Integer.parseInt(request.getParameter("num"));
		
		List<NoticeModel> list = service.DetailList(num);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/updatepage.jsp").forward(request, response);
	}
}
