package servlets.ordine;

import entities.Utente;
import entities.ordine.Pagamento;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.datasource.ordine.PagamentoJPA;
import repository.datasource.UtenteJPA;

import java.io.IOException;
import java.io.Serial;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/InserisciPagamentoServlet")
public class InserisciPagamentoServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nome = req.getParameter("cNome");
        String circuito = req.getParameter("cCircuito");
        String proprietario = req.getParameter("cProprietario");
        LocalDate dataScadenza = LocalDate.parse(req.getParameter("cDataScadenza"));
        int cvv = Integer.parseInt(req.getParameter("cCvv"));
        int uID = (Integer) req.getSession().getAttribute("uID");
        Utente utente = new UtenteJPA().findById(uID);
        List<Pagamento> pagamenti = new UtenteJPA().findById(uID).getPagamenti();
        for (Pagamento pagamento : pagamenti) {
            if (pagamento != null) {
                pagamento.setCarta(nome);
                pagamento.setCircuito(circuito);
                pagamento.setProprietario(proprietario);
                pagamento.setDataScadenza(dataScadenza);
                pagamento.setCvv(cvv);
                new PagamentoJPA().update(pagamento);
            } else {
                new PagamentoJPA().save(new Pagamento(nome, circuito, proprietario, dataScadenza, cvv, utente));
            }
            resp.sendRedirect("utente.jsp");
        }
    }
}

