package it.generationitaly.examplewebapp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.generationitaly.examplewebapp.entity.Esame;
import it.generationitaly.examplewebapp.entity.Corso;
import it.generationitaly.examplewebapp.entity.Studente;
import it.generationitaly.examplewebapp.repository.CorsoRepository;
import it.generationitaly.examplewebapp.repository.EsameRepository;
import it.generationitaly.examplewebapp.repository.StudenteRepository;
import it.generationitaly.examplewebapp.repository.impl.CorsoRepositoryImpl;
import it.generationitaly.examplewebapp.repository.impl.EsameRepositoryImpl;
import it.generationitaly.examplewebapp.repository.impl.StudenteRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AggiungiEsameServlet
 */
@WebServlet("/AggiungiEsameServlet")
public class AggiungiEsameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static StudenteRepository studenteRepository = new StudenteRepositoryImpl();
	private static CorsoRepository corsoRepository = new CorsoRepositoryImpl();
	private static EsameRepository esameRepository = new EsameRepositoryImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Studente studente = studenteRepository.findById(id);
		List<Corso> corsi = corsoRepository.findAll();

		request.setAttribute("studente", studente);
		request.setAttribute("corsi", corsi);

		request.getRequestDispatcher("aggiungi-esame.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int idStudente = Integer.parseInt(req.getParameter("idStudente"));
		int idCorso = Integer.parseInt(req.getParameter("idCorso"));

		Studente studente = studenteRepository.findById(idStudente);
		Corso corso = corsoRepository.findById(idCorso);

		String dataEsameAsString = req.getParameter("dataEsame");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
		Date dataEsame = null;

		try {
			dataEsame = sdf.parse(dataEsameAsString);
		} catch (ParseException e) {

		}

		int voto = Integer.parseInt(req.getParameter("voto"));

		String lode = req.getParameter("lode");
		boolean roseTooCapoSpulico = true;
		if (lode == null) {
			roseTooCapoSpulico = false;
		}

		Esame esame = new Esame();

		esame.setStudente(studente);
		esame.setCorso(corso);
		esame.setDataEsame(dataEsame);
		esame.setVoto(voto);
		esame.setLode(roseTooCapoSpulico);

		esameRepository.add(esame);
//		req.setAttribute("studente", studente);
//		req.getRequestDispatcher("esami.jsp").forward(req, resp);
		resp.sendRedirect("EsamiServlet?id="+studente.getId());
	}

}
