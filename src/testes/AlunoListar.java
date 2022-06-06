package testes;

import java.util.ArrayList;

import model.Aluno;
import model.AlunoDAO;

public class AlunoListar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AlunoDAO tDAO = new AlunoDAO();
		ArrayList<Aluno> lista = new ArrayList<Aluno>();

		lista = tDAO.listarTodos();
		
		for(int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i).getRa()+" | "+
			lista.get(i).getNome()+" | "+
			lista.get(i).getEndereco()+" | "+
			lista.get(i).getDataNasc()+" | "+
			lista.get(i).getTelefone()+" | "+
			lista.get(i).getCpf()+" | "+
			lista.get(i).getRg()+" | "+
			lista.get(i).getNomeResp()+" | "+
			lista.get(i).getCpfResp()+" | "+
			lista.get(i).getRgResp());
		}
	}

}
