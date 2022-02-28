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

@WebServlet("/allnotice")
public class AllNoticeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService service = new NoticeService();
		List<NoticeModel> list = service.AllNoticeList();
		
		request.setAttribute("allList", list);
		
		request.getRequestDispatcher("/WEB-INF/allnotice.jsp").forward(request, response);
	}
}
