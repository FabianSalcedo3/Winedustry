package servlets.pagamento;

import entities.Pagamento;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.pagamento.PagamentoJPA;
import utils.ParametersValidation;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/PagamentoServlet")
public class PagamentoServlet extends HttpServlet {

	@Serial
	private static final long serialVersionUID = 1L;

	private static final ParametersValidation pv = new ParametersValidation();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pagamentoID = req.getParameter("pagamentoID");
		if (pv.isValidString(pagamentoID)) {
			Pagamento pagamento = new PagamentoJPA().findById(Integer.parseInt(req.getParameter("pagamentoID")));
			req.setAttribute("pagamento", pagamento);
			req.getRequestDispatcher("pagamento.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("test.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Pagamento> pagamenti = new PagamentoJPA().findAll();
		if (!pagamenti.isEmpty()) {
			req.setAttribute("pagamenti", pagamenti);
			req.getRequestDispatcher("regioni.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("index.jsp");
		}
	}


}