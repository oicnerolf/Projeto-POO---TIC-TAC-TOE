package InterfaceGrafica;

import ProjetoDisciplina.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JanelaCadastro extends Componentes {

	private JLabel titulo = addLabel("Cadastro", 100, 15, 250, 80);
	private JLabel nome = addLabel("Nome:", 40, 120, 45, 30);
	private JLabel email = addLabel("Email:", 40, 160, 45, 30);
	private JLabel senha = addLabel("Senha:", 40, 200, 50, 30);
	private JButton cadastrar = addButton("Cadastrar", 90, 280, 100, 40);
	private JButton cancelar = addButton("Cancelar", 200, 280, 100, 40);
	private JTextField campoNome = addJTextField(95, 120, 200, 30);
	private JTextField campoEmail = addJTextField(95, 160, 200, 30);
	private JPasswordField campoSenha = addPasswordField(95, 200, 100, 30);

	public JanelaCadastro() {
		criarTelaInicial("TICK TACK TOE");
		definicoes();
		this.repaint();
	}

	public void definicoes() {
		titulo.setFont(new Font("Arial", 100, 50));
		nome.setFont(new Font("Arial", 14, 15));
		email.setFont(new Font("Arial", 14, 15));
		senha.setFont(new Font("Arial", 14, 15));
		cadastrar.setFont(new Font("Arial", 14, 15));
		cancelar.setFont(new Font("Arial", 14, 15));
		cancelar.addActionListener(new OuvinteBotao());
		cadastrar.addActionListener(new OuvinteBotao());

	}

	public class OuvinteBotao implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == cancelar) {
				new JanelaLogin();
				dispose();
			}
			if (e.getSource() == cadastrar) {
				if (campoNome.getText().equals("") || campoEmail.getText().equals("")
						|| campoSenha.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Prencha todos os dados!");
				} else {
					String nome = campoNome.getText();
					String email = campoEmail.getText();
					String senha = campoSenha.getText();
					Date data = new Date(System.currentTimeMillis());
					SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
					formatarDate.format(data);
					Jogador jogador = new Jogador(senha, nome, email, 0, data);
					// criei a persistência
					Persistencia persistencia = Persistencia.getPersistencia();
					// recuperei a central do arquivo
					Central central = persistencia.recuperarCentral();
					// mudei a central
					central.adicionarJogador(jogador);
					// salvar a nova central
					persistencia.salvarCentral(central);

					
					JOptionPane.showMessageDialog(null, "Jogador cadastrado com sucesso!");
					new JanelaLogin();
					dispose();
				}
			}

		}

	}

}
