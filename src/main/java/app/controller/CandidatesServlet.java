package app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Dao;

@WebServlet("/test") // Serveletin polku eli mistä urlista käyttöliittymä löytyy voidaan määritellä tässä tai web.xml tiedostossa
@SuppressWarnings("serial")
public class CandidatesServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        System.out.println("Testing reading data from database");
        Dao dao = new Dao();
        dao.getEhdokkaat();

        // Määritellään käyttöliittymälle välitettävä parametri
        req.setAttribute("myname","TESTI");

        // Näin välitetään käyttöliittymälle parametrejä
        req.getRequestDispatcher("TestView.jsp").forward(req, resp);
        
        // Näin niihin päästään käyttöliittymän .jsp tiedostossa käsiksi
        // <%= request.getAttribute("myname") %>
    }
}
