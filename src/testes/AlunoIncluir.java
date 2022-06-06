package testes;

import java.awt.HeadlessException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import model.Aluno;
import model.AlunoDAO;

public class AlunoIncluir {

	public static void main(String[] args) throws HeadlessException, ParseException {
		// TODO Auto-generated method stub

		Aluno p = new Aluno();
		AlunoDAO pDAO = new AlunoDAO();
		
		p.setNome(JOptionPane.showInputDialog("Digite o nome do Aluno"));
		p.setEndereco(JOptionPane.showInputDialog("Digite o endere�o do Aluno"));
		p.setDataNasc(JOptionPane.showInputDialog("Digite a data de nascimento do Aluno"));
		p.setTelefone(JOptionPane.showInputDialog("Digite o telefone do Aluno"));
		p.setCpf(JOptionPane.showInputDialog("Digite o CPF do Aluno"));
		p.setRg(JOptionPane.showInputDialog("Digite o RG do Aluno"));
		p.setNomeResp(JOptionPane.showInputDialog("Digite o nome do respons�vel do Aluno"));
		p.setCpfResp(JOptionPane.showInputDialog("Digite o CPF do respons�vel do Aluno"));
		p.setRgResp(JOptionPane.showInputDialog("Digite o RG do respons�vel do Aluno"));
		
		pDAO.inserir(p);
	}

}
