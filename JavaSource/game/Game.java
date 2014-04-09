package game;
import java.util.*;

public class Game {
	
	public static String WHITE = "WHITE";
	public static String BLACK = "BLACK";
	
	public List<Gamer> Gamers = new ArrayList<Gamer>();
	
	public Game() {
		// TODO Auto-generated constructor stub		
		for (int i = 0; i < 10; i++) {
			this.Gamers.add(new Gamer(i));
		}
	}
	
	public String print(){
		
		String result = "<table class='table table-bordered table-striped table-condensed table-hover'>"
				+ "<tr>"
				+ "<th>Jogador</th>"
				+ "<th>Tentativas</th>"
				+ "<th>Acertos</th>"
				+ "<th>Aproveitamento</th>"
				+ "</tr>";
		
		for (int i = 0; i < 10; i++) {
			result += Gamers.get(i).printResult();
		}	
		result += "</table>";
		return result;
	}
	
	// A - H
	public static int convertCollumn(char c){
		return (int)c - 65;
	}
	
	// 1 - 8
	public static int convertRow(char r){
		return Integer.parseInt(Character.toString(r)) - 1;
	}
	
	public static char convertCollumn(int c){
		return (char)(c + 65);
	}
	
	public static char convertRow(int r){
		return Character.forDigit(r+1, 10);
	}
	
	
	public static String getRandCell(){
		char col = convertCollumn(new Random().nextInt(8));
		char row = convertRow(new Random().nextInt(8));
		return  String.format("%c%c", col, row);
	}
	
	public static String getColor(String cell){		
		char[] keys =  cell.toCharArray();
		int col = convertCollumn(keys[0]);
		int row = convertRow(keys[1]);
		
		return ( ( col + row ) % 2 == 0 ) ? BLACK : WHITE;
	}
	
	public static void main(String[] args) {
		return;
	}
}

