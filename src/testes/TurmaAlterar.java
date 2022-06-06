package testes;

import javax.swing.JOptionPane;

import model.Turma;
import model.TurmaDAO;

public class TurmaAlterar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Turma t = new Turma();
		TurmaDAO tDAO = new TurmaDAO();
		
		t.setCod(Integer.parseInt(JOptionPane.showInputDialog("Digite o código da Turma")));
		t.setSerie(JOptionPane.showInputDialog("Digite o nome da serie da Turma"));
		t.setPeriodo(JOptionPane.showInputDialog("Digite o período da Turma"));
		
		tDAO.alterar(t);
	}

}
