package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Datas;
import model.Professor;
import model.ProfessorDAO;
import model.TabelaProfessor;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GuiProfessor extends JFrame {

	private JPanel contentPane;
	private JTable tbProfessor;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtCPF;
	private JTextField txtRG;
	private TabelaProfessor modeloTabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiProfessor frame = new GuiProfessor();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GuiProfessor() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1264, 681);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(624, 0, 640, 681);
		panel.add(scrollPane);

		tbProfessor = new JTable();
		this.modeloTabela = new TabelaProfessor();
		this.tbProfessor = new JTable(modeloTabela);
		tbProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(tbProfessor);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Arial", Font.PLAIN, 20));
		lblId.setBounds(10, 11, 97, 37);
		panel.add(lblId);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNome.setBounds(10, 59, 97, 37);
		panel.add(lblNome);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEndereco.setBounds(10, 107, 97, 37);
		panel.add(lblEndereco);

		JLabel lblDataNasc = new JLabel("Data de Nascimento");
		lblDataNasc.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDataNasc.setBounds(10, 155, 184, 37);
		panel.add(lblDataNasc);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTelefone.setBounds(10, 203, 97, 37);
		panel.add(lblTelefone);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCpf.setBounds(10, 251, 97, 37);
		panel.add(lblCpf);

		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRg.setBounds(10, 299, 97, 37);
		panel.add(lblRg);

		JFormattedTextField ftfId = new JFormattedTextField();
		ftfId.setFont(new Font("Arial", Font.PLAIN, 20));
		ftfId.setBounds(42, 11, 103, 31);
		panel.add(ftfId);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 20));
		txtNome.setBounds(75, 59, 369, 31);
		panel.add(txtNome);
		txtNome.setColumns(10);

		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Arial", Font.PLAIN, 20));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(103, 107, 511, 31);
		panel.add(txtEndereco);

		JComboBox cbDia = new JComboBox();
		cbDia.setFont(new Font("Arial", Font.PLAIN, 20));
		cbDia.setModel(new DefaultComboBoxModel(Datas.getDIA()));
		cbDia.setBounds(403, 155, 58, 37);
		panel.add(cbDia);

		JComboBox cbMes = new JComboBox();
		cbMes.setFont(new Font("Arial", Font.PLAIN, 20));
		cbMes.setModel(new DefaultComboBoxModel(Datas.getMes()));
		cbMes.setBounds(322, 155, 71, 37);
		panel.add(cbMes);

		JComboBox cbAno = new JComboBox();
		cbAno.setFont(new Font("Arial", Font.PLAIN, 20));
		cbAno.setModel(new DefaultComboBoxModel(Datas.getAno()));
		cbAno.setBounds(204, 155, 108, 37);
		panel.add(cbAno);

		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Arial", Font.PLAIN, 20));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(94, 203, 203, 31);
		panel.add(txtTelefone);

		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCPF.setColumns(10);
		txtCPF.setBounds(60, 251, 203, 31);
		panel.add(txtCPF);

		txtRG = new JTextField();
		txtRG.setFont(new Font("Arial", Font.PLAIN, 20));
		txtRG.setColumns(10);
		txtRG.setBounds(60, 299, 190, 31);
		panel.add(txtRG);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor p = new Professor();
				ProfessorDAO pDAO = new ProfessorDAO();
				try {
					p.setNome(txtNome.getText());
					p.setEndereco(txtEndereco.getText());
					p.setDataNasc(cbAno.getSelectedItem() + "-" + (cbMes.getSelectedIndex() + 1) + "-"
							+ cbDia.getSelectedItem());
					p.setTelefone(txtTelefone.getText());
					p.setCpf(txtCPF.getText());
					p.setRg(txtRG.getText());

					pDAO.inserir(p);
				} catch (Exception e1) {
					System.out.println(e1);
				}

				JOptionPane.showMessageDialog(btnIncluir, "Professor inserida com sucesso");
			}
		});
		btnIncluir.setFont(new Font("Arial", Font.PLAIN, 26));
		btnIncluir.setBounds(10, 347, 302, 161);
		panel.add(btnIncluir);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modeloTabela.cleanTabela();

				Professor p = new Professor();
				ProfessorDAO pDAO = new ProfessorDAO();

				try {
					p.setIdProfessor(Integer.parseInt(ftfId.getText()));
					p.setNome(txtNome.getText());
					p.setEndereco(txtEndereco.getText());
					p.setDataNasc(cbAno.getSelectedItem() + "-" + (cbMes.getSelectedIndex() + 1) + "-"+ cbDia.getSelectedItem());
					p.setTelefone(txtTelefone.getText());
					p.setCpf(txtCPF.getText());
					p.setRg(txtRG.getText());

					pDAO.alterar(p);
					JOptionPane.showMessageDialog(btnAlterar, "Professor inserida com sucesso");
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnAlterar.setBounds(312, 347, 302, 161);
		panel.add(btnAlterar);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modeloTabela.cleanTabela();

				Professor d;
				ProfessorDAO dDAO = new ProfessorDAO();
				try {
					ArrayList<Professor> lista = dDAO.listarTodos();
					for (int i = 0; i < lista.size(); i++) {
						d = new Professor();
						d.setIdProfessor(lista.get(i).getIdProfessor());
						d.setNome(lista.get(i).getNome());
						d.setEndereco(lista.get(i).getEndereco());
						d.setDataNasc(lista.get(i).getDataNasc().toString());
						d.setTelefone(lista.get(i).getTelefone());
						d.setCpf(lista.get(i).getCpf());
						d.setRg(lista.get(i).getRg());

						modeloTabela.addProfessor(d);
					}
					modeloTabela.fireTableDataChanged();
				} catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});
		btnListar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnListar.setBounds(10, 509, 302, 161);
		panel.add(btnListar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfessorDAO dDAO = new ProfessorDAO();

				dDAO.delete(Integer.parseInt(ftfId.getText()));
				JOptionPane.showMessageDialog(btnIncluir, "Professor deletada com sucesso");
			}
		});
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnDeletar.setBounds(312, 509, 302, 161);
		panel.add(btnDeletar);
	}
}
