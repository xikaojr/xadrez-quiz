package dao;

import game.Gamer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Jogador extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Jogador() {
		// TODO Auto-generated constructor stub
	}

	private Connection con = Conexao.getConnection();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("password");

		Gamer jogador = new Gamer();

		jogador.setNome(nome);
		jogador.setLogin(login);
		jogador.setSenha(senha);

		try {
			cadastrar(jogador, request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("errorMessage",
					"Ocorreu um erro, " + e.getMessage());

			request.setAttribute("jogador", jogador);

			getServletConfig().getServletContext()
					.getRequestDispatcher("/cadUsuario.jsp")
					.forward(request, response);
		}
	}

	public void cadastrar(Gamer usuario, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String sql = "INSERT INTO usuarios (nome, login, senha) VALUES (?, ?, ?)";
		PreparedStatement preparador = con.prepareStatement(sql);

		try {

			if (usuario.getNome().isEmpty())
				throw new Exception("Nome é obrigatório");
			if (usuario.getLogin().isEmpty())
				throw new Exception("Login é obrigatório");
			if (usuario.getSenha().isEmpty())
				throw new Exception("Senha é obrigatório");

			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());

			if(verificaLogin(usuario.getLogin())){
				throw new Exception("Este Login ("+usuario.getLogin()+") já esta sendo usado por favor escolha outro!");
			}

			preparador.execute();

			if (getByLogin(usuario.getLogin()).next()) {
				request.setAttribute("successMessage",
						"Cadastro realizado com sucesso, bom jogo!");
				getServletConfig().getServletContext()
						.getRequestDispatcher("/index.jsp")
						.forward(request, response);
			} else {
				request.setAttribute("errorMessage",
						"Ocorreu um erro, verifique seus dados e tente novamente!");
				getServletConfig().getServletContext()
						.getRequestDispatcher("/cadUsuario.jsp")
						.forward(request, response);
			}

			preparador.close();
		} catch (SQLException e) {
			preparador.close();

			request.setAttribute("errorMessage", "COD: " + e.getErrorCode()
					+ " " + e.getMessage().toString());
			request.setAttribute("jogador", usuario);

			getServletConfig().getServletContext()
					.getRequestDispatcher("/cadUsuario.jsp")
					.forward(request, response);
			e.printStackTrace();
		}

	}

	private boolean verificaLogin(String login) throws Exception {

		ResultSet res = null;
		
		try {

			String sql = "SELECT id FROM usuarios WHERE login = ?";
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, login);
			res = preparador.executeQuery();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return res.next() ? true : false;

	}

	public ResultSet getByLogin(String login) throws SQLException {

		String sql = "SELECT id FROM usuarios WHERE login = ?";
		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setString(1, login);
		ResultSet res = preparador.executeQuery();

		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
