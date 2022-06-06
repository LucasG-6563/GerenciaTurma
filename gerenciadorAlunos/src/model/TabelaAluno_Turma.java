package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TabelaAluno_Turma extends AbstractTableModel{

	private ArrayList<Aluno_Turma> tabela;
	private String[] colunas = {"Codigo","RA Aluno","Codigo Turma","Ano"};
	
	
	public TabelaAluno_Turma() {
		this.tabela = new ArrayList<>();
	}
	
	public void addAluno_Turma(Aluno_Turma d) {
		tabela.add(d);
	}
	public void cleanTabela() {
		tabela.clear();
	}
	
	public Aluno_Turma getAluno_Turma(int linha) {
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
			return this.tabela.get(rowIndex).getCod_alum_turm();
		case 1:
			return this.tabela.get(rowIndex).getRa_aluno();
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
