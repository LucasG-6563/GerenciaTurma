package testes;

import javax.swing.JOptionPane;

import model.ProfessorDAO;

public class ProfessorDeletar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int id = 0;
		ProfessorDAO pDAO = new ProfessorDAO();
		
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite a ID do professor"));
		
		
		pDAO.delete(id);
	}

}
