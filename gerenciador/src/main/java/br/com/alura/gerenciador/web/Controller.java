package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4985869016058892850L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String tarefa = req.getParameter("tarefa");
		
		if (tarefa == null){
			throw new IllegalArgumentException();
		}else{
			
			String nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa;

			try {
				Class<?> type = Class.forName(nomeDaClasse);
				Tarefa instancia = (Tarefa) type.newInstance();
				String pagina = instancia.executa(req, resp);
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
				requestDispatcher.forward(req, resp);
				
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
