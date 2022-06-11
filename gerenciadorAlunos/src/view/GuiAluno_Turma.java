package view;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Aluno;
import model.AlunoDAO;
import model.Aluno_Turma;
import model.Aluno_TurmaDAO;
import model.Datas;
import model.TabelaAlunoMini;
import model.TabelaAluno_Turma;
import model.TabelaTurma;
import model.Turma;
import model.TurmaDAO;

@SuppressWarnings("serial")
public class GuiAluno_Turma extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTable tbAluno_Turma;
	private TabelaAluno_Turma modeloTabela;
	private TabelaAlunoMini modeloAlunoMini;
	private TabelaTurma modeloTurma;
	private JTable tbAlunoMini;
	private JTable tbTurma;
	private JTextField txtRaAluno;
	private JTextField txtCodTurma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiAluno_Turma frame = new GuiAluno_Turma();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GuiAluno_Turma() {
		setTitle("Aluno e Turma");
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

		tbAluno_Turma = new JTable();
		this.modeloTabela = new TabelaAluno_Turma();
		this.tbAluno_Turma = new JTable(modeloTabela);
		tbAluno_Turma.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(tbAluno_Turma);

		JLabel lblId = new JLabel("C\u00F3digo");
		lblId.setFont(new Font("Arial", Font.PLAIN, 20));
		lblId.setBounds(10, 11, 65, 37);
		panel.add(lblId);

		JLabel lblNome = new JLabel("RA Aluno");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNome.setBounds(10, 78, 95, 37);
		panel.add(lblNome);

		JLabel lblEndereco = new JLabel("C\u00F3digo Turma");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEndereco.setBounds(10, 143, 140, 37);
		panel.add(lblEndereco);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodigo.setBounds(85, 14, 65, 31);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno_Turma d = new Aluno_Turma();
				Aluno_TurmaDAO dDAO = new Aluno_TurmaDAO();

				d.setRa_aluno(Integer.parseInt(txtRaAluno.getText()));
				d.setCod_turma(Integer.parseInt(txtCodTurma.getText()));

				dDAO.inserir(d);

				JOptionPane.showMessageDialog(btnIncluir, "Aluno_Turma inserida com sucesso");
			}
		});
		btnIncluir.setFont(new Font("Arial", Font.PLAIN, 26));
		btnIncluir.setBounds(10, 268, 225, 185);
		panel.add(btnIncluir);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Aluno_Turma d = new Aluno_Turma();
				Aluno_TurmaDAO dDAO = new Aluno_TurmaDAO();

				d.setCod_alun_turm(Integer.parseInt(txtCodigo.getText()));
				d.setRa_aluno(Integer.parseInt(txtCodigo.getText()));
				d.setCod_turma(Integer.parseInt(txtCodigo.getText()));

				dDAO.alterar(d);

				JOptionPane.showMessageDialog(btnIncluir, "Dados da Aluno_Turma alterado com sucesso");
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnAlterar.setBounds(236, 268, 225, 185);
		panel.add(btnAlterar);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modeloTabela.cleanTabela();

				Aluno_Turma d;
				Aluno_TurmaDAO dDAO = new Aluno_TurmaDAO();

				ArrayList<Aluno_Turma> lista = dDAO.listarTodos();
				for (int i = 0; i < lista.size(); i++) {
					d = new Aluno_Turma();
					d.setCod_alun_turm(lista.get(i).getCod_alun_turm());
					d.setRa_aluno(lista.get(i).getRa_aluno());
					d.setCod_turma(lista.get(i).getCod_turma());

					modeloTabela.addAluno_Turma(d);
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
				Aluno_TurmaDAO dDAO = new Aluno_TurmaDAO();

				dDAO.delete(Integer.parseInt(txtCodigo.getText()));

				JOptionPane.showMessageDialog(btnIncluir, "Aluno_Turma deletada com sucesso");
			}
		});
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnDeletar.setBounds(236, 453, 225, 217);
		panel.add(btnDeletar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(471, 345, 386, 325);
		panel.add(scrollPane_1);

		tbAlunoMini = new JTable();
		this.modeloAlunoMini = new TabelaAlunoMini();
		this.tbAlunoMini = new JTable(modeloAlunoMini);
		tbAlunoMini.setFont(new Font("Arial", Font.PLAIN, 20));
		scrollPane_1.setViewportView(tbAlunoMini);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(858, 345, 386, 325);
		panel.add(scrollPane_1_1);

		tbTurma = new JTable();
		this.modeloTurma = new TabelaTurma();
		this.tbTurma = new JTable(modeloTurma);
		tbTurma.setFont(new Font("Arial", Font.PLAIN, 20));
		scrollPane_1_1.setViewportView(tbTurma);

		txtRaAluno = new JTextField();
		txtRaAluno.setFont(new Font("Arial", Font.PLAIN, 20));
		txtRaAluno.setColumns(10);
		txtRaAluno.setBounds(115, 81, 65, 31);
		panel.add(txtRaAluno);

		txtCodTurma = new JTextField();
		txtCodTurma.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodTurma.setColumns(10);
		txtCodTurma.setBounds(160, 146, 65, 31);
		panel.add(txtCodTurma);

		JLabel lblEndereco_1 = new JLabel("Ano");
		lblEndereco_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEndereco_1.setBounds(10, 208, 46, 37);
		panel.add(lblEndereco_1);

		JComboBox cbAno = new JComboBox();
		cbAno.setFont(new Font("Arial", Font.PLAIN, 20));
		cbAno.setModel(new DefaultComboBoxModel(Datas.getAno()));
		cbAno.setBounds(66, 208, 84, 32);
		panel.add(cbAno);

		AlunoDAO pDAO = new AlunoDAO();
		Aluno p;
		ArrayList<Aluno> lista = pDAO.listarTodos();
		for (int i = 0; i < lista.size(); i++) {
			p = new Aluno();
			p.setRa(lista.get(i).getRa());
			p.setNome(lista.get(i).getNome());

			modeloAlunoMini.addAluno(p);
		}
		modeloAlunoMini.fireTableDataChanged();

		TurmaDAO dDAO = new TurmaDAO();
		Turma d;
		ArrayList<Turma> listaTurma = dDAO.listarTodos();
		for (int i = 0; i < listaTurma.size(); i++) {
			d = new Turma();
			d.setCod(listaTurma.get(i).getCod());
			d.setSerie(listaTurma.get(i).getSerie());
			d.setPeriodo(listaTurma.get(i).getPeriodo());

			modeloTurma.addTurma(d);
		}
		modeloAlunoMini.fireTableDataChanged();
	}
}
