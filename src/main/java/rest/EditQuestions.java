package rest;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import app.model.Candidates;
import data.Kysymykset;

@Path("/editquestions")
public class EditQuestions extends HttpServlet{
	
	@Context
	HttpServletRequest request;
	
	@Context
	HttpServletResponse response;
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone");
	
	
	
	//@POST
	//@Path("/editanswear")
	//@Produces(MediaType.APPLICATION_JSON)
	//public void editAnswear() {
		
	//}
	
	@GET
	@Path("/allquestions")
	public void readAllQuestions() {
		//Kysymysten luku JPA:lla
		//Listan lähetys jsp:lle (forward)
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
	    List<Kysymykset> list = em.createQuery("select k from Kysymykset k").getResultList();
		em.getTransaction().commit();
		request.setAttribute("kysymyslista", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/showallquestion.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
//	@PUT
//	@Path("/updatequestions")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public List<Kysymykset> updateQuestions(Candidates candidates) {
//		EntityManager em=emf.createEntityManager();
//		em.getTransaction().begin();
//		Kysymykset k=em.find(Kysymykset.class, kysymykset.getId());
//		if (k!=null) {
//			em.merge(kysymykset);
//		}
//		em.getTransaction().commit();
//		
//		List<Kysymykset> list=readAllQuestions(id);		
//		return list;
//	}	
//	
//	@DELETE 
//	@Path("/deletequestions/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public List<Kysymykset> deleteQuestions(@PathParam("id") int id) {
//		EntityManager em=emf.createEntityManager();
//		em.getTransaction().begin();
//		Kysymykset k=em.find(Kysymykset.class, id);
//		if (k!=null) {
//			em.remove(k);
//		}
//		em.getTransaction().commit();
//		List<Kysymykset> list=readAllQuestions(id);		
//		return list;
//		
//	}
}
