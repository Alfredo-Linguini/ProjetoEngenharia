package servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.InvalidUserException;

@SuppressWarnings("serial")
@WebServlet(name = "Nivel", urlPatterns = { "/nivel" })
public class NivelControllers extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String proximaPagina = "";
		String op = req.getParameter("opcao");

		if (op.trim().equals("1")) {
			proximaPagina = "paginaEleitor.html";
		} else if (op.trim().equals("2")) {
			proximaPagina = "paginaMesario.jsp";
		} else if (op.trim().equals("3")) {
			proximaPagina = "paginaChefe.html";
		} else {
			System.out.println("bugou");
			throw new InvalidUserException("Por favor selecione um nível");
		}

		RequestDispatcher rd = req.getRequestDispatcher(proximaPagina);
		rd.forward(req, resp);

	}

}
