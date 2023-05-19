package jimmy.course.controller;

import static core.util.CommonUtil.writePojo2Json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.util.CommonUtil;
import jimmy.course.service.CourseService;

@WebServlet("/allCourseServlet")
public class AllCourseServlet extends HttpServlet{
	private static final long serialVersionUID = 2743430125513612224L;
	private CourseService service;

	@Override
	public void init() throws ServletException {
		service = CommonUtil.getBean(getServletContext(), CourseService.class);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("前端回傳all");
		writePojo2Json(response, service.findAll());
}}
