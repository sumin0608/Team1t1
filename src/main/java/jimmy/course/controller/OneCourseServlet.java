package jimmy.course.controller;

import static core.util.CommonUtil.writePojo2Json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import core.util.CommonUtil;
import jimmy.course.service.CourseService;

@WebServlet("/oneCourseServlet")
public class OneCourseServlet extends HttpServlet {

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
		int creator = Integer.parseInt(request.getParameter("creator"));
		System.out.println("前端回傳"+creator);
		writePojo2Json(response, service.find(creator));

//		response.setContentType("application/json");
//		PrintWriter out = response.getWriter();
//		
//		String certName = request.getParameter("certName");
//		TrainerCert responseBack = ervice.get(certName);
//		boolean success = responseBack.isSuccessful();
//		Gson gson = new Gson();
//		
//		if (success) {
//			System.out.println(responseBack.getMessage());
//			System.out.println(responseBack);
//			
//			String json = gson.toJson(responseBack);
//			out.print(json);
//		} else {
//			System.out.println(responseBack.getMessage());
//			System.out.println(responseBack);
//			String json = gson.toJson(responseBack);
//			out.print(json);
//		}
	}
}
