package servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controles.Controles;
import exception.InvalidUserException;

@WebServlet("/LoginServelet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view;
		
		System.out.println("***********LOGIN SERVLET***********");
		
		String cod_titulo = request.getParameter("txtCOD_TITULO");
		String senha = request.getParameter("txtSENHA");
		String permiteVotar = "S";
		int nivel = Integer.parseInt(request.getParameter("opcao"));
		Controles lc = new Controles();
		int retorno = lc.ValidarLogin(cod_titulo, senha, permiteVotar, nivel);


		if (retorno == 1) {			
			if (nivel == 1)
				view = request.getRequestDispatcher("paginaEleitor.html");
			else if(nivel == 2)
				view = request.getRequestDispatcher("paginaMesario.jsp");
			else if (nivel == 3)
				view = request.getRequestDispatcher("paginaChefe.html");
			else 
				throw new InvalidUserException("Por gentileza informe seu nível.");
		} else {
			throw new InvalidUserException("Eleitor não cadastrado na base de dados, ou sem permissão para votar");
		}
		view.forward(request, response);
	}

}
