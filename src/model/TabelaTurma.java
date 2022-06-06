package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TabelaTurma extends AbstractTableModel{

	private ArrayList<Turma> tabela;
	private String[] colunas = {"Codigo","Serie","Periodo"};
	
	
	public TabelaTurma() {
		this.tabela = new ArrayList<>();
	}
	
	public void addTurma(Turma t) {
		tabela.add(t);
	}
	public void cleanTabela() {
		tabela.clear();
	}
	
	public Turma getTurma(int linha) {
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
			return this.tabela.get(rowIndex).getSerie();
		case 2:
			return this.tabela.get(rowIndex).getPeriodo();
		default:
			return this.tabela.get(rowIndex);
		}
	}
	
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}

	
}
