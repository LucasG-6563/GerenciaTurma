package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Datas;
import model.Professor_Disciplina;
import model.Professor_DisciplinaDAO;
import model.Relacao;
import model.RelacaoDAO;
import model.TabelaProfessor_DisciplinaNome;
import model.TabelaRelacao;
import model.TabelaTurma;
import model.Turma;
import model.TurmaDAO;

@SuppressWarnings("serial")
public class GuiRelacao extends JFrame {

	private JFrame frmRelacao;
	private JTextField txtCodigo;
	private JTextField txtIdAluno;
	private JTextField txtCodTurma;
	private JTable tbRelacaos;
	private TabelaRelacao modeloTabela;
	private TabelaProfessor_DisciplinaNome modeloPDNome;
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
					GuiRelacao window = new GuiRelacao();
					window.frmRelacao.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiRelacao() {
		this.modeloTabela = new TabelaRelacao();
		this.modeloPDNome = new TabelaProfessor_DisciplinaNome();
		this.modeloTurma = new TabelaTurma();
		this.tbRelacaos = new JTable(modeloTabela);
		this.tbAluno = new JTable(modeloPDNome);
		this.tbTurma = new JTable(modeloTurma);
		tbRelacaos.setFont(new Font("Arial", Font.PLAIN, 20));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		
		frmRelacao = new JFrame();
		frmRelacao.setTitle("Relacao");
		frmRelacao.setBounds(100, 100, 1280, 720);
		frmRelacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRelacao.getContentPane().setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodigo.setBounds(126, 26, 150, 22);
		frmRelacao.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtIdAluno = new JTextField();
		txtIdAluno.setFont(new Font("Arial", Font.PLAIN, 20));
		txtIdAluno.setBounds(155, 78, 258, 36);
		frmRelacao.getContentPane().add(txtIdAluno);
		txtIdAluno.setColumns(10);
		
		txtCodTurma = new JTextField();
		txtCodTurma.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodTurma.setBounds(205, 150, 202, 36);
		frmRelacao.getContentPane().add(txtCodTurma);
		txtCodTurma.setColumns(10);
		
		cbAno = new JComboBox();
		cbAno.setModel(new DefaultComboBoxModel(Datas.getAno()));
		cbAno.setBounds(127, 203, 68, 33);
		frmRelacao.getContentPane().add(cbAno);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 28, 150, 20);
		frmRelacao.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Aluno");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 86, 135, 20);
		frmRelacao.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo Turma");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(2, 156, 193, 25);
		frmRelacao.getContentPane().add(lblNewLabel_2);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Arial", Font.PLAIN, 26));
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relacao d = new Relacao();
				RelacaoDAO dDAO = new RelacaoDAO();
				
				d.setCod_prof_disc(Integer.parseInt(txtIdAluno.getText()));
				d.setCod_turma(Integer.parseInt(txtCodTurma.getText()));
				d.setAno(Integer.parseInt(cbAno.getSelectedItem().toString()));
				
				dDAO.inserir(d);
				
				JOptionPane.showMessageDialog(btnInserir, "Relacao inserida com sucesso");
			}
		});
		btnInserir.setBounds(10, 260, 296, 205);
		frmRelacao.getContentPane().add(btnInserir);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modeloTabela.cleanTabela();
				
				Relacao d;
				RelacaoDAO dDAO = new RelacaoDAO();
				
				ArrayList<Relacao> lista = dDAO.listarTodos();
				for(int i=0;i<lista.size();i++) {
					d = new Relacao();
					d.setCod_relacao(lista.get(i).getCod_relacao());
					d.setCod_prof_disc(lista.get(i).getCod_prof_disc());
					d.setCod_turma(lista.get(i).getCod_turma());
					d.setAno(lista.get(i).getAno());
					
					modeloTabela.addRelacao(d);
				}
				modeloTabela.fireTableDataChanged();
				
			}
		});
		btnListar.setBounds(10, 476, 296, 194);
		frmRelacao.getContentPane().add(btnListar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relacao d = new Relacao();
				RelacaoDAO dDAO = new RelacaoDAO();
				
				d.setCod_relacao(Integer.parseInt(txtCodigo.getText()));
				d.setCod_prof_disc(Integer.parseInt(txtIdAluno.getText()));
				d.setCod_turma(Integer.parseInt(txtCodTurma.getText()));
				d.setAno(Integer.parseInt(cbAno.getSelectedItem().toString()));
				
				dDAO.alterar(d);
				JOptionPane.showMessageDialog(btnInserir, "Dados da Relacao alterado com sucesso");
			}
		});
		btnAlterar.setBounds(316, 260, 287, 205);
		frmRelacao.getContentPane().add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelacaoDAO dDAO = new RelacaoDAO();
				
				dDAO.delete(Integer.parseInt(txtCodigo.getText()));
				JOptionPane.showMessageDialog(btnInserir, "Relacao deletada com sucesso");
			}
		});
		btnDeletar.setBounds(316, 476, 287, 194);
		frmRelacao.getContentPane().add(btnDeletar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(613, 11, 641, 330);
		frmRelacao.getContentPane().add(scrollPane);
		scrollPane.setViewportView(tbRelacaos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(613, 352, 320, 318);
		frmRelacao.getContentPane().add(scrollPane_1);
		
		scrollPane_1.setViewportView(tbAluno);
		Professor_DisciplinaDAO pDAO = new Professor_DisciplinaDAO(); 
		Professor_Disciplina p;
		ArrayList<Professor_Disciplina> lista = pDAO.listarTodos();
		for(int i=0;i<lista.size();i++) {
			p = new Professor_Disciplina();
			p.setIdProfessor(lista.get(i).getIdProfessor());
			p.setCodDisciplina(lista.get(i).getCodDisciplina());
			p.setCod(lista.get(i).getCod());
			p.setNomeProfessor(lista.get(i).getIdProfessor());
			p.setDisciplina(lista.get(i).getCodDisciplina());
			
			modeloPDNome.addProfessor_DisciplinaNome(p);
		}
		modeloPDNome.fireTableDataChanged();
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(934, 352, 320, 318);
		frmRelacao.getContentPane().add(scrollPane_1_1);
		
		scrollPane_1_1.setViewportView(tbTurma);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ano");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(45, 204, 115, 25);
		frmRelacao.getContentPane().add(lblNewLabel_2_1);
		
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
		modeloTurma.fireTableDataChanged();
	}
}
