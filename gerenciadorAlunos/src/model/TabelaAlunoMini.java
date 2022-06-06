package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TabelaAlunoMini extends AbstractTableModel{

	private ArrayList<Aluno> tabela;
	private String[] colunas = {"RA Aluno","Nome Aluno"};
	
	
	public TabelaAlunoMini() {
		this.tabela = new ArrayList<>();
	}
	
	public void addAluno(Aluno t) {
		tabela.add(t);
	}
	public void cleanTabela() {
		tabela.clear();
	}
	
	public Aluno getAluno(int linha) {
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
			return this.tabela.get(rowIndex).getRa();
		case 1:
			return this.tabela.get(rowIndex).getNome();
		default:
			return this.tabela.get(rowIndex);
		}
	}
	
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}

	
}
