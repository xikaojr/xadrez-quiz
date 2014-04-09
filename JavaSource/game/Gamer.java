package game;
import java.util.ArrayList;
import java.util.List;


public class Gamer {

	public int Acertos;
	public int Tentativas;
	public int Numero;
	public List<String> Respostas = new ArrayList<String>();
	
	
	public Gamer(int num) {
		// TODO Auto-generated constructor stub
		this.Numero = num;
		this.Acertos = 0;
		this.Tentativas = 0;
	}
	
	public String printResult(){
		
		if(this.Tentativas == 0){
			return "";
		}
		float percentual = ((float)this.Acertos / (float)this.Tentativas * (float)100);
		return String.format(""
				+ "<tr>"
				+ "<td>Jogador %d</td>"
				+ "<td>%d</td>"
				+ "<td>%d</td>"
				+ "<td>%f%s</td>"
				+ "</tr>"
				, this.Numero + 1, this.Tentativas, this.Acertos, percentual,"%");
	}
	

}
