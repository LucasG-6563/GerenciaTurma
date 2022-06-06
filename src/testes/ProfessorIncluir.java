package testes;

import java.awt.HeadlessException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import model.Professor;
import model.ProfessorDAO;

public class ProfessorIncluir {

	public static void main(String[] args) throws HeadlessException, ParseException {
		// TODO Auto-generated method stub

		Professor p = new Professor();
		ProfessorDAO pDAO = new ProfessorDAO();
		
		p.setNome(JOptionPane.showInputDialog("Digite o nome do professor"));
		p.setEndereco(JOptionPane.showInputDialog("Digite o endereço do professor"));
		p.setDataNasc(JOptionPane.showInputDialog("Digite a data de nascimento do professor"));
		p.setTelefone(JOptionPane.showInputDialog("Digite o telefone do professor"));
		p.setCpf(JOptionPane.showInputDialog("Digite o CPF do professor"));
		p.setRg(JOptionPane.showInputDialog("Digite o RG do professor"));
		
		
		pDAO.inserir(p);
	}

}
