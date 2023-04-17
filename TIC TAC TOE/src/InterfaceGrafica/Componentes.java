package InterfaceGrafica;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
// Classe padrao dos JFrame
public class Componentes extends JFrame {
	
	private JButton botao;
	private JLabel label;
	private JTextField texto;
	private JPasswordField password;
	// Metodo para criar as Telas
	public void criarTelaInicial(String titulo) {
		setTitle(titulo);
		setLayout(null);
		setResizable(false);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	// BotaoPadrao
	public JButton addButton(String nome, int posiX, int posiY, int largura, int altura) {
		botao = new JButton(nome);
		botao.setBounds(posiX, posiY, largura, altura);
		add(botao);
		return botao;
	}

	// JLabel Padrao
	public JLabel addLabel(String nome, int posix, int posiy, int largura, int altura) {
		label = new JLabel(nome);
		label.setBounds(posix, posiy, largura, altura);
		add(label);
		return label;
	}

	// JTextField
	public JTextField addJTextField(int posix, int posiy, int largura, int altura) {
		texto = new JTextField();
		texto.setBounds(posix, posiy, largura, altura);
		add(texto);
		return texto;
	}
	
	public JPasswordField addPasswordField(int posix, int posiy, int largura, int altura) {
		password = new JPasswordField();
		password.setBounds(posix, posiy, largura, altura);
		add(password);
		return password;
		
	}

	public void criarTelaInicial() {
		

	}

}
