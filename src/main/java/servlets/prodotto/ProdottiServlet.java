package servlets.prodotto;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

import entities.Prodotto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.prodotto.ProdottoJPA;

@WebServlet("/ProdottiServlet")
public class ProdottiServlet extends HttpServlet {

	@Serial
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodottoID = req.getParameter("prodottoID");
		if (isValidString(prodottoID)) {
			Prodotto prodotto = new ProdottoJPA(Prodotto.class).findById(Integer.parseInt(req.getParameter("prodottoID")));
			req.setAttribute("prodotto", prodotto);
			req.getRequestDispatcher("prodotto/prodotto.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("home.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Prodotto> prodotti = new ProdottoJPA(Prodotto.class).findAll();
		if (!prodotti.isEmpty()) {
			req.setAttribute("prodotti", prodotti);
			req.getRequestDispatcher("vini.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("test.jsp");
		}
	}
	
	private boolean isValidString(String value) {
		return (value != null && !value.isEmpty());
	}
	
}
