package testes;

import javax.swing.JOptionPane;

import model.DisciplinaDAO;

public class DisciplinaDeletar {

	public static void main(String[] args) {
		DisciplinaDAO dDAO = new DisciplinaDAO();
		
		dDAO.delete(Integer.parseInt(JOptionPane.showInputDialog("Digite o código da disciplina a ser deletada.")));
	}
}
