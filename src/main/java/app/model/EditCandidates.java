package app.model;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		name = "EditCandidates",
		urlPatterns = {"/editcandidates"}
		)

public class EditCandidates extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		
		// if sessions does not exist, create new one
		HttpSession session = request.getSession();
		
		String ehdokas_idValue = request.getParameter("ehdokas_id");
		
		if ( ehdokas_idValue != null ) {
			try {
				int id = Integer.parseInt(ehdokas_idValue);
				
				Dao dao = new Dao();
				Candidates candidates = dao.getCandidatesInfo(id);
				
				session.setAttribute("candidates", candidates);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/editform.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Back to list
			response.sendRedirect("/showdata");
			
		}
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
	
		
		// Create connection
		Dao dao=new Dao();
		Candidates candidates = readCandidates(request);
		
		dao.saveCandidates(candidates);
		
		try {
			dao.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Back to list after actions
		//RequestDispatcher rd = request.getRequestDispatcher("/showdata");
		//rd.forward(request, response);
		response.sendRedirect("/showdata");
	}
	
	private Candidates readCandidates(HttpServletRequest request) {
		Candidates candidates=new Candidates();
		candidates.setSukunimi(request.getParameter("sukunimi"));
		candidates.setEtunimi(request.getParameter("etunimi"));
		candidates.setEhdoaks_id(Integer.parseInt(request.getParameter("ehdokas_id")));
		return candidates;
	}
}
