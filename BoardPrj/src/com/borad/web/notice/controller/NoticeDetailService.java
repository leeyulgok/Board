package com.borad.web.notice.controller;

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

@WebServlet("/detail")
public class NoticeDetailService extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.getSession();
		String num_ = request.getParameter("num");
		int num = Integer.parseInt(num_);
		int result = 0;
		
		
		NoticeService service = new NoticeService();
		List<NoticeModel> list = service.DetailList(num);
		result = service.HitService(num);
		
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/detail.jsp").forward(request, response);
	}
}
