package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import model.Aluno;
import model.AlunoDAO;
import model.TabelaAluno;

@SuppressWarnings("serial")
public class GuiAluno extends JFrame {

	private JPanel contentPane;
	private JTable tbAluno;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtCPF;
	private JTextField txtRG;
	private TabelaAluno modeloTabela;
	private JTextField txtNomeResp;
	private JTextField txtCpfResp;
	private JTextField txtRgResp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiAluno frame = new GuiAluno();
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
	public GuiAluno() {

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
		scrollPane.setBounds(471, 0, 793, 681);
		panel.add(scrollPane);

		tbAluno = new JTable();
		this.modeloTabela = new TabelaAluno();
		this.tbAluno = new JTable(modeloTabela);
		tbAluno.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(tbAluno);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Arial", Font.PLAIN, 16));
		lblId.setBounds(10, 11, 37, 37);
		panel.add(lblId);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome.setBounds(10, 59, 97, 37);
		panel.add(lblNome);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEndereco.setBounds(10, 107, 97, 37);
		panel.add(lblEndereco);

		JLabel lblDataNasc = new JLabel("Data de Nascimento");
		lblDataNasc.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDataNasc.setBounds(10, 155, 184, 37);
		panel.add(lblDataNasc);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTelefone.setBounds(10, 203, 97, 37);
		panel.add(lblTelefone);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCpf.setBounds(10, 251, 97, 37);
		panel.add(lblCpf);

		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Arial", Font.PLAIN, 16));
		lblRg.setBounds(10, 299, 97, 37);
		panel.add(lblRg);

		JFormattedTextField ftfId = new JFormattedTextField();
		ftfId.setFont(new Font("Arial", Font.PLAIN, 16));
		ftfId.setBounds(34, 14, 103, 31);
		panel.add(ftfId);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNome.setBounds(60, 62, 369, 31);
		panel.add(txtNome);
		txtNome.setColumns(10);

		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(94, 110, 358, 31);
		panel.add(txtEndereco);

		JComboBox cbDia = new JComboBox();
		cbDia.setFont(new Font("Arial", Font.PLAIN, 20));
		cbDia.setModel(new DefaultComboBoxModel(Datas.getDIA()));
		cbDia.setBounds(361, 154, 58, 37);
		panel.add(cbDia);

		JComboBox cbMes = new JComboBox();
		cbMes.setFont(new Font("Arial", Font.PLAIN, 20));
		cbMes.setModel(new DefaultComboBoxModel(Datas.getMes()));
		cbMes.setBounds(280, 154, 71, 37);
		panel.add(cbMes);

		JComboBox cbAno = new JComboBox();
		cbAno.setFont(new Font("Arial", Font.PLAIN, 20));
		cbAno.setModel(new DefaultComboBoxModel(Datas.getAno()));
		cbAno.setBounds(162, 154, 108, 37);
		panel.add(cbAno);

		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(79, 206, 203, 31);
		panel.add(txtTelefone);

		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Arial", Font.PLAIN, 16));
		txtCPF.setColumns(10);
		txtCPF.setBounds(60, 254, 203, 31);
		panel.add(txtCPF);

		txtRG = new JTextField();
		txtRG.setFont(new Font("Arial", Font.PLAIN, 16));
		txtRG.setColumns(10);
		txtRG.setBounds(60, 302, 190, 31);
		panel.add(txtRG);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno p = new Aluno();
				AlunoDAO pDAO = new AlunoDAO();
				try {
					p.setNome(txtNome.getText());
					p.setEndereco(txtEndereco.getText());
					p.setDataNasc(cbAno.getSelectedItem() + "-" + (cbMes.getSelectedIndex() + 1) + "-"
							+ cbDia.getSelectedItem());
					p.setTelefone(txtTelefone.getText());
					p.setCpf(txtCPF.getText());
					p.setRg(txtRG.getText());
					p.setNomeResp(txtNomeResp.getText());
					p.setCpfResp(txtCpfResp.getText());
					p.setRgResp(txtRgResp.getText());

					pDAO.inserir(p);
				} catch (Exception e1) {
					System.out.println(e1);
				}

				JOptionPane.showMessageDialog(btnIncluir, "Aluno inserida com sucesso");
			}
		});
		btnIncluir.setFont(new Font("Arial", Font.PLAIN, 26));
		btnIncluir.setBounds(10, 485, 225, 92);
		panel.add(btnIncluir);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modeloTabela.cleanTabela();

				Aluno p = new Aluno();
				AlunoDAO pDAO = new AlunoDAO();

				try {
					p.setRa(Integer.parseInt(ftfId.getText()));
					p.setNome(txtNome.getText());
					p.setEndereco(txtEndereco.getText());
					p.setDataNasc(cbAno.getSelectedItem() + "-" + (cbMes.getSelectedIndex() + 1) + "-"+ cbDia.getSelectedItem());
					p.setTelefone(txtTelefone.getText());
					p.setCpf(txtCPF.getText());
					p.setRg(txtRG.getText());
					p.setNomeResp(txtNomeResp.getText());
					p.setCpfResp(txtCpfResp.getText());
					p.setRgResp(txtRgResp.getText());

					pDAO.alterar(p);
					JOptionPane.showMessageDialog(btnAlterar, "Aluno inserida com sucesso");
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnAlterar.setBounds(236, 485, 225, 92);
		panel.add(btnAlterar);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modeloTabela.cleanTabela();

				Aluno d;
				AlunoDAO dDAO = new AlunoDAO();
				try {
					ArrayList<Aluno> lista = dDAO.listarTodos();
					for (int i = 0; i < lista.size(); i++) {
						d = new Aluno();
						d.setRa(lista.get(i).getRa());
						d.setNome(lista.get(i).getNome());
						d.setEndereco(lista.get(i).getEndereco());
						d.setDataNasc(lista.get(i).getDataNasc().toString());
						d.setTelefone(lista.get(i).getTelefone());
						d.setCpf(lista.get(i).getCpf());
						d.setRg(lista.get(i).getRg());
						d.setNomeResp(lista.get(i).getNomeResp());
						d.setCpfResp(lista.get(i).getCpfResp());
						d.setRgResp(lista.get(i).getRgResp());

						modeloTabela.addAluno(d);
					}
					modeloTabela.fireTableDataChanged();
				} catch (Exception e1) {
					
					System.out.println(e1);
				}

			}
		});
		btnListar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnListar.setBounds(10, 581, 225, 89);
		panel.add(btnListar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlunoDAO dDAO = new AlunoDAO();

				dDAO.delete(Integer.parseInt(ftfId.getText()));
				JOptionPane.showMessageDialog(btnIncluir, "Aluno deletada com sucesso");
			}
		});
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnDeletar.setBounds(236, 581, 225, 89);
		panel.add(btnDeletar);
		
		JLabel lnlNomeResp = new JLabel("Nome do Respons\u00E1vel");
		lnlNomeResp.setFont(new Font("Arial", Font.PLAIN, 16));
		lnlNomeResp.setBounds(10, 347, 209, 37);
		panel.add(lnlNomeResp);
		
		txtNomeResp = new JTextField();
		txtNomeResp.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNomeResp.setColumns(10);
		txtNomeResp.setBounds(173, 350, 288, 31);
		panel.add(txtNomeResp);
		
		txtCpfResp = new JTextField();
		txtCpfResp.setFont(new Font("Arial", Font.PLAIN, 16));
		txtCpfResp.setColumns(10);
		txtCpfResp.setBounds(60, 395, 203, 31);
		panel.add(txtCpfResp);
		
		JLabel lblCpf_1 = new JLabel("CPF");
		lblCpf_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCpf_1.setBounds(10, 395, 97, 37);
		panel.add(lblCpf_1);
		
		JLabel lblRg_1 = new JLabel("RG");
		lblRg_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblRg_1.setBounds(10, 443, 97, 37);
		panel.add(lblRg_1);
		
		txtRgResp = new JTextField();
		txtRgResp.setFont(new Font("Arial", Font.PLAIN, 16));
		txtRgResp.setColumns(10);
		txtRgResp.setBounds(60, 443, 190, 31);
		panel.add(txtRgResp);
	}
}
