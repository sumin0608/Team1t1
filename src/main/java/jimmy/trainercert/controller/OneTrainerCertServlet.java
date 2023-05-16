package jimmy.trainercert.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jimmy.trainercert.service.TrainerCertService;
import jimmy.trainercert.service.impl.TrainerCertServiceImpl;
import jimmy.trainercert.vo.TrainerCert;

@WebServlet("/oneTrainerCertServlet")
public class OneTrainerCertServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public static final TrainerCertService SERVICE = new TrainerCertServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
		
		public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		String certName = request.getParameter("certName");
		TrainerCert responseBack = SERVICE.get(certName);
		boolean success = responseBack.isSuccessful();
		Gson gson = new Gson();
		
		if (success) {
			System.out.println(responseBack.getMessage());
			System.out.println(responseBack);
			
			String json = gson.toJson(responseBack);
			out.print(json);
		} else {
			System.out.println(responseBack.getMessage());
			System.out.println(responseBack);
			String json = gson.toJson(responseBack);
			out.print(json);
		}
	
		}
	}

