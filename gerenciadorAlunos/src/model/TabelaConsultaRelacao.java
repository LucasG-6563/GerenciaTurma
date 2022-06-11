package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TabelaConsultaRelacao extends AbstractTableModel{

	private ArrayList<ConsultaRelacao> tabela;
	private String[] colunas = {"Codigo Relação","Professor","Disciplina","Turma","Periodo","Ano"};
	
	
	public TabelaConsultaRelacao() {
		this.tabela = new ArrayList<>();
	}
	
	public void addConsultaRelacao(ConsultaRelacao cr) {
		tabela.add(cr);
	}
	public void cleanTabela() {
		tabela.clear();
	}
	
	public ConsultaRelacao getConsultaRelacao(int linha) {
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
			return this.tabela.get(rowIndex).getNomeProfessor();
		case 2:
			return this.tabela.get(rowIndex).getDisciplina();
		case 3:
			return this.tabela.get(rowIndex).getTurma();
		case 4:
			return this.tabela.get(rowIndex).getPeriodo();
		case 5:
			return this.tabela.get(rowIndex).getAno();
		default:
			return this.tabela.get(rowIndex);
		}
	}
	
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}

	
}
