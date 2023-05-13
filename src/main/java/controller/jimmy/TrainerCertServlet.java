package controller.jimmy;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addTrainerCertServlet")
public class TrainerCertServlet {
	 private static final long serialVersionUID = 1L;
	    
//	    private Dao trainerCertDAO;
//	    
//
//	    @Override
//	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	        // 
//	        String certName = request.getParameter("certName");
//	        String englishCertName = request.getParameter("englishCertName");
//	        String abbrName = request.getParameter("abbrName");
//	        
//	        // (VO)
//	        TrainerCert trainerCert = new TrainerCert(certName, englishCertName, abbrName);
//	        
//	        // 
//	        boolean success = false;
//			try {
//				success = trainerCertDAO.addTrainerCert(trainerCert);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//	        // 
//	        response.setContentType("text/html;charset=UTF-8");
//	        // 
//	        PrintWriter out = response.getWriter();
//	        
//	        if (success) {
//	            out.println("<h1>Add Success!!!</h1>");
////	          
//	        } else {
//	            out.println("<h1>Add Trainer Cert Failed</h1>");
//
//	        }
//	    }
	    


//	}
}
