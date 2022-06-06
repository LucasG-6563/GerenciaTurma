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

import model.Disciplina;
import model.DisciplinaDAO;
import model.Professor;
import model.ProfessorDAO;
import model.Professor_Disciplina;
import model.Professor_DisciplinaDAO;
import model.TabelaDisciplina;
import model.TabelaProfessorMini;
import model.TabelaProfessor_Disciplina;

@SuppressWarnings("serial")
public class GuiProfessor_Disciplina extends JFrame {

	private JFrame frmProfessor_Disciplina;
	private JTextField txtCodigo;
	private JTextField txtIdProfessor;
	private JTextField txtCodDisciplina;
	private JTable tbProfessor_Disciplinas;
	private TabelaProfessor_Disciplina modeloTabela;
	private TabelaProfessorMini modeloProfessorMini;
	private TabelaDisciplina modeloDisciplina;
	private JTable tbProfessor;
	private JTable tbDisciplina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiProfessor_Disciplina window = new GuiProfessor_Disciplina();
					window.frmProfessor_Disciplina.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiProfessor_Disciplina() {
		this.modeloTabela = new TabelaProfessor_Disciplina();
		this.modeloProfessorMini = new TabelaProfessorMini();
		this.modeloDisciplina = new TabelaDisciplina();
		this.tbProfessor_Disciplinas = new JTable(modeloTabela);
		this.tbProfessor = new JTable(modeloProfessorMini);
		this.tbDisciplina = new JTable(modeloDisciplina);
		tbProfessor_Disciplinas.setFont(new Font("Arial", Font.PLAIN, 20));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProfessor_Disciplina = new JFrame();
		frmProfessor_Disciplina.setTitle("Professor_Disciplina");
		frmProfessor_Disciplina.setBounds(100, 100, 1280, 720);
		frmProfessor_Disciplina.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfessor_Disciplina.getContentPane().setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodigo.setBounds(126, 26, 150, 22);
		frmProfessor_Disciplina.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtIdProfessor = new JTextField();
		txtIdProfessor.setFont(new Font("Arial", Font.PLAIN, 20));
		txtIdProfessor.setBounds(155, 78, 258, 36);
		frmProfessor_Disciplina.getContentPane().add(txtIdProfessor);
		txtIdProfessor.setColumns(10);
		
		txtCodDisciplina = new JTextField();
		txtCodDisciplina.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodDisciplina.setBounds(205, 150, 202, 36);
		frmProfessor_Disciplina.getContentPane().add(txtCodDisciplina);
		txtCodDisciplina.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 28, 150, 20);
		frmProfessor_Disciplina.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Professor");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 86, 135, 20);
		frmProfessor_Disciplina.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo Disciplina");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(2, 156, 193, 25);
		frmProfessor_Disciplina.getContentPane().add(lblNewLabel_2);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Arial", Font.PLAIN, 26));
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor_Disciplina d = new Professor_Disciplina();
				Professor_DisciplinaDAO dDAO = new Professor_DisciplinaDAO();
				
				d.setIdProfessor(Integer.parseInt(txtIdProfessor.getText()));
				d.setCodDisciplina(Integer.parseInt(txtCodDisciplina.getText()));
				
				dDAO.inserir(d);
				
				JOptionPane.showMessageDialog(btnInserir, "Professor_Disciplina inserida com sucesso");
			}
		});
		btnInserir.setBounds(10, 260, 296, 205);
		frmProfessor_Disciplina.getContentPane().add(btnInserir);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modeloTabela.cleanTabela();
				
				Professor_Disciplina d;
				Professor_DisciplinaDAO dDAO = new Professor_DisciplinaDAO();
				
				ArrayList<Professor_Disciplina> lista = dDAO.listarTodos();
				for(int i=0;i<lista.size();i++) {
					d = new Professor_Disciplina();
					d.setCod(lista.get(i).getCod());
					d.setIdProfessor(lista.get(i).getIdProfessor());
					d.setCodDisciplina(lista.get(i).getCodDisciplina());
					
					modeloTabela.addProfessor_Disciplina(d);
				}
				modeloTabela.fireTableDataChanged();
				
			}
		});
		btnListar.setBounds(10, 476, 296, 194);
		frmProfessor_Disciplina.getContentPane().add(btnListar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor_Disciplina d = new Professor_Disciplina();
				Professor_DisciplinaDAO dDAO = new Professor_DisciplinaDAO();
				
				d.setCod(Integer.parseInt(txtCodigo.getText()));
				d.setIdProfessor(Integer.parseInt(txtIdProfessor.getText()));
				d.setCodDisciplina(Integer.parseInt(txtCodDisciplina.getText()));
				
				dDAO.alterar(d);
				JOptionPane.showMessageDialog(btnInserir, "Dados da Professor_Disciplina alterado com sucesso");
			}
		});
		btnAlterar.setBounds(316, 260, 287, 205);
		frmProfessor_Disciplina.getContentPane().add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor_DisciplinaDAO dDAO = new Professor_DisciplinaDAO();
				
				dDAO.delete(Integer.parseInt(txtCodigo.getText()));
				JOptionPane.showMessageDialog(btnInserir, "Professor_Disciplina deletada com sucesso");
			}
		});
		btnDeletar.setBounds(316, 476, 287, 194);
		frmProfessor_Disciplina.getContentPane().add(btnDeletar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(613, 11, 641, 330);
		frmProfessor_Disciplina.getContentPane().add(scrollPane);
		scrollPane.setViewportView(tbProfessor_Disciplinas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(613, 352, 320, 318);
		frmProfessor_Disciplina.getContentPane().add(scrollPane_1);
		
		scrollPane_1.setViewportView(tbProfessor);
		ProfessorDAO pDAO = new ProfessorDAO(); 
		Professor p;
		ArrayList<Professor> lista = pDAO.listarTodos();
		for(int i=0;i<lista.size();i++) {
			p = new Professor();
			p.setIdProfessor(lista.get(i).getIdProfessor());
			p.setNome(lista.get(i).getNome());
			
			modeloProfessorMini.addProfessor(p);
		}
		modeloProfessorMini.fireTableDataChanged();
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(934, 352, 320, 318);
		frmProfessor_Disciplina.getContentPane().add(scrollPane_1_1);
		
		scrollPane_1_1.setViewportView(tbDisciplina);
		DisciplinaDAO dDAO = new DisciplinaDAO(); 
		Disciplina d;
		ArrayList<Disciplina> listaDisciplina = dDAO.listarTodos();
		for(int i=0;i<listaDisciplina.size();i++) {
			d = new Disciplina();
			d.setCod(listaDisciplina.get(i).getCod());
			d.setNome(listaDisciplina.get(i).getNome());
			d.setArea(listaDisciplina.get(i).getArea());
			
			modeloDisciplina.addDisciplina(d);
		}
		modeloProfessorMini.fireTableDataChanged();
	}
}
