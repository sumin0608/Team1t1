package jimmy.trainercert.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import core.util.CommonUtil;
import jimmy.trainercert.entity.TrainerCert;
import jimmy.trainercert.service.TrainerCertService;
import jimmy.trainercert.service.impl.TrainerCertServiceImpl;

@WebServlet("/oneTrainerCertServlet")
public class OneTrainerCertServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static TrainerCertService service = new TrainerCertServiceImpl();

	@Override
	public void init() throws ServletException {
		service = CommonUtil.getBean(getServletContext(), TrainerCertService.class);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		String certName = request.getParameter("certName");		
		List<TrainerCert> responseBack = service.get(certName);
		
		System.out.println("迴圈每筆列出");
		for (TrainerCert cert : responseBack) {
			System.out.println(cert); // toString()已override
		}
		System.out.println(responseBack.get(0).getMessage());

		Gson gson = new Gson();
		String json = gson.toJson(responseBack);
		out.print(json);
	}
}
