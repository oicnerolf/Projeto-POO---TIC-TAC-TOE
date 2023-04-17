package ProjetoDisciplina;

import java.sql.Date;

public class Jogador {

	private String senha, nome, email;
	private int totalPontos;
	private Date data;

	public Jogador() {

	}

	public Jogador(String nome) {
		this.nome = nome;
	}

	public Jogador(String senha, String nome, String email, int totalPontos, Date data) {
		
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.totalPontos = totalPontos;
		this.data = data;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTotalPontos() {
		return totalPontos;
	}

	public void setTotalPontos(int totalPontos) {
		this.totalPontos = totalPontos;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
