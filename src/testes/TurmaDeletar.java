package testes;

import javax.swing.JOptionPane;

import model.TurmaDAO;

public class TurmaDeletar {

	public static void main(String[] args) {
		TurmaDAO tDAO = new TurmaDAO();
		
		tDAO.delete(Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo da Turma a ser deletada.")));
	}
}
