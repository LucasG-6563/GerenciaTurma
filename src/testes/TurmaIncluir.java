package testes;

import javax.swing.JOptionPane;

import model.Turma;
import model.TurmaDAO;

public class TurmaIncluir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Turma t = new Turma();
		TurmaDAO tDAO = new TurmaDAO();
		
		t.setSerie(JOptionPane.showInputDialog("Digite nome da série."));
		t.setPeriodo(JOptionPane.showInputDialog("Digite o período que se passa a série."));
		
		tDAO.inserir(t);

	}

}
