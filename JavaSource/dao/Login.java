package dao;

import game.Gamer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Login() {
		// TODO Auto-generated constructor stub
	}

	private Connection con = Conexao.getConnection();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Gamer jogador = new Gamer();

		jogador.setLogin(login);
		jogador.setSenha(senha);

		try {
			auth(jogador, request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("errorMessage",
					"Ocorreu um erro, " + e.getMessage());

			request.setAttribute("jogador", jogador);

			getServletConfig().getServletContext()
					.getRequestDispatcher("/login.jsp")
					.forward(request, response);
		}
	}
	

	private void auth(Gamer jogador, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
		PreparedStatement preparador = con.prepareStatement(sql);


			if (jogador.getLogin().isEmpty())
				throw new Exception("Login é obrigatório");
			if (jogador.getSenha().isEmpty())
				throw new Exception("Senha é obrigatório");
					
	try {
		preparador.setString(1, jogador.getLogin());
		preparador.setString(2, jogador.getSenha());
		
		ResultSet res = preparador.executeQuery();
		
		if (res.next()) {
			
			jogador.setId(res.getInt("id"));
			jogador.setNome(res.getString("nome"));
			
			request.setAttribute("successMessage",
					"Login realizado com sucesso, bom jogo!");
			
			newSession(request, response, jogador);
			
			getServletConfig().getServletContext()
					.getRequestDispatcher("/index.jsp")
					.forward(request, response);
		} else {
			preparador.close();
			request.setAttribute("errorMessage",
					"Usuário não encontrado ou verifique seus dados!");
			getServletConfig().getServletContext()
					.getRequestDispatcher("/login.jsp")
					.forward(request, response);
		}
			preparador.close();
		} catch (Exception e) {
			preparador.close();
			request.setAttribute("errorMessage",
					"Erro: " + e.getMessage());

			request.setAttribute("jogador", jogador);

			getServletConfig().getServletContext()
					.getRequestDispatcher("/login.jsp")
					.forward(request, response);
		}

	}
	
	public void newSession(HttpServletRequest request,
			HttpServletResponse response, Gamer jogador) throws Exception{
		
        request.getSession().invalidate();
        HttpSession session = request.getSession(true);
        session.setAttribute("AUTHENTICATED", new Boolean(true));
        session.setAttribute("jogador", jogador);
	}

}
