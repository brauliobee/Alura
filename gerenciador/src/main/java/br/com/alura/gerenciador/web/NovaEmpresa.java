package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class NovaEmpresa implements Tarefa {

	public String executa (HttpServletRequest req, HttpServletResponse resp) {
		
		String novaEmpresa = req.getParameter("empresa");
		 
		
		if (novaEmpresa == null  || novaEmpresa.isEmpty()) {
			
			req.setAttribute("errorMessage", "Não há empresas para inserir? :(");
			return "/WEB-INF/paginas/error.jsp";
			
		} else {

			Empresa empresa = new Empresa(novaEmpresa);
			new EmpresaDAO().adiciona(empresa);
			
			req.setAttribute("nomeEmpresa", novaEmpresa);
			return "/WEB-INF/paginas/novaEmpresa.jsp";
		}
		
		
	}
	
}
