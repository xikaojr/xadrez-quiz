package game;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Gamer {

	public int Id;
	public int Acertos;
	public int Tentativas;
	public int Numero;
	public String Nome;
	public String Login;
	public String Senha;
	public String Jogadas;

	public List<String> Respostas = new ArrayList<String>();
	
	public Gamer() {
	}
	
	public String printResult() {

		if (this.Tentativas == 0) {
			return "";
		}

		float percentual = ((float) this.Acertos / (float) this.Tentativas * (float) 100);

		return String.format("" + "<tr>" + "<td>Jogador %s</td>"
				+ "<td>%d</td>" + "<td>%d</td>" + "<td>%f%s</td>" + "</tr>",
				this.Login, this.Tentativas, this.Acertos, percentual, "%");
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public void setLogin(String login) {
		this.Login = login;
	}

	public void setSenha(String senha) {
		this.Senha = senha;
	}

	public String getNome() {
		return this.Nome;
	}

	public String getLogin() {
		// TODO Auto-generated method stub
		return this.Login;
	}

	public String getSenha() {
		// TODO Auto-generated method stub
		return this.Senha;
	}

	public int getId() {
		return this.Id;
	}
	
	public String getJogadas()
	{
		return this.Jogadas;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public void setTentativas(int t) {
		this.Tentativas = t;
	}

	public void setAcertos(int a) {
		this.Acertos = a;
	}

	public void setJogadas(String jogadas) {
		this.Jogadas = jogadas;
	}

	public int getTentativas() {
		return Tentativas;
	}

	public int getAcertos() {
		return this.Acertos;
	}

}
