package app.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Dao;
import app.model.Candidates; 

/*
 * The name of the servlet is AddCandidates
 * and the servlet's URI (url-pattern) is 'addcandidates'
 */
@WebServlet(
		name = "ReadCandidates",
		urlPatterns = {"/readcandidates"}
		)
public class ReadCandidates extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		doGet(request, response);
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		// Read parameters to Model
				Candidates candidates=readCandidates(request);
			
				// Create connection
				Dao dao=new Dao();
				
				// Save value and query total list
				dao.saveCandidates(candidates);
				ArrayList<Candidates> list=dao.readAllCandidates();
				
				// print output and close connection
				printCandidatesList(out, list);
				try {
					dao.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				
				
	}
	
	
	private Candidates readCandidates(HttpServletRequest request) {
		Candidates candidates=new Candidates();
		candidates.setSukunimi(request.getParameter("sukunimi"));
		candidates.setEtunimi(request.getParameter("etunimi"));
		return candidates;
	}
	private void printCandidatesList(PrintWriter out, ArrayList<Candidates> list) {
		out.println("<ul>");
		for (Candidates c:list) {
			out.println("<li>"+c);
		}
		out.println("</ul>");
	}
}
