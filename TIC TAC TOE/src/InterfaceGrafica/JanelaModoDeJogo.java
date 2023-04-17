package InterfaceGrafica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import ProjetoDisciplina.Jogador;

public class JanelaModoDeJogo extends Componentes {

	private JLabel titulo = addLabel("Modo de Jogo", 45, 20, 350, 60);
	private JButton jogarVsJogador = addButton("Jogar vs Jogador", 70, 130, 250, 40);
	private JButton jogarVsMaquinaF = addButton("Jogar vs Maquina(Facil)", 70, 180, 250, 40);
	private JButton jogarVsMaquinaM = addButton("Jogar vs Maquina(Medio)", 70, 230, 250, 40);
	private JButton voltar = addButton("Voltar", 200, 300, 100, 40);
	private Jogador jogador;
	
	public JanelaModoDeJogo(Jogador jogador) {
		this.jogador = jogador;
		criarTelaInicial("TICK TACK TOE");
		definicoes();
		this.repaint();

	}

	public void definicoes() {
		titulo.setFont(new Font("Arial", 100, 50));
		jogarVsJogador.setFont(new Font("Arial", 14, 15));
		jogarVsMaquinaF.setFont(new Font("Arial", 14, 15));
		jogarVsMaquinaM.setFont(new Font("Arial", 14, 15));
		voltar.setFont(new Font("Arial", 14, 15));
		jogarVsJogador.addActionListener(new OuvinteBotao());
		jogarVsMaquinaF.addActionListener(new OuvinteBotao());
		jogarVsMaquinaM.addActionListener(new OuvinteBotao());
		voltar.addActionListener(new OuvinteBotao());
	}

	public class OuvinteBotao implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == voltar) {
				new JanelaLogado(jogador);
				dispose();
			}else if(e.getSource() == jogarVsJogador) {
				new JanelaJogoPVP(jogador);
				dispose();
			}else if(e.getSource() == jogarVsMaquinaF) {
				new JanelaJogoPVMF(jogador);
				dispose();
			}else if(e.getSource() == jogarVsMaquinaM) {
				//new JanelaJogoPVMM();
				dispose();
			}

		}

	}

}
