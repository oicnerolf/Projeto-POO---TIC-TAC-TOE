package ProjetoDisciplina;

import java.io.Serializable;
import java.util.ArrayList;



public class Central implements Serializable {

	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private ArrayList<Partida> partidas = new ArrayList<Partida>();

	public void adicionarJogador(Jogador jogador) {
		jogadores.add(jogador);
	}

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Jogador recuperarJogadorNome(String nome) {
		for (Jogador obj : jogadores) {
			if (nome.equals(obj.getNome())) {
				return obj;
			}
		}
		return null;
	}

	public Jogador recuperarJogadorEmail(String email) {
		for (Jogador obj : jogadores) {
			if (email.equals(obj.getEmail())) {
				return obj;
			}
		}
		return null;
	}

	public boolean recuperarJogador(String email, String senha) {
		for (Jogador obj : jogadores) {
			if (email.equals(obj.getEmail()) && senha.equals(obj.getSenha())) {
				return true;
			}
		}
		return false;
	}

	public Jogador atualizarJogador(Jogador jogador) {
		for(int i = 0; i < jogadores.size(); i ++) {
			if(jogadores.get(i).getEmail().equals(jogador.getEmail())) {
				jogadores.remove(i);
				adicionarJogador(jogador);
				
			}
		}
		return jogador;

	}
	public void apagarJogador(Jogador jogador) {
		for(int i = 0; i < jogadores.size();i++) {
			if (jogadores.get(i).getEmail().equals(jogador.getEmail()) && jogadores.get(i).getSenha().equals(jogador.getSenha())) {
				jogadores.remove(i);
			}
		}
	}
}
