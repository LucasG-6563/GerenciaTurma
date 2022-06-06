package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TabelaRelacao extends AbstractTableModel{

	private ArrayList<Relacao> tabela;
	private String[] colunas = {"Codigo Relação","Cod Professor Disciplina","Codigo Turma","Ano"};
	
	
	public TabelaRelacao() {
		this.tabela = new ArrayList<>();
	}
	
	public void addRelacao(Relacao d) {
		tabela.add(d);
	}
	public void cleanTabela() {
		tabela.clear();
	}
	
	public Relacao getRelacao(int linha) {
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
			return this.tabela.get(rowIndex).getCod_relacao();
		case 1:
			return this.tabela.get(rowIndex).getCod_prof_disc();
		case 2:
			return this.tabela.get(rowIndex).getCod_turma();
		case 3:
			return this.tabela.get(rowIndex).getAno();
		default:
			return this.tabela.get(rowIndex);
		}
	}
	
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}

	
}
