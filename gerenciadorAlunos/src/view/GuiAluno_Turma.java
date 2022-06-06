package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Turma;
import model.TurmaDAO;
import model.Aluno;
import model.AlunoDAO;
import model.Aluno_Turma;
import model.Aluno_TurmaDAO;
import model.Datas;
import model.TabelaTurma;
import model.TabelaAlunoMini;
import model.TabelaAluno_Turma;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class GuiAluno_Turma extends JFrame {

	private JFrame frmAluno_Turma;
	private JTextField txtCodigo;
	private JTextField txtIdAluno;
	private JTextField txtCodTurma;
	private JTable tbAluno_Turmas;
	private TabelaAluno_Turma modeloTabela;
	private TabelaAlunoMini modeloAlunoMini;
	private TabelaTurma modeloTurma;
	private JTable tbAluno;
	private JTable tbTurma;
	@SuppressWarnings("rawtypes")
	private JComboBox cbAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiAluno_Turma window = new GuiAluno_Turma();
					window.frmAluno_Turma.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiAluno_Turma() {
		this.modeloTabela = new TabelaAluno_Turma();
		this.modeloAlunoMini = new TabelaAlunoMini();
		this.modeloTurma = new TabelaTurma();
		this.tbAluno_Turmas = new JTable(modeloTabela);
		this.tbAluno = new JTable(modeloAlunoMini);
		this.tbTurma = new JTable(modeloTurma);
		tbAluno_Turmas.setFont(new Font("Arial", Font.PLAIN, 20));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		
		frmAluno_Turma = new JFrame();
		frmAluno_Turma.setTitle("Aluno_Turma");
		frmAluno_Turma.setBounds(100, 100, 1280, 720);
		frmAluno_Turma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAluno_Turma.getContentPane().setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodigo.setBounds(126, 26, 150, 22);
		frmAluno_Turma.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtIdAluno = new JTextField();
		txtIdAluno.setFont(new Font("Arial", Font.PLAIN, 20));
		txtIdAluno.setBounds(155, 78, 258, 36);
		frmAluno_Turma.getContentPane().add(txtIdAluno);
		txtIdAluno.setColumns(10);
		
		txtCodTurma = new JTextField();
		txtCodTurma.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodTurma.setBounds(205, 150, 202, 36);
		frmAluno_Turma.getContentPane().add(txtCodTurma);
		txtCodTurma.setColumns(10);
		
		cbAno = new JComboBox();
		cbAno.setModel(new DefaultComboBoxModel(Datas.getAno()));
		cbAno.setBounds(127, 203, 68, 33);
		frmAluno_Turma.getContentPane().add(cbAno);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 28, 150, 20);
		frmAluno_Turma.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Aluno");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 86, 135, 20);
		frmAluno_Turma.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo Turma");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(2, 156, 193, 25);
		frmAluno_Turma.getContentPane().add(lblNewLabel_2);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Arial", Font.PLAIN, 26));
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno_Turma d = new Aluno_Turma();
				Aluno_TurmaDAO dDAO = new Aluno_TurmaDAO();
				
				d.setRa_aluno(Integer.parseInt(txtIdAluno.getText()));
				d.setCod_turma(Integer.parseInt(txtCodTurma.getText()));
				d.setAno(Integer.parseInt(cbAno.getSelectedItem().toString()));
				
				dDAO.inserir(d);
				
				JOptionPane.showMessageDialog(btnInserir, "Aluno_Turma inserida com sucesso");
			}
		});
		btnInserir.setBounds(10, 260, 296, 205);
		frmAluno_Turma.getContentPane().add(btnInserir);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modeloTabela.cleanTabela();
				
				Aluno_Turma d;
				Aluno_TurmaDAO dDAO = new Aluno_TurmaDAO();
				
				ArrayList<Aluno_Turma> lista = dDAO.listarTodos();
				for(int i=0;i<lista.size();i++) {
					d = new Aluno_Turma();
					d.setCod_alum_turm(lista.get(i).getCod_alum_turm());
					d.setRa_aluno(lista.get(i).getRa_aluno());
					d.setCod_turma(lista.get(i).getCod_turma());
					d.setAno(lista.get(i).getAno());
					
					modeloTabela.addAluno_Turma(d);
				}
				modeloTabela.fireTableDataChanged();
				
			}
		});
		btnListar.setBounds(10, 476, 296, 194);
		frmAluno_Turma.getContentPane().add(btnListar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno_Turma d = new Aluno_Turma();
				Aluno_TurmaDAO dDAO = new Aluno_TurmaDAO();
				
				d.setCod_alum_turm(Integer.parseInt(txtCodigo.getText()));
				d.setRa_aluno(Integer.parseInt(txtIdAluno.getText()));
				d.setCod_turma(Integer.parseInt(txtCodTurma.getText()));
				d.setAno(DO_NOTHING_ON_CLOSE);
				
				dDAO.alterar(d);
				JOptionPane.showMessageDialog(btnInserir, "Dados da Aluno_Turma alterado com sucesso");
			}
		});
		btnAlterar.setBounds(316, 260, 287, 205);
		frmAluno_Turma.getContentPane().add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno_TurmaDAO dDAO = new Aluno_TurmaDAO();
				
				dDAO.delete(Integer.parseInt(txtCodigo.getText()));
				JOptionPane.showMessageDialog(btnInserir, "Aluno_Turma deletada com sucesso");
			}
		});
		btnDeletar.setBounds(316, 476, 287, 194);
		frmAluno_Turma.getContentPane().add(btnDeletar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(613, 11, 641, 330);
		frmAluno_Turma.getContentPane().add(scrollPane);
		scrollPane.setViewportView(tbAluno_Turmas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(613, 352, 320, 318);
		frmAluno_Turma.getContentPane().add(scrollPane_1);
		
		scrollPane_1.setViewportView(tbAluno);
		AlunoDAO pDAO = new AlunoDAO(); 
		Aluno p;
		ArrayList<Aluno> lista = pDAO.listarTodos();
		for(int i=0;i<lista.size();i++) {
			p = new Aluno();
			p.setRa(lista.get(i).getRa());
			p.setNome(lista.get(i).getNome());
			
			modeloAlunoMini.addAluno(p);
		}
		modeloAlunoMini.fireTableDataChanged();
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(934, 352, 320, 318);
		frmAluno_Turma.getContentPane().add(scrollPane_1_1);
		
		scrollPane_1_1.setViewportView(tbTurma);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ano");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(45, 204, 115, 25);
		frmAluno_Turma.getContentPane().add(lblNewLabel_2_1);
		
		TurmaDAO dDAO = new TurmaDAO(); 
		Turma d;
		ArrayList<Turma> listaTurma = dDAO.listarTodos();
		for(int i=0;i<listaTurma.size();i++) {
			d = new Turma();
			d.setCod(listaTurma.get(i).getCod());
			d.setSerie(listaTurma.get(i).getSerie());
			d.setPeriodo(listaTurma.get(i).getPeriodo());
			
			modeloTurma.addTurma(d);
		}
		modeloAlunoMini.fireTableDataChanged();
	}
}
