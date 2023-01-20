package servlets.pagamento;

import entities.Pagamento;
import entities.Utente;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.pagamento.PagamentoJPA;
import repository.utente.UtenteJPA;
import utils.ParametersValidation;

import java.io.IOException;
import java.io.Serial;
import java.time.LocalDate;

@WebServlet("/InserisciPagamentoServlet")
public class InserisciPagamentoServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final ParametersValidation pv = new ParametersValidation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String utenteID = req.getParameter("utenteID");
        String cartaNome = req.getParameter("cartaNome");
        String cartaCircuito = req.getParameter("cartaCircuito");
        String cartaProprietario = req.getParameter("cartaProprietario");
        String cartaDataScadenza = req.getParameter("cartaDataScadenza");
        String cartaCvv = req.getParameter("cartaCvv");
        if (pv.isValidUser(utenteID)) {
            Utente utente = new UtenteJPA().findById(Integer.parseInt(utenteID));
            Pagamento pagamento = new Pagamento();
            if (pv.isValidString(cartaNome)) {pagamento.setCarta(cartaNome);}
            if (pv.isValidString(cartaCircuito)) {pagamento.setCircuito(cartaCircuito);}
            if (pv.isValidString(cartaProprietario)) {pagamento.setProprietario(cartaProprietario);}
            if (pv.isValidString(cartaDataScadenza)) {pagamento.setDataScadenza(LocalDate.parse(cartaDataScadenza));}
            if (pv.isValidInteger(cartaCvv)) {pagamento.setCvv(Integer.parseInt(cartaCvv));}
            if (pv.existPagamento(utente)) {
                new PagamentoJPA().update(pagamento);
            } else {
                new PagamentoJPA().save(pagamento);
            }
        }
        resp.sendRedirect("utente.jsp");
    }
}

