package jimmy.trainercert.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jimmy.trainercert.entity.TrainerCert;
import jimmy.trainercert.service.TrainerCertService;
import jimmy.trainercert.service.impl.TrainerCertServiceImpl;

@WebServlet("/addTrainerCertServlet")
public class AddTrainerCertServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public static final TrainerCertService SERVICE = new TrainerCertServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String certName = request.getParameter("certName");
		String englishCertName = request.getParameter("englishCertName");
		String abbrName = request.getParameter("abbrName");
		TrainerCert trainerCert = new TrainerCert(certName, englishCertName, abbrName);

		TrainerCert responseBack = SERVICE.addnew(trainerCert);
		boolean success = responseBack.isSuccessful();

		if (success) {
			System.out.println("新增成功!!!");
			out.println(responseBack.getMessage());
		} else {
			System.out.println("新增失敗???");
			out.println(responseBack.getMessage());
		}

	}
}
