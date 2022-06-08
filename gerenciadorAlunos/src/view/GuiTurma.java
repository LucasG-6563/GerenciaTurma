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

import model.TabelaTurma;
import model.Turma;
import model.TurmaDAO;

@SuppressWarnings("serial")
public class GuiTurma extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtSerie;
	private JTextField txtPeriodo;
	private JTable tbTurmas;
	private TabelaTurma modeloTabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTurma frame = new GuiTurma();
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
	public GuiTurma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		tbTurmas = new JTable();
		this.modeloTabela = new TabelaTurma();
		this.tbTurmas = new JTable(modeloTabela);
		tbTurmas.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(tbTurmas);

		JLabel lblId = new JLabel("C\u00F3digo");
		lblId.setFont(new Font("Arial", Font.PLAIN, 20));
		lblId.setBounds(10, 11, 65, 37);
		panel.add(lblId);

		JLabel lblNome = new JLabel("Serie");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNome.setBounds(10, 78, 65, 37);
		panel.add(lblNome);

		JLabel lblEndereco = new JLabel("Per\u00EDodo");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEndereco.setBounds(10, 156, 72, 37);
		panel.add(lblEndereco);

		txtSerie = new JTextField();
		txtSerie.setFont(new Font("Arial", Font.PLAIN, 20));
		txtSerie.setBounds(83, 81, 217, 31);
		panel.add(txtSerie);
		txtSerie.setColumns(10);

		txtPeriodo = new JTextField();
		txtPeriodo.setFont(new Font("Arial", Font.PLAIN, 20));
		txtPeriodo.setColumns(10);
		txtPeriodo.setBounds(83, 159, 217, 31);
		panel.add(txtPeriodo);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodigo.setBounds(85, 14, 103, 31);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Turma d = new Turma();
				TurmaDAO dDAO = new TurmaDAO();
				
				d.setSerie(txtSerie.getText());
				d.setPeriodo(txtPeriodo.getText());
				
				dDAO.inserir(d);
				
				JOptionPane.showMessageDialog(btnIncluir, "Turma inserida com sucesso");
			}
		});
		btnIncluir.setFont(new Font("Arial", Font.PLAIN, 26));
		btnIncluir.setBounds(10, 268, 225, 185);
		panel.add(btnIncluir);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Turma d = new Turma();
				TurmaDAO dDAO = new TurmaDAO();

				d.setCod(Integer.parseInt(txtCodigo.getText()));
				d.setSerie(txtSerie.getText());
				d.setPeriodo(txtPeriodo.getText());

				dDAO.alterar(d);

				JOptionPane.showMessageDialog(btnIncluir, "Dados da turma alterado com sucesso");
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnAlterar.setBounds(236, 268, 225, 185);
		panel.add(btnAlterar);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modeloTabela.cleanTabela();

				Turma d;
				TurmaDAO dDAO = new TurmaDAO();

				ArrayList<Turma> lista = dDAO.listarTodos();
				for (int i = 0; i < lista.size(); i++) {
					d = new Turma();
					d.setCod(lista.get(i).getCod());
					d.setSerie(lista.get(i).getSerie());
					d.setPeriodo(lista.get(i).getPeriodo());

					modeloTabela.addTurma(d);
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
				TurmaDAO dDAO = new TurmaDAO();

				dDAO.delete(Integer.parseInt(txtCodigo.getText()));

				JOptionPane.showMessageDialog(btnIncluir, "Turma deletada com sucesso");
			}
		});
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnDeletar.setBounds(236, 453, 225, 217);
		panel.add(btnDeletar);
	}

}
