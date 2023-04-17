package InterfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ProjetoDisciplina.Central;
import ProjetoDisciplina.Jogador;
import ProjetoDisciplina.Persistencia;

public class JanelaLogin extends Componentes {

	private JLabel titulo = addLabel("Login", 125, 15, 200, 80);
	private JLabel email = addLabel("Email:", 40, 120, 45, 30);
	private JLabel senha = addLabel("Senha:", 40, 180, 50, 30);
	private JButton cadastrar = addButton("Cadastrar", 200, 280, 100, 40);
	private JButton login = addButton("Login", 100, 280, 80, 40);
	private JTextField campoEmail = addJTextField(95, 120, 200, 30);
	private JPasswordField campoSenha = addPasswordField(95, 180, 100, 30);
	private JLabel recuperarSenha = addLabel("Esqueceu Senha?", 40, 210, 150, 30);

	public JanelaLogin() {
		criarTelaInicial("TICK TACK TOE");
		definicoes();
		this.repaint();
	}

	public void definicoes() {
		titulo.setFont(new Font("Arial", 100, 50));
		email.setFont(new Font("Arial", 14, 15));
		senha.setFont(new Font("Arial", 14, 15));
		cadastrar.setFont(new Font("Arial", 14, 15));
		login.setFont(new Font("Arial", 14, 15));
		cadastrar.addActionListener(new OuvinteBotao());
		login.addActionListener(new OuvinteBotao());
		recuperarSenha.setFont(new Font("Arial", 8, 12));
		

	}
	
	private class OuvinteBotao implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == cadastrar) {
				new JanelaCadastro();
				dispose();

			}
			if (e.getSource() == login) {
				if (campoEmail.getText().equals("") || campoSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Prencha todos os campos!");
				} else {
					String email = campoEmail.getText();
					String senha = campoSenha.getText();
					Persistencia persistencia = Persistencia.getPersistencia();

					Central central = persistencia.recuperarCentral();
					if (central.recuperarJogador(email, senha)) {
						Jogador jogador = central.recuperarJogadorEmail(email);
						new JanelaLogado(jogador);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Usuario não cadastrado ou Email ou Senha errados!");
					}

				}

			}

		}
	}

}
