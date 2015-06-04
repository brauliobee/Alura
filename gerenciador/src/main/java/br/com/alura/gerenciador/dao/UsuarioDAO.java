package br.com.alura.gerenciador.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.alura.gerenciador.Usuario;

public class UsuarioDAO {

	private final static Map<String, Usuario> USUARIOS = new HashMap<>();
	static {
		USUARIOS.put("guilherme.silveira@alura.com.br", new Usuario("guilherme.silveira@alura.com.br","silveira"));
		USUARIOS.put("rodrigo.turini@alura.com.br", new Usuario("rodrigo.turini@alura.com.br","turini"));
		USUARIOS.put("brauliobee@yahoo.com.br", new Usuario("brauliobee@yahoo.com.br","pass"));
	}

	public Usuario buscaPorEmailESenha(String email, String senha) {
		if (!USUARIOS.containsKey(email)){
			System.out.println("Log da aplicação: [WARN] Usuário desconhecido");			
			return null;
		}
			
		System.out.println("Log da aplicação: [DEBUG] Usuário encontrado. A senha será validada.");		
		
		Usuario usuario = USUARIOS.get(email);
		if (usuario.getSenha().equals(senha)){
			System.out.println("Log da aplicação: [DEBUG] Senha validada com sucesso.");
			return usuario;
		}
		
		System.out.println("Log da aplicação: [WARN] Senha inválida.");
		return null;
	}

}
