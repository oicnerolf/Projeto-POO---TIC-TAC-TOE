package InterfaceGrafica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import ProjetoDisciplina.Jogador;

public class InformacoesPartida extends Componentes {

	private JLabel titulo = addLabel("Info Partidas", 40, 20, 350, 60);
	private JButton voltar = addButton("Voltar", 200, 300, 100, 40);
	private Jogador jogador;

	public InformacoesPartida(Jogador jogador) {
		this.jogador = jogador;
		criarTelaInicial("TICK TACK TOE");
		definicoes();
		this.repaint();
	}

	public void definicoes() {
		titulo.setFont(new Font("Arial", 100, 50));
		voltar.setFont(new Font("Arial", 14, 15));
		voltar.addActionListener(new OuvinteBotao());
	}

	public class OuvinteBotao implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == voltar) {
				new JanelaLogado(jogador);
				dispose();
			}

		}

	}
}
