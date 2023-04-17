package InterfaceGrafica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ProjetoDisciplina.Central;
import ProjetoDisciplina.Jogador;
import ProjetoDisciplina.Persistencia;
import ProjetoDisciplina.Tabuleiro;

public class JanelaJogoPVP extends Componentes {

	private String aux = "X";
	private JButton but1 = addButton("", 100, 100, 55, 55);
	private JButton but2 = addButton("", 160, 100, 55, 55);
	private JButton but3 = addButton("", 220, 100, 55, 55);
	private JButton but4 = addButton("", 100, 160, 55, 55);
	private JButton but5 = addButton("", 160, 160, 55, 55);
	private JButton but6 = addButton("", 220, 160, 55, 55);
	private JButton but7 = addButton("", 100, 220, 55, 55);
	private JButton but8 = addButton("", 160, 220, 55, 55);
	private JButton but9 = addButton("", 220, 220, 55, 55);
	private JLabel titulo = addLabel("Jogo", 150, 10, 150, 60);
	private JLabel info = addLabel("Jogador 1", 20, 50, 100, 50);
	private JLabel info2 = addLabel("Sua Vez", 20, 100, 100, 50);
	private JLabel info3 = addLabel("Jogador 2", 300, 50, 100, 50);
	private JLabel info4 = addLabel("Sua Vez", 300, 100, 100, 50);
	private Tabuleiro tabuleiro = new Tabuleiro();
	private ArrayList<JButton> lista = new ArrayList<>();
	private Jogador jogador1, jogador2;

	public JanelaJogoPVP(Jogador jogador1) {
		this.jogador1 = jogador1;

		lista.add(but1);
		lista.add(but2);
		lista.add(but3);
		lista.add(but4);
		lista.add(but5);
		lista.add(but6);
		lista.add(but7);
		lista.add(but8);
		lista.add(but9);
		edtJButton(lista);

		criarTelaInicial("TICK TACK TOE");
		definicoes();
		this.repaint();
	}

	private void edtJButton(ArrayList<JButton> lista) {
		for (JButton jButton : lista) {
			jButton.setFont(new Font("Arial", Font.BOLD, 20));
		}

	}

	public void definicoes() {
		titulo.setFont(new Font("Arial", 100, 50));
		info.setFont(new Font("Arial", 16, 14));
		info2.setFont(new Font("Arial", 15, 14));
		info3.setFont(new Font("Arial", 16, 14));
		info4.setFont(new Font("Arial", 15, 14));
		info4.setEnabled(false);
		but1.addActionListener(new OuvinteBotao());
		but2.addActionListener(new OuvinteBotao());
		but3.addActionListener(new OuvinteBotao());
		but4.addActionListener(new OuvinteBotao());
		but5.addActionListener(new OuvinteBotao());
		but6.addActionListener(new OuvinteBotao());
		but7.addActionListener(new OuvinteBotao());
		but8.addActionListener(new OuvinteBotao());
		but9.addActionListener(new OuvinteBotao());
	}

	private void fazer() {
		if (this.aux.equals("X")) {
			this.aux = "O";
			info2.setEnabled(false);
			info4.setEnabled(true);
		} else if (this.aux.equals("O")) {
			this.aux = "X";
			info2.setEnabled(true);
			info4.setEnabled(false);
		}
	}

	private class OuvinteBotao implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == but1) {
				if (but1.getText().equals("")) {
					tabuleiro.jogada(0, 0, aux);
					but1.setText(aux);
					if (tabuleiro.fimDeJogada() == true) {
						JOptionPane.showMessageDialog(null, jogador1.getNome() + " Venceu");
						new JanelaJogoPVP(jogador1);
						dispose();

					}
					fazer();

				}

			} else if (e.getSource() == but2) {
				if (but2.getText().equals("")) {
					tabuleiro.jogada(0, 1, aux);
					but2.setText(aux);
					if (tabuleiro.fimDeJogada() == true) {
						JOptionPane.showMessageDialog(null, jogador1.getNome() + " Venceu");
						new JanelaLogado(jogador1);
						dispose();

					}

					fazer();

				}
			} else if (e.getSource() == but3) {
				if (but3.getText().equals("")) {
					tabuleiro.jogada(0, 2, aux);
					but3.setText(aux);
					if (tabuleiro.fimDeJogada() == true) {
						JOptionPane.showMessageDialog(null, jogador1.getNome() + " Venceu");
						new JanelaLogado(jogador1);
						dispose();

					}

					fazer();
				}
			} else if (e.getSource() == but4) {
				if (but4.getText().equals("")) {
					tabuleiro.jogada(1, 0, aux);
					but4.setText(aux);

					if (tabuleiro.fimDeJogada() == true) {
						JOptionPane.showMessageDialog(null, jogador1.getNome() + " Venceu");
						new JanelaLogado(jogador1);
						dispose();

					}

					fazer();
				}
			} else if (e.getSource() == but5) {
				if (but5.getText().equals("")) {
					tabuleiro.jogada(1, 1, aux);
					but5.setText(aux);

					if (tabuleiro.fimDeJogada() == true) {
						JOptionPane.showMessageDialog(null, jogador1.getNome() + " Venceu");
						new JanelaLogado(jogador1);
						dispose();

					}

					fazer();
				}
			} else if (e.getSource() == but6) {
				if (but6.getText().equals("")) {
					tabuleiro.jogada(1, 2, aux);
					but6.setText(aux);
					if (tabuleiro.fimDeJogada() == true) {
						JOptionPane.showMessageDialog(null, jogador1.getNome() + " Venceu");
						new JanelaLogado(jogador1);
						dispose();

					}

					fazer();
				}
			} else if (e.getSource() == but7) {
				if (but7.getText().equals("")) {
					tabuleiro.jogada(2, 0, aux);
					but7.setText(aux);

					if (tabuleiro.fimDeJogada() == true) {
						JOptionPane.showMessageDialog(null, jogador1.getNome() + " Venceu");
						new JanelaLogado(jogador1);
						dispose();

					}

					fazer();
				}
			} else if (e.getSource() == but8) {
				if (but8.getText().equals("")) {
					tabuleiro.jogada(2, 1, aux);
					but8.setText(aux);

					if (tabuleiro.fimDeJogada() == true) {
						JOptionPane.showMessageDialog(null, jogador1.getNome() + " Venceu");
						new JanelaLogado(jogador1);
						dispose();

					}

					fazer();
				}
			} else if (e.getSource() == but9) {
				if (but9.getText().equals("")) {
					tabuleiro.jogada(2, 2, aux);
					but9.setText(aux);

					if (tabuleiro.fimDeJogada() == true) {
						JOptionPane.showMessageDialog(null, jogador1.getNome() + " Venceu");
						new JanelaLogado(jogador1);
						dispose();

					}

					fazer();
				}
			}

		}

	}

}
