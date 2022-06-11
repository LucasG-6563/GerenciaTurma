package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Professor;
import model.ProfessorDAO;
import model.Professor_Disciplina;
import model.Professor_DisciplinaDAO;
import model.TabelaProfessorMini;
import model.TabelaProfessor_Disciplina;
import model.TabelaDisciplina;
import model.Disciplina;
import model.DisciplinaDAO;

@SuppressWarnings("serial")
public class GuiProfessor_Disciplina extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTable tbProfessor_Disciplina;
	private TabelaProfessor_Disciplina modeloTabela;
	private TabelaProfessorMini modeloProfessorMini;
	private TabelaDisciplina modeloDisciplina;
	private JTable tbProfessorMini;
	private JTable tbDisciplina;
	private JTextField txtRaProfessor;
	private JTextField txtCodDisciplina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiProfessor_Disciplina frame = new GuiProfessor_Disciplina();
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
	public GuiProfessor_Disciplina() {
		setTitle("Professor e Disciplina");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1264, 681);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(471, 0, 773, 345);
		panel.add(scrollPane);

		tbProfessor_Disciplina = new JTable();
		this.modeloTabela = new TabelaProfessor_Disciplina();
		this.tbProfessor_Disciplina = new JTable(modeloTabela);
		tbProfessor_Disciplina.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(tbProfessor_Disciplina);

		JLabel lblId = new JLabel("C\u00F3digo");
		lblId.setFont(new Font("Arial", Font.PLAIN, 20));
		lblId.setBounds(10, 11, 65, 37);
		panel.add(lblId);

		JLabel lblNome = new JLabel("ID Professor");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNome.setBounds(10, 78, 127, 37);
		panel.add(lblNome);

		JLabel lblEndereco = new JLabel("C\u00F3digo Disciplina");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEndereco.setBounds(10, 143, 170, 37);
		panel.add(lblEndereco);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodigo.setBounds(85, 14, 65, 31);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor_Disciplina d = new Professor_Disciplina();
				Professor_DisciplinaDAO dDAO = new Professor_DisciplinaDAO();

				d.setIdProfessor(Integer.parseInt(txtRaProfessor.getText()));
				d.setCodDisciplina(Integer.parseInt(txtCodDisciplina.getText()));

				dDAO.inserir(d);

				JOptionPane.showMessageDialog(btnIncluir, "Professor_Disciplina inserida com sucesso");
			}
		});
		btnIncluir.setFont(new Font("Arial", Font.PLAIN, 26));
		btnIncluir.setBounds(10, 268, 225, 185);
		panel.add(btnIncluir);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Professor_Disciplina d = new Professor_Disciplina();
				Professor_DisciplinaDAO dDAO = new Professor_DisciplinaDAO();

				d.setCod(Integer.parseInt(txtCodigo.getText()));
				d.setIdProfessor(Integer.parseInt(txtCodigo.getText()));
				d.setCodDisciplina(Integer.parseInt(txtCodigo.getText()));

				dDAO.alterar(d);

				JOptionPane.showMessageDialog(btnIncluir, "Dados da Professor_Disciplina alterado com sucesso");
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnAlterar.setBounds(236, 268, 225, 185);
		panel.add(btnAlterar);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modeloTabela.cleanTabela();

				Professor_Disciplina d;
				Professor_DisciplinaDAO dDAO = new Professor_DisciplinaDAO();

				ArrayList<Professor_Disciplina> lista = dDAO.listarTodos();
				for (int i = 0; i < lista.size(); i++) {
					d = new Professor_Disciplina();
					d.setCod(lista.get(i).getCod());
					d.setIdProfessor(lista.get(i).getIdProfessor());
					d.setCodDisciplina(lista.get(i).getCodDisciplina());

					modeloTabela.addProfessor_Disciplina(d);
				}
				modeloTabela.fireTableDataChanged();

			}
		});
		btnListar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnListar.setBounds(10, 453, 225, 217);
		panel.add(btnListar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor_DisciplinaDAO dDAO = new Professor_DisciplinaDAO();

				dDAO.delete(Integer.parseInt(txtCodigo.getText()));

				JOptionPane.showMessageDialog(btnIncluir, "Professor_Disciplina deletada com sucesso");
			}
		});
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnDeletar.setBounds(236, 453, 225, 217);
		panel.add(btnDeletar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(471, 345, 386, 325);
		panel.add(scrollPane_1);

		tbProfessorMini = new JTable();
		this.modeloProfessorMini = new TabelaProfessorMini();
		this.tbProfessorMini = new JTable(modeloProfessorMini);
		tbProfessorMini.setFont(new Font("Arial", Font.PLAIN, 20));
		scrollPane_1.setViewportView(tbProfessorMini);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(858, 345, 386, 325);
		panel.add(scrollPane_1_1);

		tbDisciplina = new JTable();
		this.modeloDisciplina = new TabelaDisciplina();
		this.tbDisciplina = new JTable(modeloDisciplina);
		tbDisciplina.setFont(new Font("Arial", Font.PLAIN, 20));
		scrollPane_1_1.setViewportView(tbDisciplina);

		txtRaProfessor = new JTextField();
		txtRaProfessor.setFont(new Font("Arial", Font.PLAIN, 20));
		txtRaProfessor.setColumns(10);
		txtRaProfessor.setBounds(147, 81, 65, 31);
		panel.add(txtRaProfessor);

		txtCodDisciplina = new JTextField();
		txtCodDisciplina.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodDisciplina.setColumns(10);
		txtCodDisciplina.setBounds(190, 146, 65, 31);
		panel.add(txtCodDisciplina);

		ProfessorDAO pDAO = new ProfessorDAO();
		Professor p;
		ArrayList<Professor> lista = pDAO.listarTodos();
		for (int i = 0; i < lista.size(); i++) {
			p = new Professor();
			p.setIdProfessor(lista.get(i).getIdProfessor());
			p.setNome(lista.get(i).getNome());

			modeloProfessorMini.addProfessor(p);
		}
		modeloProfessorMini.fireTableDataChanged();

		DisciplinaDAO dDAO = new DisciplinaDAO();
		Disciplina d;
		ArrayList<Disciplina> listaDisciplina = dDAO.listarTodos();
		for (int i = 0; i < listaDisciplina.size(); i++) {
			d = new Disciplina();
			d.setCod(listaDisciplina.get(i).getCod());
			d.setNome(listaDisciplina.get(i).getNome());
			d.setArea(listaDisciplina.get(i).getArea());

			modeloDisciplina.addDisciplina(d);
		}
		modeloProfessorMini.fireTableDataChanged();
	}
}
