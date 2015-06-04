package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")  
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		//Necessario fazer o cast pois o filtro serve para qualquer servlet e não somente servlets http
		HttpServletRequest httpReq = (HttpServletRequest) req; 
		//HttpServletResponse httpResp = (HttpServletResponse) resp;
		
		HttpSession session = httpReq.getSession();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		if (usuarioLogado==null) {
			System.out.println("Usuario <deslogado> acessando a URI " + httpReq.getRequestURI());
		} else {
			System.out.println("Usuario "+usuarioLogado.getEmail()+" acessando a URI " + httpReq.getRequestURI());
		}
		 
		chain.doFilter(req, resp);
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
