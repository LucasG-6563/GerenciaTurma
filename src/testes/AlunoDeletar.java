package testes;

import javax.swing.JOptionPane;

import model.AlunoDAO;

public class AlunoDeletar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int ra = 0;
		AlunoDAO aDAO = new AlunoDAO();
		
		ra = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do Aluno"));
		
		
		aDAO.delete(ra);
	}

}
