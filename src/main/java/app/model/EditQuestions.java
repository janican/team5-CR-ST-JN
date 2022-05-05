package app.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/editquestions")
public class EditQuestions {
	
	@Context
	HttpServletRequest request;
	
	@Context
	HttpServletResponse response;
	
	
	@POST
	@Path("/editanswear")
	@Produces(MediaType.APPLICATION_JSON)
	public void editAnswear() {
		
	}
	
	@GET
	@Path("/allquestions")
	public void readAllQuestions() {
		//Kysymysten luku JPA:lla
		//Listan lähetys jsp:lle (forward)
	}
}
