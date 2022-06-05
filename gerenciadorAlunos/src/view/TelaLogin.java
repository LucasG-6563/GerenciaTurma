package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Usuario;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUser = new JLabel("Usu\u00E1rio");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(44, 68, 46, 14);
		contentPane.add(lblUser);

		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(44, 120, 46, 14);
		contentPane.add(lblPassword);

		txtPasswordField = new JPasswordField();
		txtPasswordField.setBounds(100, 117, 213, 20);
		contentPane.add(txtPasswordField);

		JFormattedTextField txtUserField = new JFormattedTextField();
		txtUserField.setBounds(100, 65, 213, 20);
		contentPane.add(txtUserField);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				if (usuario.verificaUser(txtUserField.getText(), txtPasswordField.getText())) {
					JOptionPane.showMessageDialog(btnEntrar, "Bem vindo lusca!");
					TelaPrincipal tp = new TelaPrincipal();
					tp.frmPrincipal.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(btnEntrar, "Usuário e/ou senha incorreto.");
			}
		});
		
		btnEntrar.setBounds(44, 188, 124, 23);
		contentPane.add(btnEntrar);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		btnSair.setBounds(198, 188, 115, 23);
		contentPane.add(btnSair);

		JLabel lblRecuperaSenha = new JLabel("Recuperar Senha");
		lblRecuperaSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Usuario obj = new Usuario();
				String senha = JOptionPane.showInputDialog("Coloque a senha de recuperação");
				if (obj.recuperaSenha(senha) == null)
					JOptionPane.showMessageDialog(lblRecuperaSenha, "Senha de recuperação incorreta");
				else
					JOptionPane.showMessageDialog(lblRecuperaSenha, obj.recuperaSenha(senha));
			}
		});
		lblRecuperaSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRecuperaSenha.setBounds(218, 236, 146, 14);
		contentPane.add(lblRecuperaSenha);
	}
}
