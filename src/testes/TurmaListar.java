package testes;

import java.util.ArrayList;

import model.Turma;
import model.TurmaDAO;

public class TurmaListar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TurmaDAO tDAO = new TurmaDAO();
		ArrayList<Turma> lista = new ArrayList<Turma>();
		
		tDAO.listarTodos();
		
		for(int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i).getCod()+" | "+
			lista.get(i).getSerie()+" | "+
			lista.get(i).getPeriodo());
		}
		
	}

}
