package game;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestGame extends HttpServlet {

	Game jogo = new Game();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RequestGame() {
		
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		jogo = new Game();
		request.setAttribute("jogo", jogo.print(request));
	    getServletConfig().getServletContext()
	    	.getRequestDispatcher("/index.jsp").forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String cell = request.getParameter("cell");
	    String resp = request.getParameter("resposta");
	    
	    
	    try {
	    	
	    	String color = Game.getColor(cell);
	    	Gamer jogador = (Gamer)request.getSession().getAttribute("jogador");
		    
		    jogador.Tentativas++;
		    jogador.Respostas.add(cell);
		    
		    if(color.compareTo(resp) == 0){
		    	jogador.Acertos++;
		    }
		    
		    request.setAttribute("jogo", jogo.print(request));
		    getServletConfig().getServletContext()
		    	.getRequestDispatcher("/index.jsp").forward(request,response);
		} catch (Exception e) {
		    request.setAttribute("errorMessage", e.getMessage());
		    getServletConfig().getServletContext()
		    	.getRequestDispatcher("/index.jsp").forward(request,response);

		}
	}
		

}
