package app.model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet (
		name = "AddUserServlet",
		urlPatterns = {"/add"}
		)

public class AddUserServlet extends HttpServlet {
	
	@Override
	public void doGet (HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		response.sendRedirect("Login.html");
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		
		Dao dao = new Dao();
		
		String tunnus = request.getParameter("tunnus");
		String hashSalasana = request.getParameter("salasana");
		
		String salt = SecurityUtils.getSalt();
		String hashpw = SecurityUtils.getPasswordHashed(hashSalasana, salt);
		
		dao.addUser(tunnus, hashSalasana, salt);

		
		try {
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("Login.html");
	}

}
