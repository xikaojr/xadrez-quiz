package dao;

import game.Game;
import game.Gamer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Jogador {

	public Jogador() {
		// TODO Auto-generated constructor stub
	}

	private Connection con = Conexao.getConnection();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nome = request.getParameter("nome");
	    String login = request.getParameter("login");
	    String senha = request.getParameter("senha");
	    
	    Gamer jogador = new Gamer();
	    
	    jogador.setNome(nome);
	    jogador.setLogin(login);
	    jogador.setSenha(senha);
	    
	    cadastrar(jogador);
	}
		
	
	public Gamer cadastrar(Gamer usuario) {

		String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());

			preparador.execute();
			preparador.close();
			System.out.println("Cadastro com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
