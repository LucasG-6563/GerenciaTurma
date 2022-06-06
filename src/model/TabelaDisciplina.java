package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TabelaDisciplina extends AbstractTableModel{

	private ArrayList<Disciplina> tabela;
	private String[] colunas = {"Codigo","Disciplina","Area"};
	
	
	public TabelaDisciplina() {
		this.tabela = new ArrayList<>();
	}
	
	public void addDisciplina(Disciplina d) {
		tabela.add(d);
	}
	public void cleanTabela() {
		tabela.clear();
	}
	
	public Disciplina getDisciplina(int linha) {
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
			return this.tabela.get(rowIndex).getNome();
		case 2:
			return this.tabela.get(rowIndex).getArea();
		default:
			return this.tabela.get(rowIndex);
		}
	}
	
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}

	
}
