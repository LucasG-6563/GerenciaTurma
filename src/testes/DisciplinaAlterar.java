package testes;

import javax.swing.JOptionPane;

import model.Disciplina;
import model.DisciplinaDAO;

public class DisciplinaAlterar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Disciplina d = new Disciplina();
		DisciplinaDAO dDAO = new DisciplinaDAO();
		
		d.setCod(Integer.parseInt(JOptionPane.showInputDialog("Digite o código da disciplina")));
		d.setNome(JOptionPane.showInputDialog("Digite o nome da disciplina"));
		d.setArea(JOptionPane.showInputDialog("Digite a área da disciplina"));
		
		dDAO.alterar(d);
	}

}
