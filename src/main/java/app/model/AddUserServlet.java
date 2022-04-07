package app.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@webServlet (
		name = "AddUserServlet",
		urlPatterns = {"/add"}
		)

public class AddUserServlet {
	
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
		String salasana = request.getParameter("salasana");
		
		String salt = SecurityUtils.getSalt();
		String hashsalasana = SecurityUtils.getPasswordHashed(salasana, salt);
		
		dao.addUser(tunnus, hashsalasana, salt);
		
		dao.close();
		response.sendRedirect("Login.html");
	}

}
