package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

public class Login implements Tarefa {

	public String executa (HttpServletRequest req, HttpServletResponse resp)  {
		
		HttpSession session = req.getSession();
		
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		if (usuario==null) {
			req.setAttribute("errorMessage", "Usuário ou senha inválidos.");
			return "/WEB-INF/paginas/error.jsp";
		} else {
			session.setAttribute("usuarioLogado",usuario);
			session.setMaxInactiveInterval(10 * 60);
			return "/WEB-INF/paginas/login.jsp";
		}
		
	}
	
}
