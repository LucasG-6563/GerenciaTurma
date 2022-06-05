package testes;

import java.util.ArrayList;

import model.Professor;
import model.ProfessorDAO;

public class ProfessorListar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProfessorDAO tDAO = new ProfessorDAO();
		ArrayList<Professor> lista = new ArrayList<Professor>();

		lista = tDAO.listarTodos();
		
		for(int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i).getIdProfessor()+" | "+
			lista.get(i).getNome()+" | "+
			lista.get(i).getEndereco()+" | "+
			lista.get(i).getDataNasc()+" | "+
			lista.get(i).getTelefone()+" | "+
			lista.get(i).getCpf()+" | "+
			lista.get(i).getRg());
		}
	}

}
