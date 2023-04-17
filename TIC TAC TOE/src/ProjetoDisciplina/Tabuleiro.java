package ProjetoDisciplina;

import java.util.Scanner;

public class Tabuleiro {

	private static String[][] tabuleiro = new String[3][3];
	Scanner l = new Scanner(System.in);

	public Tabuleiro() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				tabuleiro[i][j] = "-";
			}
	}

	public boolean jogada(int x, int y, String letra) {

		tabuleiro[x][y] = letra;
		return true;

	}

	public String jogadaMaquinaFacil(String letra) {
		boolean cond = true;
		int x = 0, y = 0;
		while (cond) {
			 x = (int) (0 + (Math.random() * 3));
			 y = (int) (0 + (Math.random() * 3));
			if (tabuleiro[x][y].equals("-")) {
				tabuleiro[x][y] = letra;
				cond = false;
			} else {
				cond = true;
			}

		}

		return x + "," + y ;

	}

	public boolean fimDeJogada() {
		String[] jogadores = { "X", "O" };
		for (String s : jogadores) {
			for (int i = 0; i < 3; i++) {
				if ((s.equals(tabuleiro[i][0]) && s.equals(tabuleiro[i][1]) && s.equals(tabuleiro[i][2]))
						|| (s.equals(tabuleiro[0][i]) && s.equals(tabuleiro[1][i]) && s.equals(tabuleiro[2][i]))) {
					return true;
				}
			}
			if ((s.equals(tabuleiro[0][0]) && s.equals(tabuleiro[1][1]) && s.equals(tabuleiro[2][2]))
					|| (s.equals(tabuleiro[0][2]) && s.equals(tabuleiro[1][1]) && s.equals(tabuleiro[2][0]))) {
				return true;
			}
		}
		return false;
	}

	public String[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(String[][] tabuleiro) {
		this.tabuleiro = tabuleiro;

	}

}
