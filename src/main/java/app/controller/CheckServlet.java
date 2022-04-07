package app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Dao;

@WebServlet(
		name = "CheckServlet",
		urlPatterns = {"/check"}
		)

public class CheckServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOExpection, ServletException {
		response.sendRedirect("Login.html");
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		Dao dao = new Dao();
		
		String tunnus = request.getParameter("tunnus");
		String salasana = request.getParameter("salasana");
		
		String salt = dao.getUserSalt(tunnus);
		String hashsalasana = dao.getUserPasswordHash(salasana);
		
		dao.close();
		
		if ( SecurityUtils.isPasswordOk(salasana, hashsalasana, salt) ) {
			response.getWriter().println("Login success");
		} else {
			response.getWriter().println("Login failed");
		}
	}

}
