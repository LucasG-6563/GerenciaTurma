package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TabelaProfessor_Disciplina extends AbstractTableModel{

	private ArrayList<Professor_Disciplina> tabela;
	private String[] colunas = {"Codigo","ID Professor","Codigo Disciplina"};
	
	
	public TabelaProfessor_Disciplina() {
		this.tabela = new ArrayList<>();
	}
	
	public void addProfessor_Disciplina(Professor_Disciplina d) {
		tabela.add(d);
	}
	public void cleanTabela() {
		tabela.clear();
	}
	
	public Professor_Disciplina getProfessor_Disciplina(int linha) {
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
			return this.tabela.get(rowIndex).getCod();
		case 1:
			return this.tabela.get(rowIndex).getIdProfessor();
		case 2:
			return this.tabela.get(rowIndex).getCodDisciplina();
		default:
			return this.tabela.get(rowIndex);
		}
	}
	
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}

	
}
