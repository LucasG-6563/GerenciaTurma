package testes;

import javax.swing.JOptionPane;

import model.Disciplina;
import model.DisciplinaDAO;

public class DisciplinaAlterar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Disciplina d = new Disciplina();
		DisciplinaDAO dDAO = new DisciplinaDAO();
		
		d.setCod(Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo da disciplina")));
		d.setNome(JOptionPane.showInputDialog("Digite o nome da disciplina"));
		d.setArea(JOptionPane.showInputDialog("Digite a �rea da disciplina"));
		
		dDAO.alterar(d);
	}

}
