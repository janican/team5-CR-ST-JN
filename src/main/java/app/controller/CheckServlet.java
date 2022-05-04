package app.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Dao;
import app.model.SecurityUtils;

@WebServlet(
		name = "CheckServlet",
		urlPatterns = {"/check"}
		)

public class CheckServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
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
		
		String salt = dao.getTunnusSalt(tunnus);
		String hashSalasana = dao.getUserPasswordHash(tunnus);
		
		try {
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if ( SecurityUtils.isPasswordOk(salasana, hashSalasana, salt) ) {
			response.getWriter().println("Login success");
		} else {
			response.getWriter().println("Login failed");
		}
	}

}
