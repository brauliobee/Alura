package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {

	private Cookie[] cookies;
	
	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}
	
	public Cookie getUsuarioLogado(){
		
		Cookie searchCookie = null;
		
		if (cookies==null){
			System.out.println("Log da aplicação: [Cookies][WARN] Não há usuário logado!");
		} else {
			for ( Cookie cookie : cookies) {
				if (cookie.getName().equals("usuario.logado")) {
					searchCookie = cookie;
				} 
			}
			
			if (searchCookie==null){
				System.out.println("Log da aplicação: [Cookies][WARN] Não há usuário logado!");
			}
		}		
		
		return searchCookie;
	}
	
}
