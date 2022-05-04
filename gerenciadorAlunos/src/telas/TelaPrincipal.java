package telas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal {

	public static final String[] colunas = {"Nome","RA","Ano","Exatas","Humanas","Natureza"};
	JFrame frmPrincipal;
	private DefaultTableModel tbModelo = new DefaultTableModel(colunas, 0);
	private JTable tbAlunos = new JTable(tbModelo);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setResizable(false);
		frmPrincipal.setTitle("Principal");
		frmPrincipal.setBounds(100, 100, 720, 480);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		
		
		tbAlunos = new JTable(tbModelo);
		tbAlunos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		tbAlunos.setEnabled(true);
		tbAlunos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tbAlunos.setCellSelectionEnabled(false);
		tbAlunos.setBounds(206, 11, 488, 364);
		frmPrincipal.getContentPane().add(tbAlunos);
		
		JLabel lblAluno = new JLabel("Aluno: ");
		lblAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAluno.setBounds(10, 28, 43, 14);
		frmPrincipal.getContentPane().add(lblAluno);
		
		JLabel lblRA = new JLabel("RA: ");
		lblRA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRA.setBounds(10, 53, 43, 14);
		frmPrincipal.getContentPane().add(lblRA);
		
		JLabel lblSerieAluno = new JLabel("Ano: ");
		lblSerieAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSerieAluno.setBounds(10, 78, 43, 14);
		frmPrincipal.getContentPane().add(lblSerieAluno);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(546, 386, 148, 44);
		frmPrincipal.getContentPane().add(btnFechar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(377, 386, 148, 44);
		frmPrincipal.getContentPane().add(btnDeletar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(206, 386, 148, 44);
		frmPrincipal.getContentPane().add(btnAtualizar);
		
		JLabel lblExatas = new JLabel("Exatas: ");
		lblExatas.setBounds(10, 175, 43, 14);
		frmPrincipal.getContentPane().add(lblExatas);
		
		JLabel lblHumanas = new JLabel("Humanas: ");
		lblHumanas.setBounds(10, 200, 51, 14);
		frmPrincipal.getContentPane().add(lblHumanas);
		
		JLabel lblNewLabel_3_2 = new JLabel("Natureza: ");
		lblNewLabel_3_2.setBounds(10, 225, 51, 14);
		frmPrincipal.getContentPane().add(lblNewLabel_3_2);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbModelo.addRow(
						new Object[] {
								"Lucas",
								"1050482113046",
								"3º Semestre",
								"9",
								"7",
								"8"
						});
				tbModelo.addRow(
						new Object[] {
								"Lucas",
								"1050482113046",
								"3º Semestre",
								null,
								"7",
								"8"
						});
				tbModelo.addRow(
						new Object[] {
								"Lucas",
								"1050482113046",
								"3º Semestre",
								"9",
								"7",
								null
						});
				
			}
		});
		btnAdicionar.setBounds(10, 386, 186, 44);
		frmPrincipal.getContentPane().add(btnAdicionar);
		
		JLabel lblNomeAluno = new JLabel("New label");
		lblNomeAluno.setBounds(63, 30, 46, 14);
		frmPrincipal.getContentPane().add(lblNomeAluno);
		
		JLabel lblRaAluno = new JLabel("New label");
		lblRaAluno.setBounds(63, 55, 46, 14);
		frmPrincipal.getContentPane().add(lblRaAluno);
		
		JLabel lblAnoAluno = new JLabel("New label");
		lblAnoAluno.setBounds(63, 80, 46, 14);
		frmPrincipal.getContentPane().add(lblAnoAluno);
		
		JLabel lblNotaExatas = new JLabel("New label");
		lblNotaExatas.setBounds(63, 175, 46, 14);
		frmPrincipal.getContentPane().add(lblNotaExatas);
		
		JLabel lblNotaHumanas = new JLabel("New label");
		lblNotaHumanas.setBounds(63, 200, 46, 14);
		frmPrincipal.getContentPane().add(lblNotaHumanas);
		
		JLabel lblNotaNatureza = new JLabel("New label");
		lblNotaNatureza.setBounds(63, 225, 46, 14);
		frmPrincipal.getContentPane().add(lblNotaNatureza);
		
	}
}
