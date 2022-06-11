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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.ConsultaRelacao;
import model.ConsultaRelacaoDAO;
import model.Datas;
import model.TabelaConsultaRelacao;

@SuppressWarnings("serial")
public class GuiConsultaRelacao extends JFrame {

	private JPanel contentPane;
	private JTable tbConsulta;
	private JTextField txtNomeProfessor;
	private JTextField txtNomeDisciplina;
	private JTextField txtTurma;
	private JTextField txtPeriodo;
	private TabelaConsultaRelacao modeloTabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiConsultaRelacao frame = new GuiConsultaRelacao();
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
	public GuiConsultaRelacao() {
		setTitle("Consulta das Rela\u00E7\u00F5es");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 329, 924, 341);
		contentPane.add(scrollPane);
		
		this.modeloTabela = new TabelaConsultaRelacao();
		tbConsulta = new JTable(modeloTabela);
		scrollPane.setViewportView(tbConsulta);
		ConsultaRelacao cr;
		ConsultaRelacaoDAO crDAO = new ConsultaRelacaoDAO();
		ArrayList<ConsultaRelacao> lista = new ArrayList<ConsultaRelacao>();
		lista = crDAO.consultaRelacaoPadrao();
		
		for(int i=0;i<lista.size();i++) {
			cr = new ConsultaRelacao();
			cr.setCod_relacao(lista.get(i).getCod_relacao());
			cr.setNomeProfessor(lista.get(i).getNomeProfessor());
			cr.setDisciplina(lista.get(i).getDisciplina());
			cr.setTurma(lista.get(i).getTurma());
			cr.setPeriodo(lista.get(i).getPeriodo());
			cr.setAno(lista.get(i).getAno());
			
			modeloTabela.addConsultaRelacao(cr);
		}
		
		modeloTabela.fireTableDataChanged();
		
		JLabel lblNewLabel = new JLabel("Nome do Professor");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(62, 11, 171, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome da Disciplina");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(62, 111, 171, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Turma");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(62, 208, 56, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Per\u00EDodo");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(356, 11, 70, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ano");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(356, 111, 46, 24);
		contentPane.add(lblNewLabel_4);
		
		txtNomeProfessor = new JTextField();
		txtNomeProfessor.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNomeProfessor.setBounds(62, 46, 171, 24);
		contentPane.add(txtNomeProfessor);
		txtNomeProfessor.setColumns(10);
		
		txtNomeDisciplina = new JTextField();
		txtNomeDisciplina.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNomeDisciplina.setColumns(10);
		txtNomeDisciplina.setBounds(62, 146, 171, 24);
		contentPane.add(txtNomeDisciplina);
		
		txtTurma = new JTextField();
		txtTurma.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTurma.setColumns(10);
		txtTurma.setBounds(62, 243, 162, 24);
		contentPane.add(txtTurma);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setFont(new Font("Arial", Font.PLAIN, 16));
		txtPeriodo.setColumns(10);
		txtPeriodo.setBounds(356, 46, 171, 24);
		contentPane.add(txtPeriodo);
		
		JComboBox cbAno = new JComboBox();
		cbAno.setFont(new Font("Arial", Font.PLAIN, 16));
		cbAno.setModel(new DefaultComboBoxModel(Datas.getAno()));
		cbAno.setBounds(356, 146, 171, 24);
		contentPane.add(cbAno);
		cbAno.setSelectedItem(null);
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomeDisciplina.setText("");
				txtNomeProfessor.setText("");
				txtTurma.setText("");
				txtPeriodo.setText("");
				cbAno.setSelectedItem(null);
			}
		});
		btnLimparCampos.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLimparCampos.setBounds(356, 208, 171, 59);
		contentPane.add(btnLimparCampos);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaRelacao cr = new ConsultaRelacao();
				ConsultaRelacao aux;
				ConsultaRelacaoDAO crDAO = new ConsultaRelacaoDAO();
				ArrayList<ConsultaRelacao> lista = new ArrayList<ConsultaRelacao>();
				cr.setNomeProfessor(txtNomeProfessor.getText());
				cr.setDisciplina(txtNomeDisciplina.getText());
				cr.setTurma(txtTurma.getText());
				cr.setPeriodo(txtPeriodo.getText());
				if(cbAno.getSelectedItem() != null)
					cr.setAno(Integer.parseInt(cbAno.getSelectedItem().toString()));
				else
					cr.setAno(0);
				lista = crDAO.consultaRelacao(cr);
				
				for(int i=0;i<lista.size();i++) {
					aux = new ConsultaRelacao();
					aux.setCod_relacao(lista.get(i).getCod_relacao());
					aux.setNomeProfessor(lista.get(i).getNomeProfessor());
					aux.setDisciplina(lista.get(i).getDisciplina());
					aux.setTurma(lista.get(i).getTurma());
					aux.setPeriodo(lista.get(i).getPeriodo());
					aux.setAno(lista.get(i).getAno());
					
					modeloTabela.addConsultaRelacao(aux);
				}
				
				modeloTabela.fireTableDataChanged();
			}
		});
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnConsultar.setBounds(620, 11, 302, 256);
		contentPane.add(btnConsultar);
	}
}
