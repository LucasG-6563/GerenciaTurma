package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Turma;
import model.TurmaDAO;
import model.TabelaTurma;
import javax.swing.JScrollPane;

public class GuiTurma {

	private JFrame frmTurma;
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
					GuiTurma window = new GuiTurma();
					window.frmTurma.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiTurma() {
		this.modeloTabela = new TabelaTurma();
		this.tbTurmas = new JTable(modeloTabela);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTurma = new JFrame();
		frmTurma.setTitle("Turma");
		frmTurma.setBounds(100, 100, 540, 360);
		frmTurma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTurma.getContentPane().setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(68, 25, 61, 20);
		frmTurma.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtSerie = new JTextField();
		txtSerie.setBounds(68, 75, 120, 20);
		frmTurma.getContentPane().add(txtSerie);
		txtSerie.setColumns(10);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setBounds(68, 125, 120, 20);
		frmTurma.getContentPane().add(txtPeriodo);
		txtPeriodo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 28, 48, 14);
		frmTurma.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Serie");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 78, 48, 14);
		frmTurma.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Periodo");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 128, 48, 14);
		frmTurma.getContentPane().add(lblNewLabel_2);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Turma d = new Turma();
				TurmaDAO dDAO = new TurmaDAO();
				
				d.setCod(Integer.parseInt(txtCodigo.getText()));
				d.setSerie(txtSerie.getText());
				d.setPeriodo(txtPeriodo.getText());
				
				dDAO.inserir(d);
				
				JOptionPane.showMessageDialog(btnInserir, "Turma inserida com sucesso");
			}
		});
		btnInserir.setBounds(10, 175, 116, 67);
		frmTurma.getContentPane().add(btnInserir);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modeloTabela.cleanTabela();
				
				Turma d;
				TurmaDAO dDAO = new TurmaDAO();
				
				ArrayList<Turma> lista = dDAO.listarTodos();
				for(int i=0;i<lista.size();i++) {
					d = new Turma();
					d.setCod(lista.get(i).getCod());
					d.setSerie(lista.get(i).getSerie());
					d.setPeriodo(lista.get(i).getPeriodo());
					
					modeloTabela.addTurma(d);
				}
				modeloTabela.fireTableDataChanged();
				
			}
		});
		btnListar.setBounds(10, 243, 116, 67);
		frmTurma.getContentPane().add(btnListar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Turma d = new Turma();
				TurmaDAO dDAO = new TurmaDAO();
				
				d.setCod(Integer.parseInt(txtCodigo.getText()));
				d.setSerie(txtSerie.getText());
				d.setPeriodo(txtPeriodo.getText());
				
				dDAO.alterar(d);
				
				JOptionPane.showMessageDialog(btnInserir, "Dados da turma alterado com sucesso");
			}
		});
		btnAlterar.setBounds(126, 175, 116, 67);
		frmTurma.getContentPane().add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TurmaDAO dDAO = new TurmaDAO();
				
				dDAO.delete(Integer.parseInt(txtCodigo.getText()));
				
				JOptionPane.showMessageDialog(btnInserir, "Turma deletada com sucesso");
			}
		});
		btnDeletar.setBounds(126, 243, 116, 67);
		frmTurma.getContentPane().add(btnDeletar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(252, 16, 262, 294);
		frmTurma.getContentPane().add(scrollPane);
		scrollPane.setViewportView(tbTurmas);
	}
}
