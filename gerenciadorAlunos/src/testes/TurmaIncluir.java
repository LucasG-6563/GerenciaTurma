package testes;

import javax.swing.JOptionPane;

import model.Turma;
import model.TurmaDAO;

public class TurmaIncluir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Turma t = new Turma();
		TurmaDAO tDAO = new TurmaDAO();
		
		t.setCod(Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo da turma.")));
		t.setSerie(JOptionPane.showInputDialog("Digite nome da s�rie."));
		t.setPeriodo(JOptionPane.showInputDialog("Digite o per�odo que se passa a s�rie."));
		
		tDAO.inserir(t);

	}

}
