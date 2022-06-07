package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	public static final String[] colunas = {"Nome","RA","Ano","Exatas","Humanas","Natureza"};
	JFrame frmPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setResizable(false);
		frmPrincipal.setTitle("Principal");
		frmPrincipal.setBounds(100, 100, 720, 480);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		
		JButton btnProfessor = new JButton("Professores");
		btnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiProfessor tela = new GuiProfessor();
				tela.setVisible(true);
			}
		});
		btnProfessor.setBounds(35, 208, 186, 130);
		frmPrincipal.getContentPane().add(btnProfessor);
		
		JButton btnTurma = new JButton("Turmas");
		btnTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiTurma tela = new GuiTurma();
				tela.setVisible(true);
			}
		});
		btnTurma.setBounds(457, 77, 186, 130);
		frmPrincipal.getContentPane().add(btnTurma);
		
		JButton btnAluno_Turma = new JButton("Alunos e Turmas");
		btnAluno_Turma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiAluno_Turma tela = new GuiAluno_Turma();
				tela.setVisible(true);
			}
		});
		btnAluno_Turma.setBounds(244, 11, 186, 130);
		frmPrincipal.getContentPane().add(btnAluno_Turma);
		
		JButton btnAdicionar = new JButton("Alunos");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GuiAluno tela = new GuiAluno();
				tela.setVisible(true);;
			}
			
			});
		btnAdicionar.setBounds(35, 77, 186, 130);
		frmPrincipal.getContentPane().add(btnAdicionar);
		
		JButton btnProfessor_Disciplina = new JButton("Professores e Disciplinas");
		btnProfessor_Disciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiProfessor_Disciplina tela = new GuiProfessor_Disciplina();
				tela.setVisible(true);
			}
		});
		btnProfessor_Disciplina.setBounds(244, 300, 186, 130);
		frmPrincipal.getContentPane().add(btnProfessor_Disciplina);
		
		JButton btnDisciplina = new JButton("Disciplinas");
		btnDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiDisciplina tela = new GuiDisciplina();
				tela.setVisible(true);
			}
		});
		btnDisciplina.setBounds(457, 208, 186, 130);
		frmPrincipal.getContentPane().add(btnDisciplina);
		
		JButton btnRelacao = new JButton("Rela\u00E7\u00E3o");
		btnRelacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiRelacao tela = new GuiRelacao();
				tela.setVisible(true);
			}
		});
		btnRelacao.setBounds(244, 152, 186, 130);
		frmPrincipal.getContentPane().add(btnRelacao);
		
	}
}
