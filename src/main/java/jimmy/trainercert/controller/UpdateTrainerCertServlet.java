package jimmy.trainercert.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jimmy.trainercert.service.TrainerCertService;
import jimmy.trainercert.service.impl.TrainerCertServiceImpl;
import jimmy.trainercert.vo.TrainerCert;

@WebServlet("/updaterainerCertServlet")
public class UpdateTrainerCertServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public static final TrainerCertService SERVICE = new TrainerCertServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int number = Integer.parseInt(request.getParameter("number"));
		String certName = request.getParameter("certName");
		String englishCertName = request.getParameter("englishCertName");
		String abbrName = request.getParameter("abbrName");
		TrainerCert trainerCert = new TrainerCert(number,certName, englishCertName, abbrName);

		TrainerCert responseBack = SERVICE.edit(trainerCert);
		boolean success = responseBack.isSuccessful();

		if (success) {
			System.out.println("修改成功!!!");
			System.out.println(responseBack);
			out.println(responseBack.getMessage());
		} else {
			System.out.println("修改失敗???");
			out.println(responseBack.getMessage());
		}

	}
}
