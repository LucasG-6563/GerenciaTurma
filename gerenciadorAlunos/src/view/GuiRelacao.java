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

import model.Relacao;
import model.RelacaoDAO;
import model.Datas;
import model.Professor_Disciplina;
import model.Professor_DisciplinaDAO;
import model.TabelaRelacao;
import model.TabelaProfessor_DisciplinaNome;
import model.TabelaTurma;
import model.Turma;
import model.TurmaDAO;

@SuppressWarnings("serial")
public class GuiRelacao extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoRelacao;
	private JTable tbRelacao;
	private TabelaRelacao modeloTabela;
	private TabelaProfessor_DisciplinaNome modeloProfDisc;
	private TabelaTurma modeloTurma;
	private JTable tbProfDisc;
	private JTable tbTurma;
	private JTextField txtCodProfDisc;
	private JTextField txtCodTurma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiRelacao frame = new GuiRelacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Atualiza os dados da tabela Relacao
	 */
	public void atualizaTabela() {
		modeloTabela.cleanTabela();

		Relacao d;
		RelacaoDAO dDAO = new RelacaoDAO();

		ArrayList<Relacao> lista = dDAO.listarTodos();
		for (int i = 0; i < lista.size(); i++) {
			d = new Relacao();
			d.setCod_relacao(lista.get(i).getCod_relacao());
			d.setCod_prof_disc(lista.get(i).getCod_prof_disc());
			d.setCod_turma(lista.get(i).getCod_turma());
			d.setAno(lista.get(i).getAno());

			modeloTabela.addRelacao(d);
		}
		modeloTabela.fireTableDataChanged();
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GuiRelacao() {
		setTitle("Rela\u00E7\u00E3o");
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

		tbRelacao = new JTable();
		this.modeloTabela = new TabelaRelacao();
		this.tbRelacao = new JTable(modeloTabela);
		tbRelacao.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(tbRelacao);

		JLabel lblCodRelacao = new JLabel("C\u00F3digo Rela\u00E7\u00E3o");
		lblCodRelacao.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCodRelacao.setBounds(10, 11, 140, 37);
		panel.add(lblCodRelacao);

		JLabel lblCodProfDisc = new JLabel("C\u00F3digo Professor_Disciplina");
		lblCodProfDisc.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCodProfDisc.setBounds(10, 78, 254, 37);
		panel.add(lblCodProfDisc);

		JLabel lblEndereco = new JLabel("C\u00F3digo Turma");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEndereco.setBounds(10, 143, 140, 37);
		panel.add(lblEndereco);

		txtCodigoRelacao = new JTextField();
		txtCodigoRelacao.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodigoRelacao.setBounds(170, 14, 65, 31);
		panel.add(txtCodigoRelacao);
		txtCodigoRelacao.setColumns(10);

		JComboBox cbAno = new JComboBox();
		cbAno.setFont(new Font("Arial", Font.PLAIN, 20));
		cbAno.setModel(new DefaultComboBoxModel(Datas.getAno()));
		cbAno.setBounds(66, 208, 84, 32);
		panel.add(cbAno);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relacao d = new Relacao();
				RelacaoDAO dDAO = new RelacaoDAO();

				d.setCod_prof_disc(Integer.parseInt(txtCodProfDisc.getText()));
				d.setCod_turma(Integer.parseInt(txtCodTurma.getText()));
				d.setAno(Integer.parseInt(cbAno.getSelectedItem().toString()));

				dDAO.inserir(d);

				JOptionPane.showMessageDialog(btnIncluir, "Relacao inserida com sucesso");
				
				atualizaTabela();
			}
		});
		btnIncluir.setFont(new Font("Arial", Font.PLAIN, 26));
		btnIncluir.setBounds(10, 268, 225, 185);
		panel.add(btnIncluir);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Relacao d = new Relacao();
				RelacaoDAO dDAO = new RelacaoDAO();

				d.setCod_relacao(Integer.parseInt(txtCodigoRelacao.getText()));
				d.setCod_prof_disc(Integer.parseInt(txtCodigoRelacao.getText()));
				d.setCod_turma(Integer.parseInt(txtCodigoRelacao.getText()));

				dDAO.alterar(d);

				JOptionPane.showMessageDialog(btnIncluir, "Dados da Relacao alterado com sucesso");
				
				atualizaTabela();
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnAlterar.setBounds(236, 268, 225, 185);
		panel.add(btnAlterar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GuiConsultaRelacao tela = new GuiConsultaRelacao();
				tela.setVisible(true);
			}
		});
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnConsultar.setBounds(10, 453, 225, 217);
		panel.add(btnConsultar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelacaoDAO dDAO = new RelacaoDAO();

				dDAO.delete(Integer.parseInt(txtCodigoRelacao.getText()));

				JOptionPane.showMessageDialog(btnIncluir, "Relacao deletada com sucesso");
				
				atualizaTabela();
			}
		});
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnDeletar.setBounds(236, 453, 225, 217);
		panel.add(btnDeletar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(471, 345, 386, 325);
		panel.add(scrollPane_1);

		tbProfDisc = new JTable();
		this.modeloProfDisc = new TabelaProfessor_DisciplinaNome();
		this.tbProfDisc = new JTable(modeloProfDisc);
		tbProfDisc.setFont(new Font("Arial", Font.PLAIN, 20));
		scrollPane_1.setViewportView(tbProfDisc);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(858, 345, 386, 325);
		panel.add(scrollPane_1_1);

		tbTurma = new JTable();
		this.modeloTurma = new TabelaTurma();
		this.tbTurma = new JTable(modeloTurma);
		tbTurma.setFont(new Font("Arial", Font.PLAIN, 20));
		scrollPane_1_1.setViewportView(tbTurma);

		txtCodProfDisc = new JTextField();
		txtCodProfDisc.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodProfDisc.setColumns(10);
		txtCodProfDisc.setBounds(273, 81, 65, 31);
		panel.add(txtCodProfDisc);

		txtCodTurma = new JTextField();
		txtCodTurma.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodTurma.setColumns(10);
		txtCodTurma.setBounds(160, 146, 65, 31);
		panel.add(txtCodTurma);

		JLabel lblEndereco_1 = new JLabel("Ano");
		lblEndereco_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEndereco_1.setBounds(10, 208, 46, 37);
		panel.add(lblEndereco_1);

		Professor_DisciplinaDAO pDAO = new Professor_DisciplinaDAO();
		Professor_Disciplina p;
		ArrayList<Professor_Disciplina> lista = pDAO.listarTodos();
		for (int i = 0; i < lista.size(); i++) {
			p = new Professor_Disciplina();
			p.setCod(lista.get(i).getCod());
			p.setNomeProfessor(lista.get(i).getIdProfessor());
			p.setDisciplina(lista.get(i).getCodDisciplina());

			modeloProfDisc.addProfessor_DisciplinaNome(p);
		}
		modeloProfDisc.fireTableDataChanged();

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
		modeloProfDisc.fireTableDataChanged();
		
		atualizaTabela();
	}

}
