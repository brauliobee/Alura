package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Tarefa {
	

	@Override
	public String executa (HttpServletRequest req, HttpServletResponse resp)
			{
		
		
		HttpSession session = req.getSession();
		session.removeAttribute("usuarioLogado");
		
		System.out.println("Log da aplicação: [Logout][INFO] Logout efetuado com sucesso!");
		
		return "/WEB-INF/paginas/logout.html";
		
	}
}
