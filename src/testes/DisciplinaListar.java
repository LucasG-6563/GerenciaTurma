package testes;

import java.util.ArrayList;

import model.Disciplina;
import model.DisciplinaDAO;

public class DisciplinaListar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DisciplinaDAO dDAO = new DisciplinaDAO();
		ArrayList<Disciplina> lista = new ArrayList<Disciplina>();
		lista = dDAO.listarTodos();
		
		for(int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i).getCod()+" | "+
			lista.get(i).getNome()+" | "+
			lista.get(i).getArea());
		}
		
	}

}
