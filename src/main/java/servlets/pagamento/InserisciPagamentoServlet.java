package servlets.pagamento;

import entities.Pagamento;
import entities.Utente;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.pagamento.PagamentoJPA;
import repository.utente.UtenteJPA;

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
        Utente utente = new UtenteJPA().findById(req.getParameter("uID"));
        List<Pagamento> pagamenti = new UtenteJPA().findById(req.getParameter("uID")).getPagamenti();
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

