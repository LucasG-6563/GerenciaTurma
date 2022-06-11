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

import model.Disciplina;
import model.DisciplinaDAO;
import model.TabelaDisciplina;

@SuppressWarnings("serial")
public class GuiDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtArea;
	private JTable tbDisciplinas;
	private TabelaDisciplina modeloTabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiDisciplina frame = new GuiDisciplina();
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
	public GuiDisciplina() {
		setTitle("Disciplinas");
		
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
		scrollPane.setBounds(471, 0, 773, 681);
		panel.add(scrollPane);

		tbDisciplinas = new JTable();
		this.modeloTabela = new TabelaDisciplina();
		this.tbDisciplinas = new JTable(modeloTabela);
		tbDisciplinas.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(tbDisciplinas);

		JLabel lblId = new JLabel("C\u00F3digo");
		lblId.setFont(new Font("Arial", Font.PLAIN, 20));
		lblId.setBounds(10, 11, 65, 37);
		panel.add(lblId);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNome.setBounds(10, 78, 65, 37);
		panel.add(lblNome);

		JLabel lblEndereco = new JLabel("Per\u00EDodo");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEndereco.setBounds(10, 156, 72, 37);
		panel.add(lblEndereco);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 20));
		txtNome.setBounds(83, 81, 217, 31);
		panel.add(txtNome);
		txtNome.setColumns(10);

		txtArea = new JTextField();
		txtArea.setFont(new Font("Arial", Font.PLAIN, 20));
		txtArea.setColumns(10);
		txtArea.setBounds(83, 159, 217, 31);
		panel.add(txtArea);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodigo.setBounds(85, 14, 103, 31);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Disciplina d = new Disciplina();
				DisciplinaDAO dDAO = new DisciplinaDAO();
				
				d.setNome(txtNome.getText());
				d.setArea(txtArea.getText());
				
				dDAO.inserir(d);
				
				JOptionPane.showMessageDialog(btnIncluir, "Disciplina inserida com sucesso");
			}
		});
		btnIncluir.setFont(new Font("Arial", Font.PLAIN, 26));
		btnIncluir.setBounds(10, 268, 225, 185);
		panel.add(btnIncluir);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Disciplina d = new Disciplina();
				DisciplinaDAO dDAO = new DisciplinaDAO();

				d.setCod(Integer.parseInt(txtCodigo.getText()));
				d.setNome(txtNome.getText());
				d.setArea(txtArea.getText());

				dDAO.alterar(d);

				JOptionPane.showMessageDialog(btnIncluir, "Dados da Disciplina alterado com sucesso");
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnAlterar.setBounds(236, 268, 225, 185);
		panel.add(btnAlterar);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modeloTabela.cleanTabela();

				Disciplina d;
				DisciplinaDAO dDAO = new DisciplinaDAO();

				ArrayList<Disciplina> lista = dDAO.listarTodos();
				for (int i = 0; i < lista.size(); i++) {
					d = new Disciplina();
					d.setCod(lista.get(i).getCod());
					d.setNome(lista.get(i).getNome());
					d.setArea(lista.get(i).getArea());

					modeloTabela.addDisciplina(d);
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
				DisciplinaDAO dDAO = new DisciplinaDAO();

				dDAO.delete(Integer.parseInt(txtCodigo.getText()));

				JOptionPane.showMessageDialog(btnIncluir, "Disciplina deletada com sucesso");
			}
		});
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnDeletar.setBounds(236, 453, 225, 217);
		panel.add(btnDeletar);
	}

}
