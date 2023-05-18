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

@WebServlet("/getAllTrainerCertServlet")
public class GetAllTrainerCertServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public static TrainerCertService service = new TrainerCertServiceImpl();
	
	public void init() throws ServletException {
		service = CommonUtil.getBean(getServletContext(), TrainerCertService.class);
	}
	
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
		//測試
//		out.println("<HTML>");
//		out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
//		out.println("<BODY>");
//		out.println("<BIG>Hello World , 世界你好 !</BIG>");
//		out.println("</BODY></HTML>");
//	}

		try {
			List<TrainerCert> getallList = service.getall();

			System.out.println("迴圈每筆列出");
			for (TrainerCert cert : getallList) {
				System.out.println(cert); // toString()已override
			}
			// html印出
			Gson gson = new Gson();
			String json = gson.toJson(getallList);
			out.print(json);
		} catch (Exception e) {
			e.printStackTrace();
			out.print("Error");
		} finally {
			out.close();
		}
	}
}
