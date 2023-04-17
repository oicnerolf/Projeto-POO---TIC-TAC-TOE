package InterfaceGrafica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import ProjetoDisciplina.Jogador;

public class JanelaLogado extends Componentes{
	
	private JLabel titulo = addLabel("Opções",85,20,350,60);
	private JButton jogar = addButton("Jogar", 70, 130, 250, 40);
	private JButton infoJogador = addButton("Informações Jogador", 70, 180, 250, 40);
	private JButton infoPartida = addButton("Informações Partidas", 70, 230, 250, 40);
	private JButton logout = addButton("Logout", 200, 300, 100, 40);
	private Jogador jogador;
	
	public JanelaLogado(Jogador jogador) {
		this.jogador = jogador;
		criarTelaInicial("TICK TACK TOE");
		definicoes();
		this.repaint();
		
	}
	public void definicoes() {
		titulo.setFont(new Font("Arial", 100, 50));
		jogar.setFont(new Font("Arial", 14, 15));
		infoJogador.setFont(new Font("Arial", 14, 15));
		infoPartida.setFont(new Font("Arial", 14, 15));
		logout.setFont(new Font("Arial", 14, 15));
		jogar.addActionListener(new OuvinteBotao());
		infoJogador.addActionListener(new OuvinteBotao());
		infoPartida.addActionListener(new OuvinteBotao());
		logout.addActionListener(new OuvinteBotao());
		
	}
	public class OuvinteBotao implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == jogar) {
				new JanelaModoDeJogo(jogador);
				dispose();
			}else if(e.getSource() == infoJogador) {
				new InformacoesJogador(jogador);
				dispose();
			}else if(e.getSource() == infoPartida) {
				new InformacoesPartida(jogador);
				dispose();
			}else if(e.getSource() == logout) {
				new JanelaLogin();
				dispose();
			}
			
		}
		
	}
}

