package servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controles.Controles;


@WebServlet("/updateServelet")
public class UpdatesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdatesServlet() {
        super();
    }

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}*/



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Controles cont = new Controles();
		String comando = request.getParameter("txtZONA");
		System.out.println("comandoooo: " + comando);
		
		if (comando == null) {
			System.out.println("eleitor");
			int numero = Integer.parseInt(request.getParameter("txtNUMERO_CANDIDATO"));
			cont.votacao(numero);
		}
		else {
			System.out.println("mesario");
			int titulo = Integer.parseInt(request.getParameter("txtCOD_TITULO"));
			String zona = request.getParameter("txtZONA");
			String secao = request.getParameter("txtSECAO_ELEITORAL");
			String permite = request.getParameter("PERMITE_VOTAR");
			System.out.println(permite);
			cont.validarUsuario(titulo, zona, secao, permite);
		}
		
	}

}
