package InterfaceGrafica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ProjetoDisciplina.Central;
import ProjetoDisciplina.Jogador;
import ProjetoDisciplina.Persistencia;

public class InformacoesJogador extends Componentes {
	private JLabel titulo = addLabel("Info Jogador", 40, 20, 350, 60);
	private JButton voltar = addButton("Voltar", 200, 300, 100, 40);
	private JButton trocarSenha = addButton("Trocar Senha", 200, 120, 120, 40);
	private JButton pontuacao = addButton("Pontuação", 60, 120, 120, 40);
	private JButton deletarJogador = addButton("Deletar Jogador", 110, 180, 150, 40);

	private Jogador jogador;

	public InformacoesJogador(Jogador jogador) {
		this.jogador = jogador;
		criarTelaInicial("TICK TACK TOE");
		definicoes();
		this.repaint();
	}

	public void definicoes() {
		titulo.setFont(new Font("Arial", 100, 50));
		voltar.setFont(new Font("Arial", 14, 15));
		trocarSenha.setFont(new Font("Arial", 14, 15));
		pontuacao.setFont(new Font("Arial", 14, 15));
		deletarJogador.setFont(new Font("Arial", 14, 15));
		voltar.addActionListener(new OuvinteBotao());
		trocarSenha.addActionListener(new OuvinteBotao());
		deletarJogador.addActionListener(new OuvinteBotao());
		pontuacao.addActionListener(new OuvinteBotao());
	}

	public class OuvinteBotao implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == voltar) {
				new JanelaLogado(jogador);
				dispose();
			} else if (e.getSource() == trocarSenha) {
				Persistencia persistencia = Persistencia.getPersistencia();
				Central central = persistencia.recuperarCentral();
				String senha = JOptionPane.showInputDialog(null, "Digite a nova senha:");
				dispose();
				JOptionPane.showMessageDialog(null, "Senha trocada com sucesso!");
				dispose();
				jogador.setSenha(senha);
				central.atualizarJogador(jogador);
				persistencia.salvarCentral(central);
				new InformacoesJogador(jogador);

			} else if (e.getSource() == deletarJogador) {
				Persistencia persistencia = Persistencia.getPersistencia();
				Central central = persistencia.recuperarCentral();
				int op = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar sua conta?", null,
						JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);
				dispose();
				if (op == JOptionPane.YES_OPTION) {
					central.apagarJogador(jogador);
					persistencia.salvarCentral(central);
					new JanelaLogin();
				} else {
					new InformacoesJogador(jogador);
				}

			} else if (e.getSource() == pontuacao) {
				JOptionPane.showMessageDialog(null, jogador.getNome() + " sua pontuação: " + jogador.getTotalPontos());
				dispose();
				new InformacoesJogador(jogador);
			}

		}

	}
}
