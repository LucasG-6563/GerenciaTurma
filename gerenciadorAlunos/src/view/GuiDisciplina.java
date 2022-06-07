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

import model.Disciplina;
import model.DisciplinaDAO;
import model.TabelaDisciplina;
import javax.swing.JScrollPane;
import java.awt.Font;

@SuppressWarnings("serial")
public class GuiDisciplina extends JFrame{

	private JFrame frmDisciplina;
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
					GuiDisciplina window = new GuiDisciplina();
					window.frmDisciplina.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiDisciplina() {
		this.modeloTabela = new TabelaDisciplina();
		this.tbDisciplinas = new JTable(modeloTabela);
		tbDisciplinas.setFont(new Font("Arial", Font.PLAIN, 20));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDisciplina = new JFrame();
		frmDisciplina.setTitle("Disciplina");
		frmDisciplina.setBounds(100, 100, 1280, 720);
		frmDisciplina.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDisciplina.getContentPane().setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodigo.setBounds(126, 26, 150, 20);
		frmDisciplina.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 20));
		txtNome.setBounds(126, 78, 477, 36);
		frmDisciplina.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtArea = new JTextField();
		txtArea.setFont(new Font("Arial", Font.PLAIN, 20));
		txtArea.setBounds(126, 150, 477, 36);
		frmDisciplina.getContentPane().add(txtArea);
		txtArea.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 28, 150, 20);
		frmDisciplina.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 86, 150, 20);
		frmDisciplina.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u00C1rea");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(34, 161, 92, 14);
		frmDisciplina.getContentPane().add(lblNewLabel_2);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Arial", Font.PLAIN, 26));
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Disciplina d = new Disciplina();
				DisciplinaDAO dDAO = new DisciplinaDAO();
				
				d.setNome(txtNome.getText());
				d.setArea(txtArea.getText());
				
				dDAO.inserir(d);
				
				JOptionPane.showMessageDialog(btnInserir, "Disciplina inserida com sucesso");
			}
		});
		btnInserir.setBounds(10, 260, 296, 205);
		frmDisciplina.getContentPane().add(btnInserir);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modeloTabela.cleanTabela();
				
				Disciplina d;
				DisciplinaDAO dDAO = new DisciplinaDAO();
				
				ArrayList<Disciplina> lista = dDAO.listarTodos();
				for(int i=0;i<lista.size();i++) {
					d = new Disciplina();
					d.setCod(lista.get(i).getCod());
					d.setNome(lista.get(i).getNome());
					d.setArea(lista.get(i).getArea());
					
					modeloTabela.addDisciplina(d);
				}
				modeloTabela.fireTableDataChanged();
				
			}
		});
		btnListar.setBounds(10, 476, 296, 194);
		frmDisciplina.getContentPane().add(btnListar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Disciplina d = new Disciplina();
				DisciplinaDAO dDAO = new DisciplinaDAO();
				
				d.setCod(Integer.parseInt(txtCodigo.getText()));
				d.setNome(txtNome.getText());
				d.setArea(txtArea.getText());
				
				dDAO.alterar(d);
				JOptionPane.showMessageDialog(btnInserir, "Dados da disciplina alterado com sucesso");
			}
		});
		btnAlterar.setBounds(316, 260, 287, 205);
		frmDisciplina.getContentPane().add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 26));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisciplinaDAO dDAO = new DisciplinaDAO();
				
				dDAO.delete(Integer.parseInt(txtCodigo.getText()));
				JOptionPane.showMessageDialog(btnInserir, "Disciplina deletada com sucesso");
			}
		});
		btnDeletar.setBounds(316, 476, 287, 194);
		frmDisciplina.getContentPane().add(btnDeletar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(613, 11, 641, 659);
		frmDisciplina.getContentPane().add(scrollPane);
		scrollPane.setViewportView(tbDisciplinas);
	}
}
