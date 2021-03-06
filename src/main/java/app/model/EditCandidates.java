package app.model;

import java.io.IOException;
import java.io.PrintWriter;
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
		PrintWriter out=response.getWriter();
		
		// if sessions does not exist, create new one
		HttpSession session = request.getSession();
		
		String idValue = request.getParameter("id");
		System.out.println(idValue);
		if ( idValue != null ) {
			try {
				int id = Integer.parseInt(idValue);
				
				Dao dao = new Dao();
				Candidates candidates = dao.getCandidatesInfo(id);
				
				
				
				session.setAttribute("candidates", candidates);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/editcandidate.jsp");
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
		
	
		Dao dao=new Dao();
		Candidates candidates=updateCandidates(request);
		dao.updateCandidates(candidates);
		
		try {
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Back to list after actions
		//RequestDispatcher rd = request.getRequestDispatcher("/showdata");
		//rd.forward(request, response);
		response.sendRedirect("/showdata");
	}
	
	private Candidates updateCandidates(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Candidates candidates=new Candidates();
		candidates.setId(Integer.parseInt(request.getParameter("id")));
		candidates.setSukunimi(request.getParameter("sukunimi"));
		candidates.setEtunimi(request.getParameter("etunimi"));
		candidates.setPuolue(request.getParameter("puolue"));
		candidates.setKotipaikkakunta(request.getParameter("kotipaikkakunta"));
		candidates.setIka(Integer.parseInt(request.getParameter("ika")));
		candidates.setMiksi_eduskuntaan(request.getParameter("miksi_eduskuntaan"));
		candidates.setMita_asioita_haluat_edistaa(request.getParameter("mita_asioita_haluat_edistaa"));
		candidates.setAmmatti(request.getParameter("ammatti"));
		return candidates;
	}
/**
	private Candidates readCandidates(HttpServletRequest request) {
		Candidates candidates=new Candidates();
		candidates.setSukunimi(request.getParameter("sukunimi"));
		candidates.setEtunimi(request.getParameter("etunimi"));
		candidates.setId(Integer.parseInt(request.getParameter("ehdokas_id")));
		return candidates;
	}*/
}
