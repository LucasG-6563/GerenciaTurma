package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TabelaProfessor extends AbstractTableModel{

	private ArrayList<Professor> tabela;
	private String[] colunas = {"ID","Nome","Endereço","Data de Nascimento","Telefone","CPF","RG"};
	
	
	public TabelaProfessor() {
		this.tabela = new ArrayList<>();
	}
	
	public void addProfessor(Professor t) {
		tabela.add(t);
	}
	public void cleanTabela() {
		tabela.clear();
	}
	
	public Professor getProfessor(int linha) {
		return this.tabela.get(linha);
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.tabela.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return this.tabela.get(rowIndex).getIdProfessor();
		case 1:
			return this.tabela.get(rowIndex).getNome();
		case 2:
			return this.tabela.get(rowIndex).getEndereco();
		case 3:
			return this.tabela.get(rowIndex).getDataNasc();
		case 4:
			return this.tabela.get(rowIndex).getTelefone();
		case 5:
			return this.tabela.get(rowIndex).getCpf();
		case 6:
			return this.tabela.get(rowIndex).getRg();
		default:
			return this.tabela.get(rowIndex);
		}
	}
	
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}

	
}
