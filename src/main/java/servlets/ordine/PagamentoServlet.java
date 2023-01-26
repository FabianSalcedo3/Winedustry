package servlets.ordine;

import entities.ordine.Pagamento;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.datasource.ordine.PagamentoJPA;
import repository.datasource.UtenteJPA;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/PagamentoServlet")
public class PagamentoServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uID = (Integer) req.getSession().getAttribute("uID");
        List<Pagamento> pagamenti = new UtenteJPA().findById(uID).getPagamenti();
        for (Pagamento pagamento : pagamenti) {
            if (pagamento != null) {
                req.setAttribute("pagamento", pagamento);
                req.getRequestDispatcher("pagamento.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("test.jsp");
            }
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